/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.util;

import com.rafaelcarlos.positivo.model.Cellcard;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author rafaellcarloss
 */
public class CellCardConversor implements Converter {

    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

        Cellcard cellcard = new Cellcard();

        while (reader.hasMoreChildren()) {
            reader.moveDown();
            if ("versao".equals(reader.getNodeName())) {

                Double versao = (Double) context.convertAnother(cellcard, Double.class);
                cellcard.setVersao(versao);
            } else if ("codigotransacao".equals(reader.getNodeName())) {
                Integer codigo = (Integer) context.convertAnother(cellcard, Integer.class);
                cellcard.setCodigoTransacao(codigo);
            } else if ("loja".equals(reader.getNodeName())) {
                Integer loja = (Integer) context.convertAnother(cellcard, Integer.class);
                cellcard.setLoja(loja);
            } 
//            else if ("operadoras".equals(reader.getNodeName())) {
//                ArrayList operadoras = (ArrayList) context.convertAnother(cellcard, ArrayList.class);
//
//                cellcard.setOperadorass(operadoras);
//            }
            reader.moveUp();
        }
        return cellcard;

    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Cellcard.class);
    }

}
