/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author rafaellcarloss
 */
public abstract class AtualizacaoOperadoraConversor extends XmlAdapter {

    public LocalDate unmarshal( String v ) throws Exception
    {
        return LocalDate.parse( v );
    }

    public String marshal( LocalDate v ) throws Exception
    {
        return v.toString();
    }

}
