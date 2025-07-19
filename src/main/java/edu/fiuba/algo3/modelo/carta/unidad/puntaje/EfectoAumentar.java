package edu.fiuba.algo3.modelo.carta.unidad.puntaje;

public class EfectoAumentar implements Efecto{
    private int aumento;

    public EfectoAumentar(int aumento){
        this.aumento = aumento;
    }

    @Override
    public int aplicar(int puntaje) {
        return (puntaje + this.aumento);
    }

    @Override
    public Prioridad getPrioridad() {
        return Prioridad.MEDIA;
    }
}
