package org.htbn.sh.mole.analyzer.impl;

import org.htbn.sh.mole.analyzer.Analyzer;
import org.htbn.sh.mole.common.bean.MoleActionTemplate;

public abstract class AbstractActionTemplateAnalyzer<BizType,Result,BizBean> implements Analyzer<MoleActionTemplate<BizType, Result, BizBean>>{

	@Override
	public abstract MoleActionTemplate<BizType, Result, BizBean> analyseForBiz(MoleActionTemplate<BizType, Result, BizBean> action);

	@Override
	public MoleActionTemplate<BizType, Result, BizBean> analyseForExecute(MoleActionTemplate<BizType, Result, BizBean> action) {
		// TODO Auto-generated method stub
		return analyseForBiz(action);
	}

}
