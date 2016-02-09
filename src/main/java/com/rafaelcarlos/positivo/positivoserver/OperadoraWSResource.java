package com.rafaelcarlos.positivo.positivoserver;

import com.rafaelcarlos.positivo.model.Operadora;
import java.util.Date;
import javax.net.ssl.SSLContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @POST
    @Produces(MediaType.APPLICATION_XML)
    public void pegaOperadora() {
        Operadora operadora = new Operadora();

        operadora.setId(1);
        operadora.setCodigoOperadora("V211");
        operadora.setNomeOperadora("Vivo");
        operadora.setUltimaAtualizacaoOperadora(new Date());

        Client clientt = ClientBuilder.newBuilder()
                .property("connection.timeout", 100)
                .register(MediaType.APPLICATION_XML_TYPE)
                .build();
        Integer codigo = 14;

        StringBuilder parametro = new StringBuilder();

        parametro.append("teste");
        parametro.append("teste");
        parametro.append("teste");
        parametro.append("3.93");
        parametro.append("1");
        parametro.append("1417");
        parametro.append("1");

        /**
         * Parte responsável por acessar o servidor da RV Tecnologia.
         */
        Form form = new Form()
                .param("envio_primario", "1")
                .param("nome_primario", "teste")
                .param("loja_primaria", "teste")
                .param("senha_primaria", "teste")
                .param("versao", "3.93")
                .param("codigo_transacao", codigo.toString())
                .param("cod_retorno", "14");

        Response response = clientt.target("https://www.cellcard.com.br/teste/integracao_xml.php")
                .request()
                .post(Entity.form(form));

        System.out.println("Resposta: " + response);
        System.out.println("\n" + response.getStatus());
        System.out.println("\n" + response.readEntity(String.class));

        response.close();

//        Response response = client.target("https://www.cellcard.com.br/teste/integracao_xml.php").request()
//                .post(operadora, MediaType.APPLICATION_XML_TYPE)
    }

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
