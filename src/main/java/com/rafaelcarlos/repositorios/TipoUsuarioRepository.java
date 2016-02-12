package com.rafaelcarlos.repositorios;

import com.rafaelcarlos.positivo.model.TipoUsuario;
import javax.persistence.EntityManager;

/**
 *
 * @author rafaelcarlos
 */
public class TipoUsuarioRepository extends RepositorioGenerico<Integer, TipoUsuario> {

    private RepositorioGenerico tipoUsuarioRepository;

    public TipoUsuarioRepository() {
        super(TipoUsuario.class);
        this.tipoUsuarioRepository = new RepositorioGenerico(TipoUsuario.class);
    }

}
