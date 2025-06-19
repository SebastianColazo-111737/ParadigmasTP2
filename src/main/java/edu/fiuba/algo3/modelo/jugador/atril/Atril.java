package edu.fiuba.algo3.modelo.jugador.atril;



import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.posiciones.*;

import java.util.ArrayList;
import java.util.List;

public class Atril {
    private List<Seccion> secciones;
    private List<ICarta> descate;

    public Atril(){
        this.secciones = new ArrayList<>();
        this.descate = new ArrayList<>();
    }

    public void agregarSeccion(Seccion seccion){
        secciones.add(seccion);
    }

    public List<Seccion> getSecciones(){
        return this.secciones;
    }

    public boolean contiene(Seccion seccion){
        return this.secciones.contains(seccion);
    }
//    public int calcularPuntaje(){
//        int total = 0;
//        for(Seccion seccino: secciones){
//            total += seccino.calcularPuntaje();
//        }
//        return total;
//    }

//    public void descartarCartas() {
//        for (Seccion seccion : secciones) {
//            List<ICarta> cartas = seccion.removerCartasJugadas();
//            this.descate.addAll(cartas);
//        }
//    }
}
