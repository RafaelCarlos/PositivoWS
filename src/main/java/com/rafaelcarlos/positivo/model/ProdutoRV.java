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
public class ProdutoRV {

    private String modelorecarga;

    private String nomeproduto;

    private String precocompraproduto;

    private String codigoproduto;

    private String validadeproduto;

    private String valormaximoproduto;

    private EstadosProdutoPin estadosprodutopin;

    private String ultima_atualizacaoproduto;

    private String precovariavelproduto;

    private String precovendaproduto;

    private String valorminimoproduto;

    private String valorincrementoproduto;

    public String getModelorecarga() {
        return modelorecarga;
    }

    public void setModelorecarga(String modelorecarga) {
        this.modelorecarga = modelorecarga;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public String getPrecocompraproduto() {
        return precocompraproduto;
    }

    public void setPrecocompraproduto(String precocompraproduto) {
        this.precocompraproduto = precocompraproduto;
    }

    public String getCodigoproduto() {
        return codigoproduto;
    }

    public void setCodigoproduto(String codigoproduto) {
        this.codigoproduto = codigoproduto;
    }

    public String getValidadeproduto() {
        return validadeproduto;
    }

    public void setValidadeproduto(String validadeproduto) {
        this.validadeproduto = validadeproduto;
    }

    public String getValormaximoproduto() {
        return valormaximoproduto;
    }

    public void setValormaximoproduto(String valormaximoproduto) {
        this.valormaximoproduto = valormaximoproduto;
    }

    public EstadosProdutoPin getEstadosprodutopin() {
        return estadosprodutopin;
    }

    public void setEstadosprodutopin(EstadosProdutoPin estadosprodutopin) {
        this.estadosprodutopin = estadosprodutopin;
    }

    public String getUltima_atualizacaoproduto() {
        return ultima_atualizacaoproduto;
    }

    public void setUltima_atualizacaoproduto(String ultima_atualizacaoproduto) {
        this.ultima_atualizacaoproduto = ultima_atualizacaoproduto;
    }

    public String getPrecovariavelproduto() {
        return precovariavelproduto;
    }

    public void setPrecovariavelproduto(String precovariavelproduto) {
        this.precovariavelproduto = precovariavelproduto;
    }

    public String getPrecovendaproduto() {
        return precovendaproduto;
    }

    public void setPrecovendaproduto(String precovendaproduto) {
        this.precovendaproduto = precovendaproduto;
    }

    public String getValorminimoproduto() {
        return valorminimoproduto;
    }

    public void setValorminimoproduto(String valorminimoproduto) {
        this.valorminimoproduto = valorminimoproduto;
    }

    public String getValorincrementoproduto() {
        return valorincrementoproduto;
    }

    public void setValorincrementoproduto(String valorincrementoproduto) {
        this.valorincrementoproduto = valorincrementoproduto;
    }

    @Override
    public String toString() {
        return "ClassPojo [modelorecarga = " + modelorecarga + ", nomeproduto = " + nomeproduto + ", precocompraproduto = " + precocompraproduto + ", codigoproduto = " + codigoproduto + ", validadeproduto = " + validadeproduto + ", valormaximoproduto = " + valormaximoproduto + ", estadosprodutopin = " + estadosprodutopin + ", ultima_atualizacaoproduto = " + ultima_atualizacaoproduto + ", precovariavelproduto = " + precovariavelproduto + ", precovendaproduto = " + precovendaproduto + ", valorminimoproduto = " + valorminimoproduto + ", valorincrementoproduto = " + valorincrementoproduto + "]";
    }

}
