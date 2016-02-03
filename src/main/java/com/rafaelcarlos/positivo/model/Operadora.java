package com.rafaelcarlos.positivo.model;

import java.io.Serializable;
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
    @NamedQuery(name = "Operadora.findByCodigoOperadora", query = "SELECT o FROM Operadora o WHERE o.codigoOperadora = :codigoOperadora"),
    @NamedQuery(name = "Operadora.findByUltimaAtualizacaoOperadora", query = "SELECT o FROM Operadora o WHERE o.ultimaAtualizacaoOperadora = :ultimaAtualizacaoOperadora")})
public class Operadora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nome_operadora")
    private String nomeOperadora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @XmlElement
    @Column(name = "codigo_operadora")
    private String codigoOperadora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ultima_atualizacao_operadora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAtualizacaoOperadora;

    private Produtos produtos;

    private EstadosAtuantes estadosAtuantes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operadoraId")
    private Collection<Produto> produto;

    public Operadora() {
    }

    public Operadora(Integer id) {
        this.id = id;
    }

    public Operadora(Integer id, String nomeOperadora, String codigoOperadora, Date ultimaAtualizacaoOperadora, Collection<Produto> produto) {
        this.id = id;
        this.nomeOperadora = nomeOperadora;
        this.codigoOperadora = codigoOperadora;
        this.ultimaAtualizacaoOperadora = ultimaAtualizacaoOperadora;
        this.produto = produto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public EstadosAtuantes getEstadosAtuantes() {
        return estadosAtuantes;
    }

    public void setEstadosAtuantes(EstadosAtuantes estadosAtuantes) {
        this.estadosAtuantes = estadosAtuantes;
    }

    public Collection<Produto> getProduto() {
        return produto;
    }

    public void setProduto(Collection<Produto> produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Operadora other = (Operadora) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Operadora{" + "id=" + id + ", nomeOperadora=" + nomeOperadora + ", codigoOperadora=" + codigoOperadora + ", ultimaAtualizacaoOperadora=" + ultimaAtualizacaoOperadora + ", produtos=" + produtos + ", estadosAtuantes=" + estadosAtuantes + ", produto=" + produto + '}';
    }

}
