package edu.fiuba.algo3.modelo.jugador.Atril;

import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.posicion.Posicion;


import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Efecto;

import java.util.ArrayList;
import java.util.List;

public class Seccion {
    private Posicion posicion;
    private List<Unidad> unidadesColocadas;
    private List<Efecto> efectosEnLaSeccion;

    public Seccion(Posicion posiccion){
        this.posicion = posiccion;
        this.unidadesColocadas = new ArrayList<Unidad>();
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
        actualizarPuntajeUnidades();
    }

    public void removerEfecto(Efecto tipoDeEfecto){
        efectosEnLaSeccion.removeIf(efecto -> tipoDeEfecto.getClass().isInstance(efecto));
        actualizarPuntajeUnidades();
    }

    private void actualizarPuntajeUnidades(){

        for (Unidad unidadColocada: this.unidadesColocadas){
            unidadColocada.resetearPuntaje();
        }

        for (Unidad unidadActual : this.unidadesColocadas) {
            List<Unidad> otrasUnidades = filtrarUnidad(unidadActual, this.unidadesColocadas);
            unidadActual.calcularPuntaje(otrasUnidades, this.efectosEnLaSeccion);
        }
    }

    private List<Unidad> filtrarUnidad(Unidad unidad, List<Unidad> unidades){
        List<Unidad> listaFiltrada = new ArrayList<>(unidades);
        listaFiltrada.remove(unidad);
        return listaFiltrada;
    }

    public List<Unidad> removerUnidadesJugadas(){
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

    public List<Unidad> descartarUnidadesConPuntaje(int puntaje){
        List<Unidad> descarte = new ArrayList<>();
        for(Unidad unidad: this.unidadesColocadas){
            if(unidad.getPuntajeActual() == puntaje){
                descarte.add(unidad);
            }
        }
        this.unidadesColocadas.removeAll(descarte);
        return descarte;
    }

    public int getPuntaje(){
        int puntaje = 0;
        if(this.unidadesColocadas.isEmpty()){
            return puntaje;
        }else{
            for(Unidad unidad: this.unidadesColocadas){
                puntaje += unidad.getPuntajeActual();
            }
            return puntaje;
        }
    }
}
