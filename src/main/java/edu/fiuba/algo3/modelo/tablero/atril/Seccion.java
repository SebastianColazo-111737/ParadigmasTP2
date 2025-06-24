package edu.fiuba.algo3.modelo.tablero.atril;

import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.juego.Puntaje;
import edu.fiuba.algo3.modelo.posiciones.Posicion;


import java.util.ArrayList;
import java.util.List;

public class Seccion {
    private Posicion posicion;
    private List<Unidad> unidadesColocadas;

    private boolean afectadoPorClima;
    private boolean afectadoPorMoraleBoost;

    private Puntaje puntajeSeccion;
    private final static int puntajeBaseSeccion = 0;

    public Seccion(Posicion posiccion){
        this.posicion = posiccion;
        this.unidadesColocadas = new ArrayList<Unidad>();

        this.puntajeSeccion = new Puntaje(puntajeBaseSeccion);

        this.afectadoPorClima = false;
        this.afectadoPorMoraleBoost = false;
    }

    public void activarClima(){
        this.afectadoPorClima = true;
    }

    public void activarMoraleBoost(){
        this.afectadoPorMoraleBoost = true;
    }




    public void colocarUnidad(Unidad unidad){
        if(!unidad.sePuedeColocar(posicion)){
            throw new SeccionNoPermiteColocarUnidadesConPosicionIncompatible("");
        }
        unidadesColocadas.add(unidad);
        actualizarPuntajes();
    }

    public Boolean puedeColocarse(Posicion posicion){
        return this.posicion.esCompatible(posicion);
    }

    private void actualizarPuntajes(){
        for (Unidad unidadColocada: unidadesColocadas){
            if(afectadoPorClima){
                unidadColocada.getPuntaje().setPuntajeActual(1);
            }
            unidadColocada.calcularPuntajeActual(this.unidadesColocadas);

            if(afectadoPorMoraleBoost){
                unidadColocada.getPuntaje().multiplicarPuntaje(2);
            }
        }
    }

    public void removerUnidad(Unidad unidad){
        unidadesColocadas.remove(unidad);
    }

    public List<Unidad> removerUnidadesJugadas(){
        List<Unidad> descartadas = new ArrayList<Unidad>();
        while (!unidadesColocadas.isEmpty()) {
            descartadas.add(unidadesColocadas.remove(0));
        }
        return descartadas;
    }

    public List<Unidad> getUnidadesColocadas(){
        return this.unidadesColocadas;
    }

    public int getPuntajeActual(){
        return this.puntajeSeccion.getPuntajeActual();
    }

}
