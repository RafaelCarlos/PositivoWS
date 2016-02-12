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
public class EstadosAtuantes implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer qtdestadosoperadoras;

    private List<String> estadooperadora;

    public EstadosAtuantes() {
    }

    public EstadosAtuantes(Integer qtdestadosoperadoras, List<String> estadooperadora) {
        this.qtdestadosoperadoras = qtdestadosoperadoras;
        this.estadooperadora = estadooperadora;
    }

    public Integer getQtdestadosoperadoras() {
        return qtdestadosoperadoras;
    }

    public void setQtdestadosoperadoras(Integer qtdestadosoperadoras) {
        this.qtdestadosoperadoras = qtdestadosoperadoras;
    }

    public List<String> getEstadooperadora() {
        return estadooperadora;
    }

    public void setEstadooperadora(List<String> estadooperadora) {
        this.estadooperadora = estadooperadora;
    }

    @Override
    public String toString() {
        return "EstadosAtuantes{" + "qtdestadosoperadoras=" + qtdestadosoperadoras + ", estadooperadora=" + estadooperadora + '}';
    }

}
