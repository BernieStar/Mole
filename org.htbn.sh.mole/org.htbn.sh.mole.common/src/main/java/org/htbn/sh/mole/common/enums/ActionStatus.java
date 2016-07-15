package org.htbn.sh.mole.common.enums;

public enum ActionStatus {
	//待执行,满足条件即可执行
	READY(0),
	//执行中
	ACTIVE(1),
	//挂起,挂起状态由对外接口操作产生，必须由接口操作重置状态
	PENDING(2),
	//成功结束
	SUCESS(3),
	
	//失败结束
	FAIL(-1),
	//强制结束
	EXPECTED(-2);
	
	
	
	private int value;

	private ActionStatus(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
