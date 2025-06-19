package edu.fiuba.algo3.modelo.cartas.especiales;

import edu.fiuba.algo3.modelo.cartas.Especial;
import edu.fiuba.algo3.modelo.jugador.Seccion;

import java.util.List;

public class TierraArrasada extends Especial {
    private List<Seccion> tablero;

    public TierraArrasada(List<Seccion> seccionesAfectadas){
        this.tablero = seccionesAfectadas;
    }

    @Override
    public void activar(Seccion seccion) {
        for (Seccion seccionCargada: tablero){
            seccionCargada.eliminarUnidadMasFuerte();
        }
    }
}
