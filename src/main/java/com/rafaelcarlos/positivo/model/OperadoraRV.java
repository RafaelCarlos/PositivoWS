/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafaellcarloss
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OperadoraRV {

    private String codigooperadoa;
    private String nomeoperadora;
    private Date utimaatualizacaooperadora;

    public OperadoraRV() {
    }

    public String getCodigooperadoa() {
        return codigooperadoa;
    }

    public void setCodigooperadoa(String codigooperadoa) {
        this.codigooperadoa = codigooperadoa;
    }

    public String getNomeoperadora() {
        return nomeoperadora;
    }

    public void setNomeoperadora(String nomeoperadora) {
        this.nomeoperadora = nomeoperadora;
    }

    public Date getUtimaatualizacaooperadora() {
        return utimaatualizacaooperadora;
    }

    public void setUtimaatualizacaooperadora(Date utimaatualizacaooperadora) {
        this.utimaatualizacaooperadora = utimaatualizacaooperadora;
    }

}
