package edu.fiuba.algo3.modelo.carta.Especial;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.*;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.EfectoDebilitar;

import java.util.ArrayList;
import java.util.List;

public class ClimaSoleado implements Carta {
    private String nombre;
    private List<Posicion> posicionAfectada;
    private EfectoDebilitar efectoPararemover;

    public ClimaSoleado(String nombre, List<Posicion> posicionAfectada){
        this.nombre = nombre;
        this.efectoPararemover = new EfectoDebilitar();

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

        for(Posicion posicion: this.posicionAfectada){
            atrilJugador.removerEfecto(this.efectoPararemover, posicion);
            atrilOponente.removerEfecto(this.efectoPararemover, posicion);
        }
    }


}
