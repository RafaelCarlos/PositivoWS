/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rafaellcarloss
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p WHERE p.id = :id"),
    @NamedQuery(name = "Produto.findByQtdProduto", query = "SELECT p FROM Produto p WHERE p.qtdProduto = :qtdProduto"),
    @NamedQuery(name = "Produto.findByNomeProduto", query = "SELECT p FROM Produto p WHERE p.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "Produto.findByValorCompra", query = "SELECT p FROM Produto p WHERE p.valorCompra = :valorCompra"),
    @NamedQuery(name = "Produto.findByValorVenda", query = "SELECT p FROM Produto p WHERE p.valorVenda = :valorVenda"),
    @NamedQuery(name = "Produto.findByValidade", query = "SELECT p FROM Produto p WHERE p.validade = :validade"),
    @NamedQuery(name = "Produto.findByModeloRecarga", query = "SELECT p FROM Produto p WHERE p.modeloRecarga = :modeloRecarga"),
    @NamedQuery(name = "Produto.findByValorMinimo", query = "SELECT p FROM Produto p WHERE p.valorMinimo = :valorMinimo"),
    @NamedQuery(name = "Produto.findByValorMaximo", query = "SELECT p FROM Produto p WHERE p.valorMaximo = :valorMaximo"),
    @NamedQuery(name = "Produto.findByValorVariavel", query = "SELECT p FROM Produto p WHERE p.valorVariavel = :valorVariavel"),
    @NamedQuery(name = "Produto.findByUlltimaAtualizacao", query = "SELECT p FROM Produto p WHERE p.ulltimaAtualizacao = :ulltimaAtualizacao")})
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_compra")
    private BigDecimal valorCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_venda")
    private BigDecimal valorVenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validade")
    private int validade;
    @Column(name = "modelo_recarga")
    private Integer modeloRecarga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_minimo")
    private BigDecimal valorMinimo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_maximo")
    private BigDecimal valorMaximo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_variavel")
    private BigDecimal valorVariavel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ulltima_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ulltimaAtualizacao;
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

    public Produto(Integer id, int qtdProduto, String nomeProduto, BigDecimal valorCompra, BigDecimal valorVenda, int validade, BigDecimal valorMinimo, BigDecimal valorMaximo, BigDecimal valorVariavel, Date ulltimaAtualizacao) {
        this.id = id;
        this.qtdProduto = qtdProduto;
        this.nomeProduto = nomeProduto;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.validade = validade;
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
        this.valorVariavel = valorVariavel;
        this.ulltimaAtualizacao = ulltimaAtualizacao;
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

    public int getValidade() {
        return validade;
    }

    public void setValidade(int validade) {
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

    public Date getUlltimaAtualizacao() {
        return ulltimaAtualizacao;
    }

    public void setUlltimaAtualizacao(Date ulltimaAtualizacao) {
        this.ulltimaAtualizacao = ulltimaAtualizacao;
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

    @XmlTransient
    public Collection<Recarga> getRecargaCollection() {
        return recargaCollection;
    }

    public void setRecargaCollection(Collection<Recarga> recargaCollection) {
        this.recargaCollection = recargaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rafaelcarlos.positivo.model.Produto[ id=" + id + " ]";
    }

}
