package com.projectname.testutils.testlink.xmlrpcclient;

/**
 * The exception is used to indicate the conditions under which a failure occurred during a call to a TestLink API Java
 * Client method.
 * 
 */
public class TestLinkAPIException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create exception with a message.
	 * 
	 * @param msg
	 */
	public TestLinkAPIException(String msg) {
		super(msg);
	}

	/**
	 * Create a nested exception with a new message.
	 * 
	 * @param msg
	 * @param e
	 */
	public TestLinkAPIException(String msg, Throwable e) {
		super(msg, e);
	}
}
