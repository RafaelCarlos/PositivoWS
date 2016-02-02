/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.util;

import com.rafaelcarlos.positivo.model.Operadora;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.util.Date;

/**
 *
 * @author rafaellcarloss
 */
public class OperadoraConverter implements Converter {

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Operadora.class);

    }

    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

        Operadora operadora = new Operadora();

        while (reader.hasMoreChildren()) {
            reader.moveDown();

            if ("codigooperadora".equals(reader.getNodeName())) {
                String codigoOperadora = (String) context.convertAnother(operadora, String.class);
                operadora.setCodigoOperadora(codigoOperadora);
            } else if ("nomeoperadora".equals(reader.getNodeName())) {
                String nomeOperadora = (String) context.convertAnother(operadora, String.class);
                operadora.setNomeOperadora(nomeOperadora);
            } else if ("ultimaatualizacaooperadora".equals(reader.getNodeName())) {
                Date ultimaAtualizacaoOperadora = (Date) context.convertAnother(operadora, Date.class);
                operadora.setUltimaAtualizacaoOperadora(ultimaAtualizacaoOperadora);

            }

            reader.moveUp();
        }
        return operadora;
    }

}
