package com.softtek.repositorio;

import com.softtek.modelo.Lugar;
import com.softtek.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILugarRepo extends IGenericoRepo<Lugar,Integer> {
}
