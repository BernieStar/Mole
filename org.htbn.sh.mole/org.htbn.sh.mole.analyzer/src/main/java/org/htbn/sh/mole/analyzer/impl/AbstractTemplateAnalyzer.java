package org.htbn.sh.mole.analyzer.impl;

import org.htbn.sh.mole.analyzer.Analyzer;
import org.htbn.sh.mole.common.bean.MoleTemplate;

public abstract class AbstractTemplateAnalyzer<BizType, Result> implements Analyzer<MoleTemplate<BizType, Result>>{

	@Override
	public abstract MoleTemplate<BizType, Result> analyseForBiz(MoleTemplate<BizType, Result> t) ;

	@Override
	public MoleTemplate<BizType, Result> analyseForExecute(MoleTemplate<BizType, Result> t) {
		// TODO Auto-generated method stub
		
		return analyseForBiz(t);
	}

}
