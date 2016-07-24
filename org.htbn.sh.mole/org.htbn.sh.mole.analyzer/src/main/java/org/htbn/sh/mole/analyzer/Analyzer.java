package org.htbn.sh.mole.analyzer;


public interface Analyzer<T> {
	
	public T analyseForBiz(T t);
	
	public T analyseForExecute(T t);
}
