/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author rafaellcarloss
 */
public class DateAdapter extends XmlAdapter<String, Date> {

    private static final String pattern = "dd-MM-yyyy";

    @Override
    public Date unmarshal(String v) throws Exception {
        Date data;
        SimpleDateFormat dataFormatada = new SimpleDateFormat(pattern);

        data = dataFormatada.parse(v);
        return data;
    }

    @Override
    public String marshal(Date v) throws Exception {

        SimpleDateFormat dataFormatada = new SimpleDateFormat(pattern);
        return dataFormatada.toString();
    }

}
