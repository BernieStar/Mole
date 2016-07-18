package org.htbn.sh.mole.analyzer;

import org.htbn.sh.mole.common.bean.MoleInstance;

public interface InstanceAnalyzer<BizType,Result,BizId> {
	
	public MoleInstance<BizType,Result,BizId> analyseForBiz(MoleInstance<BizType,Result,BizId> instance);
	
	public MoleInstance<BizType,Result,BizId> analyseForExecute(MoleInstance<BizType,Result,BizId> instance);
}
