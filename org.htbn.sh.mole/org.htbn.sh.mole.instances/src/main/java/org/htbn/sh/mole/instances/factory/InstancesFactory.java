package org.htbn.sh.mole.instances.factory;

import java.util.List;

import org.htbn.sh.mole.analyzer.InstanceAnalyzer;
import org.htbn.sh.mole.analyzer.impl.SimpleInstanceAnalyzerImpl;
import org.htbn.sh.mole.common.bean.MoleInstance;
import org.htbn.sh.mole.common.bean.MoleTemplate;
import org.htbn.sh.mole.common.enums.InstanceStatus;
import org.htbn.sh.mole.common.exception.InstanceAnalysisException;
import org.htbn.sh.mole.common.util.BNBeanUtil;
import org.htbn.sh.mole.common.util.BNIdUtil;
import org.htbn.sh.mole.instances.redis.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InstancesFactory <BizType,Result,BizBean,BizId>{
	
	private static final Logger logger = LoggerFactory.getLogger(InstancesFactory.class);
	
	@Value("#{propertiesReader['instance.expireTime']}")
	private String expireTime;
	
	@Autowired
	private RedisUtils redisUtil;
	
	/**
	 * 不同的业务流程采用不用的分析器，所以不自动注入，需通过代码操作来set一个实现。
	 */
	private InstanceAnalyzer<BizType,Result,BizId> instanceAnalyzer;
	
	public MoleInstance<BizType,Result,BizId> generateInsstance(BizType bizType,Result insResult,BizId bizId,MoleTemplate<BizType,Result> template, InstanceStatus insStatus){
		
		return generateInsstance(bizType,insResult,bizId,template, insStatus, null);
	}
	
	public MoleInstance<BizType,Result,BizId> generateInsstance(BizType bizType,Result insResult,BizId bizId,MoleTemplate<BizType,Result> template, InstanceStatus insStatus, List<String> dependeceIds){
		
		MoleInstance<BizType,Result,BizId> instance = new MoleInstance<BizType,Result,BizId>();
		
		BNBeanUtil.fieldCopy(MoleTemplate.class, template, MoleInstance.class, instance);
		
		String instanceId = BNIdUtil.createUUIDByDATE("I-");
		
		instance.setInstanceId(instanceId);
		
		instance.setBizId(bizId);
		
		instance.setInsResult(insResult);
		
		instance.setInsStatus(insStatus);
		
		instance.setDependeceIds(dependeceIds);
		
		logger.debug("Generate Moleinstance success : "+instanceId);
		 
		return instance;
	}
	
	public boolean analyseInstance(MoleInstance<BizType,Result,BizId> instance) throws InstanceAnalysisException{
		if(instanceAnalyzer ==null){
			instanceAnalyzer = new SimpleInstanceAnalyzerImpl<BizType, Result, BizId>();
		}
		try{
			instance  = instanceAnalyzer.analyseForExecute(instance);
		}catch(Exception e){
			throw new InstanceAnalysisException(e);
		}
		
		return false;
	}
	
	public boolean storeInstance(MoleInstance<BizType,Result,BizId> instance){
		logger.debug("Instance expireTime is "+expireTime);
		redisUtil.setValueCache(instance.getInstanceId(), instance, Long.valueOf(expireTime));
		return true;
	}

	public InstanceAnalyzer<BizType,Result,BizId> getInstanceAnalyzer() {
		return instanceAnalyzer;
	}

	public void setInstanceAnalyzer(InstanceAnalyzer<BizType,Result,BizId> instanceAnalyzer) {
		this.instanceAnalyzer = instanceAnalyzer;
	}
}
