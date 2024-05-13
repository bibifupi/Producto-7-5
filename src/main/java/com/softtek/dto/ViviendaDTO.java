package com.softtek.dto;
import com.softtek.modelo.Vivienda;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ViviendaDTO {
    private int idVivienda;
    @NotNull
    private int tamano;
    @NotNull
    private int nHabitaciones;
    @NotNull
    private int piso;
    @NotNull
    private boolean gasNatural;

    public Vivienda castVivienda() {
        Vivienda v1 = new Vivienda();
        v1.setIdVivienda(this.idVivienda);
        v1.setTamano(this.tamano);
        v1.setNHabitaciones(this.nHabitaciones);
        v1.setPiso(this.piso);
        v1.setGasNatural(this.gasNatural);
        return v1;
    }

    public ViviendaDTO castViviendaDTO(Vivienda v) {
        idVivienda = v.getIdVivienda();
        tamano = v.getTamano();
        nHabitaciones = v.getNHabitaciones();
        piso = v.getPiso();
        gasNatural = v.isGasNatural();
        return this;
    }
}
