package edu.fiuba.algo3.clases;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mesa {
    private HashMap<Posicion,Seccion> secciones;

    public Mesa() {
        secciones = new HashMap<>();
        secciones.put(Posicion.CUERPO_A_CUERPO, new Seccion());
        secciones.put(Posicion.A_DISTANCIA, new Seccion());
        secciones.put(Posicion.ASEDIO, new Seccion());
    }

    public void colocarUnidad(Unidad unidad) {
        Seccion seccion = secciones.get(unidad.getPosicion());
        seccion.colocarUnidad(unidad);
    }

    public Seccion getSeccion(Posicion posicion){
        return secciones.get(posicion);
    }
}
