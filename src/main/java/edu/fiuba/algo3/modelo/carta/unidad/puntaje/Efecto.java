package edu.fiuba.algo3.modelo.carta.unidad.puntaje;

public interface Efecto {

    enum Prioridad {
        ALTA,
        MEDIA,
        BAJA
    }
    Prioridad getPrioridad();

    int aplicar(int puntaje);
}
