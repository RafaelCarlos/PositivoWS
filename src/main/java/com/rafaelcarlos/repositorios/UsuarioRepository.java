package com.rafaelcarlos.repositorios;

import com.rafaelcarlos.positivo.model.Usuario;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author rafaellcarloss
 */
public class UsuarioRepository extends RepositorioGenerico<Integer, Usuario> implements Serializable {

    private static final long serialVersionUID = 1L;

    public UsuarioRepository() {
        super(Usuario.class);

    }

    public UsuarioRepository(EntityManager em) {
        super(em);
    }

    public Usuario porTipoUsuario(String nomeTipo) {

        String jpql = "select u from Usuario u, TipoUsuario t where t.nome_tipo like ? "
                + "and u.tipo_usuario_id.id = t.id";

        return findOne(jpql, nomeTipo);
    }
}
