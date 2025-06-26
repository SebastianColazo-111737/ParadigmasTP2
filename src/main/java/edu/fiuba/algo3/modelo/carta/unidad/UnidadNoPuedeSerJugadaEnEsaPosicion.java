package edu.fiuba.algo3.modelo.carta.unidad;

public class UnidadNoPuedeSerJugadaEnEsaPosicion extends RuntimeException {
    public UnidadNoPuedeSerJugadaEnEsaPosicion(String message) {
        super(message);
    }
}
