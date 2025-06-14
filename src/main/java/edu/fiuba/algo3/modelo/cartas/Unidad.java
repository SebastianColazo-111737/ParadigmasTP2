package edu.fiuba.algo3.modelo.cartas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Atril;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public class Unidad implements ICarta {
    private String nombre;
    private int puntosBase; //puede ser una clase
    private Posicion posicion;

    public Unidad(String nombre, int puntosBase, Posicion posicicon){
        this.nombre = nombre;
        this.puntosBase = puntosBase;
        this.posicion = posicicon;
    }


    @Override
    public void jugarEnJuego(Jugador jugador, Juego juego, Posicion posicionElegida) {
        Atril atril = juego.getAtril(jugador);
        atril.colocarUnidad(this, posicionElegida);
    }

    public int calcularPuntaje(){
        return puntosBase;
    }
}
