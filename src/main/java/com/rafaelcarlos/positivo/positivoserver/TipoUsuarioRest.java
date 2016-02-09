package com.rafaelcarlos.positivo.positivoserver;

import java.io.Serializable;
import javax.inject.Named;
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
@Path("tipousuariows")
public class TipoUsuarioRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TipoUsuarioRest
     */
    public TipoUsuarioRest() {
    }

    /**
     * Retrieves representation of an instance of
     * com.rafaelcarlos.positivo.positivoserver.TipoUsuarioRest
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of TipoUsuarioRest
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
