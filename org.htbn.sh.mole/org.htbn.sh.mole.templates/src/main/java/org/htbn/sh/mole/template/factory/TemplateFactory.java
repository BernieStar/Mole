package org.htbn.sh.mole.template.factory;

import org.htbn.sh.mole.analyzer.Analyzer;
import org.htbn.sh.mole.analyzer.impl.SimpleTemplateAnalyzerImpl;
import org.htbn.sh.mole.common.bean.MoleTemplate;
import org.htbn.sh.mole.common.enums.InstanceStatus;
import org.htbn.sh.mole.common.exception.TemplateAnalysisException;
import org.htbn.sh.mole.common.util.BNBeanUtil;
import org.htbn.sh.mole.common.util.BNIdUtil;
import org.htbn.sh.mole.common.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TemplateFactory<BizType,Result> {
private static final Logger logger = LoggerFactory.getLogger(TemplateFactory.class);
	
	@Value("#{propertiesReader['template.expireTime']}")
	private String expireTime;
	
	@Autowired
	private RedisUtils redisUtil;
	
	/**
	 * 不同的业务流程采用不用的分析器，所以不自动注入，需通过代码操作来set一个实现。
	 */
	private Analyzer<MoleTemplate<BizType,Result>> analyzer;
	
	
	public MoleTemplate<BizType,Result> generateTemplate(BizType bizType,Result insResult, InstanceStatus insStatus){
		
		MoleTemplate<BizType,Result> template = new MoleTemplate<BizType,Result>();
		
		BNBeanUtil.fieldCopy(MoleTemplate.class, template, MoleTemplate.class, template);
		
		String templateId = BNIdUtil.createUUIDByDATE("I-");
		
		template.setTemplateId(templateId);
		
		template.setDefaultResult(insResult);
		
		template.setDefaultStatus(insStatus);
		
		logger.debug("Generate Moletemplate success : "+templateId);
		 
		return template;
	}
	
	public boolean analyseTemplate(MoleTemplate<BizType,Result> template) throws TemplateAnalysisException{
		if(analyzer ==null){
			analyzer = new SimpleTemplateAnalyzerImpl<BizType, Result>();
		}
		try{
			template  = analyzer.analyseForExecute(template);
		}catch(Exception e){
			throw new TemplateAnalysisException(e);
		}
		
		return true;
	}
	
	public boolean storeTemplate(MoleTemplate<BizType,Result> template){
		Long expireTime = template.getExpireTime();
		expireTime = expireTime==null? Long.valueOf(this.expireTime) :expireTime;
		logger.debug("Template expireTime is "+expireTime);
		redisUtil.setValueCache(template.getTemplateId(), template, expireTime);
		return true;
	}

	public Analyzer<MoleTemplate<BizType, Result>> getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(Analyzer<MoleTemplate<BizType, Result>> analyzer) {
		this.analyzer = analyzer;
	}
	
	
	
}
