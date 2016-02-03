/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

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
public class Produtos extends Produto{

    private Integer qtdprodutos;

    private List<Produto> produto;

    public Produtos() {
        super();
    }
   
    public Integer getQtdprodutos() {
        return qtdprodutos;
    }

    public void setQtdprodutos(Integer qtdprodutos) {
        this.qtdprodutos = qtdprodutos;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Produtos{" + "qtdprodutos=" + qtdprodutos + ", produto=" + produto + '}';
    }

}
