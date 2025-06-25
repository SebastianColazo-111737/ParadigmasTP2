package edu.fiuba.algo3.modelo.cartas.unidades;

public class UnidadNoPuedeSerJugadaPorEseJugadorEnEsaSeccion extends RuntimeException {
    public UnidadNoPuedeSerJugadaPorEseJugadorEnEsaSeccion(String message) {
        super(message);
    }
}
