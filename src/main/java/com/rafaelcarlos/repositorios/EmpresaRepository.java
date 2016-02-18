package com.rafaelcarlos.repositorios;

import com.rafaelcarlos.positivo.model.Empresa;

/**
 *
 * @author rafaelcarlos
 */
public class EmpresaRepository extends RepositorioGenerico<Integer, Empresa> {
    
    public EmpresaRepository() {
        super(Empresa.class);
    }
    
}
