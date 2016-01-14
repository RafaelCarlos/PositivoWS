/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.positivoserver;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author rafaellcarloss
 */
@Path("OperadoraWS")
public class OperadoraWSResource {

    public static Client client;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OperadoraWSResource
     */
    public OperadoraWSResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.rafaelcarlos.positivo.model.OperadoraWSResource
     *
     * @return an instance of java.lang.String
     */
    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_XML)
//    @Produces(MediaType.APPLICATION_XML)
//    public void pegaOperadora() {
//        Operadora operadora = new Operadora();
//
//        operadora.setId(1);
//        operadora.setCodigoOperadora("V211");
//        operadora.setNomeOperadora("Vivo");
//        operadora.setUltimaAtualizacaoOperadora(new Date());
//
////        Response response = client.target("https://www.cellcard.com.br/teste/integracao_xml.php").request()
////                .post(operadora, MediaType.APPLICATION_XML_TYPE)
//    }

    /**
     * PUT method for updating or creating an instance of OperadoraWSResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
