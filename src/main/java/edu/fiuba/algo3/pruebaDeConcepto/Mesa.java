package edu.fiuba.algo3.pruebaDeConcepto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mesa {
    private HashMap<Posicion, Seccion> secciones;
    private int puntaje;
    private List<Unidad> pilaDeDescarte;

    public Mesa() {
        secciones = new HashMap<>();
        for (Posicion posicion : Posicion.values()) {
            secciones.put(posicion, new Seccion());
        }
        pilaDeDescarte = new ArrayList<>();
    }

    public void colocarUnidad(Unidad unidad){
        Seccion seccion = secciones.get(unidad.getPosicion());
        seccion.colocarUnidad(unidad);
    }

    public int calcularPuntaje(){
        int total = 0;
        for (Seccion seccion : this.secciones.values()) {
            total += seccion.calcularPuntaje();
        }
        return total;
    }
}
