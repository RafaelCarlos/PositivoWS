/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.positivoserver;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author rafaellcarloss
 */
@Path("restful")
public class PositivoRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PositivoRest
     */
    public PositivoRest() {
    }

    /**
     * Retrieves representation of an instance of com.rafaelcarlos.positivo.positivoserver.PositivoRest
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        return "WebService";
    }

    /**
     * PUT method for updating or creating an instance of PositivoRest
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
