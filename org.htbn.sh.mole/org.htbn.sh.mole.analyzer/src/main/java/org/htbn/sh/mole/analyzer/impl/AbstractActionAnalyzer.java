package org.htbn.sh.mole.analyzer.impl;

import org.htbn.sh.mole.analyzer.Analyzer;
import org.htbn.sh.mole.common.bean.MoleActionInstance;

public abstract class AbstractActionAnalyzer<BizType,Result,BizBean> implements Analyzer<MoleActionInstance<BizType, Result, BizBean>>{

	@Override
	public abstract MoleActionInstance<BizType, Result, BizBean> analyseForBiz(MoleActionInstance<BizType, Result, BizBean> action);

	@Override
	public MoleActionInstance<BizType, Result, BizBean> analyseForExecute(MoleActionInstance<BizType, Result, BizBean> action) {
		// TODO Auto-generated method stub
		return analyseForBiz(action);
	}

}
