package com.rafaelcarlos.positivo.model;

import java.math.BigDecimal;
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
public class Cellcard {

    private Double versao;

    private Integer codigoTransacao;

    private Integer loja;

    private Operadoras operadoras;

    public Cellcard() {
    }

    public Double getVersao() {
        return versao;
    }

    public void setVersao(Double versao) {
        this.versao = versao;
    }

    public Integer getCodigoTransacao() {
        return codigoTransacao;
    }

    public void setCodigoTransacao(Integer codigoTransacao) {
        this.codigoTransacao = codigoTransacao;
    }

    public Integer getLoja() {
        return loja;
    }

    public void setLoja(Integer loja) {
        this.loja = loja;
    }

    public Operadoras getOperadoras() {
        return operadoras;
    }

    public void setOperadoras(Operadoras operadoras) {
        this.operadoras = operadoras;
    }

}
