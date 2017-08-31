package it.sella.bg.exception;

import java.util.List;

public interface IBGException {

	public List<ExceptionMessage> getExceptionMessage();


	public BGError[] getBGError();


}
