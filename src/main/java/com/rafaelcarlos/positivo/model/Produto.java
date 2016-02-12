package com.rafaelcarlos.positivo.model;

import com.rafaelcarlos.positivo.util.DateAdapter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author rafaellcarloss
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtd_produto")
    private int qtdProduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigo_produto")
    private String codigoProduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nome_produto")
    private String nomeProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_compra")
    @XmlElement(name = "precocompraproduto", required = true)
    private BigDecimal precoCompraProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_venda")
    private BigDecimal precoVendaProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validade")
    private int validade;
    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 20)
    @Column(name = "modelo_recarga")
    private String modeloRecarga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_minimo")
    private BigDecimal valorMinimoProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_maximo")
    private BigDecimal valorMaximoProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_incremento")
    private BigDecimal valorIncrementoProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ultima_atualizacao_produto")
    @Temporal(TemporalType.TIMESTAMP)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date ultimaAtualizacaoProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_variavel")
    private BigDecimal precoVariavelProduto;
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresaId;
    @JoinColumn(name = "operadora_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Operadora operadoraId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private Collection<Recarga> recargaCollection;

    public Produto() {
    }

    public Produto(Integer id) {
        this.id = id;
    }

    public Produto(Integer id, int qtdProduto, String codigoProduto, String nomeProduto, BigDecimal valorCompra, BigDecimal valorVenda, int validade, String modeloRecarga, BigDecimal valorMinimo, BigDecimal valorMaximo, BigDecimal valorVariavel, Date ulltimaAtualizacao, BigDecimal valorIncremento, Empresa empresaId, Operadora operadoraId, Collection<Recarga> recargaCollection) {
        this.id = id;
        this.qtdProduto = qtdProduto;
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.precoCompraProduto = valorCompra;
        this.precoVendaProduto = valorVenda;
        this.validade = validade;
        this.modeloRecarga = modeloRecarga;
        this.valorMinimoProduto = valorMinimo;
        this.valorMaximoProduto = valorMaximo;
        this.precoVariavelProduto = valorVariavel;
        this.ultimaAtualizacaoProduto = ulltimaAtualizacao;
        this.valorIncrementoProduto = valorIncremento;
        this.empresaId = empresaId;
        this.operadoraId = operadoraId;
        this.recargaCollection = recargaCollection;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getPrecoCompraProduto() {
        return precoCompraProduto;
    }

    public void setPrecoCompraProduto(BigDecimal precoCompraProduto) {
        this.precoCompraProduto = precoCompraProduto;
    }

    public BigDecimal getPrecoVendaProduto() {
        return precoVendaProduto;
    }

    public void setPrecoVendaProduto(BigDecimal precoVendaProduto) {
        this.precoVendaProduto = precoVendaProduto;
    }

    public int getValidade() {
        return validade;
    }

    public void setValidade(int validade) {
        this.validade = validade;
    }

    public String getModeloRecarga() {
        return modeloRecarga;
    }

    public void setModeloRecarga(String modeloRecarga) {
        this.modeloRecarga = modeloRecarga;
    }

    public BigDecimal getValorMinimoProduto() {
        return valorMinimoProduto;
    }

    public void setValorMinimoProduto(BigDecimal valorMinimoProduto) {
        this.valorMinimoProduto = valorMinimoProduto;
    }

    public BigDecimal getValorMaximoProduto() {
        return valorMaximoProduto;
    }

    public void setValorMaximoProduto(BigDecimal valorMaximoProduto) {
        this.valorMaximoProduto = valorMaximoProduto;
    }

    public BigDecimal getValorVariavel() {
        return precoVariavelProduto;
    }

    public void setValorVariavel(BigDecimal valorVariavel) {
        this.precoVariavelProduto = valorVariavel;
    }

    public Date getUltimaAtualizacaoProduto() {
        return ultimaAtualizacaoProduto;
    }

    public void setUltimaAtualizacaoProduto(Date ultimaAtualizacaoProduto) {
        this.ultimaAtualizacaoProduto = ultimaAtualizacaoProduto;
    }

    public BigDecimal getPrecoVariavelProduto() {
        return precoVariavelProduto;
    }

    public void setPrecoVariavelProduto(BigDecimal precoVariavelProduto) {
        this.precoVariavelProduto = precoVariavelProduto;
    }

    public BigDecimal getValorIncrementoProduto() {
        return valorIncrementoProduto;
    }

    public void setValorIncrementoProduto(BigDecimal valorIncrementoProduto) {
        this.valorIncrementoProduto = valorIncrementoProduto;
    }

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
    }

    public Operadora getOperadoraId() {
        return operadoraId;
    }

    public void setOperadoraId(Operadora operadoraId) {
        this.operadoraId = operadoraId;
    }

    public Collection<Recarga> getRecargaCollection() {
        return recargaCollection;
    }

    public void setRecargaCollection(Collection<Recarga> recargaCollection) {
        this.recargaCollection = recargaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", qtdProduto=" + qtdProduto + ", codigoProduto=" + codigoProduto + ", nomeProduto=" + nomeProduto + ", valorCompra=" + precoCompraProduto + ", valorVenda=" + precoVendaProduto + ", validade=" + validade + ", modeloRecarga=" + modeloRecarga + ", valorMinimo=" + valorMinimoProduto + ", valorMaximo=" + valorMaximoProduto + ", valorVariavel=" + precoVariavelProduto + ", ulltimaAtualizacao=" + ultimaAtualizacaoProduto + ", valorIncremento=" + valorIncrementoProduto + ", empresaId=" + empresaId + ", operadoraId=" + operadoraId + ", recargaCollection=" + recargaCollection + '}';
    }

}
