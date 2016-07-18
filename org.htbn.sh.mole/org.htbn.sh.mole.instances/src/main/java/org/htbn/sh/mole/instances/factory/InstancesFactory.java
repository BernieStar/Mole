package org.htbn.sh.mole.instances.factory;

import java.util.List;

import org.htbn.sh.mole.analyzer.InstanceAnalyzer;
import org.htbn.sh.mole.analyzer.impl.SimpleInstanceAnalyzerImpl;
import org.htbn.sh.mole.common.bean.MoleInstance;
import org.htbn.sh.mole.common.bean.MoleTemplate;
import org.htbn.sh.mole.common.enums.ActionStatus;
import org.htbn.sh.mole.common.exception.InstanceAnalysisException;
import org.htbn.sh.mole.common.util.BNBeanUtil;
import org.htbn.sh.mole.common.util.BNIdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstancesFactory <BizType,Result,BizBean,BizId>{
	
	private static final Logger logger = LoggerFactory.getLogger(InstancesFactory.class);
	
	private InstanceAnalyzer<BizType,Result,BizId> instanceAnalyzer;
	
	public MoleInstance<BizType,Result,BizId> generateInsstance(BizType bizType,Result insResult,BizId bizId,MoleTemplate<BizType,Result> template, ActionStatus insStatus){
		
		generateInsstance(bizType,insResult,bizId,template, insStatus, null);
		
		return null;
	}
	
	public MoleInstance<BizType,Result,BizId> generateInsstance(BizType bizType,Result insResult,BizId bizId,MoleTemplate<BizType,Result> template, ActionStatus insStatus, List<String> dependeceIds){
		
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
	
	public boolean storeInstance(){
		return false;
	}

	public InstanceAnalyzer<BizType,Result,BizId> getInstanceAnalyzer() {
		return instanceAnalyzer;
	}

	public void setInstanceAnalyzer(InstanceAnalyzer<BizType,Result,BizId> instanceAnalyzer) {
		this.instanceAnalyzer = instanceAnalyzer;
	}
}
