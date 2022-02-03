/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.empresarest.rest;

import br.edu.empresarest.model.Empresa;
import br.edu.empresarest.service.Response;
import br.edu.empresarest.service.empresaService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Carlos
 */
@Path("/empresa")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class EmpresaResource {

   private empresaService empresaService = new empresaService();


	@GET
	public List<Empresa> get() {

 

	List<Empresa> empresas = empresaService.getEmpresa();

        return empresas;

        }


	@POST
	public Response post(Empresa c) {
		empresaService.save(c);
		return Response.Ok("Empresa salvo com sucesso");
	}


       
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") long id) {
		empresaService.delete(id);
		return Response.Ok("Empresa deletado com sucesso");
	}


	@PUT
	public Response put(Empresa c) {
		empresaService.save(c);
		return Response.Ok("Empresa atualizado com sucesso");
	}
    
}
