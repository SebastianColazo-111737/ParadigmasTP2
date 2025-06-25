package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.tablero.Atril;

public class UnidadBasica implements Unidad {
    private String nombre;
    private Puntaje puntaje;
    private Posicion posicionValida;

    public UnidadBasica(String nombre, Puntaje puntaje, Posicion posicionValida) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.posicionValida = posicionValida;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean sePuedeColocar(Posicion posicion){
        return posicionValida.esCompatible(posicion);
    }

    @Override
    public Atril atrilDestino(Jugador jugador, Tablero tablero) {
        return tablero.getAtril(jugador);
    }

    @Override
    public void realizarAccionAdicional(Jugador jugador, Tablero tablero) {
        // no hace nada
    }
}
