/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelcarlos.repositorios;

import com.rafaelcarlos.positivo.model.Produto;

/**
 *
 * @author rafaelcarlos
 */
public class ProdutoRepository extends RepositorioGenerico<Integer, Produto> {

    public ProdutoRepository() {
        super(Produto.class);
    }

}
