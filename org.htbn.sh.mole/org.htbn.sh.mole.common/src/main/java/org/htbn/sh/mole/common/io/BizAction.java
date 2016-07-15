package org.htbn.sh.mole.common.io;

public interface BizAction<BizBean> {
	public BizBean executor(BizBean bizBean);
}
