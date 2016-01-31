package com.rafaelcarlos.positivo.testes;

import com.rafaelcarlos.positivo.model.Cellcard;
import com.rafaelcarlos.positivo.model.EstadosAtuantes;
import com.rafaelcarlos.positivo.model.Operadora;
import com.rafaelcarlos.positivo.model.Operadoras;
import com.rafaelcarlos.positivo.model.Produto;
import com.rafaelcarlos.positivo.model.QtdEstadosOperadora;
import com.rafaelcarlos.positivo.model.QtdOperadoras;
import com.rafaelcarlos.positivo.util.CellCardConversor;
import com.rafaelcarlos.positivo.util.ConversorData;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author rafaellcarloss
 */
public class Cobaia {
    
    public static void main(String[] args) throws Exception {
        
        Cobaia http = new Cobaia();

//        System.out.println("Testing 1 - Send Http GET request");
//        http.sendGet();
//        System.out.println("\nTesting 2 - Send Http POST request");
        System.out.println("Enviando form...");
        http.enviaForm();
        
    }
    
    public void enviaForm() throws NoSuchAlgorithmException {
        
        SSLContext sslContext = SSLContext.getInstance("SSL");
        Client client = ClientBuilder.newBuilder()
                .property("connection.timeout", 100)
                .register(MediaType.APPLICATION_XML_TYPE)
                .build();
        Integer codigo = 1;
        
        XStream conversor = new XStream(new DomDriver());
        conversor.alias("cellcard", Cellcard.class);
        conversor.alias("operadoras", Operadoras.class);
//        conversor.alias("qtdoperadoras", QtdOperadoras.class);
        conversor.alias("operadora", Operadora.class);
//        conversor.alias("produto", Produto.class);
//        conversor.alias("estadosatuantes", EstadosAtuantes.class);
//        conversor.alias("qtdestadosoperadora", QtdEstadosOperadora.class);
        conversor.registerConverter(new CellCardConversor());
        Form form = new Form()
                .param("envio_primario", "1")
                .param("nome_primario", "teste")
                .param("loja_primaria", "teste")
                .param("senha_primaria", "teste")
                .param("versao", "3.93")
                .param("codigo_transacao", codigo.toString())
                .param("cod_retorno", "14");
        
        Response response = client.target("https://www.cellcard.com.br/teste/integracao_xml.php")
                .request()
                .post(Entity.form(form));
        
        String varia = response.readEntity(String.class);
//        Operadora operadora = (Operadora) conversor.fromXML(varia);
        Cellcard cellcard = (Cellcard) conversor.fromXML(varia);
        System.out.println("Resposta: " + response);
        System.out.println("\n" + response.getStatus());
//        System.out.println("\n" + response.readEntity(String.class));

        System.out.println("Resultado cellcard" + cellcard.getVersao());
        System.out.println("Resultado cellcard" + cellcard.getCodigoTransacao());
        System.out.println("Resultado cellcard" + cellcard.getLoja());
//        System.out.println("Resultado cellcard" + cellcard.getOperadoras().getQtdOperadoras());
//        System.out.println("Resultado cellcard" + cellcard.getOperadoras());
//        System.out.println("Resultado em objeto: " + operadora.getCodigoOperadora());
//        System.out.println("Resultado em objeto: " + operadora.getNomeOperadora());
//        System.out.println("Resultado em objeto: " + operadora.getEstadosAtuantes());
//        System.out.println("Resultado em objeto: " + operadora.getUltimaAtualizacaoOperadora());

        response.close();
    }
}
