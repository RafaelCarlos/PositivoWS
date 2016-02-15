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
import javax.ws.rs.Consumes;
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

    /**
     * Creates a new instance of UsuarioRest
     */
    public UsuarioRest() {
    }

    /**
     * Retrieves representation of an instance of
     * com.rafaelcarlos.positivo.positivoserver.UsuarioRest
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        return "Usuario";
    }
    
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
    
    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Usuario porId(@PathParam("id") Integer id) {
        return usuarioRepository.getPorId(id);
    }
    
    @POST
    @Path("inserir")
    public void inserir() {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setEmail("email@example.com");
        usuario.setSenha("123");
        usuario.setIdFacebook("12ds");
        
        usuario.setNome("Rafal Carlos");
        usuario.setSobrenome("Oliveira");
        usuario.setSenha("123");
        usuario.setAtivo(true);
        usuario.setTipoUsuario(Usuario.NomeTipoUsuario.SUPORTE);
        
        new UsuarioRepository().salvar(usuario);
        
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
