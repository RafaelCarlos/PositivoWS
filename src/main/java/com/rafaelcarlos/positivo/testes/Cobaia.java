package com.rafaelcarlos.positivo.testes;

import com.rafaelcarlos.positivo.model.Cellcard;
import com.rafaelcarlos.positivo.model.Distribuidora;
import com.rafaelcarlos.positivo.model.Empresa;
import com.rafaelcarlos.positivo.model.Operadora;
import com.rafaelcarlos.positivo.model.Produto;
import com.rafaelcarlos.repositorios.EmpresaRepository;
import com.rafaelcarlos.repositorios.OperadoraRepository;
import com.rafaelcarlos.repositorios.ProdutoRepository;
import java.io.Serializable;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
public class Cobaia implements Serializable {

    private ProdutoRepository produtoRepository;
    private OperadoraRepository operadoraRepository;

    public Cobaia() {
        this.produtoRepository = new ProdutoRepository();
        this.operadoraRepository = new OperadoraRepository();
    }

    public static void main(String[] args) throws Exception {

        Cobaia http = new Cobaia();
        System.out.println("Enviando form...");
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        System.out.println("Data atual: " + sdf.format(new Date()));

        http.enviaForm();
    }

    public void enviaForm() throws JAXBException {

        Client client = ClientBuilder.newBuilder()
                .build();
        JAXBContext jaxbContext = JAXBContext.newInstance(Cellcard.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Form form = new Form()
                .param("envio_primario", "1")
                .param("nome_primario", "teste")
                .param("loja_primaria", "teste")
                .param("senha_primaria", "teste")
                .param("versao", "3.93")
                .param("codigo_transacao", "1")
                .param("cod_retorno", "14");

        Response response = client.target("https://www.cellcard.com.br/teste/integracao_xml.php")
                .request()
                .post(Entity.form(form));

        String varia = response.readEntity(String.class);
        StringBuffer temp = new StringBuffer(varia);
        Cellcard celular = (Cellcard) jaxbUnmarshaller.unmarshal(new StreamSource(new StringReader(temp.toString())));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        System.out.println("Resultado: " + varia);
        System.out.println("\n");
        System.out.println("Resposta: " + response);
        System.out.println("\n" + response.getStatus());
        System.out.println("Código transação: " + celular.getCodigoTransacao());
        System.out.println("Loja: " + celular.getLoja());
        System.out.println("Versão: " + celular.getVersao());
        System.out.println("Quantidade operadoras: " + celular.getOperadoras().getQtdOperadoras());
        Produto produtoPersist = new Produto();
        Operadora operadoraPersist = new Operadora();
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial("Positivo Automação");
        empresa.setIe("3023032");
        empresa.setNomeFantasia("Positivo");
        empresa.setCnpj("232.212.0001/21");
        empresa.setEndereco("3203 Norte");
        empresa.setNumero("22");
        empresa.setComplemento("Sem Complemento");
        empresa.setBairro("Taquari");
        empresa.setNomeCidade("Palmas");
        empresa.setUf("TO");
        empresa.setCep("7770007");
        empresa.setTelefoneEmpresa("32-2233-2222");
        empresa.setEmailEmpresa("email@example.com");
        empresa.setDistribuidoraId(new Distribuidora(1));
//        new EmpresaRepository().salvar(empresa);
        EmpresaRepository empresaRepository = new EmpresaRepository();
        int contador = 0;
        try {
            for (Operadora operadora : celular.getOperadoras().getOperadora()) {
//            if (operadora.getCodigoOperadora().equals("M5") || operadora.getCodigoOperadora().equals("M2")
//                    || operadora.getCodigoOperadora().equals("M3") || operadora.getCodigoOperadora().equals("3")) {

                for (Produto produto : operadora.getProdutos().getProduto()) {

                    if (produto.getModeloRecarga().equals("ONLINE")) {
                        contador++;
//                        System.out.println("Codigo " + operadora.getCodigoOperadora());
//                        System.out.println("Nome " + operadora.getNomeOperadora());
//                        System.out.println("Atualizaçao Operadora: " + sdf.format(operadora.getUltimaAtualizacaoOperadora()));
//                        System.out.println("Quantidade Produtos: " + operadora.getProdutos().getQtdprodutos());
//                        
//                        System.out.println("\nCódigo produto: " + produto.getCodigoProduto());
//                        System.out.println("Nome produto: " + produto.getNomeProduto());
//                        System.out.println("Preço compra produto: " + produto.getPrecocompraProduto());
//                        System.out.println("Preço venda produto: " + produto.getPrecovendaProduto());
//                        System.out.println("Validade produto: " + produto.getValidade());
//                        System.out.println("Modelo recarga: " + produto.getModeloRecarga());
//                        System.out.println("Valor minimo: " + produto.getValorMinimoProduto());
//                        System.out.println("Valor maximo: " + produto.getValorMaximoProduto());
//                        System.out.println("Valor incremento: " + produto.getValorIncrementoProduto());
//                        System.out.println("Atualização Produto: " + sdf.format(produto.getUltima_atualizacaoProduto()));
//                        System.out.println("Valor variavel: " + produto.getValorVariavel());
//                        System.out.println("------------------------------------------");
                        operadoraPersist.setNomeOperadora(operadora.getNomeOperadora());
                        operadoraPersist.setCodigoOperadora(operadora.getCodigoOperadora());
                        operadoraPersist.setUltimaAtualizacaoOperadora(sdf.parse(sdf.format(operadora.getUltimaAtualizacaoOperadora())));
//                        operadoraRepository.salvar(operadora);

                        produtoPersist.setQtdProduto(operadora.getProdutos().getQtdprodutos());
                        produtoPersist.setCodigoProduto(produto.getCodigoProduto());
                        produtoPersist.setNomeProduto(produto.getNomeProduto());
                        produtoPersist.setPrecocompraProduto(produto.getPrecocompraProduto());
                        produtoPersist.setPrecovendaProduto(produto.getPrecovendaProduto());
                        produtoPersist.setUltima_atualizacaoProduto(sdf.parse(sdf.format(operadora.getUltimaAtualizacaoOperadora())));
                        produtoPersist.setValidade(produto.getValidade());
                        produtoPersist.setModeloRecarga(produto.getModeloRecarga());
                        produtoPersist.setValorMinimoProduto(produto.getValorMinimoProduto());
                        produtoPersist.setValorMaximoProduto(produto.getValorMaximoProduto());
                        produtoPersist.setValorIncrementoProduto(produto.getValorIncrementoProduto());
                        produtoPersist.setValorVariavel(produto.getValorVariavel());
                        empresa.adiciona(produtoPersist);
//                        empresa.setId(null);
//                        operadoraPersist.getProduto().add(produtoPersist);
//                        empresa.getProdutos().add(produtoPersist);
//                        empresa.adiciona(produto);
//                        operadora.adiciona(produto);
//                        produtoPersist.setEmpresaId(empresa);
//                        produtoPersist.setOperadoraId(operadoraPersist);
//                        operadoraPersist.setProduto(Arrays.asList(produtoPersist));]
                        operadoraPersist.adiciona(produtoPersist);
                        operadoraPersist.setId(null);
//                produtoPersist.setEmpresaId(new Empresa());
                        empresa.setId(null);
                        operadoraRepository.salvar(operadoraPersist);
                    }

                }

            }
        } catch (Exception e) {

        }
        System.out.println("Quantidade de produtos que funcionam com regarca online: " + contador);
        response.close();
    }
}
