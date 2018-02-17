package br.com.gestionnaire.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ExpressionService {
	
	@Autowired
	private ExpressionDAO expressionDAO;

	// Lista todos as expressions do banco de dados
	public List<Expression> getExpressions() {
		List<Expression> expressions = expressionDAO.getExpressions();
		return expressions;
	}

	// Busca uma expression pelo id
	public Expression getExpressionById(Long id) {
		return expressionDAO.getExpressionById(id);
	}

	// Busca a expression pela descricao
	public List<Expression> findByDescricao(String description) {
		return expressionDAO.findByDescricao(description);
	}
	
	public List<Expression> findByStatus(int inactive) {
		return expressionDAO.findByStatus(inactive);
	}
	
	// Deleta a expression pelo id
	@Transactional(rollbackFor = Exception.class)
	public boolean delete(Long id) {
		return expressionDAO.delete(id);
	}

	// Salva ou atualiza a Expression
	@Transactional(rollbackFor = Exception.class)
	public boolean save(Expression expression) {
		expressionDAO.saveOrUpdate(expression);
		return true;
	}

//	// Busca a Expression pela descricao
//	public List<Expression> findByDescricao(String description) {
//		return expressionDAO.findByDescricao(description);
//	}
//	
//	// Busca a Expression pelo comentario
//	public List<Expression> findByComentario(String comment) {
//		return expressionDAO.findByComentario(comment);
//	}
}
	