/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.util;

import static java.lang.String.format;
import static java.lang.String.format;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.text.DateFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author rafaellcarloss
 */
public class DateAdapter extends XmlAdapter<String, Date> {

    Locale brasil = new Locale("pt", "br");
    private final SimpleDateFormat dataFormatada = new SimpleDateFormat("EEE MMM yy HH:mm:ssZ", brasil);
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

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
