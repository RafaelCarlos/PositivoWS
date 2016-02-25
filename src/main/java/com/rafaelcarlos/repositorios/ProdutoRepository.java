package com.rafaelcarlos.repositorios;

import com.rafaelcarlos.positivo.model.Produto;
import java.io.Serializable;

/**
 *
 * @author rafaelcarlos
 */
public class ProdutoRepository extends RepositorioGenerico<Integer, Produto> implements Serializable {
    
    private RepositorioGenerico produtoRepositorioGenerico;
    
    public ProdutoRepository() {
        super(Produto.class);
        
        this.produtoRepositorioGenerico = new RepositorioGenerico(Produto.class);
    }
    
}
