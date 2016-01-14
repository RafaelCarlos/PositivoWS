/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.positivoserver;

import com.rafaelcarlos.positivo.model.Usuario;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author rafaellcarloss
 */
@Path("recarga")
public class RecargaWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RecargaWS
     */
    public RecargaWS() {
    }

    /**
     * Retrieves representation of an instance of
     * com.rafaelcarlos.positivo.positivoserver.RecargaWS
     *
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces("application/json")
//    public String getXml() {
//        //TODO return proper representation object
//        return "Olá!";
//    }
    @GET
    @Produces("application/json")
    public Usuario exibe() {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNome("Rafael");
        usuario.setEmail("shanglangjunior@hotmail.com");
        usuario.setAtivo(true);

        return usuario;

    }

    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Request recarrega() {

        Client client = ClientBuilder.newClient();
        Response resposta = client.target("https://www.cellcard.com.br/teste/integracao_xml.php").request().get();

        return null;

    }

    /**
     * PUT method for updating or creating an instance of RecargaWS
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
