package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.juego.Puntaje;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.tablero.atril.Atril;
import edu.fiuba.algo3.modelo.tablero.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

import java.util.List;

public class Medico extends Unidad{

    private Unidad unidadParaRevivir;
    private Posicion posicionParaColocarUnidad;

    public Medico(String nombre, Puntaje puntaje, Posicion posicion){
        super(nombre,puntaje,posicion);
        this.unidadParaRevivir = null;
        this.posicionParaColocarUnidad = null;
    }

    public void setUnidadParaRevivir(Unidad unidad,Posicion posicionParaColocarUnidad ){
        this.unidadParaRevivir = unidad;
        this.posicionParaColocarUnidad = posicionParaColocarUnidad;
    }


    @Override
    public void calcularPuntajeActual(List<Unidad> unidades) {

    }

    @Override
    public void jugarCarta(Jugador jugador, Tablero tablero, Posicion posicion){
        if(!this.sePuedeColocar(posicion)){
            throw new RuntimeException();
        }
        Atril atrilJugador = tablero.getAtril(jugador);
        atrilJugador.colocarUnidad(this, posicion);

        if(this.unidadParaRevivir != null){
            // puedo agregar un metodo a jugador para que saque la carta de la pila de descarte
            // y luego la juegue como jugador.revivirCarta(ICarta)
            jugador.agregarCartaALaMano(unidadParaRevivir);
            jugador.jugarCarta(unidadParaRevivir, tablero, posicionParaColocarUnidad);
        }
    }
}
