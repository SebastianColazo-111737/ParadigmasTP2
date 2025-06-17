package edu.fiuba.algo3.modelo.cartas.unidades;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Juego.Tablero.Atril;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

public class Medico extends Unidad{
    private Unidad unidadParaRevivir;
    private Posicion posicionDeLaUnidadParaRevivir;

    public Medico(String nombre, int puntosBase, Posicion posicicon){
        super(nombre, puntosBase, posicicon);
        this.unidadParaRevivir = null;
        this.posicionDeLaUnidadParaRevivir = null;
    }

    public void setUnidadParaRevivir(Unidad unidad, Posicion posicionDeLaUnidad){
        this.unidadParaRevivir = unidad;
        this.posicionDeLaUnidadParaRevivir = posicionDeLaUnidad;
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
        juego.jugarCarta(jugador, this.unidadParaRevivir, this.posicionDeLaUnidadParaRevivir);
        Atril atril = juego.getAtril(jugador);
        atril.colocarUnidad(this, posicionElegida);
    }
}
