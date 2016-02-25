/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
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
@Table(name = "usuario")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByIdFacebook", query = "SELECT u FROM Usuario u WHERE u.idFacebook = :idFacebook"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findBySobrenome", query = "SELECT u FROM Usuario u WHERE u.sobrenome = :sobrenome"),
    @NamedQuery(name = "Usuario.findByAtivo", query = "SELECT u FROM Usuario u WHERE u.ativo = :ativo")})
public class Usuario implements Serializable {

    public enum NomeTipoUsuario {

        SUPORTE, ADMINISTRADOR, USUARIO
    }
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "senha")
    private String senha;
    @Size(max = 100)
    @Column(name = "id_facebook")
    private String idFacebook;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nome")
    private String nome;
    @Size(max = 40)
    @Column(name = "sobrenome")
    private String sobrenome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ativo")
    private boolean ativo;
    @Enumerated(EnumType.STRING)
    @Column(name = "nome_tipo_usuario", nullable = false)
    private NomeTipoUsuario nomeTipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<CartaoCredito> cartaoCreditoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<CelularRecarga> celularRecargaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<Configuracao> configuracaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<RecargaGratis> recargaGratisCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<RecargaAutomatica> recargaAutomaticaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<Feedback> feedbackCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<Recomendados> recomendadosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<Carteira> carteiraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private Collection<Recarga> recargaCollection;

    public Usuario() {
    }

    public Usuario(String email, String senha, String idFacebook, String nome, String sobrenome, boolean ativo, NomeTipoUsuario tipousuario) {
        this.email = email;
        this.senha = senha;
        this.idFacebook = idFacebook;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.ativo = ativo;
        this.nomeTipoUsuario = tipousuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getIdFacebook() {
        return idFacebook;
    }

    public void setIdFacebook(String idFacebook) {
        this.idFacebook = idFacebook;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public NomeTipoUsuario getNomeTipoUsuario() {
        return nomeTipoUsuario;
    }

    public void setNomeTipoUsuario(NomeTipoUsuario nomeTipoUsuario) {
        this.nomeTipoUsuario = nomeTipoUsuario;
    }

    @XmlTransient
    public Collection<CartaoCredito> getCartaoCreditoCollection() {
        return cartaoCreditoCollection;
    }

    public void setCartaoCreditoCollection(Collection<CartaoCredito> cartaoCreditoCollection) {
        this.cartaoCreditoCollection = cartaoCreditoCollection;
    }

    @XmlTransient
    public Collection<CelularRecarga> getCelularRecargaCollection() {
        return celularRecargaCollection;
    }

    public void setCelularRecargaCollection(Collection<CelularRecarga> celularRecargaCollection) {
        this.celularRecargaCollection = celularRecargaCollection;
    }

    @XmlTransient
    public Collection<Configuracao> getConfiguracaoCollection() {
        return configuracaoCollection;
    }

    public void setConfiguracaoCollection(Collection<Configuracao> configuracaoCollection) {
        this.configuracaoCollection = configuracaoCollection;
    }

    @XmlTransient
    public Collection<RecargaGratis> getRecargaGratisCollection() {
        return recargaGratisCollection;
    }

    public void setRecargaGratisCollection(Collection<RecargaGratis> recargaGratisCollection) {
        this.recargaGratisCollection = recargaGratisCollection;
    }

    @XmlTransient
    public Collection<RecargaAutomatica> getRecargaAutomaticaCollection() {
        return recargaAutomaticaCollection;
    }

    public void setRecargaAutomaticaCollection(Collection<RecargaAutomatica> recargaAutomaticaCollection) {
        this.recargaAutomaticaCollection = recargaAutomaticaCollection;
    }

    @XmlTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    @XmlTransient
    public Collection<Recomendados> getRecomendadosCollection() {
        return recomendadosCollection;
    }

    public void setRecomendadosCollection(Collection<Recomendados> recomendadosCollection) {
        this.recomendadosCollection = recomendadosCollection;
    }

    @XmlTransient
    public Collection<Carteira> getCarteiraCollection() {
        return carteiraCollection;
    }

    public void setCarteiraCollection(Collection<Carteira> carteiraCollection) {
        this.carteiraCollection = carteiraCollection;
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
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.idFacebook);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idFacebook, other.idFacebook)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", senha=" + senha + ", idFacebook=" + idFacebook + ", nome=" + nome + ", sobrenome=" + sobrenome + ", ativo=" + ativo + ", tipousuario=" + nomeTipoUsuario + ", cartaoCreditoCollection=" + cartaoCreditoCollection + ", celularRecargaCollection=" + celularRecargaCollection + ", configuracaoCollection=" + configuracaoCollection + ", recargaGratisCollection=" + recargaGratisCollection + ", recargaAutomaticaCollection=" + recargaAutomaticaCollection + ", feedbackCollection=" + feedbackCollection + ", recomendadosCollection=" + recomendadosCollection + ", carteiraCollection=" + carteiraCollection + ", recargaCollection=" + recargaCollection + '}';
    }

}
