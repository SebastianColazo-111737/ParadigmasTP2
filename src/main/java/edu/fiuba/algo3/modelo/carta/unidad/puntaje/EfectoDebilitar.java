package edu.fiuba.algo3.modelo.carta.unidad.puntaje;

public class EfectoDebilitar implements Efecto{

    @Override
    public void aplicar(Puntaje puntaje) {
        int nuevoPuntaje = 1;
        puntaje.setPuntajeActual(nuevoPuntaje);
    }
}
