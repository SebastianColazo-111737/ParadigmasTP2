package edu.fiuba.algo3.modelo.carta.unidad.puntaje;

public class EfectoBoost implements Efecto{
    private int multiplicador;

    public EfectoBoost(int multiplicador){
        this.multiplicador = multiplicador;
    }

    @Override
    public int aplicar(int puntaje) {
        return puntaje * multiplicador;
    }

    @Override
    public Prioridad getPrioridad() {
        return Prioridad.BAJA;
    }
}
