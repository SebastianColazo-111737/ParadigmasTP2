package edu.fiuba.algo3.modelo.carta.unidad.modificadores;


import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Efecto;

import java.util.List;

public abstract class UnidadModificada implements Unidad {
    protected Unidad unidad;

    public UnidadModificada(Unidad unidad){
        this.unidad = unidad;
    }

    @Override
    public String getNombre(){
        return unidad.getNombre();
    }

    @Override
    public int getPuntajeActual(){ return unidad.getPuntajeActual();}
    @Override
    public void setPuntajeActual(int puntajeActual){unidad.setPuntajeActual(puntajeActual);}
    @Override
    public void resetearPuntaje(){ this.unidad.resetearPuntaje();}
    @Override
    public void calcularPuntaje(List<Unidad> unidades, List<Efecto> efectos) {
        unidad.calcularPuntaje(unidades, efectos);
    }


    @Override
    public boolean sePuedeColocar(Posicion posicion){
        return unidad.sePuedeColocar(posicion);
    }
    @Override
    public Atril atrilDestino(Jugador jugador, Jugador oponente) {
        return unidad.atrilDestino(jugador, oponente);
    }
    @Override
    public void realizarAccionAdicional(Jugador jugador, Jugador oponente){
        unidad.realizarAccionAdicional(jugador, oponente);
    }

}
