/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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

    public Operadora() {
    }

    public Operadora(String id) {
        this.id = id;
    }

    public Operadora(String id, String nomeOperadora, String codigoOperadora) {
        this.id = id;
        this.nomeOperadora = nomeOperadora;
        this.codigoOperadora = codigoOperadora;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        return "Operadora{" + "id=" + id + ", nomeOperadora=" + nomeOperadora + ", codigoOperadora=" + codigoOperadora + '}';
    }

}
