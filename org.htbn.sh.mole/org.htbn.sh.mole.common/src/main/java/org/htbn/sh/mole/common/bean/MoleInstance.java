package org.htbn.sh.mole.common.bean;

import java.util.List;
import java.util.Set;

import org.htbn.sh.mole.common.enums.ActionStatus;

@SuppressWarnings("serial")
public class MoleInstance<BizType,Result,BizId> extends MoleTemplate<BizType,Result>{
	
	private String instanceId;
	
	private ActionStatus insStatus;
	
	private Result insResult;
	
	private BizId bizId;
	
	private Set<String> insActionIds;
	
	private Set<Integer> insNumbers;
	
	//该实例所依赖的节点实例Id号码
	private List<String> dependeceIds;

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public ActionStatus getInsStatus() {
		return insStatus;
	}

	public void setInsStatus(ActionStatus insStatus) {
		this.insStatus = insStatus;
	}

	public Result getInsResult() {
		return insResult;
	}

	public void setInsResult(Result insResult) {
		this.insResult = insResult;
	}

	public BizId getBizId() {
		return bizId;
	}

	public void setBizId(BizId bizId) {
		this.bizId = bizId;
	}

	public Set<String> getInsActionIds() {
		return insActionIds;
	}

	public void setInsActionIds(Set<String> insActionIds) {
		this.insActionIds = insActionIds;
	}

	public List<String> getDependeceIds() {
		return dependeceIds;
	}

	public void setDependeceIds(List<String> dependeceIds) {
		this.dependeceIds = dependeceIds;
	}

	public Set<Integer> getInsNumbers() {
		return insNumbers;
	}

	public void setInsNumbers(Set<Integer> insNumbers) {
		this.insNumbers = insNumbers;
	}
	
}
