package org.htbn.sh.mole.common.enums;

public enum InstanceStatus {
	//准备
	READY(0),
	//运行
	ACTIVE(1),
	//挂起,挂起状态由对外接口操作产生，必须由接口操作重置状态，挂起状态的实例，所有待执行节点都不可执行
	PENDING(2),
	//成功结束
	SUCESS(3),
	//失败结束
	FAIL(-1),
	//强制结束
	EXPECTED(-2);
	
	private int value;

	private InstanceStatus(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
