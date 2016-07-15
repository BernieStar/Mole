package org.htbn.sh.mole.common.enums;

public enum TemplateType {
		//主流程，不依赖其他节点
		MAIN (0),
		
		//下级流程，依赖于其他节点的成功结束状态来启动
		SUITE (1),
		
		//伴生流程，依赖于其他节点的执行中状态	
		RETINUE (2),
		
		// 补偿从流程，依赖于其他节点的失败结束状态
		COMPENSATION(3);
		
		
		private int value;

		private TemplateType(int value){
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
}
