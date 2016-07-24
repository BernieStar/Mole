package org.htbn.sh.mole.common.exception;

@SuppressWarnings("serial")
public class TemplateAnalysisException extends Exception{
	/**
	 * 
	 */
	public TemplateAnalysisException() {
		super();
	}

	/**
	 * @param msg
	 * @param exp
	 */
	public TemplateAnalysisException(String msg, Throwable exp) {
		super(msg, exp);
	}

	/**
	 * @param msg
	 */
	public TemplateAnalysisException(String msg) {
		super(msg);
	}

	/**
	 * @param exp
	 */
	public TemplateAnalysisException(Throwable exp) {
		super(exp);
	}

}
