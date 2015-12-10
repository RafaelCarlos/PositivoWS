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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafaellcarloss
 */
@Entity
@Table(name = "recomendados")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Recomendados.findAll", query = "SELECT r FROM Recomendados r"),
    @NamedQuery(name = "Recomendados.findById", query = "SELECT r FROM Recomendados r WHERE r.id = :id"),
    @NamedQuery(name = "Recomendados.findByNome", query = "SELECT r FROM Recomendados r WHERE r.nome = :nome"),
    @NamedQuery(name = "Recomendados.findByNumeroTelefone", query = "SELECT r FROM Recomendados r WHERE r.numeroTelefone = :numeroTelefone")})
public class Recomendados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 40)
    @Column(name = "nome")
    private String nome;
    @Size(max = 20)
    @Column(name = "numero_telefone")
    private String numeroTelefone;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public Recomendados() {
    }

    public Recomendados(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Recomendados other = (Recomendados) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recomendados{" + "id=" + id + ", nome=" + nome + ", numeroTelefone=" + numeroTelefone + ", usuarioId=" + usuarioId + '}';
    }

}
