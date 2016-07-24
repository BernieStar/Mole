package org.htbn.sh.mole.common.bean;

import java.util.List;
import java.util.Set;

import org.htbn.sh.mole.common.enums.InstanceStatus;

/**
 * @param <BizType>
 * @param <Result>
 * @param <BizId>
 * @author : Bernie
 * @Description : TODO
 */
@SuppressWarnings("serial")
public class MoleInstance<BizType,Result,BizId> extends MoleTemplate<BizType,Result>{
	
	/**
	 * 实例ID。
	 */
	private String instanceId;
	
	/**
	 * 实例初始状态。
	 */
	private InstanceStatus insStatus;
	
	/**
	 * 实例初始结果。
	 */
	private Result insResult;
	
	/**
	 * 业务对象关联ID。非常重要。通常一个实例服务于一个业务CASE。
	 */
	private BizId bizId;
	
	/**
	 * 实例包含的节点实例ID集合，支持动态添加节点，所以该集合Size会大于模板相关集合Size。
	 */
	private Set<String> insActionIds;
	
	/**
	 *  实例包含的节点实例序号集合，支持动态添加节点，所以该集合Size会大于模板相关集合Size。
	 */
	private Set<Integer> insNumbers;
	
	/**
	 * 该实例所依赖的节点实例Id号码。
	 */
	private List<String> dependeceIds;

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public InstanceStatus getInsStatus() {
		return insStatus;
	}

	public void setInsStatus(InstanceStatus insStatus) {
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
