package com.softtek.servicio;


import com.softtek.modelo.Vivienda;
import com.softtek.repositorio.IGenericoRepo;
import com.softtek.repositorio.IViviendaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViviendaServicio extends CRUDImpl<Vivienda, Integer> implements IViviendaServicio{
    @Autowired
    private IViviendaRepo viviendaRepositorio;
    @Override
    protected IGenericoRepo<Vivienda, Integer> getRepo() {return viviendaRepositorio;}

}
