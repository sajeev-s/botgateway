package it.sella.bg.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExceptionMessage {

	String msg;
	String errorMessage;
	String errorStackTrace;
	String code;



	public ExceptionMessage(final BGError chatError,final String message ,final String errorStackTrace){
		this.code = chatError.errorCode();
		this.msg = chatError.errorMsg();
		this.errorStackTrace = errorStackTrace;
		this.errorMessage = message;
	}

	@JsonIgnore
	public String getErrorStackTrace(){
		String errorTrace = this.errorStackTrace;
		/**
		 * Line Added to avoid json response Misbehaviour 
		 */
		if(errorTrace!=null && errorTrace.length()>1020) {
			errorTrace = errorTrace.substring(0, 1020);
		}
		return errorTrace;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(final String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(final String code) {
		this.code = code;
	}




}
