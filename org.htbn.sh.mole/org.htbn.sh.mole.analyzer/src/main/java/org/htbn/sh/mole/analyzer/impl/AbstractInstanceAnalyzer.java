package org.htbn.sh.mole.analyzer.impl;

import org.htbn.sh.mole.analyzer.Analyzer;
import org.htbn.sh.mole.common.bean.MoleInstance;

public abstract class AbstractInstanceAnalyzer<BizType, Result, BizId> implements Analyzer<MoleInstance<BizType, Result, BizId>>{

	@Override
	public abstract MoleInstance<BizType, Result, BizId> analyseForBiz(MoleInstance<BizType, Result, BizId> instance) ;

	@Override
	public MoleInstance<BizType, Result, BizId> analyseForExecute(MoleInstance<BizType, Result, BizId> instance) {
		// TODO Auto-generated method stub
		
		return analyseForBiz(instance);
	}

}
