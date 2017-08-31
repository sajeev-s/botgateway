package it.sella.bg.im.dto.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IMResponse {

	List<String> requests;
	List<String> codes;
	String contextChange;
	Map<String, String> concepts;
	Map<String, String> favorites;
	String chatid;
	String chaturl;
	String result;
	String cause;
	String licenses;
	List<String> transcript;// Don't know type detail

	public List<String> getRequests() {
		return requests;
	}

	public void setRequests(final List<String> requests) {
		this.requests = requests;
	}

	public List<String> getCodes() {
		return codes;
	}

	public void setCodes(final List<String> codes) {
		this.codes = codes;
	}

	public String getContextChange() {
		return contextChange;
	}

	public void setContextChange(final String contextChange) {
		this.contextChange = contextChange;
	}

	public Map<String, String> getConcepts() {
		return concepts;
	}

	public void setConcepts(final Map<String, String> concepts) {
		this.concepts = concepts;
	}

	public Map<String, String> getFavorites() {
		return favorites;
	}

	public void setFavorites(final Map<String, String> favorites) {
		this.favorites = favorites;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public List<String> getTranscript() {
		return transcript;
	}

	public void setTranscript(List<String> transcript) {
		this.transcript = transcript;
	}

	public String getChatid() {
		return chatid;
	}

	public void setChatid(String chatid) {
		this.chatid = chatid;
	}

	public String getLicenses() {
		return licenses;
	}

	public void setLicenses(String licenses) {
		this.licenses = licenses;
	}

	public String getChaturl() {
		return chaturl;
	}

	public void setChaturl(String chaturl) {
		this.chaturl = chaturl;
	}

}
