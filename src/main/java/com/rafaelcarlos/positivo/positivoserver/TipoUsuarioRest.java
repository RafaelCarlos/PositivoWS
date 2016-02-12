package com.rafaelcarlos.positivo.positivoserver;

import com.rafaelcarlos.positivo.model.TipoUsuario;
import com.rafaelcarlos.repositorios.TipoUsuarioRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
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
@Path("tipousuariows")
public class TipoUsuarioRest {

    @Context
    private UriInfo context;

    private TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioRest() {
        this.tipoUsuarioRepository = new TipoUsuarioRepository();
    }

    @GET
    @Produces("application/xml")
    public String getXml() {
        return "Olá";
    }

    @POST
    @Path("inserirtipousuario")
    public void inserirTipoUsuario(@PathParam("tipo") String nomeTipo) {

        TipoUsuario tipoUsuario = new TipoUsuario();

        tipoUsuario.setNomeTipo(nomeTipo);

        tipoUsuarioRepository.salvar(tipoUsuario);
    }

    @GET
    @Path("viaget")
    @Produces(MediaType.APPLICATION_XML)
    public TipoUsuario insert() {
        TipoUsuario tipoUsuario = new TipoUsuarioRepository().getPorId(1);
        return tipoUsuario;
    }

//    @GET
//    @Path("viagettodos")
//    @Produces(MediaType.APPLICATION_XML)
//    public List<TipoUsuario> pegaTodos() {
//        List<TipoUsuario> tipoUsuarios = new TipoUsuarioRepository().getList();
//
//        for (TipoUsuario tipoUsuario : tipoUsuarios) {
//            System.out.println("Tipos de Usuários: " + tipoUsuario.toString());
//        }
//        return tipoUsuarios;
//    }
    @GET
    @Path("qtd")
    @Produces(MediaType.APPLICATION_XML)
    public String qtdTipos() {
        Integer total = new TipoUsuarioRepository().count();

        System.out.println("Quantidades de Tipos de usuários: " + total);

        return total.toString();
    }

    @PUT
    @Path("atualizar")
    @Produces(MediaType.APPLICATION_XML)
    public void atualizarTipoUsuario(@PathParam("id") Integer id, TipoUsuario tipo) {

        TipoUsuario tipoUsuario = new TipoUsuarioRepository().getPorId(id);

        new TipoUsuarioRepository().atualizar(tipoUsuario);
    }

    @DELETE
    @Path("deletar")
    public void excluirTipoUsuario(@PathParam("id") Integer id) {
        TipoUsuario tipoUsuario = new TipoUsuarioRepository().getPorId(id);
        new TipoUsuarioRepository().excluir(tipoUsuario);

    }

    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {

    }
}
