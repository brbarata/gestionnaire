package br.com.gestionnaire.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gestionnaire.domain.Phrase;
import br.com.gestionnaire.domain.PhraseService;
import br.com.gestionnaire.domain.Response;
import br.com.gestionnaire.domain.UploadService;

@Path("/gestionnaire/phrases")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Component
public class PhraseResource {
	
	private String URL_FOTO = "";
	
	@Context
	HttpServletRequest request;
	
	@Autowired
	private PhraseService phraseService;
	
	@Autowired
	private UploadService uploadService;


	@GET
	public List<Phrase> get() {
		List<Phrase> phrases = phraseService.getPhrases();
		return phrases;
	}

	@GET
	@Path("{id}")
	public Phrase get(@PathParam("id") long id) {
		Phrase c = phraseService.getPhrase(id);
		return c;
	}

	@GET
	@Path("/descricao/{description}")
	public List<Phrase> getByDescricao(@PathParam("description") String description) {
		List<Phrase> phrases = phraseService.findByDescricao(description);
		return phrases;
	}
	
	@GET
	@Path("/comentario/{comments}")
	public List<Phrase> getByComentario(@PathParam("comments") String comments) {
		List<Phrase> phrases = phraseService.findByComentario(comments);
		return phrases;
	}

	@GET
	@Path("/status/{inactive}")
	public List<Phrase> getByStatus(@PathParam("inactive") int inactive) {
		List<Phrase> phrases = phraseService.findByStatus(inactive);
		return phrases;
	}

	
//	@GET
//	@Path("/tipo/{tipo}")
//	public List<Phrase> getByTipo(@PathParam("tipo") String tipo) {
//		List<Phrase> phrases = phraseService.findByTipo(tipo);
//		return phrases;
//	}


	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") long id) {
		phraseService.delete(id);
		return Response.Ok("Phrase deletada com sucesso");
	}

	@POST
	public Response post(Phrase p) {
		phraseService.save(p);
		return Response.Ok("Phrase salva com sucesso");
	}

	@PUT
	public Response put(Phrase p) {
		phraseService.save(p);
		return Response.Ok("Phrase atualizada com sucesso");
	}

}