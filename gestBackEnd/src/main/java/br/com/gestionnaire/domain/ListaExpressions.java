package br.com.gestionnaire.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "phrases")
public class ListaExpressions implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Expression> expressions;

	@XmlElement(name = "EXPRESSION")
	public List<Expression> getExpressions() {
		return expressions;
	}

	public void setExpressions(List<Expression> expressions) {
		this.expressions = expressions;
	}

	@Override
	public String toString() {
		return "ListaExpressions [expressions=" + expressions + "]";
	}
	
	
}