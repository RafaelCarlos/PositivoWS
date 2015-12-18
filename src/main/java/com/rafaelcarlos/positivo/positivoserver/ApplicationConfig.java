package com.rafaelcarlos.positivo.positivoserver;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author rafaellcarloss
 */
@javax.ws.rs.ApplicationPath("positivoservice")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.rafaelcarlos.positivo.positivoserver.PositivoRest.class);
        resources.add(com.rafaelcarlos.positivo.positivoserver.PositivoWSResource.class);
        resources.add(com.rafaelcarlos.positivo.positivoserver.RecargaWS.class);
        resources.add(com.rafaelcarlos.positivo.positivoserver.TipoUsuarioRest.class);
        resources.add(com.rafaelcarlos.positivo.positivoserver.UsuarioRest.class);
    }

}
