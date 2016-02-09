/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.util;

import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author rafaellcarloss
 */
public class ConversorPersonalizado extends XmlAdapter<ConversorPersonalizado.AdaptedDate, XMLGregorianCalendar> {

    @Override
    public AdaptedDate marshal(XMLGregorianCalendar date) throws Exception {
        AdaptedDate adaptedDate = new AdaptedDate();
        adaptedDate.value = date;
        return adaptedDate;
    }

    @Override
    public XMLGregorianCalendar unmarshal(AdaptedDate adaptedDate) throws Exception {
        return adaptedDate.value;
    }

    public static class AdaptedDate {

        @XmlValue
        public XMLGregorianCalendar value;
    }

}
