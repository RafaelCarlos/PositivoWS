/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.positivo.positivoserver;

import com.rafaelcarlos.positivo.model.Usuario;
import com.rafaelcarlos.repositorios.UsuarioRepository;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author rafaellcarloss
 */
@Path("usuario")
public class UsuarioRest {

    @Context
    private UriInfo context;

    private UsuarioRepository usuarioRepository;
    private Usuario usuario;

    /**
     * Creates a new instance of UsuarioRest
     */
    public UsuarioRest() {
        usuarioRepository = new UsuarioRepository();
        usuario = new Usuario();
    }

    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        return "Usuario";
    }

    @POST
    @Path("{id}")
    @Produces("application/xml")
    public Usuario porId(@PathParam("id") Integer id) {
        return usuarioRepository.getPorId(id);
    }

    @POST
    @Path("inserir")
    @Produces(MediaType.APPLICATION_JSON)
    public void inserir(@PathParam("email") String email,
            @PathParam("senha") String senha,
            @PathParam("id_facebook") String idFacebook,
            @PathParam("nome") String nome,
            @PathParam("sobre_nome") String sobreNome) {

        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setIdFacebook(idFacebook);
        usuario.setNome(nome);
        usuario.setSobrenome(sobreNome);
        usuario.setAtivo(true);
        usuario.setNomeTipoUsuario(Usuario.NomeTipoUsuario.USUARIO);

        usuarioRepository.salvar(usuario);

//        for (Usuario usu : usuarioRepository.porSobrenome("Oliveira")) {
//
//            System.out.println("Usuarios com sobrenome Oliveira: " + usu);
//            return (List<Usuario>) usu;
//        }
//        return usuarioRepository.porSobrenome("Oliveira");
    }

    @PUT
    @Path("atualizar")
    public void atualizar(@PathParam("id") Usuario usuario) {
        this.usuarioRepository.atualizar(usuario);
    }

    @DELETE
    @Path("excluir")
    public void excluir(@PathParam("id") Usuario usuario) {
        this.usuarioRepository.excluir(usuario);
    }

}
