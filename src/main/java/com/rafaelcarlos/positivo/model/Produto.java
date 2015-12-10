package com.rafaelcarlos.positivo.model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafaellcarloss
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Produto.findAll" , query = "SELECT p FROM p" ),
    @NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p WHERE p.id = :id")   
})
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
    @Size(min = 1, max = 20)
    @Column(name = "nome_produto")
    private String nomeProduto;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigo_operadora")
    private String codigoOperadora;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_compra", precision = 5, scale = 2)
    private BigDecimal valorCompra;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_venda", precision = 5, scale = 2)
    private BigDecimal valorVenda;

    @Basic(optional = false)
    @NotNull
    @Column(name = "validade", length = 3)
    private Integer validade;

    @Basic(optional = false)
    @NotNull
    @Column(name = "modelo_recarga")
    private Integer modeloRecarga;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_minimo", precision = 5, scale = 2)
    private BigDecimal valorMinimo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_maximo", precision = 5, scale = 2)
    private BigDecimal valorMaximo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_variavel", precision = 5, scale = 2)
    private BigDecimal valorVariavel;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAtualizacao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private Collection<Recarga> recargaCollection;

    @JoinColumn(name = "operadora_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Operadora operadoraId;

    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresaId;

    public Produto() {
    }

    public Produto(Integer id) {
        this.id = id;
    }

    public Produto(Integer id, int qtdProduto, String nomeProduto, String codigoOperadora, BigDecimal valorCompra, BigDecimal valorVenda, Integer validade, Integer modeloRecarga, BigDecimal valorMinimo, BigDecimal valorMaximo, BigDecimal valorVariavel, Date ultimaAtualizacao, Collection<Recarga> recargaCollection, Operadora operadoraId, Empresa empresaId) {
        this.id = id;
        this.qtdProduto = qtdProduto;
        this.nomeProduto = nomeProduto;
        this.codigoOperadora = codigoOperadora;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.validade = validade;
        this.modeloRecarga = modeloRecarga;
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
        this.valorVariavel = valorVariavel;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.recargaCollection = recargaCollection;
        this.operadoraId = operadoraId;
        this.empresaId = empresaId;
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

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCodigoOperadora() {
        return codigoOperadora;
    }

    public void setCodigoOperadora(String codigoOperadora) {
        this.codigoOperadora = codigoOperadora;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Integer getValidade() {
        return validade;
    }

    public void setValidade(Integer validade) {
        this.validade = validade;
    }

    public Integer getModeloRecarga() {
        return modeloRecarga;
    }

    public void setModeloRecarga(Integer modeloRecarga) {
        this.modeloRecarga = modeloRecarga;
    }

    public BigDecimal getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(BigDecimal valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public BigDecimal getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(BigDecimal valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public BigDecimal getValorVariavel() {
        return valorVariavel;
    }

    public void setValorVariavel(BigDecimal valorVariavel) {
        this.valorVariavel = valorVariavel;
    }

    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public Collection<Recarga> getRecargaCollection() {
        return recargaCollection;
    }

    public void setRecargaCollection(Collection<Recarga> recargaCollection) {
        this.recargaCollection = recargaCollection;
    }

    public Operadora getOperadoraId() {
        return operadoraId;
    }

    public void setOperadoraId(Operadora operadoraId) {
        this.operadoraId = operadoraId;
    }

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        return "Produto{" + "id=" + id + ", qtdProduto=" + qtdProduto + ", nomeProduto=" + nomeProduto + ", codigoOperadora=" + codigoOperadora + ", valorCompra=" + valorCompra + ", valorVenda=" + valorVenda + ", validade=" + validade + ", modeloRecarga=" + modeloRecarga + ", valorMinimo=" + valorMinimo + ", valorMaximo=" + valorMaximo + ", valorVariavel=" + valorVariavel + ", ultimaAtualizacao=" + ultimaAtualizacao + ", recargaCollection=" + recargaCollection + ", operadoraId=" + operadoraId + ", empresaId=" + empresaId + '}';
    }

}
