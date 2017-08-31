/**
 * 
 */
package it.sella.bg.exception;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public enum BGError {

	MSG_101("BT-101","Error Completing Request"),
	SQL_ERR;

	private String error_code;
	private String error_msg;
	private String msg;
	private static Map<String,BGError> sqlErrorCodeMap = new HashMap<String, BGError>();


	BGError(){
		//Empty Constructor
	}


	BGError(final String error_code,final String error_msg){
		this.error_code = error_code;
		this.error_msg = error_msg;
		this.msg = error_msg;
	}

	public String errorCode(){
		return this.error_code;
	}

	public String errorMsg(){
		return this.msg;
	}

	public String getConcatErrMsg(){
		final StringBuilder builder = new StringBuilder();
		builder.append(this.error_code).append(" : ").append(this.msg);
		return builder.toString();
	}


	/**
	 * Method FormatMessage.
	 * @param String... args
	 * @return BTError
	 */
	public BGError formatMessage(final String... args){
		this.msg = String.format(this.error_msg, args);
		return this;
	}


	/**
	 * Method getSQLErrorMsg.
	 * @param sqlEx SQLException
	 * @return BTError
	 */
	public BGError getSQLErrorMsg(final SQLException sqlEx){
		final String sqlErrorCode = String.valueOf(sqlEx.getErrorCode());
		final String sqlErrorMessage = sqlEx.getMessage();
		BGError  errMsg = MSG_101;
		if(isCustomSQLErrorCode(sqlErrorCode)){
			errMsg = getSQLErrorMsgMap().get(sqlErrorCode);
		}else if(sqlErrorMessage!=null && !sqlErrorMessage.trim().equals("")){
			this.error_code = "";
			this.error_msg = sqlErrorMessage.trim().toUpperCase();
			this.msg = this.error_msg;
			errMsg = SQL_ERR;
		}

		return errMsg;
	}

	private Map<String,BGError> getSQLErrorMsgMap(){
		//	if(sqlErrorCodeMap.isEmpty()){
		//sqlErrorCodeMap.put("20002", MSG_102);
		//	}
		return sqlErrorCodeMap;
	}



	private boolean isCustomSQLErrorCode(final String sqlErrorCode){

		return getSQLErrorMsgMap().containsKey(sqlErrorCode);
	}

}
