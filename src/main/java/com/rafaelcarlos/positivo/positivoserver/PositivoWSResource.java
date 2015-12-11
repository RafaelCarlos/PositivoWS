package com.rafaelcarlos.positivo.positivoserver;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author rafaellcarloss
 */
@Path("positivoWS")
public class PositivoWSResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PositivoWSResource
     */
    public PositivoWSResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.rafaelcarlos.positivo.positivoserver.PositivoWSResource
     *
     * @return an instance of java.lang.String
     */
    @Path("retorno")
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        return "Teste Webservice";
    }

    /**
     * PUT method for updating or creating an instance of PositivoWSResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
