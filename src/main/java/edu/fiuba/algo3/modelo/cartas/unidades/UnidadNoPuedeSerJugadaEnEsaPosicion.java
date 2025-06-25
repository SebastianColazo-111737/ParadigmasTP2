package edu.fiuba.algo3.modelo.cartas.unidades;

public class UnidadNoPuedeSerJugadaEnEsaPosicion extends RuntimeException {
    public UnidadNoPuedeSerJugadaEnEsaPosicion(String message) {
        super(message);
    }
}
