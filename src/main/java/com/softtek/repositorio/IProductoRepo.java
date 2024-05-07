package com.softtek.repositorio;


import com.softtek.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepo extends IGenericoRepo<Producto,Integer> {


}