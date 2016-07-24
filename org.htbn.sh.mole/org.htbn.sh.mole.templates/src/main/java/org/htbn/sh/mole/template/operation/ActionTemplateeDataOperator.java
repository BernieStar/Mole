package org.htbn.sh.mole.template.operation;

import org.htbn.sh.mole.common.bean.MoleActionTemplate;
import org.htbn.sh.mole.common.enums.ActionStatus;
import org.htbn.sh.mole.common.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionTemplateeDataOperator<BizType, Result, BizBean> {
private static final Logger logger = LoggerFactory.getLogger(ActionTemplateeDataOperator.class);
	
	@Autowired
	private RedisUtils redisUtil;
	
	public MoleActionTemplate<BizType, Result, BizBean> loadActionInstance(String ActionInstanceId){
		
		return (MoleActionTemplate<BizType, Result, BizBean>) redisUtil.getValueCache(ActionInstanceId);
	}
	
	public boolean updateActionInstance(MoleActionTemplate<BizType, Result, BizBean> actionInstance){
		
		return false;
	}
	public boolean updateActionInstanceStatus(MoleActionTemplate<BizType, Result, BizBean> actionInstance,ActionStatus status){
		
		return false;
	}
	public boolean updateActionInstanceResult(MoleActionTemplate<BizType, Result, BizBean> actionInstance,Result result){
		
		return false;
	}
	public boolean updateActionInstanceBizBean(MoleActionTemplate<BizType, Result, BizBean> actionInstance,BizBean b){
		
		return false;
	}
	
	public boolean updateActionInstanceBizId(MoleActionTemplate<BizType, Result, BizBean> actionInstance,String bizId){
		
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
	
	
	public Integer getMaxNumber(MoleActionTemplate<BizType, Result, BizBean> actionInstance){
		
		return 0;
	}
	
	public boolean addDependeceIds(MoleActionTemplate<BizType, Result, BizBean> actionInstance){
		
		return false;
	}

}
