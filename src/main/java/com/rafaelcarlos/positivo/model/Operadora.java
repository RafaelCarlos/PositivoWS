/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "operadora")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Operadora.findAll", query = "SELECT o FROM Operadora o"),
    @NamedQuery(name = "Operadora.findById", query = "SELECT o FROM Operadora o WHERE o.id = :id"),
    @NamedQuery(name = "Operadora.findByNomeOperadora", query = "SELECT o FROM Operadora o WHERE o.nomeOperadora = :nomeOperadora"),
    @NamedQuery(name = "Operadora.findByCodigoOperadora", query = "SELECT o FROM Operadora o WHERE o.codigoOperadora = :codigoOperadora")})
public class Operadora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nome_operadora")
    private String nomeOperadora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigo_operadora")
    private String codigoOperadora;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name = "ultima_atualizacao_operadora")
    private Date ultimaAtualizacaoOperadora;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operadoraId")
    private Collection<Produto> produtoCollection;

    public Operadora() {
    }

    public Operadora(String id) {
        this.id = id;
    }

    public Operadora(String id, String nomeOperadora, String codigoOperadora, Date ultimaAtualizacaoOperadora, Collection<Produto> produtoCollection) {
        this.id = id;
        this.nomeOperadora = nomeOperadora;
        this.codigoOperadora = codigoOperadora;
        this.ultimaAtualizacaoOperadora = ultimaAtualizacaoOperadora;
        this.produtoCollection = produtoCollection;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeOperadora() {
        return nomeOperadora;
    }

    public void setNomeOperadora(String nomeOperadora) {
        this.nomeOperadora = nomeOperadora;
    }

    public String getCodigoOperadora() {
        return codigoOperadora;
    }

    public void setCodigoOperadora(String codigoOperadora) {
        this.codigoOperadora = codigoOperadora;
    }

    public Date getUltimaAtualizacaoOperadora() {
        return ultimaAtualizacaoOperadora;
    }

    public void setUltimaAtualizacaoOperadora(Date ultimaAtualizacaoOperadora) {
        this.ultimaAtualizacaoOperadora = ultimaAtualizacaoOperadora;
    }

    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public String toString() {
        return "Operadora{" + "id=" + id + ", nomeOperadora=" + nomeOperadora + ", codigoOperadora=" + codigoOperadora + ", ultimaAtualizacaoOperadora=" + ultimaAtualizacaoOperadora + ", produtoCollection=" + produtoCollection + '}';
    }

}
