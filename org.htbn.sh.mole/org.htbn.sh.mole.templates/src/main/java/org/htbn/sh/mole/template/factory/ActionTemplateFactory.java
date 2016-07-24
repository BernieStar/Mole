package org.htbn.sh.mole.template.factory;

import org.htbn.sh.mole.analyzer.Analyzer;
import org.htbn.sh.mole.analyzer.impl.SimpleActionTemplateAnalyzerImpl;
import org.htbn.sh.mole.common.bean.MoleActionTemplate;
import org.htbn.sh.mole.common.bean.MoleInstance;
import org.htbn.sh.mole.common.bean.MoleTemplate;
import org.htbn.sh.mole.common.exception.InstanceAnalysisException;
import org.htbn.sh.mole.common.util.BNBeanUtil;
import org.htbn.sh.mole.common.util.BNIdUtil;
import org.htbn.sh.mole.common.util.RedisUtils;
import org.htbn.sh.mole.template.operation.ActionTemplateeDataOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ActionTemplateFactory<BizType,Result,BizBean> {
private static final Logger logger = LoggerFactory.getLogger(ActionTemplateFactory.class);
	
	/**
	 * 不同的业务节点采用不用的分析器，所以不自动注入，需通过代码操作来set一个实现。
	 */
	private Analyzer<MoleActionTemplate<BizType,Result,BizBean>> analyzer;
	
	@Value("#{propertiesReader['action.expireTime']}")
	private String expireTime;
	
	@Autowired
	private RedisUtils redisUtil;
	
	@Autowired
	private ActionTemplateeDataOperator<BizType,Result,BizBean> actionTemplateeDataOperator;
	/**
	 * @param bizBean
	 * @param bizId
	 * @param actionTemplate
	 * @return
	 * @Description： 
	 */
	public  MoleActionTemplate<BizType,Result,BizBean>  generateActionTemplate(
			MoleActionTemplate<BizType,Result,BizBean> actionTemplate){
		
		MoleActionTemplate<BizType,Result,BizBean> action = new MoleActionTemplate<BizType,Result,BizBean>();
		
		BNBeanUtil.fieldCopy(MoleActionTemplate.class, actionTemplate, MoleActionTemplate.class, action);
		
		String instanceActionId = BNIdUtil.createUUIDByDATE("IA-");
		
		action.setTemplateActionId(instanceActionId);
		
		//TODO
		
		logger.debug("generate action instance success : "+instanceActionId);
		
		return action;
	}
	
	public boolean analyseActionTemplate(MoleInstance<BizType,Result,BizBean> instance,MoleActionTemplate<BizType,Result,BizBean> actionTemplate) throws InstanceAnalysisException{
		
		if(analyzer ==null){
			analyzer = new SimpleActionTemplateAnalyzerImpl<BizType, Result, BizBean>();
		}
		try{
			actionTemplate  = analyzer.analyseForExecute(actionTemplate);
		}catch(Exception e){
			throw new InstanceAnalysisException(e);
		}
		return true;
	}
	
	
	
	public boolean storeActionTemplate(MoleActionTemplate<BizType,Result,BizBean> actionTemplate){
		Long expireTime = actionTemplate.getExpireTime();
		expireTime = expireTime==null? Long.valueOf(this.expireTime) :expireTime;
		logger.debug("Instance expireTime is "+expireTime);
		redisUtil.setValueCache(actionTemplate.getTemplateActionId(), actionTemplate,expireTime );
		return true;
	}
	
	/**
	 * @param instance
	 * @param actionTemplate
	 * @return
	 */
	public boolean installActionTemplate(MoleTemplate<BizType,Result> instance,MoleActionTemplate<BizType,Result,BizBean> actionTemplate){
		
		//actionTemplateeDataOperator.addActionId(instance,actionTemplate.getTemplateActionId());
		
		return true;
	}

	
	

	public Analyzer<MoleActionTemplate<BizType, Result, BizBean>> getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(Analyzer<MoleActionTemplate<BizType, Result, BizBean>> analyzer) {
		this.analyzer = analyzer;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}
}
