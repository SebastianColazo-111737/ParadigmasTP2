package edu.fiuba.algo3.modelo.jugador.Atril;

import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Efecto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Atril {
    private HashMap<Posicion, Seccion> secciones;
    private Descarte descarte;


    public Atril(){
        this.secciones = new HashMap<>();
        this.descarte = new Descarte();
    }

    public void agregarSeccion(Seccion seccion){
        Posicion posicionDeLaSeccion = seccion.getPosicion();
        secciones.put(posicionDeLaSeccion, seccion);
    }

    public void colocarUnidad(Unidad unidad, Posicion posicion){

        Seccion seccion = secciones.get(posicion);
        seccion.colocarUnidad(unidad);
    }

    public void agregarEfecto(Efecto efecto, Posicion posicion){
        Seccion seccion = secciones.get(posicion);
        seccion.agregarEfecto(efecto);
    }

    public void removerEfecto(Efecto tipoDeEfecto, Posicion posicion){
        Seccion seccion = secciones.get(posicion);
        seccion.removerEfecto(tipoDeEfecto);
    }

    public void removerUnidadesConPuntaje(int puntaje){
        List<Unidad> descartadas = new ArrayList<>();
        for (Seccion seccion : this.secciones.values()) {
            descartadas.addAll(seccion.descartarUnidadesConPuntaje(puntaje));
        }
        this.descarte.descartarUnidad(descartadas);
    }

    public void descartarUnidadesJugadas() {
        for (Seccion seccion : this.secciones.values()) {
            descarte.descartarUnidad(seccion.removerUnidadesJugadas());
            seccion.limpiarEfectos();
        }
    }

    public List<Unidad> getUnidadesColocadas(){
        List<Unidad> unidades = new ArrayList<>();
        for (Seccion seccion : this.secciones.values()) {
            unidades.addAll(seccion.getUnidadesColocadas());
        }
        return unidades;
    }

    public int getPuntajeActual(){
        int puntajeActual = 0;
        for (Seccion seccion : this.secciones.values()) {
            puntajeActual+= seccion.getPuntaje();
        }
        return puntajeActual;
    }

}
