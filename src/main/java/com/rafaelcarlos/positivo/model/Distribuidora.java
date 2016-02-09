/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rafaellcarloss
 */
@Entity
@Table(name = "distribuidora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distribuidora.findAll", query = "SELECT d FROM Distribuidora d"),
    @NamedQuery(name = "Distribuidora.findById", query = "SELECT d FROM Distribuidora d WHERE d.id = :id"),
    @NamedQuery(name = "Distribuidora.findByNomeDistribuidora", query = "SELECT d FROM Distribuidora d WHERE d.nomeDistribuidora = :nomeDistribuidora")})
public class Distribuidora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nome_distribuidora")
    private String nomeDistribuidora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distribuidoraId")
    private Collection<Empresa> empresaCollection;

    public Distribuidora() {
    }

    public Distribuidora(Integer id) {
        this.id = id;
    }

    public Distribuidora(Integer id, String nomeDistribuidora) {
        this.id = id;
        this.nomeDistribuidora = nomeDistribuidora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeDistribuidora() {
        return nomeDistribuidora;
    }

    public void setNomeDistribuidora(String nomeDistribuidora) {
        this.nomeDistribuidora = nomeDistribuidora;
    }

    @XmlTransient
    public Collection<Empresa> getEmpresaCollection() {
        return empresaCollection;
    }

    public void setEmpresaCollection(Collection<Empresa> empresaCollection) {
        this.empresaCollection = empresaCollection;
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
        if (!(object instanceof Distribuidora)) {
            return false;
        }
        Distribuidora other = (Distribuidora) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Distribuidora{" + "id=" + id + ", nomeDistribuidora=" + nomeDistribuidora + ", empresaCollection=" + empresaCollection + '}';
    }

}
