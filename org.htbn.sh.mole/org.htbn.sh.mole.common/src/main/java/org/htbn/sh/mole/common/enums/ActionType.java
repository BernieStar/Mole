package org.htbn.sh.mole.common.enums;

public enum ActionType {
	// 手动同步主节点：由业务操作触发的节点，并且不依赖于其他节点
	MANUAL_MAIN (0),
	
	// 手动同步从节点：由业务操作触发的节点，并且依赖于其他节点的成功结束状态
	MANUAL_SUITE (1),
	
	// 手动异步伴生节点：由业务操作触发的节点，并且依赖于其他节点的执行中状态	
	MANUAL_RETINUE (2),
	
	// 手动补偿从节点：由业务操作触发的节点，并且依赖于其他节点的失败结束状态
	MANUAL_COMPENSATION(3),
	
	// 自动异步主节点：实例安装后立即开始执行的节点，并且不依赖于其他节点
	AUTORUN_MAIN (5),
	
	// 自动同步从节点：由其他节点触发的自动节点，并且依赖其他节点的成功结束状态
	AUTORUN_SUITE (6),
	
	// 自动异步从节点：由其他节点触发的自动节点，并且依赖其他节点的执行中状态
	AUTORUN_RETINUE (7),
	
	// 自动补偿从节点：由其他节点触发的自动节点，并且依赖其他节点的失败结束状态
	AUTORUN_COMPENSATION (8);
	
	private int value;

	private ActionType(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
