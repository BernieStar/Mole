package org.htbn.sh.mole.instances.factory;

import java.util.LinkedHashSet;
import java.util.Set;

import org.htbn.sh.mole.common.bean.MoleActionInstance;
import org.htbn.sh.mole.common.bean.MoleActionTemplate;
import org.htbn.sh.mole.common.bean.MoleInstance;
import org.htbn.sh.mole.common.util.BNBeanUtil;
import org.htbn.sh.mole.common.util.BNIdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @param <BizType>
 * @param <Result>
 * @param <BizBean>
 * @param <BizId>
 * <li><b>ClassName :</b> ActionFactory</li>
 * <li><b>Author :   </b> Bernie</li>
 * <li><b>Date :     </b> 2016年7月19日 上午12:03:53</li>
 * <li><b>Description :</b> ActionFactory </li>
 * <style>*{color:#145b7d;}li{color:#00a6ac;list-style-type:square;}li b{color:#2585a6;}</style>
 */
public class ActionFactory<BizType,Result,BizBean,BizId> {
	
	private static final Logger logger = LoggerFactory.getLogger(ActionFactory.class);
	/**
	 * @param bizBean
	 * @param bizId
	 * @param actionTemplate
	 * @return
	 * @Description： 
	 */
	public  MoleActionInstance<BizType,Result,BizBean>  generateActionInstance(
			BizBean bizBean,String bizId,MoleActionTemplate<BizType,Result,BizBean> actionTemplate){
		
		MoleActionInstance<BizType,Result,BizBean> action = new MoleActionInstance<BizType,Result,BizBean>();
		
		BNBeanUtil.fieldCopy(MoleActionTemplate.class, actionTemplate, MoleActionInstance.class, action);
		
		String instanceActionId = BNIdUtil.createUUIDByDATE("IA-");
		
		action.setInstanceActionId(instanceActionId);
		
		action.setStatus(actionTemplate.getDefaultStatus());
		
		action.setResult(actionTemplate.getDefaultResult());
		
		action.setBizId(bizId);
		
		action.setBizBean(bizBean);
		
		logger.debug("generate action instance success : "+instanceActionId);
		
		return action;
	}
	
	/**
	 * @param instance
	 * @param actionInstance
	 * @return
	 */
	public boolean installActionInstance(MoleInstance<BizType,Result,BizBean> instance,MoleActionInstance<BizType,Result,BizBean> actionInstance){
		
		Set<String> ActionIds  = instance.getInsActionIds();
		ActionIds = ActionIds==null? new LinkedHashSet<String>():ActionIds;
		ActionIds.add(actionInstance.getInstanceActionId());
		
		
		Set<Integer> numbers = instance.getInsNumbers();
		if(!numbers.contains(actionInstance.getNumber())){
			numbers.add(actionInstance.getNumber());
		}
		return true;
	}
	
	public boolean storeActionInstance(MoleActionInstance<BizType,Result,BizBean> actionInstance){
		
		return false;
	}
	
	
}
