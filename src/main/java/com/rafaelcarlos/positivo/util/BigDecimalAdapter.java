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
public class BigDecimalAdapter extends XmlAdapter<String, BigDecimal> {

    @Override
    public String marshal(BigDecimal value) throws Exception {
        if (value != null) {
            return value.toString();
        }
        return null;
    }

    @Override
    public BigDecimal unmarshal(String s) throws Exception {
        return new BigDecimal(s);
    }

}
