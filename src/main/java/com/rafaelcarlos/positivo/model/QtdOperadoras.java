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
public class QtdOperadoras {

    private List qtdOperadoras = new ArrayList();

    private List<Operadora> operadoras;

    public QtdOperadoras() {
    }

    public List getQtdOperadoras() {
        return qtdOperadoras;
    }

    public void setQtdOperadoras(List qtdOperadoras) {
        this.qtdOperadoras = qtdOperadoras;
    }

    public List<Operadora> getOperadoras() {
        return operadoras;
    }

    public void setOperadoras(List<Operadora> operadoras) {
        this.operadoras = operadoras;
    }

}