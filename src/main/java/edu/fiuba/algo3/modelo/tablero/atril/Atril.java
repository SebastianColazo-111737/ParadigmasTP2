package edu.fiuba.algo3.modelo.tablero.atril;



import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.posiciones.Posicion;


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

    public void colocarUnidad(Unidad unidad, Posicion posicion){
        for(Seccion seccion: secciones){
            if(seccion.puedeColocarse(posicion)){
                seccion.colocarUnidad(unidad);
            }
        }
    }

    public void activarClima(Posicion posicion){
        for(Seccion seccion: secciones){
            if(seccion.puedeColocarse(posicion)){
                seccion.activarClima();
            }
        }
    }

    public void activarMoraleBoost(Posicion posicion){
        for(Seccion seccion: secciones){
            if(seccion.puedeColocarse(posicion)){
                seccion.activarMoraleBoost();
            }
        }
    }

    public int getPuntajeActual(){
        int puntajeActual = 0;
        for(Seccion seccino: secciones){
            puntajeActual += seccino.getPuntajeActual();
        }
        return puntajeActual;
    }

    public void descartarCartas() {
        for (Seccion seccion : secciones) {
            List<Unidad> cartas = seccion.removerUnidadesJugadas();
            this.descarte.addAll(cartas);
        }
    }
}
