package edu.fiuba.algo3.modelo.cartas.unidades.modificadores;
import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadDecoradora;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadNoPuedeSerJugadaEnEsaPosicion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.modelo.tablero.Tablero;


public class Agil extends UnidadDecoradora {
    private Posicion posicionExtra;

    public Agil(Unidad unidadOriginal, Posicion posicionExtra) {
        super(unidadOriginal);
        this.posicionExtra = posicionExtra;
    }

    @Override
    public boolean sePuedeColocar(Posicion posicion){
        return super.unidad.sePuedeColocar(posicion) || posicionExtra.esCompatible(posicion);
    }
}
