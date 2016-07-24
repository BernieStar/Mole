package org.htbn.sh.mole.instances.operation;

import org.htbn.sh.mole.common.bean.MoleInstance;
import org.htbn.sh.mole.common.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @param <BizType>
 * @param <Result>
 * @param <BizId>
 * <li><b>ClassName :</b> InstancesDataOperator</li>
 * <li><b>Author :   </b> Bernie</li>
 * <li><b>Date :     </b> 2016年7月22日 下午10:31:36</li>
 * <li><b>Description :</b> InstancesDataOperator </li>
 * <style>*{color:#145b7d;}li{color:#00a6ac;list-style-type:square;}li b{color:#2585a6;}</style>
 */
@Component
public class InstancesDataOperator<BizType,Result,BizId> {
	
	private static final Logger logger = LoggerFactory.getLogger(InstancesDataOperator.class);
	
	@Autowired
	private RedisUtils redisUtil;
	
	public MoleInstance<BizType,Result,BizId> loadInsstance(String instanceId){
		
		return (MoleInstance<BizType, Result, BizId>) redisUtil.getValueCache(instanceId);
	}
	
	public boolean updateInstance(MoleInstance<BizType,Result,BizId> instance){
		
		return false;
	}
	public boolean updateInstanceStatus(MoleInstance<BizType,Result,BizId> instance){
		
		return false;
	}
	public boolean updateInstanceResult(MoleInstance<BizType,Result,BizId> instance){
		
		return false;
	}
	
	public boolean updateInstanceBizId(MoleInstance<BizType,Result,BizId> instance){
		
		return false;
	}
	
	/**
	 * @param instance
	 * @return
	 * @Description： 同时获取最大ActionNumber并+1后add到insNumbers
	 */
	public boolean addActionId(MoleInstance<BizType,Result,BizId> instance,String actionId){
		
		return false;
	}
	
	
	public Integer getMaxNumber(MoleInstance<BizType,Result,BizId> instance){
		
		return 0;
	}
	
	public boolean addDependeceIds(MoleInstance<BizType,Result,BizId> instance){
		
		return false;
	}

}
