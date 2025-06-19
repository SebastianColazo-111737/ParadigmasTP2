package edu.fiuba.algo3.modelo.cartas.especiales;

import edu.fiuba.algo3.modelo.cartas.Especial;
import edu.fiuba.algo3.modelo.jugador.Seccion;

import java.util.List;

public class Nieve extends Especial {
    private List<Seccion> secciones;
    private int puntosEnClima;

    public Nieve(List<Seccion> seccionesAfectadas, int puntosEnClima){
        this.secciones = seccionesAfectadas;
        this.puntosEnClima = puntosEnClima;
    }

    @Override
    public void activar(Seccion seccion) {
        for(Seccion seccionCargada: secciones){
            seccionCargada.igualarPuntos(puntosEnClima);
        }
    }
}
