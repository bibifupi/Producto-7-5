package com.softtek.controlador;

import com.softtek.dto.ViviendaDTO;
import com.softtek.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.softtek.modelo.Vivienda;
import com.softtek.servicio.IViviendaServicio;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/viviendas")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorVivienda {
    private IViviendaServicio servicio;

    @GetMapping
    public ResponseEntity<List<ViviendaDTO>> obtenerTodos(){
        List<Vivienda> viviendasBBDD = servicio.consultarTodos();
        List<ViviendaDTO> viviendasDTO = new ArrayList<>();
        for (Vivienda elemento:
                viviendasBBDD) {
            ViviendaDTO eDto = new ViviendaDTO();
            viviendasDTO.add(eDto.castViviendaDTO(elemento));
        }
        return new ResponseEntity<>(viviendasDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViviendaDTO> obtenerId(@PathVariable(name="id") Integer id) {
        Vivienda v1 = servicio.consultarUno(id);
        if(v1 == null){
            throw new ExcepcionPersonalizadaNoEncontrado("VIVIENDA NO ENCONTRADA " + id);
        }
        return new ResponseEntity<>((new ViviendaDTO()).castViviendaDTO(v1),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ViviendaDTO> insertarVivienda(@Valid @RequestBody ViviendaDTO v) {
        Vivienda v1 = v.castVivienda();
        v1 = servicio.crear(v1);
        return new ResponseEntity<>(v.castViviendaDTO(v1), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ViviendaDTO> actualizarVivienda(@Valid @RequestBody ViviendaDTO v) {
        Vivienda v1 = servicio.consultarUno(v.getIdVivienda());
        if(v1 == null){
            throw new ExcepcionPersonalizadaNoEncontrado("VIVIENDA NO ENCONTRADA " + v.getIdVivienda());
        }
        v1 = servicio.modificar(v.castVivienda());
        return new ResponseEntity<>(v.castViviendaDTO(v1), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarVivienda(@PathVariable(name="id") Integer id){
        Vivienda v1 = servicio.consultarUno(id);
        if(v1 == null){
            throw new ExcepcionPersonalizadaNoEncontrado("VIVIENDA NO ENCONTRADA " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
