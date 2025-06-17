package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Juego.Tablero.Atril;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public class General extends Unidad{

    public General(String nombre, int puntosBase, Posicion posicicon){
        super(nombre, puntosBase, posicicon);
    }

    @Override
    public int calcularPuntaje() {
        return this.puntosBase;
    }

    @Override
    public void jugarEnJuego(Jugador jugador, Juego juego, Posicion posicionElegida) {
        if(!sePuedeColocar(posicionElegida)){
            throw new RuntimeException();
        }
        Atril atril = juego.getAtril(jugador);
        atril.colocarUnidad(this, posicionElegida);
    }
}
