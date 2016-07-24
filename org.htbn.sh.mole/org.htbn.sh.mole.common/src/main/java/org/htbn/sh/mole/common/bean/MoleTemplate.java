package org.htbn.sh.mole.common.bean;

import java.io.Serializable;
import java.util.Set;

import org.htbn.sh.mole.common.enums.InstanceStatus;
import org.htbn.sh.mole.common.enums.TemplateType;

/**
 * @param <BizType>
 * @param <Result>
 * @author : Bernie
 * @Description : 模板实体类
 */
@SuppressWarnings("serial")
public class MoleTemplate<BizType,Result> implements Serializable{

	/**
	 * 模板ID。
	 */
	private String templateId;
	
	/**
	 * 模板名称。取名时尽量不要重复。
	 */
	private String templateName;
	
	/**
	 * 模板类型，决定该模板产生的实例，初始运行动作与所依赖的节点的关系。
	 */
	private TemplateType type;
	
	/**
	 * 该字段并非决定模板缓存时间，而是统一设置该类模板实现类缓存存放默认时间，在实例对象创建后，可以为每个实例单独设置缓存时间。
	 */
	private Long expireTime;
	
	/**
	 * 模板优先级，优先级值越大，优先级越高，可以从业务出发进行资源优化配置，为业务场景服务。
	 */
	private int priority;

	/**
	 * 引擎执行该模板产生的实例包含的所有节点默认是否即时返回执行结果。
	 */
	private boolean isSyn = true;
	
	/**
	 * 业务分类标识，与业务相关
	 */
	private BizType bizType;
	
	/**
	 * 默认实例初始状态。
	 */
	private InstanceStatus defaultStatus;
	
	//
	/**
	 * 默认实例初始结果，生成模板时，由业务注入泛型默认结果。
	 */
	private Result defaultResult;
	
	/**
	 * 默认包含节点的内部序号集合。节点序号与执行顺序无关。
	 */
	private Set<Integer> defaultNumbers;
	
	/**
	 * 默认包含的节点ID集合。
	 */
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

	public Long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}

	public TemplateType getType() {
		return type;
	}

	public void setType(TemplateType type) {
		this.type = type;
	}

	
	
}
