package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Juego.Tablero.Atril;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public class Espia extends Unidad{

    public Espia(String nombre, int puntosBase, Posicion posicicon){
        super(nombre, puntosBase, posicicon);
    }

    @Override
    public int calcularPuntaje() {
        return this.puntosBase;
    }

    @Override
    public void jugarEnJuego(Jugador jugador, Juego juego, Posicion posicionElegida) {
        jugador.robarCartas(2);
        Jugador oponente = juego.getOponente(jugador);
        Atril atril = juego.getAtril(oponente);
        atril.colocarUnidad(this, posicionElegida);
    }
}
