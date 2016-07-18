package org.htbn.sh.mole.common.exception;

@SuppressWarnings("serial")
public class InstanceAnalysisException extends Exception{
	/**
	 * 
	 */
	public InstanceAnalysisException() {
		super();
	}

	/**
	 * @param msg
	 * @param exp
	 */
	public InstanceAnalysisException(String msg, Throwable exp) {
		super(msg, exp);
	}

	/**
	 * @param msg
	 */
	public InstanceAnalysisException(String msg) {
		super(msg);
	}

	/**
	 * @param exp
	 */
	public InstanceAnalysisException(Throwable exp) {
		super(exp);
	}
}
