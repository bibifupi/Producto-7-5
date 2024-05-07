package com.softtek.servicio;

import com.softtek.modelo.Lugar;
import com.softtek.repositorio.IGenericoRepo;
import com.softtek.repositorio.ILugarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LugarServicio extends CRUDImpl<Lugar, Integer> implements ILugarServicio{
    @Autowired
    private ILugarRepo lugarRepositorio;
    @Override
    protected IGenericoRepo<Lugar, Integer> getRepo() {return lugarRepositorio;}


}
