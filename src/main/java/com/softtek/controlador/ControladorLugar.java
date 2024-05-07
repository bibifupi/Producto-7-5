

package com.softtek.controlador;

import com.softtek.modelo.Lugar;
import com.softtek.servicio.ILugarServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/lugares")
@CrossOrigin(origins = "http://localhost:4200")


public class ControladorLugar{

@Autowired
    private ILugarServicio servicio;

    @GetMapping
    public List<Lugar> obtenerTodos() throws SQLException, ClassNotFoundException {

        return servicio.consultarTodos();
    }

    @GetMapping("/{id}")
    public Lugar obtenerId(@PathVariable int id) throws SQLException, ClassNotFoundException {
        return servicio.consultarUno(id);
    }

    @PostMapping
    public void insertarLugar(@RequestBody Lugar producto) throws SQLException, ClassNotFoundException {
        servicio.crear(producto);
    }

    @PutMapping
    public void actualizarLugar(@RequestBody Lugar lugares) throws SQLException, ClassNotFoundException {
        servicio.modificar(lugares);
    }

    @DeleteMapping("/{id}")
    public void borrarLugar(@PathVariable int id) throws SQLException, ClassNotFoundException {
        servicio.eliminar(id);
    }


}

