/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafaellcarloss
 */
@Entity
@Table(name = "recarga_cancelada")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "RecargaCancelada.findAll", query = "SELECT r FROM RecargaCancelada r"),
    @NamedQuery(name = "RecargaCancelada.findById", query = "SELECT r FROM RecargaCancelada r WHERE r.id = :id"),
    @NamedQuery(name = "RecargaCancelada.findByDataCancelamento", query = "SELECT r FROM RecargaCancelada r WHERE r.dataCancelamento = :dataCancelamento")})
public class RecargaCancelada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_cancelamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCancelamento;
    @JoinColumn(name = "recarga_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Recarga recargaId;

    public RecargaCancelada() {
    }

    public RecargaCancelada(Integer id) {
        this.id = id;
    }

    public RecargaCancelada(Integer id, Date dataCancelamento) {
        this.id = id;
        this.dataCancelamento = dataCancelamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public Recarga getRecargaId() {
        return recargaId;
    }

    public void setRecargaId(Recarga recargaId) {
        this.recargaId = recargaId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final RecargaCancelada other = (RecargaCancelada) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RecargaCancelada{" + "id=" + id + ", dataCancelamento=" + dataCancelamento + ", recargaId=" + recargaId + '}';
    }

}
