package it.sella.bg.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class BGException extends RuntimeException implements IBGException{


	private static final long serialVersionUID = -3254086682593991984L;
	public BGError[] BGErrors;


	public BGException(final BGError BGError) {
		this.BGErrors = new BGError[]{BGError};
	}

	public BGException(final BGError[] BGError, final Throwable throwable) {
		super(throwable);
		this.BGErrors = BGError;
	}

	public BGException(final BGError BGError,final Throwable throwable) {
		super(throwable);
		this.BGErrors = new BGError[]{BGError};
	}

	public BGException(final BGError BGError, final String message) {
		super(message);
		this.BGErrors = new BGError[]{BGError};
	}

	public BGException( final Throwable throwable) {
		super(throwable);
		this.BGErrors = new BGError[]{BGError.MSG_101};
	}

	@Override
	public List<ExceptionMessage> getExceptionMessage() {
		final StringWriter errors = new StringWriter();
		this.printStackTrace(new PrintWriter(errors));
		final List<ExceptionMessage> exceptionMessages = new ArrayList<ExceptionMessage>();
		for (final BGError BGError : this.BGErrors) {
			exceptionMessages.add(new ExceptionMessage(BGError, this.getMessage(),errors.toString()));
		}
		return exceptionMessages;
	}

	@Override
	public BGError[] getBGError() {
		return this.BGErrors;
	}


}
