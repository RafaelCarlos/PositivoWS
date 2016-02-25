package com.rafaelcarlos.repositorios;

import com.rafaelcarlos.positivo.model.Usuario;
import java.io.Serializable;
import java.util.List;
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

    public List<Usuario> porTipoUsuario(String nomeTipo) {

        String jpql = "SELECT u FROM Usuario u WHERE u.nomeTipo like ? ";

        return find(jpql, nomeTipo);
    }

    public List<Usuario> porSobrenome(String sobrenome) {

        String jpql = "SELECT u FROM Usuario u WHERE u.sobrenome like ? ";

        return find(jpql, sobrenome);
    }
}
