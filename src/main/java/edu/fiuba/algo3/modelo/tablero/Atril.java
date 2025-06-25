package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.posiciones.Posicion;


import java.util.ArrayList;
import java.util.List;

public class Atril {
    private List<Seccion> secciones;
//    private List<Carta> descarte;

    public Atril(){
        this.secciones = new ArrayList<>();
    }

    public void agregarSeccion(Seccion seccion){
        secciones.add(seccion);
    }

    public List<Seccion> getSecciones(){
        return this.secciones;
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

    public List<Carta> removerCartasJugadas() {
        List<Carta> cartasDescartadas = new ArrayList<>();
        for (Seccion seccion : secciones) {
            cartasDescartadas.addAll(seccion.removerUnidadesJugadas());
        }
        return cartasDescartadas;
    }
}
