package com.softtek.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="viviendas")
public class Vivienda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVivienda;
    @Column(length = 60, nullable = false)
    private int tamano;
    @Column (length = 60, nullable = false)
    private int nHabitaciones;
    @Column (length = 60, nullable = false)
    private int piso;
    @Column (length = 60, nullable = false)
    private boolean gasNatural;
}
