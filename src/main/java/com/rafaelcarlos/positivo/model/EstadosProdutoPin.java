/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

/**
 *
 * @author rafaellcarloss
 */
public class EstadosProdutoPin {

    private String qtdestadosproduto;

    private String[] estadoproduto;

    public String getQtdestadosproduto() {
        return qtdestadosproduto;
    }

    public void setQtdestadosproduto(String qtdestadosproduto) {
        this.qtdestadosproduto = qtdestadosproduto;
    }

    public String[] getEstadoproduto() {
        return estadoproduto;
    }

    public void setEstadoproduto(String[] estadoproduto) {
        this.estadoproduto = estadoproduto;
    }

    @Override
    public String toString() {
        return "ClassPojo [qtdestadosproduto = " + qtdestadosproduto + ", estadoproduto = " + estadoproduto + "]";
    }
}
