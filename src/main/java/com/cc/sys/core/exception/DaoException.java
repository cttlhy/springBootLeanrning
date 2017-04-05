package com.cc.sys.core.exception;

import org.springframework.dao.DataAccessException;

public class DaoException extends DataAccessException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaoException(String msg, Throwable cause) {
		super(msg, cause);
	}
	public DaoException(String msg) {
		super(msg);
	}
	
}
