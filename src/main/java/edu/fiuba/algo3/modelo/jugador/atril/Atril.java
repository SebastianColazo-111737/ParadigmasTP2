package edu.fiuba.algo3.modelo.jugador.atril;


import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.Unidad;
import edu.fiuba.algo3.modelo.posiciones.*;

import java.util.ArrayList;
import java.util.List;

public class Atril {
    private List<Seccion> secciones;
    private List<ICarta> descate; //puede o no estar aca

    public Atril(){
        this.secciones = new ArrayList<>();
        this.secciones.add(new Seccion(new CuerpoACuerpo()));
        this.secciones.add(new Seccion(new Distancia()));
        this.secciones.add(new Seccion(new Asedio()));

        this.descate = new ArrayList<>();
    }

    public void colocarUnidad(Unidad unidad, Posicion posicion){
        Seccion seccion = getSeccion(posicion);
        seccion.colocarUnidad(unidad);
    }

    public Seccion getSeccion(Posicion posicion){
        for(Seccion seccion: secciones){
            if(seccion.puedeColocarse(posicion)){
                return seccion;
            }
        }
        return null; // deberia lanzar una exepcion o algo
    }

    public int calcularPuntaje(){
        int total = 0;
        for(Seccion seccino: secciones){
            total += seccino.calcularPuntaje();
        }
        return total;
    }

    public void descartarCartas() {
        for (Seccion seccion : secciones) {
            List<ICarta> cartas = seccion.removerCartasJugadas();
            this.descate.addAll(cartas);
        }
    }

    public List<ICarta> getDescarte(){
        return this.descate;
    }
}
