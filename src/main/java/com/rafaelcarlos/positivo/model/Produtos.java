/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafaellcarloss
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer qtdProdutos;

    private List<Produto> produto;

    public Produtos() {
        super();
    }

    public Integer getQtdprodutos() {
        return qtdProdutos;
    }

    public void setQtdprodutos(Integer qtdprodutos) {
        this.qtdProdutos = qtdprodutos;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Produtos{" + "qtdprodutos=" + qtdProdutos + ", produto=" + produto + '}';
    }

}
