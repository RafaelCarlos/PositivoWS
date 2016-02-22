/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author rafaellcarloss
 */
public class DateAdapter extends XmlAdapter<String, Date> {

    private final SimpleDateFormat SD1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final SimpleDateFormat SD2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    @Override
    public String marshal(Date v) throws Exception {
        return SD2.format(v);
    }

    @Override
    public Date unmarshal(String v) throws Exception, ParseException {
        return SD1.parse(v);

    }

}
