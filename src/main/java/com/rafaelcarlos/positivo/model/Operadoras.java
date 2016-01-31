/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

import java.util.ArrayList;
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

    private ArrayList<Operadora> operadoras;
    private ArrayList qtdOperadoras;

    public Operadoras() {
    }

    public ArrayList<Operadora> getOperadoras() {
        return operadoras;
    }

    public void setOperadoras(ArrayList<Operadora> operadoras) {
        this.operadoras = operadoras;
    }

    public ArrayList getQtdOperadoras() {
        return qtdOperadoras;
    }

    public void setQtdOperadoras(ArrayList qtdOperadoras) {
        this.qtdOperadoras = qtdOperadoras;
    }

}
