package edu.fiuba.algo3.clases.Posicion;

public class Distancia implements IPosicion{
    @Override
    public boolean esCompatible(IPosicion posicion) {
        return posicion instanceof Distancia;
    }
}
