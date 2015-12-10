/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.ws.BindingType;

/**
 *
 * @author rafaellcarloss
 */
@Entity
@Table(name = "recarga")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Recarga.findAll", query = "SELECT r FROM Recarga r"),
    @NamedQuery(name = "Recarga.findById", query = "SELECT r FROM Recarga r WHERE r.id = :id"),
    @NamedQuery(name = "Recarga.findByValor", query = "SELECT r FROM Recarga r WHERE r.valor = :valor"),
    @NamedQuery(name = "Recarga.findByDdd", query = "SELECT r FROM Recarga r WHERE r.ddd = :ddd"),
    @NamedQuery(name = "Recarga.findByNumeroCelular", query = "SELECT r FROM Recarga r WHERE r.numeroCelular = :numeroCelular"),
    @NamedQuery(name = "Recarga.findByHorarioVenda", query = "SELECT r FROM Recarga r WHERE r.horarioVenda = :horarioVenda"),
    @NamedQuery(name = "Recarga.findByVersao", query = "SELECT r FROM Recarga r WHERE r.versao = :versao"),
    @NamedQuery(name = "Recarga.findByPago", query = "SELECT r FROM Recarga r WHERE r.pago = :pago"),
    @NamedQuery(name = "Recarga.findByStatus", query = "SELECT r FROM Recarga r WHERE r.status = :status"),
    @NamedQuery(name = "Recarga.findByNsu", query = "SELECT r FROM Recarga r WHERE r.nsu = :nsu")})
public class Recarga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor", precision = 5, scale = 2)
    private BigDecimal valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ddd")
    private String ddd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_celular")
    private String numeroCelular;
    @Column(name = "horario_venda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horarioVenda;
    @Column(name = "versao", precision = 2, scale = 1)
    private BigDecimal versao;
    @Column(name = "pago")
    private Boolean pago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nsu")
    private String nsu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recargaId")
    private Collection<RecargaCancelada> recargaCanceladaCollection;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produto produtoId;

    public Recarga() {
    }

    public Recarga(Integer id) {
        this.id = id;
    }

    public Recarga(Integer id, BigDecimal valor, String ddd, String numeroCelular, Date horarioVenda, BigDecimal versao, Boolean pago, String status, String nsu, Collection<RecargaCancelada> recargaCanceladaCollection, Usuario usuarioId, Produto produtoId) {
        this.id = id;
        this.valor = valor;
        this.ddd = ddd;
        this.numeroCelular = numeroCelular;
        this.horarioVenda = horarioVenda;
        this.versao = versao;
        this.pago = pago;
        this.status = status;
        this.nsu = nsu;
        this.recargaCanceladaCollection = recargaCanceladaCollection;
        this.usuarioId = usuarioId;
        this.produtoId = produtoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public Date getHorarioVenda() {
        return horarioVenda;
    }

    public void setHorarioVenda(Date horarioVenda) {
        this.horarioVenda = horarioVenda;
    }

    public BigDecimal getVersao() {
        return versao;
    }

    public void setVersao(BigDecimal versao) {
        this.versao = versao;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public Collection<RecargaCancelada> getRecargaCanceladaCollection() {
        return recargaCanceladaCollection;
    }

    public void setRecargaCanceladaCollection(Collection<RecargaCancelada> recargaCanceladaCollection) {
        this.recargaCanceladaCollection = recargaCanceladaCollection;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Recarga other = (Recarga) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recarga{" + "id=" + id + ", valor=" + valor + ", ddd=" + ddd + ", numeroCelular=" + numeroCelular + ", horarioVenda=" + horarioVenda + ", versao=" + versao + ", pago=" + pago + ", status=" + status + ", nsu=" + nsu + ", recargaCanceladaCollection=" + recargaCanceladaCollection + ", usuarioId=" + usuarioId + ", produtoId=" + produtoId + '}';
    }

}
