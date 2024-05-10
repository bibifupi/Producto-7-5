package com.softtek.dto;

import com.softtek.modelo.Producto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductoDTO {
    private int idProducto;
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nombreProducto;
    @NotNull
    private double precioUnitario;
    @NotNull
    private int unidadesStock;
    @NotNull
    private int categoria;

    public Producto castProducto() {
        Producto p1 = new Producto();
        p1.setIdProducto(this.idProducto);
        p1.setNombreProducto(this.nombreProducto);
        p1.setPrecioUnitario(this.precioUnitario);
        p1.setUnidadesStock(this.unidadesStock);
        p1.setCategoria(this.categoria);
        return p1;
    }

    public ProductoDTO castProductoADTO(Producto p) {
        idProducto = p.getIdProducto();
        nombreProducto = p.getNombreProducto();
        precioUnitario = p.getPrecioUnitario();
        unidadesStock = p.getUnidadesStock();
        categoria = p.getCategoria();
        return this;
    }

}
