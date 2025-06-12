package edu.fiuba.algo3.modelo.Posicion;

public class CuerpoACuerpo implements IPosicion {
    @Override
    public boolean esCompatible(IPosicion posicion) {
        return posicion instanceof CuerpoACuerpo;
    }
}
