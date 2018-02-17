package br.com.gestionnaire.domain;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

@Component
public class PhraseDAO extends HibernateDAO<Phrase> {
	
	public PhraseDAO() {
		// Informa o tipo da entidade para o Hibernate
		super(Phrase.class);
	}

	// Consulta uma phrase pelo id
	public Phrase getPhraseById(Long id) {
		// O Hibernate consulta automaticamente pelo id
		return super.get(id);
	}

	// Busca uma phrase pelo nome
	@SuppressWarnings("unchecked")
	public List<Phrase> findByDescricao(String description) {
		Query q = getSession().createQuery("from Phrase where lower(description) like lower(?)");
		q.setString(0, "%" + description +"%");
		return q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Phrase> findByComentario(String comments) {
		Query q = getSession().createQuery("from Phrase where lower(comments) like lower(?)");
		q.setString(0, "%" + comments +"%");
		return q.list();
	}

	@SuppressWarnings("unchecked")
	public List<Phrase> findByStatus(int inactive) {
		Query q = getSession().createQuery("from Phrase where inactive = (?)");
		q.setInteger(0, inactive);
		return q.list();
	}

	// Consulta todas phrases
	@SuppressWarnings("unchecked")
	public List<Phrase> getPhrases() {
		Query q = getSession().createQuery("from Phrase");
		List<Phrase> phrase = q.list();
		return phrase;
	}

	// Insere ou atualiza uma phrase
	public void salvar(Phrase phrase) {
		super.save(phrase);
	}

	// Deleta pelo id
	public boolean delete(Long id) {
		Phrase c = get(id);
		delete(c);
		return true;
	}
	
}	