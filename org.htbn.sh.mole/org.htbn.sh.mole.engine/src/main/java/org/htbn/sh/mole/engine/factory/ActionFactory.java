package org.htbn.sh.mole.engine.factory;

import java.util.LinkedHashSet;
import java.util.Set;

import org.htbn.sh.mole.common.bean.MoleActionInstance;
import org.htbn.sh.mole.common.bean.MoleActionTemplate;
import org.htbn.sh.mole.common.bean.MoleInstance;
import org.htbn.sh.mole.common.util.BNBeanUtil;
import org.htbn.sh.mole.common.util.BNIdUtil;


public class ActionFactory {
	
	public <BizType,Result,BizBean,BizId> MoleActionInstance<BizType,Result,BizBean>  generateActionInstance(
			BizBean bizBean,String bizId,MoleActionTemplate<BizType,Result,BizBean> actionTemplate){
		
		MoleActionInstance<BizType,Result,BizBean> action = new MoleActionInstance<BizType,Result,BizBean>();
		
		BNBeanUtil.fieldCopy(MoleActionTemplate.class, actionTemplate, MoleActionInstance.class, action);
		
		String instanceActionId = BNIdUtil.createUUIDByDATE("I-");
		
		action.setInstanceActionId(instanceActionId);
		
		action.setStatus(actionTemplate.getDefaultStatus());
		
		action.setResult(actionTemplate.getDefaultResult());
		
		action.setBizId(bizId);
		
		action.setBizBean(bizBean);
		
		return action;
	}
	
	public <BizType,Result,BizBean> boolean installActionInstance(MoleInstance<BizType,Result,BizBean> instance,MoleActionInstance<BizType,Result,BizBean> actionInstance){
		
		Set<String> ActionIds  = instance.getInsActionIds();
		ActionIds = ActionIds==null? new LinkedHashSet<String>():ActionIds;
		ActionIds.add(actionInstance.getInstanceActionId());
		
		
		Set<Integer> numbers = instance.getInsNumbers();
		if(!numbers.contains(actionInstance.getNumber())){
			numbers.add(actionInstance.getNumber());
		}
		return true;
	}
	
	public <BizType,Result,BizBean> boolean storeActionInstance(MoleActionInstance<BizType,Result,BizBean> actionInstance){
		
		return false;
	}
	
	
}
