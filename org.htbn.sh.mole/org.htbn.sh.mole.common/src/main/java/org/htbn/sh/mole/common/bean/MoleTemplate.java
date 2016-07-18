package org.htbn.sh.mole.common.bean;

import java.io.Serializable;
import java.util.Set;

import org.htbn.sh.mole.common.enums.InstanceStatus;

@SuppressWarnings("serial")
public class MoleTemplate<BizType,Result> implements Serializable{

	private String templateId;
	
	private String templateName;
	
	//模板优先级，优先级值越大，优先级越高，为业务场景服务
	private int priority;

	//模板内所有节点是否即时返回执行结果
	private boolean isSyn = true;
	
	//业务分类标识
	private BizType bizType;
	
	//默认状态
	private InstanceStatus defaultStatus;
	
	//默认结果生，成模板时，由业务注入泛型默认结果
	private Result defaultResult;
	
	private Set<Integer> defaultNumbers;
	
	private Set<String> defaultActionTemplateIds;

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isSyn() {
		return isSyn;
	}

	public void setSyn(boolean isSyn) {
		this.isSyn = isSyn;
	}

	public BizType getBizType() {
		return bizType;
	}

	public void setBizType(BizType bizType) {
		this.bizType = bizType;
	}

	public InstanceStatus getDefaultStatus() {
		return defaultStatus;
	}

	public void setDefaultStatus(InstanceStatus defaultStatus) {
		this.defaultStatus = defaultStatus;
	}

	public Result getDefaultResult() {
		return defaultResult;
	}

	public void setDefaultResult(Result defaultResult) {
		this.defaultResult = defaultResult;
	}

	public Set<Integer> getDefaultNumbers() {
		return defaultNumbers;
	}

	public void setDefaultNumbers(Set<Integer> defaultNumbers) {
		this.defaultNumbers = defaultNumbers;
	}

	public Set<String> getDefaultActionTemplateIds() {
		return defaultActionTemplateIds;
	}

	public void setDefaultActionTemplateIds(Set<String> defaultActionTemplateIds) {
		this.defaultActionTemplateIds = defaultActionTemplateIds;
	}

	
	
}
