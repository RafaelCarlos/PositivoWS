/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafaellcarloss
 */
@Entity
@Table(name = "boleto_empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BoletoEmpresa.findAll", query = "SELECT b FROM BoletoEmpresa b"),
    @NamedQuery(name = "BoletoEmpresa.findById", query = "SELECT b FROM BoletoEmpresa b WHERE b.id = :id"),
    @NamedQuery(name = "BoletoEmpresa.findByValorBoleto", query = "SELECT b FROM BoletoEmpresa b WHERE b.valorBoleto = :valorBoleto"),
    @NamedQuery(name = "BoletoEmpresa.findByDataVencimento", query = "SELECT b FROM BoletoEmpresa b WHERE b.dataVencimento = :dataVencimento"),
    @NamedQuery(name = "BoletoEmpresa.findByStatus", query = "SELECT b FROM BoletoEmpresa b WHERE b.status = :status"),
    @NamedQuery(name = "BoletoEmpresa.findByDataEmissao", query = "SELECT b FROM BoletoEmpresa b WHERE b.dataEmissao = :dataEmissao")})
public class BoletoEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_boleto")
    private BigDecimal valorBoleto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_emissao")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresaId;

    public BoletoEmpresa() {
    }

    public BoletoEmpresa(Integer id) {
        this.id = id;
    }

    public BoletoEmpresa(Integer id, BigDecimal valorBoleto, Date dataVencimento, boolean status, Date dataEmissao) {
        this.id = id;
        this.valorBoleto = valorBoleto;
        this.dataVencimento = dataVencimento;
        this.status = status;
        this.dataEmissao = dataEmissao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorBoleto() {
        return valorBoleto;
    }

    public void setValorBoleto(BigDecimal valorBoleto) {
        this.valorBoleto = valorBoleto;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Empresa getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresaId = empresaId;
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
        if (!(object instanceof BoletoEmpresa)) {
            return false;
        }
        BoletoEmpresa other = (BoletoEmpresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BoletoEmpresa{" + "id=" + id + ", valorBoleto=" + valorBoleto + ", dataVencimento=" + dataVencimento + ", status=" + status + ", dataEmissao=" + dataEmissao + ", empresaId=" + empresaId + '}';
    }
}
