package edu.fiuba.algo3.modelo.cartas.refactor;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;

public class Unidad implements ICarta {
    private String nombre;
    private EstrategiaColocarUnidad estrategiaColocar;
    //private EstrategiaCalcularPuntaje estrategiaPuntaje;


    @Override
    public void jugarCarta(Jugador jugador, Seccion seccion) {
        this.estrategiaColocar.colocarUnidad(this, jugador, seccion);
    }

}
