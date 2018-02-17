package br.com.gestionnaire.domain;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

@Component
public class ExpressionDAO extends HibernateDAO<Expression> {
	
	public ExpressionDAO() {
		// Informa o tipo da entidade para o Hibernate
		super(Expression.class);
	}
	
	// Consulta uma expression pelo id
	public Expression getExpressionById(Long id) {
		// O Hibernate consulta automaticamente pelo id
		return super.get(id);
	}

	// Busca uma expression pelo nome
	@SuppressWarnings("unchecked")
	public List<Expression> findByDescricao(String description) {
		Query q = getSession().createQuery("from Expression where lower(description) like lower(?)");
		q.setString(0, "%" + description +"%");
		return q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Expression> findByStatus(int inactive) {
		Query q = getSession().createQuery("from Expression where inactive = (?)");
		q.setInteger(0, inactive);
		return q.list();
	}

	
	// Consulta todas phrases
	@SuppressWarnings("unchecked")
	public List<Expression> getExpressions() {
		Query q = getSession().createQuery("from Expression");
		List<Expression> expression = q.list();
		return expression;
	}

	// Insere ou atualiza uma expression
	public void salvar(Expression expression) {
		super.save(expression);
	}

	// Deleta pelo id
	public boolean delete(Long id) {
		Expression c = get(id);
		delete(c);
		return true;
	}
	
}	