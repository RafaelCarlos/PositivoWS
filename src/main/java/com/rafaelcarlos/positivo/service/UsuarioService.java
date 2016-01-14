package com.rafaelcarlos.positivo.service;

import com.rafaelcarlos.positivo.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author rafaellcarloss
 */
public class UsuarioService implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager em;

    public List<Usuario> getTodosUsuarios() {
        Query query = em.createQuery("SELECT usu Usuario usu");
        return query.getResultList();
    }
}
