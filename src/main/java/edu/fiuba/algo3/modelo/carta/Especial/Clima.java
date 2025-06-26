package edu.fiuba.algo3.modelo.carta.Especial;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.EfectoDebilitar;

public class Clima implements Carta {
    private String nombre;
    private EfectoDebilitar efecto;
    private Posicion posicionAfectada;

    public Clima(String nombre, Posicion posicionAfectada){
        this.nombre = nombre;
        this.efecto = new EfectoDebilitar();
        this.posicionAfectada = posicionAfectada;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void jugarCarta(Jugador jugador, Jugador oponente, Posicion posicionElegida) {
        Atril atrilJugador = jugador.getAtril();
        Atril atrilOponente = oponente.getAtril();

        atrilJugador.agregarEfecto(this.efecto , this.posicionAfectada);
        atrilOponente.agregarEfecto(this.efecto, this.posicionAfectada);
    }

}
