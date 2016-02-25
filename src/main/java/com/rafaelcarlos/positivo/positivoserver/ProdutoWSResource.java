/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.positivoserver;

import com.rafaelcarlos.positivo.model.Produto;
import com.rafaelcarlos.positivo.model.Usuario;
import com.rafaelcarlos.repositorios.ProdutoRepository;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author rafaellcarloss
 */
@Path("produtows")
public class ProdutoWSResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProdutoWSResource
     */
    public ProdutoWSResource() {
    }

    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    @Path("listaproduto")
    public void requesProduto() {

        Usuario user = new Usuario();
        user.setId(1);
        user.setNome("eduardo");
        user.setSenha("1234");
        user.setIdFacebook("Rua abc");
        user.setEmail("abc@abc.com");

        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("https://www.cellcard.com.br/teste/integracao_xml.php");
        WebTarget resourceWebTarget = webTarget.path("teste");

        WebTarget deleteWeb = resourceWebTarget.path("integracao_xml.php");
        Invocation.Builder deleteInvocationBuilder = webTarget.request();
        Response putResponse = deleteInvocationBuilder.put(Entity.entity(user, MediaType.APPLICATION_XML_TYPE));

        System.out.println(putResponse.getStatus());
        System.out.println(putResponse.readEntity(String.class));
//        
//        Produto produto = new Produto();
//        
//        StringBuilder parametros = new StringBuilder();
//        parametros.append("");
//        
//        Client client = ClientBuilder.newClient();
//
//        WebTarget target = client.target("https://www.cellcard.com.br/teste/integracao_xml.php");
//
//        String toReturn = target.request().get(String.class);
//        System.out.println("Resultado - " + toReturn);

//        return toReturn;
    }

    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        return "oi";
    }

    @GET
    @Path("listatodosprodutos")
    @Produces(MediaType.APPLICATION_XML)
    public Produto listaProdutos() {

        Produto produto = new ProdutoRepository().getPorId(12);
        return produto;

    }

    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
