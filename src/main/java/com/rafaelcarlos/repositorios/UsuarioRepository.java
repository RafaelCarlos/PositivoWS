/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.repositorios;

import com.rafaelcarlos.positivo.model.Usuario;
import javax.persistence.EntityManager;

/**
 *
 * @author rafaellcarloss
 */
public class UsuarioRepository extends RepositorioGenerico<Integer, Usuario> {

    private RepositorioGenerico usuarioRepositorio;

    public UsuarioRepository() {
        super();
        this.usuarioRepositorio = new RepositorioGenerico(Usuario.class);
    }

    public UsuarioRepository(EntityManager em) {
        super(em);
    }

}
