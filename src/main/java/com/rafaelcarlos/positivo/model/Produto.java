/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafaellcarloss
 */
@Entity
@Table(name = "produto")
@XmlRootElement
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "qtd_produto")
    private int qtdProduto;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nome_produto")
    private String nomeProduto;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigo_operadora")
    private String codigoOperadora;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_compra", precision = 5, scale = 2)
    private BigDecimal valorCompra;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_venda", precision = 5, scale = 2)
    private BigDecimal valorVenda;

    @Basic(optional = false)
    @NotNull
    @Column(name = "validade", length = 3)
    private Integer validade;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_compra")
    private Integer modeloRecarga;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_minimo", precision = 5, scale = 2)
    private BigDecimal valorMinimo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_maximo", precision = 5, scale = 2)
    private BigDecimal valorMaximo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_variavel", precision = 5, scale = 2)
    private BigDecimal valorVariavel;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAtualizacao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private Collection<Recarga> recargaCollection;

    @JoinColumn(name = "operadora_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Operadora operadoraId;

    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresaId;

}
