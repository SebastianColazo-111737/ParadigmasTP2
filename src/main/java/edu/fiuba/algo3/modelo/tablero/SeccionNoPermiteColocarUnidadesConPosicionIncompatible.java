package edu.fiuba.algo3.modelo.tablero;

public class SeccionNoPermiteColocarUnidadesConPosicionIncompatible extends RuntimeException {
    public SeccionNoPermiteColocarUnidadesConPosicionIncompatible(String message) {
        super(message);
    }
}
