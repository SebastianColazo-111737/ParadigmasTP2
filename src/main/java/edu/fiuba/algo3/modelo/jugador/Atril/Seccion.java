package edu.fiuba.algo3.modelo.jugador.Atril;

import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.posicion.Posicion;


import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Efecto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Seccion {
    private Posicion posicion;
    private List<Unidad> unidadesColocadas;
    private List<Efecto> efectosEnLaSeccion;

    public Seccion(Posicion posiccion){
        this.posicion = posiccion;
        this.unidadesColocadas = new ArrayList<>();
        this.efectosEnLaSeccion = new ArrayList<>();
    }

    public Posicion getPosicion(){return this.posicion;}

    public void colocarUnidad(Unidad nuevaUnidad){
        if(!nuevaUnidad.sePuedeColocar(posicion)){
            throw new SeccionNoPermiteColocarUnidadesConPosicionIncompatible("");
        }

        unidadesColocadas.add(nuevaUnidad);
        actualizarPuntajeUnidades();
    }

    public void agregarEfecto(Efecto nuevoEfecto){
        efectosEnLaSeccion.add(nuevoEfecto);
        efectosEnLaSeccion.sort(Comparator.comparing(Efecto::getPrioridad));
        actualizarPuntajeUnidades();
    }

    public void removerEfecto(Efecto tipoDeEfecto){
        efectosEnLaSeccion.removeIf(efecto -> tipoDeEfecto.getClass().isInstance(efecto));
        actualizarPuntajeUnidades();
    }

    private void actualizarPuntajeUnidades(){
        for (Unidad unidadActual : this.unidadesColocadas) {
            unidadActual.calcularPuntaje(this.unidadesColocadas, this.efectosEnLaSeccion);
        }
    }

    public List<Unidad> descartarUnidadesJugadas(){
        List<Unidad> descartadas = new ArrayList<>(unidadesColocadas);
        this.unidadesColocadas.clear();
        return descartadas;
    }

    public void limpiarEfectos(){
        this.efectosEnLaSeccion.clear();
    }

    public List<Unidad> getUnidadesColocadas(){
        return this.unidadesColocadas;
    }

    public void removerUnidadesIguales(List<Unidad> descartar){
        this.unidadesColocadas.removeAll(descartar);
    }

    public int getPuntaje(){
        int puntajeSeccion = 0;
        if(this.unidadesColocadas.isEmpty()){
            return puntajeSeccion;
        }else{
            for(Unidad unidad: this.unidadesColocadas){
                Puntaje puntajeUnidad = unidad.getPuntaje();
                puntajeSeccion += puntajeUnidad.getPuntajeActual();
            }
            return puntajeSeccion;
        }
    }
}
