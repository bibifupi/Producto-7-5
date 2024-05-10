

package com.softtek.controlador;

import com.softtek.dto.ProductoDTO;
import com.softtek.excepciones.ExcepcionPersonalizadaNoEncontrado;
import com.softtek.modelo.Producto;
import com.softtek.servicio.IProductoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")


public class ControladorProducto {

    @Autowired
    private IProductoServicio servicio;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> obtenerTodos(){
        List<Producto> productosBBDD = servicio.consultarTodos();
        List<ProductoDTO> productosDTO = new ArrayList<>();
        for (Producto elemento:
                productosBBDD) {
            ProductoDTO eDto = new ProductoDTO();
            productosDTO.add(eDto.castProductoADTO(elemento));
        }
        return new ResponseEntity<>(productosDTO,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerId(@PathVariable(name="id") Integer id) {
        Producto p1 = servicio.consultarUno(id);
        if(p1 == null){
            throw new ExcepcionPersonalizadaNoEncontrado("PRODUCTO NO ENCONTRADO " + id);
        }
        return new ResponseEntity<>((new ProductoDTO()).castProductoADTO(p1),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> insertarProducto(@Valid @RequestBody ProductoDTO p) {
        Producto p1 = p.castProducto();
        p1 = servicio.crear(p1);
        return new ResponseEntity<>(p.castProductoADTO(p1), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductoDTO> actualizarProducto(@Valid @RequestBody ProductoDTO p) {
        Producto p1 = servicio.consultarUno(p.getIdProducto());
        if(p1 == null){
            throw new ExcepcionPersonalizadaNoEncontrado("PRODUCTO NO ENCONTRADO " + p.getIdProducto());
        }
        p1 = servicio.modificar(p.castProducto());
        return new ResponseEntity<>(p.castProductoADTO(p1), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarProducto(@PathVariable(name="id") Integer id){
        Producto p1 = servicio.consultarUno(id);
        if(p1 == null){
            throw new ExcepcionPersonalizadaNoEncontrado("PRODUCTO NO ENCONTRADO " + id);
        }
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

