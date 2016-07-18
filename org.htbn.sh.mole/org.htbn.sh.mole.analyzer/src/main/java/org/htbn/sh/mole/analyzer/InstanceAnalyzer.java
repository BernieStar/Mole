package org.htbn.sh.mole.analyzer;

import org.htbn.sh.mole.common.bean.MoleInstance;

public interface InstanceAnalyzer<BizType,Result,BizId> {
	public MoleInstance<BizType,Result,BizId> analysisInstance(MoleInstance<BizType,Result,BizId> instance);
}
