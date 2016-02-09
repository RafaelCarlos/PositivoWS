/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "recarga_automatica")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "RecargaAutomatica.findAll", query = "SELECT r FROM RecargaAutomatica r"),
    @NamedQuery(name = "RecargaAutomatica.findById", query = "SELECT r FROM RecargaAutomatica r WHERE r.id = :id"),
    @NamedQuery(name = "RecargaAutomatica.findByCelular", query = "SELECT r FROM RecargaAutomatica r WHERE r.celular = :celular"),
    @NamedQuery(name = "RecargaAutomatica.findByValor", query = "SELECT r FROM RecargaAutomatica r WHERE r.valor = :valor"),
    @NamedQuery(name = "RecargaAutomatica.findByDia", query = "SELECT r FROM RecargaAutomatica r WHERE r.dia = :dia"),
    @NamedQuery(name = "RecargaAutomatica.findByDdd", query = "SELECT r FROM RecargaAutomatica r WHERE r.ddd = :ddd"),
    @NamedQuery(name = "RecargaAutomatica.findByRecargaAtivada", query = "SELECT r FROM RecargaAutomatica r WHERE r.recargaAtivada = :recargaAtivada")})
public class RecargaAutomatica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "celular")
    private String celular;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dia")
    @Temporal(TemporalType.DATE)
    private Date dia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ddd")
    private String ddd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recarga_ativada")
    private boolean recargaAtivada;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public RecargaAutomatica() {
    }

    public RecargaAutomatica(Integer id) {
        this.id = id;
    }

    public RecargaAutomatica(Integer id, String celular, BigDecimal valor, Date dia, String ddd, boolean recargaAtivada) {
        this.id = id;
        this.celular = celular;
        this.valor = valor;
        this.dia = dia;
        this.ddd = ddd;
        this.recargaAtivada = recargaAtivada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public boolean getRecargaAtivada() {
        return recargaAtivada;
    }

    public void setRecargaAtivada(boolean recargaAtivada) {
        this.recargaAtivada = recargaAtivada;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final RecargaAutomatica other = (RecargaAutomatica) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RecargaAutomatica{" + "id=" + id + ", celular=" + celular + ", valor=" + valor + ", dia=" + dia + ", ddd=" + ddd + ", recargaAtivada=" + recargaAtivada + ", usuarioId=" + usuarioId + '}';
    }

}
