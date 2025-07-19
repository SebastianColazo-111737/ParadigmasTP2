package edu.fiuba.algo3.modelo.carta.unidad.puntaje;

public class EfectoDebilitar implements Efecto{

    @Override
    public int aplicar(int puntaje) {
        return 1;
    }

    @Override
    public Prioridad getPrioridad() {
        return Prioridad.ALTA;
    }
}
