package br.com.gestionnaire.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PhraseService {
	
	@Autowired
	private PhraseDAO phraseDAO;

	// Lista todos as phrases do banco de dados
	public List<Phrase> getPhrases() {
		List<Phrase> phrases = phraseDAO.getPhrases();
		return phrases;
	}

	// Busca uma phrase pelo id
	public Phrase getPhrase(Long id) {
		return phraseDAO.getPhraseById(id);
	}

	// Deleta a phrase pelo id
	@Transactional(rollbackFor = Exception.class)
	public boolean delete(Long id) {
		return phraseDAO.delete(id);
	}

	// Salva ou atualiza a phrase
	@Transactional(rollbackFor = Exception.class)
	public boolean save(Phrase phrase) {
		phraseDAO.saveOrUpdate(phrase);
		return true;
	}

	// Busca a phrase pela descricao
	public List<Phrase> findByDescricao(String description) {
		return phraseDAO.findByDescricao(description);
	}
	
	// Busca a phrase pelo comentario
	public List<Phrase> findByComentario(String comments) {
		return phraseDAO.findByComentario(comments);
	}

	public List<Phrase> findByStatus(int inactive) {
		return phraseDAO.findByStatus(inactive);
	}
}
	