package org.htbn.sh.mole.common.bean;

import java.io.Serializable;
import java.util.List;

import org.htbn.sh.mole.common.enums.ActionStatus;
import org.htbn.sh.mole.common.enums.ActionType;
import org.htbn.sh.mole.common.io.BizAction;

/**
 * @author Bernie
 * 节点说明：
 */
@SuppressWarnings("serial")
public class MoleActionTemplate<BizType,Result,BizBean> implements Serializable{
	
	private String templateActionId;
	
	private String ActionName;
	
	//模板内节点号码，与执行顺序无关
	private Integer number;
	
	private ActionType type;
	
	//是否即时返回执行结果
	private boolean isSyn = true;
	
	//disabled = true 时，节点不可用，不参与实例状态计算，所有依赖节点不可执行
	private boolean disabled ;
	
	//read only = true 时，节点不可执行，不参与实例状态计算，所有依赖节点默认满足条件可执行
	private boolean readonly ;
	
	//生成节点模板时，由业务注入泛型默认结果
	private ActionStatus defaultStatus;
	
	private Result defaultResult;
	
	//业务分类标识
	private BizType bizType;
	
	//被该节点所依赖的节点号码
	private List<Integer> dependeceNumbers;
	
	//依赖该节点的节点号码
	private List<Integer> branchNumbers;
	
	private BizAction<BizBean> bizAction;

	public String getTemplateActionId() {
		return templateActionId;
	}

	public void setTemplateActionId(String templateActionId) {
		this.templateActionId = templateActionId;
	}

	public String getActionName() {
		return ActionName;
	}

	public void setActionName(String actionName) {
		ActionName = actionName;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public ActionType getType() {
		return type;
	}

	public void setType(ActionType type) {
		this.type = type;
	}

	public boolean isSyn() {
		return isSyn;
	}

	public void setSyn(boolean isSyn) {
		this.isSyn = isSyn;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public boolean isReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	public ActionStatus getDefaultStatus() {
		return defaultStatus;
	}

	public void setDefaultStatus(ActionStatus defaultStatus) {
		this.defaultStatus = defaultStatus;
	}

	public Result getDefaultResult() {
		return defaultResult;
	}

	public void setDefaultResult(Result defaultResult) {
		this.defaultResult = defaultResult;
	}

	public BizType getBizType() {
		return bizType;
	}

	public void setBizType(BizType bizType) {
		this.bizType = bizType;
	}

	public List<Integer> getDependeceNumbers() {
		return dependeceNumbers;
	}

	public void setDependeceNumbers(List<Integer> dependeceNumbers) {
		this.dependeceNumbers = dependeceNumbers;
	}

	public BizAction<BizBean> getBizAction() {
		return bizAction;
	}

	public void setBizAction(BizAction<BizBean> bizAction) {
		this.bizAction = bizAction;
	}

	public List<Integer> getBranchNumbers() {
		return branchNumbers;
	}

	public void setBranchNumbers(List<Integer> branchNumbers) {
		this.branchNumbers = branchNumbers;
	}
	
}
