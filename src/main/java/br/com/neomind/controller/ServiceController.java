package br.com.neomind.controller;

import java.util.ArrayList;
import java.util.List;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.neomind.http.Supplier;
import br.com.neomind.repository.SupplierRepository;
import br.com.neomind.repository.entity.SupplierEntity;

@Path("/service")
public class ServiceController {
	
	private final  SupplierRepository repository = new SupplierRepository();
	
	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/salvar")
	public String Salvar(Supplier pessoa){
 
		SupplierEntity entity = new SupplierEntity();
 
		try {
 
			entity.setNome(pessoa.getNome());
			entity.setEmail(pessoa.getEmail());
			entity.setComentario(pessoa.getComentario());
			entity.setCnpj(pessoa.getCnpj());
 
			repository.Salvar(entity);
 
			return "Registro cadastrado com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
 
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/alterar")
	public String Alterar(Supplier pessoa){
 
		SupplierEntity entity = new SupplierEntity();
 
		try {
 
			entity.setCodigo(pessoa.getCodigo());
			entity.setEmail(pessoa.getEmail());
			entity.setComentario(pessoa.getComentario());
			entity.setCnpj(pessoa.getCnpj());
 
			repository.Alterar(entity);
 
			return "Registro alterado com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao alterar o registro " + e.getMessage();
 
		}
 
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todasPessoas")
	public List<Supplier> TodasPessoas(){
 
		List<Supplier> pessoas =  new ArrayList<Supplier>();
 
		List<SupplierEntity> listaEntityPessoas = repository.TodasPessoas();
 
		for (SupplierEntity entity : listaEntityPessoas) {
 
			pessoas.add(new Supplier(entity.getCodigo(), entity.getNome(),entity.getEmail(), entity.getComentario(), entity.getCnpj()));
		}
 
		return pessoas;
	}
 

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getPessoa/{codigo}")
	public Supplier GetPessoa(@PathParam("codigo") Integer codigo){
 
		SupplierEntity entity = repository.GetPessoa(codigo);
 
		if(entity != null)
			return new Supplier(entity.getCodigo(), entity.getNome(),entity.getEmail(), entity.getComentario(), entity.getCnpj());
 
		return null;
	}
 

	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{codigo}")	
	public String Excluir(@PathParam("codigo") Integer codigo){
 
		try {
 
			repository.Excluir(codigo);
 
			return "Registro excluido com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao excluir o registro! " + e.getMessage();
		}
 
	}

}
