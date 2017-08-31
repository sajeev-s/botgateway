package it.sella.bg.external.im;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import it.sella.bg.im.dto.request.IMRequest;
import it.sella.bg.im.dto.response.IMResponse;

@Component
public class IMserviceImpl implements IMservice{

	private static final Logger logger = Logger.getLogger(IMserviceImpl.class);
	@Value("${IM_URL}")
	private String url; //="http://sede.imservicelab.com:18002/External/ChatInterface/index.php";

	@Override
	public IMResponse message(IMRequest imRequest){
		logger.info("imRequest.getAction()-->"+imRequest.getAction());
		System.setProperty("java.net.useSystemProxies", "true");
		final RestTemplate restTemplate = new RestTemplate();
		/*final MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
    	headers.set("Ocp-Apim-Subscription-Key", accessDetailDTO.getToken());//"6b6870805fb6475eb43aa02071c2df77"
    	headers.set("Content-Type", "application/json");*/
		final HttpEntity<Object> entity = new HttpEntity<Object>(imRequest);//,headers
		//    	restTemplate.setRequestFactory(getRequestFactory());
		System.out.println("url -->"+this.url);
		if(StringUtils.isNotEmpty(imRequest.getChaturl())){
			this.url = imRequest.getChaturl();
		}
		System.out.println("url -->"+this.url);
		final ResponseEntity<IMResponse> responseEntity = restTemplate.exchange(this.url, HttpMethod.POST, entity, IMResponse.class);
		final IMResponse imResponse = responseEntity.getBody();

		System.out.println("imResponse -->"+imResponse.getResult()+" -- "+imResponse.getCause());
		return imResponse;
	}

	private static ClientHttpRequestFactory getRequestFactory(){
		final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		final HttpHost myProxy = new HttpHost("proxy-na.gbs.pre", 8080);
		final HttpClientBuilder clientBuilder = HttpClientBuilder.create();
		clientBuilder.setProxy(myProxy);
		requestFactory.setHttpClient(clientBuilder.build());
		return requestFactory;
	}
}
