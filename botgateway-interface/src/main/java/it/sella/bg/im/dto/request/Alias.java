package it.sella.bg.im.dto.request;

import java.util.List;

public class Alias {

	String Concept;
	String token;
	List<Interpretation> interpretations;

	public String getConcept() {
		return this.Concept;
	}

	public void setConcept(final String concept) {
		this.Concept = concept;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(final String token) {
		this.token = token;
	}

	public List<Interpretation> getInterpretations() {
		return this.interpretations;
	}

	public void setInterpretations(List<Interpretation> interpretations) {
		this.interpretations = interpretations;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("$Concept-->").append(this.Concept).append("$token-->").append(this.token);

		for (final Interpretation interpretation : this.interpretations) {
			builder.append("$interpretation-Name-->").append(interpretation.getName());
			builder.append("$interpretation-value-->").append(interpretation.getValue()).append("#");
		}

		return builder.toString();
	}

}
