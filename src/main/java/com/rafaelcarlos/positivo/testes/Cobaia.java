package com.rafaelcarlos.positivo.testes;

import com.rafaelcarlos.positivo.model.Cellcard;
import com.rafaelcarlos.positivo.model.EstadosAtuantes;
import com.rafaelcarlos.positivo.model.EstadosProdutoPin;
import com.rafaelcarlos.positivo.model.Operadora;
import com.rafaelcarlos.positivo.model.OperadoraRV;
import com.rafaelcarlos.positivo.model.Operadoras;
import com.rafaelcarlos.positivo.model.Produto;
import com.rafaelcarlos.positivo.model.ProdutoRV;
import com.rafaelcarlos.positivo.model.Produtos;
import com.rafaelcarlos.positivo.util.AtualizacaoOperadoraConversor;
import com.rafaelcarlos.positivo.util.ConversorData;
import com.rafaelcarlos.positivo.util.OperadoraConverter;
import com.rafaelcarlos.positivo.util.OperadorasConversor;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.StringReader;
import java.security.NoSuchAlgorithmException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

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
    
    public void enviaForm() throws JAXBException {
        
        Client client = ClientBuilder.newBuilder()
                .build();
        Integer codigo = 1;
        
        XStream conversor = new XStream(new DomDriver());
        conversor.alias("cellcard", Cellcard.class);
        conversor.alias("operadoras", Operadoras.class);
        conversor.alias("operadora", OperadoraRV.class);
        conversor.alias("estadosatuantes", EstadosAtuantes.class);
        conversor.alias("produtos", Produtos.class);
        conversor.alias("produto", ProdutoRV.class);
        conversor.alias("estadosprodutopin", EstadosProdutoPin.class);
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Cellcard.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//        conversor.omitField(QtdOperadoras.class, "qtdoperadoras");
//        conversor.alias("estadosatuantes", EstadosAtuantes.class);
//        conversor.alias("qtdestadosoperadora", QtdEstadosOperadora.class);
//        conversor.registerConverter(new CellCardConversor());
//        conversor.registerConverter(new OperadorasConversor());
//        conversor.registerConverter(new OperadoraConverter());
        conversor.registerConverter(new ConversorData());
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
        StringBuffer temp = new StringBuffer(varia);
//        Operadora operadora = (Operadora) conversor.fromXML(varia);
//        Cellcard cellcard = (Cellcard) conversor.fromXML(varia);
//        Cellcard cellcardJax = (Cellcard) jaxbUnmarshaller.unmarshal(varia);
        Object cell = jaxbUnmarshaller.unmarshal(new StreamSource(new StringReader(temp.toString())));
        Cellcard celular = (Cellcard) cell;
        
        System.out.println("Resposta: " + response);
        System.out.println("\n" + response.getStatus());
        System.out.println("Objeto " + celular.getCodigoTransacao());
        System.out.println("Objeto " + celular.getLoja());
        System.out.println("Objeto " + celular.getVersao());
        System.out.println("Operadoras " + celular.getOperadoras().getQtdOperadoras());
        
        for (Operadora operadora : celular.getOperadoras().getOperadora()) {
            if (operadora.getCodigoOperadora().equals("M5") || operadora.getCodigoOperadora().equals("M2")
                    || operadora.getCodigoOperadora().equals("M3") || operadora.getCodigoOperadora().equals("3")) {
                
                System.out.println("Codigo " + operadora.getCodigoOperadora());
                System.out.println("Nome " + operadora.getNomeOperadora());
                System.out.println("Atualizaçao " + operadora.getUltimaAtualizacaoOperadora());
                System.out.println("Quantidade Produtos: " + operadora.getProdutos().getQtdprodutos());
                System.out.println("Produtos: " + operadora.getProdutos().getProduto());
                System.out.println("Nome Produto: " + operadora.getProdutos().getNomeProduto());
                
//                for(Produto produto : celular.getOperadoras().getOperadora())
//                {
//                    System.out.println("Codigo Produto: " + produto.getNomeProduto());
//                }
            }
        }
        response.close();
    }
}
