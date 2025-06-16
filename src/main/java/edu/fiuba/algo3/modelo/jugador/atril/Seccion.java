package edu.fiuba.algo3.modelo.jugador.atril;

import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.cartas.Unidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;

import java.util.ArrayList;
import java.util.List;

public class Seccion {
    private Posicion posicion;
    //private List<Unidad> unidadesColocadas;
    private Jugador jugadorPropietario;
    private List<Carta> cartasJugadas;

//    public Seccion(Posicion posiccion){
//        this.posicion = posiccion;
//        this.unidadesColocadas = new ArrayList<>();
//    }
//
//    public Boolean puedeColocarse(Posicion posicion){
//        return this.posicion.esCompatible(posicion);
//    }
//
//    public void colocarUnidad(Unidad unidad){
//            unidadesColocadas.add(unidad);
//    }
//
//    public List<Carta> obtenerCartasJugadas(){
//        return this.cartasJugadas;
//    }
//
//    public int calcularPuntaje(){
//        int total = 0;
//        for(Unidad unidad: unidadesColocadas){
//            total+= unidad.calcularPuntaje();
//        }
//        return total;
//    }
//
//    public List<ICarta> removerCartasJugadas(){
//        List<ICarta> descartadas = new ArrayList<>();
//        while (!unidadesColocadas.isEmpty()) {
//            descartadas.add(unidadesColocadas.remove(0));
//        }
//        return descartadas;
//    }

    public void agregarCarta(Carta cartaUsuario, Jugador jugadorActual){
        if (!cartaUsuario.compararPosicion(this.posicion)){
            //lanzar excpecionCartaIncompatible
        }
        if (!jugadorPropietario.equals(jugadorActual)) {
            if (!cartaUsuario.esDeMapa()){
                // lanzar excepcionSeccionNoPermitida
            }
        }
        cartasJugadas.add(cartaUsuario);
    }

    public Jugador obtenerPropietario(){
        return this.jugadorPropietario;
    }
}
