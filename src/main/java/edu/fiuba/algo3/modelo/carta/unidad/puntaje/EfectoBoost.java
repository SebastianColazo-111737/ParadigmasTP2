package edu.fiuba.algo3.modelo.carta.unidad.puntaje;

public class EfectoBoost implements Efecto{
    private int multiplicador;

    public EfectoBoost(int multiplicador){
        this.multiplicador = multiplicador;
    }

    @Override
    public void aplicar(Puntaje puntaje) {
        int nuevoPuntaje = puntaje.getPuntajeActual() * multiplicador;
        puntaje.setPuntajeActual(nuevoPuntaje);
    }
}
