package br.com.gestionnaire.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "phrases")
public class ListaPhrases implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Phrase> phrases;

	@XmlElement(name = "PHRASE")
	public List<Phrase> getPhrases() {
		return phrases;
	}

	public void setPhrases(List<Phrase> phrases) {
		this.phrases = phrases;
	}

	@Override
	public String toString() {
		return "ListaPhrases [Phrases=" + phrases + "]";
	}
}