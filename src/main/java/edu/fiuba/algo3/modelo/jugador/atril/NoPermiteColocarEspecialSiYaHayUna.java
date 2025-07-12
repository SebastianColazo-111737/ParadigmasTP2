package edu.fiuba.algo3.modelo.jugador.atril;

public class NoPermiteColocarEspecialSiYaHayUna extends RuntimeException {

    public NoPermiteColocarEspecialSiYaHayUna(String message) {
        super(message);
    }
}
