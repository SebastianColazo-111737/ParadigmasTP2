package edu.fiuba.algo3.modelo.jugador.atril;



import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.cartas.ICarta;


import java.util.ArrayList;
import java.util.List;

public class Atril {
    private List<Seccion> secciones;
    private List<ICarta> descarte;

    public Atril(){
        this.secciones = new ArrayList<>();
        this.descarte = new ArrayList<>();
    }

    public void agregarSeccion(Seccion seccion){
        secciones.add(seccion);
    }

    public List<Seccion> getSecciones(){
        return this.secciones;
    }

    public List<ICarta> getDescarte(){
        return this.descarte;
    }

    public boolean contiene(Seccion seccion){
        return this.secciones.contains(seccion);
    }

    public int getPuntajeActual(){
        int puntajeActual = 0;
        for(Seccion seccion: secciones){
            puntajeActual += seccion.getPuntajeActual();
        }
        return puntajeActual;
    }

    public void descartarCartas() {
        for (Seccion seccion : secciones) {
            List<Unidad> cartas = seccion.removerCartasJugadas();
            this.descarte.addAll(cartas);
        }
    }
}
