package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.cartas.Especial;
import edu.fiuba.algo3.modelo.cartas.Unidad;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

import java.util.ArrayList;
import java.util.List;

public class Seccion {
    private Posicion posicion;
    private Jugador jugadorPropietario;
    private List<Unidad> unidadesColocadas;

    public Seccion(Posicion posicion, Jugador jugadorPropietario){
        this.posicion = posicion;
        this.jugadorPropietario = jugadorPropietario;
        this.unidadesColocadas = new ArrayList<>();
    }

    // SOLO PARA PASAR PRUEBA UNIDADTEST
    public List<Unidad> getUnidadesColocadas() {
        return unidadesColocadas;
    }

    public void agregarUnidad(Unidad unidad){

        /*
        REVISAR CHEQUEOS, YA NO PASAMOS jugadorActual
        */
        if (!unidad.compararPosicion(this.posicion)){
            // SE LANZA EXCEPCION
        }

        if (!unidad.sosInvasiva()) {  // es una unidad invasiva? Unidad carta1('jinElEspia',[new Espia()],true'esInvasiva')
            // SI NO ES INVASIVA
            // SE LANZA EXCEPCION
        }

        unidadesColocadas.add(unidad);
        unidad.activar(this);
    }

    public void recibirHechizo(Especial especial){
        especial.activar(this);
    }

    // LANZAR EXCEPCION SI NO HAY UNIDADES
    public void eliminarUnidadMasFuerte(){
        Unidad unidadMasFuerte = unidadesColocadas.get(0);
        int indiceMasFuerte = 0;

        for (int i = 1; i < unidadesColocadas.size(); i++) {
            if (unidadMasFuerte.compararPoder(unidadesColocadas.get(i))) {
                unidadMasFuerte = unidadesColocadas.get(i);
                indiceMasFuerte = i;
            }
        }

        unidadesColocadas.remove(indiceMasFuerte);

        // EL JUGADOR QUE RECIBIO EL ATAQUE DEBE ENVIAR SU CARTA A SU DESCARTE
        jugadorPropietario.enviarAlDescarte(unidadMasFuerte);
    }

    public List<Unidad> unidadesIguales(String nombreUnidad){
        List<Unidad> unidadesIguales = new ArrayList<>();
        for(Unidad unidad: unidadesColocadas){
            if(unidad.getNombre() == nombreUnidad){
                unidadesIguales.add(unidad);
            }
        }
        return unidadesIguales;
    }

    public void duplicarPuntos(){
        for(Unidad unidad: unidadesColocadas){
            unidad.setPuntosEspeciales(unidad.getPuntosBase()*2);
        }
    }

    public void igualarPuntos(int puntosParaTodaUnidad){
        for(Unidad unidad: unidadesColocadas){
            unidad.setPuntosEspeciales(puntosParaTodaUnidad);
        }
    }

    public void puntosExtra(int puntosExtras){
        for(Unidad unidad: unidadesColocadas){
            unidad.setPuntosBase(unidad.getPuntosBase() + puntosExtras);
        }
    }

    public int obtenerPuntosTotales(){
        int puntosTotales = 0;
        for(Unidad unidad: unidadesColocadas){
            if(!(unidad.getPuntosEspeciales() == 0)){  // si es != 0 significa que hay clima activado
                puntosTotales += unidad.getPuntosEspeciales();
            } else {
                puntosTotales += unidad.getPuntosBase();
            }
        }
        return puntosTotales;
    }
}
