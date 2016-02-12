package com.rafaelcarlos.positivo.testes;

import com.rafaelcarlos.positivo.model.Cellcard;
import com.rafaelcarlos.positivo.model.Operadora;
import com.rafaelcarlos.positivo.model.Produto;
import java.io.StringReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
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

//        XStream conversor = new XStream(new DomDriver());
//        conversor.alias("cellcard", Cellcard.class);
//        conversor.alias("operadoras", Operadoras.class);
//        conversor.alias("operadora", OperadoraRV.class);
//        conversor.alias("estadosatuantes", EstadosAtuantes.class);
//        conversor.alias("produtos", Produtos.class);
//        conversor.alias("produto", ProdutoRV.class);
//        conversor.alias("estadosprodutopin", EstadosProdutoPin.class);
        JAXBContext jaxbContext = JAXBContext.newInstance(Cellcard.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//        conversor.omitField(QtdOperadoras.class, "qtdoperadoras");
//        conversor.alias("estadosatuantes", EstadosAtuantes.class);
//        conversor.alias("qtdestadosoperadora", QtdEstadosOperadora.class);
//        conversor.registerConverter(new CellCardConversor());
//        conversor.registerConverter(new OperadorasConversor());
//        conversor.registerConverter(new OperadoraConverter());
//        conversor.registerConverter(new ConversorData());
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
        Cellcard celular = (Cellcard) jaxbUnmarshaller.unmarshal(new StreamSource(new StringReader(temp.toString())));
//        Cellcard celular = (Cellcard) cell;
//        Cellcard retorno =  (Cellcard) jaxbUnmarshaller.unmarshal(new StreamSource(new StringReader(temp.toString())));

        System.out.println("Resposta: " + response);
        System.out.println("\n" + response.getStatus());
        System.out.println("Código transação: " + celular.getCodigoTransacao());
        System.out.println("Loja: " + celular.getLoja());
        System.out.println("Versão: " + celular.getVersao());
        System.out.println("Quantidade operadoras: " + celular.getOperadoras().getQtdOperadoras());

        for (Operadora operadora : celular.getOperadoras().getOperadora()) {
            if (operadora.getCodigoOperadora().equals("M5") || operadora.getCodigoOperadora().equals("M2")
                    || operadora.getCodigoOperadora().equals("M3") || operadora.getCodigoOperadora().equals("3")) {

                for (Produto produto : operadora.getProdutos().getProduto()) {

                    System.out.println("Codigo " + operadora.getCodigoOperadora());
                    System.out.println("Nome " + operadora.getNomeOperadora());
                    System.out.println("Atualizaçao Operadora: " + operadora.getUltimaAtualizacaoOperadora());
                    System.out.println("Quantidade Produtos: " + operadora.getProdutos().getQtdprodutos());

                    System.out.println("\nCódigo produto: " + produto.getCodigoProduto());
                    System.out.println("Nome produto: " + produto.getNomeProduto());
                    System.out.println("Preço compra produto: " + produto.getPrecoCompraProduto());
                    System.out.println("Preço venda produto: " + produto.getPrecoVendaProduto());
                    System.out.println("Validade produto: " + produto.getValidade());
                    System.out.println("Modelo recarga: " + produto.getModeloRecarga());
                    System.out.println("Valor minimo: " + produto.getValorMinimoProduto());
                    System.out.println("Valor maximo: " + produto.getValorMaximoProduto());
                    System.out.println("Valor incremento: " + produto.getValorIncrementoProduto());
                    System.out.println("Atualizaçao Produto: " + produto.getUltimaAtualizacaoProduto());
                    System.out.println("Valor variavel: " + produto.getValorVariavel());
                    System.out.println("------------------------------------------");
                }

//                for(Produto produto : celular.getOperadoras().getOperadora())
//                {
//                    System.out.println("Codigo Produto: " + produto.getNomeProduto());
//                }
            }
        }
        response.close();
    }
}
