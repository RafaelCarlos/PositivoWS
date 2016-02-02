/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

import java.util.ArrayList;
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
public class Operadoras {

    private Integer qtdOperadoras;

    private List<Operadora> operadora;

    public Operadoras() {
    }

    public Integer getQtdOperadoras() {
        return qtdOperadoras;
    }

    public void setQtdOperadoras(Integer qtdOperadoras) {
        this.qtdOperadoras = qtdOperadoras;
    }

    public List<Operadora> getOperadora() {
        return operadora;
    }

    public void setOperadora(List<Operadora> operadora) {
        this.operadora = operadora;
    }

}
