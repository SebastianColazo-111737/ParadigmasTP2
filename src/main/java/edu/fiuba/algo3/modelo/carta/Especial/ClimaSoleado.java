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
    private List<Posicion> posicionesAfectadas;

    public ClimaSoleado(String nombre, List<Posicion> posicionesAfectadas){
        this.nombre = nombre;
        this.posicionesAfectadas = posicionesAfectadas;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void jugarCarta(Jugador jugador, Jugador oponente, Posicion posicionElegida) {
        Atril atrilJugador = jugador.getAtril();
        Atril atrilOponente = oponente.getAtril();

        for(Posicion posicion: this.posicionesAfectadas){
            atrilJugador.removerEfecto(new EfectoDebilitar(), posicion);
            atrilOponente.removerEfecto(new EfectoDebilitar(), posicion);
        }
    }


}
