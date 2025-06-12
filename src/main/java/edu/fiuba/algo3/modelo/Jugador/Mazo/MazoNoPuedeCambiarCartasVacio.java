package edu.fiuba.algo3.modelo.Jugador.Mazo;

public class MazoNoPuedeCambiarCartasVacio extends RuntimeException {
    public MazoNoPuedeCambiarCartasVacio(String message) {
        super(message);
    }
}
