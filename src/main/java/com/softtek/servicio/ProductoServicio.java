
package com.softtek.servicio;

import com.softtek.modelo.Producto;
import com.softtek.repositorio.IGenericoRepo;
import com.softtek.repositorio.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductoServicio extends CRUDImpl<Producto, Integer> implements IProductoServicio{
    @Autowired
    private IProductoRepo productoRepositorio;
    @Override
    protected IGenericoRepo<Producto, Integer> getRepo() {return productoRepositorio;}

}

