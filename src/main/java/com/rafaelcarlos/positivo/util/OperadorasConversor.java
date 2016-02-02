/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.util;

import com.rafaelcarlos.positivo.model.Operadora;
import com.rafaelcarlos.positivo.model.Operadoras;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.util.List;

/**
 *
 * @author rafaellcarloss
 */
public class OperadorasConversor implements Converter {

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Operadoras.class);
    }

    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

        Operadoras operadoras = new Operadoras();

        while (reader.hasMoreChildren()) {
            reader.moveDown();
            if ("qtdoperadoras".equals(reader.getNodeName())) {
                Integer qtdOperadora = (Integer) context.convertAnother(operadoras, Integer.class);
                operadoras.setQtdOperadoras(qtdOperadora);
            }

//            if ("operadora".equals(reader.getNodeName())) {
//                Operadora operadora = (Operadora) context.convertAnother(operadoras, Operadora.class);
////                operadoras.setOperadora(operadora);
//            }
            reader.moveUp();
        }
        return operadoras;

    }
}
