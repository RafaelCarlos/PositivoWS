/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.model;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
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

    @XStreamImplicit
    private String codigooperadora;

    private Produtos produtos;

    private EstadosAtuantes estadosatuantes;

    private String nomeoperadora;

    private String ultimaatualizacaooperadora;

    public String getCodigooperadora ()
    {
        return codigooperadora;
    }

    public void setCodigooperadora (String codigooperadora)
    {
        this.codigooperadora = codigooperadora;
    }

    public Produtos getProdutos ()
    {
        return produtos;
    }

    public void setProdutos (Produtos produtos)
    {
        this.produtos = produtos;
    }

    public EstadosAtuantes getEstadosatuantes ()
    {
        return estadosatuantes;
    }

    public void setEstadosatuantes (EstadosAtuantes estadosatuantes)
    {
        this.estadosatuantes = estadosatuantes;
    }

    public String getNomeoperadora ()
    {
        return nomeoperadora;
    }

    public void setNomeoperadora (String nomeoperadora)
    {
        this.nomeoperadora = nomeoperadora;
    }

    public String getUltimaatualizacaooperadora ()
    {
        return ultimaatualizacaooperadora;
    }

    public void setUltimaatualizacaooperadora (String ultimaatualizacaooperadora)
    {
        this.ultimaatualizacaooperadora = ultimaatualizacaooperadora;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [codigooperadora = "+codigooperadora+", produtos = "+produtos+", estadosatuantes = "+estadosatuantes+", nomeoperadora = "+nomeoperadora+", ultimaatualizacaooperadora = "+ultimaatualizacaooperadora+"]";
    }

   
}
