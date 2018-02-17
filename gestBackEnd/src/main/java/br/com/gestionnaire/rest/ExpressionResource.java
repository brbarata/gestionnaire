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

import br.com.gestionnaire.domain.Expression;
import br.com.gestionnaire.domain.ExpressionService;
import br.com.gestionnaire.domain.Response;
import br.com.gestionnaire.domain.UploadService;

@Path("/gestionnaire/expressions")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Component
public class ExpressionResource {
	
	private String URL_FOTO = "";
	
	@Context
	HttpServletRequest request;
	
	@Autowired
	private ExpressionService expressionService;
	
	@Autowired
	private UploadService uploadService;


	@GET
	public List<Expression> get() {
		List<Expression> Expressions = expressionService.getExpressions();
		return Expressions;
	}

	@GET
	@Path("{id}")
	public Expression get(@PathParam("id") long id) {
		Expression c = expressionService.getExpressionById(id);
		return c;
	}

	@GET
	@Path("/descricao/{description}")
	public List<Expression> getByDescricao(@PathParam("description") String description) {
		List<Expression> expressions = expressionService.findByDescricao(description);
		return expressions;
	}
	
	@GET
	@Path("/status/{inactive}")
	public List<Expression> getByStatus(@PathParam("inactive") int inactive) {
		List<Expression> expressions = expressionService.findByStatus(inactive);
		return expressions;
	}

//	
//	@GET
//	@Path("/comentario/{comment}")
//	public List<Expression> getByComentario(@PathParam("comment") String comment) {
//		List<Expression> expressions = expressionService.findByComentario(comment);
//		return expressions;
//	}


	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") long id) {
		expressionService.delete(id);
		return Response.Ok("Expression deletada com sucesso");
	}

	@POST
	public Response post(Expression e) {
		expressionService.save(e);
		return Response.Ok("Expression salva com sucesso");
	}

	@PUT
	public Response put(Expression e) {
		expressionService.save(e);
		return Response.Ok("Expression atualizada com sucesso");
	}
}