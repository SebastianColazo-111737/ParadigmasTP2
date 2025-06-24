package edu.fiuba.algo3.modelo.tablero.atril;

public class SeccionNoPermiteColocarUnidadesConPosicionIncompatible extends RuntimeException {
    public SeccionNoPermiteColocarUnidadesConPosicionIncompatible(String message) {
        super(message);
    }
}
