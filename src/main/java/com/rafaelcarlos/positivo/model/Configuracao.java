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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafaellcarloss
 */
@Entity
@Table(name = "configuracao")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Configuracao.findAll", query = "SELECT c FROM Configuracao c"),
    @NamedQuery(name = "Configuracao.findById", query = "SELECT c FROM Configuracao c WHERE c.id = :id"),
    @NamedQuery(name = "Configuracao.findByNotificacao", query = "SELECT c FROM Configuracao c WHERE c.notificacao = :notificacao"),
    @NamedQuery(name = "Configuracao.findByEmailPromocional", query = "SELECT c FROM Configuracao c WHERE c.emailPromocional = :emailPromocional"),
    @NamedQuery(name = "Configuracao.findByBaixoSaldo", query = "SELECT c FROM Configuracao c WHERE c.baixoSaldo = :baixoSaldo")})
public class Configuracao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notificacao")
    private boolean notificacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "email_promocional")
    private boolean emailPromocional;
    @Basic(optional = false)
    @NotNull
    @Column(name = "baixo_saldo")
    private boolean baixoSaldo;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public Configuracao() {
    }

    public Configuracao(Integer id) {
        this.id = id;
    }

    public Configuracao(Integer id, boolean notificacao, boolean emailPromocional, boolean baixoSaldo) {
        this.id = id;
        this.notificacao = notificacao;
        this.emailPromocional = emailPromocional;
        this.baixoSaldo = baixoSaldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(boolean notificacao) {
        this.notificacao = notificacao;
    }

    public boolean getEmailPromocional() {
        return emailPromocional;
    }

    public void setEmailPromocional(boolean emailPromocional) {
        this.emailPromocional = emailPromocional;
    }

    public boolean getBaixoSaldo() {
        return baixoSaldo;
    }

    public void setBaixoSaldo(boolean baixoSaldo) {
        this.baixoSaldo = baixoSaldo;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Configuracao other = (Configuracao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Configuracao{" + "id=" + id + ", notificacao=" + notificacao + ", emailPromocional=" + emailPromocional + ", baixoSaldo=" + baixoSaldo + ", usuarioId=" + usuarioId + '}';
    }

}
