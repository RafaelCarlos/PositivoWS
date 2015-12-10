package com.rafaelcarlos.positivo.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "empresa")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "razao_social")
    private String razaoSocial;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ie")
    private String iE;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cnpj")
    private String cnpj;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "endereco")
    private String endereco;

    @Size(min = 1, max = 5)
    @Column(name = "numero")
    private String numero;

    @Size(min = 1, max = 50)
    @Column(name = "complemento")
    private String complemento;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "bairro")
    private String bairro;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome_cidade")
    private String nomeCidade;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "uf")
    private String uf;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "cep")
    private String cep;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telefone_empresa")
    private String telefoneEmpresa;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "email_empresa")
    private String emailEmpresa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private Collection<Produto> produtoCollection;

    @JoinColumn(name = "distribuidora_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Distribuidora distribuidoraId;

    public Empresa() {
    }

    public Empresa(Integer id) {
        this.id = id;
    }

    public Empresa(Integer id, String razaoSocial, String iE, String nomeFantasia, String cnpj, String endereco, String numero, String complemento, String bairro, String nomeCidade, String uf, String cep, String telefoneEmpresa, String emailEmpresa, Collection<Produto> produtoCollection, Distribuidora distribuidoraId) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.iE = iE;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.nomeCidade = nomeCidade;
        this.uf = uf;
        this.cep = cep;
        this.telefoneEmpresa = telefoneEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.produtoCollection = produtoCollection;
        this.distribuidoraId = distribuidoraId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getiE() {
        return iE;
    }

    public void setiE(String iE) {
        this.iE = iE;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefoneEmpresa() {
        return telefoneEmpresa;
    }

    public void setTelefoneEmpresa(String telefoneEmpresa) {
        this.telefoneEmpresa = telefoneEmpresa;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    public Distribuidora getDistribuidoraId() {
        return distribuidoraId;
    }

    public void setDistribuidoraId(Distribuidora distribuidoraId) {
        this.distribuidoraId = distribuidoraId;
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
        final Empresa other = (Empresa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", razaoSocial=" + razaoSocial + ", iE=" + iE + ", nomeFantasia=" + nomeFantasia + ", cnpj=" + cnpj + ", endereco=" + endereco + ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro + ", nomeCidade=" + nomeCidade + ", uf=" + uf + ", cep=" + cep + ", telefoneEmpresa=" + telefoneEmpresa + ", emailEmpresa=" + emailEmpresa + ", produtoCollection=" + produtoCollection + ", distribuidoraId=" + distribuidoraId + '}';
    }

}
