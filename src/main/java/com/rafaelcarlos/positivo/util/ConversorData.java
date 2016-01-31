/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.util;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafaellcarloss
 */
public class ConversorData implements Converter {

    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {

        Date data = (Date) o;

        String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(data);

        writer.setValue(dataFormatada);

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        Date dataFormatada = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            dataFormatada = sdf.parse(reader.getValue());
        } catch (ParseException ex) {
            Logger.getLogger(ConversorData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataFormatada;
    }

    @Override
    public boolean canConvert(Class type) {

        return type.equals(Date.class);
    }

}
