package com.rafaelcarlos.positivo.service;

import com.rafaelcarlos.positivo.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author rafaellcarloss
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UsuarioService {

    private EntityManager em;

    public List<Usuario> getTodosUsuarios() {
        Query query = em.createQuery("SELECT usu Usuario usu");
        return query.getResultList();
    }
}
