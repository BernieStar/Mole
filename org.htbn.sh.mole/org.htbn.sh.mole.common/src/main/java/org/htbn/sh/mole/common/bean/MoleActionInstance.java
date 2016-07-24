package org.htbn.sh.mole.common.bean;

import java.util.List;

import org.htbn.sh.mole.common.enums.ActionStatus;

@SuppressWarnings("serial")
public class MoleActionInstance<BizType,Result,BizBean> extends MoleActionTemplate<BizType,Result,BizBean>{
	
	private String instanceActionId;
	
	private ActionStatus status;
	
	private Result result;
	
	private String bizId;
	
	private BizBean bizBean;
	
	
	//依赖该节点的实例ID
	private List<Integer> branchInstanceIds;

	public String getInstanceActionId() {
		return instanceActionId;
	}

	public void setInstanceActionId(String instanceActionId) {
		this.instanceActionId = instanceActionId;
	}

	public ActionStatus getStatus() {
		return status;
	}

	public void setStatus(ActionStatus status) {
		this.status = status;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public List<Integer> getBranchInstanceIds() {
		return branchInstanceIds;
	}

	public void setBranchInstanceIds(List<Integer> branchInstanceIds) {
		this.branchInstanceIds = branchInstanceIds;
	}

	public BizBean getBizBean() {
		return bizBean;
	}

	public void setBizBean(BizBean bizBean) {
		this.bizBean = bizBean;
	}
	
	
	
}
