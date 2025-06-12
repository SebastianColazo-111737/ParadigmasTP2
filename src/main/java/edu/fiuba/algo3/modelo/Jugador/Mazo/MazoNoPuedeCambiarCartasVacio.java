package edu.fiuba.algo3.clases.Mazo;

public class MazoNoPuedeCambiarCartasVacio extends RuntimeException {
    public MazoNoPuedeCambiarCartasVacio(String message) {
        super(message);
    }
}
