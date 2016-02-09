/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.util;

import java.math.BigDecimal;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author rafaellcarloss
 */
public class BigDecimalAdapter extends XmlAdapter<Double, Double> {

    @Override
    public Double unmarshal(Double v) throws Exception {
        return v;
    }

    @Override
    public Double marshal(Double v) throws Exception {
        if (Double.MAX_VALUE == v) {
            return null;
        } else {
            return v;
        }
    }

}
