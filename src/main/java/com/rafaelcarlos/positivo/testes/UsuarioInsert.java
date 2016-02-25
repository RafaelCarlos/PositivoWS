/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.testes;

import com.rafaelcarlos.positivo.model.Usuario;
import com.rafaelcarlos.repositorios.UsuarioRepository;

/**
 *
 * @author rafaelcarlos
 */
public class UsuarioInsert {

    public static void main(String[] args) {
        insere();
    }

    public static void insere() {
        Usuario usuario = new Usuario("rafael@example.com", "senhafacil", null, "João", "Barros", true, Usuario.NomeTipoUsuario.USUARIO);

        boolean restulado = new UsuarioRepository().salvar(usuario);

        if (restulado) {
            System.out.println("Inserido com sucesso!");
            System.exit(0);
        } else {
            System.out.println("Não foi possível inserir.");
        }
    }
}
