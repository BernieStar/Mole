package org.htbn.sh.mole.instances.operation;

import org.htbn.sh.mole.common.bean.MoleActionInstance;
import org.htbn.sh.mole.common.enums.ActionStatus;
import org.htbn.sh.mole.common.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActionDataOperator<BizType, Result, BizBean> {
private static final Logger logger = LoggerFactory.getLogger(ActionDataOperator.class);
	
	@Autowired
	private RedisUtils redisUtil;
	
	public MoleActionInstance<BizType, Result, BizBean> loadActionInstance(String ActionInstanceId){
		
		return (MoleActionInstance<BizType, Result, BizBean>) redisUtil.getValueCache(ActionInstanceId);
	}
	
	public boolean updateActionInstance(MoleActionInstance<BizType, Result, BizBean> actionInstance){
		
		return false;
	}
	public boolean updateActionInstanceStatus(MoleActionInstance<BizType, Result, BizBean> actionInstance,ActionStatus status){
		
		return false;
	}
	public boolean updateActionInstanceResult(MoleActionInstance<BizType, Result, BizBean> actionInstance,Result result){
		
		return false;
	}
	public boolean updateActionInstanceBizBean(MoleActionInstance<BizType, Result, BizBean> actionInstance,BizBean b){
		
		return false;
	}
	
	public boolean updateActionInstanceBizId(MoleActionInstance<BizType, Result, BizBean> actionInstance,String bizId){
		
		return false;
	}
	
	/**
	 * @param actionInstance
	 * @return
	 * @Description： 动态clone节点并增加到实例
	 */
	public boolean cloneActionByActionTempId(String actionTempId,BizBean bizBean,String bizId){
		
		return false;
	}
	
	
	public Integer getMaxNumber(MoleActionInstance<BizType, Result, BizBean> actionInstance){
		
		return 0;
	}
	
	public boolean addDependeceIds(MoleActionInstance<BizType, Result, BizBean> actionInstance){
		
		return false;
	}
}
