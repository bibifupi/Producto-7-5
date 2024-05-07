package com.softtek.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    @Column (length = 60, nullable = false)
    private String nombreProducto;
    @Column (length = 60, nullable = false)
    private double precioUnitario;
    @Column (length = 60, nullable = false)
    private int unidadesStock;
    @Column (length = 60, nullable = false)
    private int categoria;
}
