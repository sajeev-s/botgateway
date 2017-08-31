package it.sella.bg.external.im;

import it.sella.bg.im.dto.request.IMRequest;
import it.sella.bg.im.dto.response.IMResponse;


public interface IMservice {

	public IMResponse message(IMRequest imRequest);
}
