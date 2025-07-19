package edu.fiuba.algo3.modelo.carta.unidad;


import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Efecto;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;

import java.util.List;

public class UnidadBasica implements Unidad {
    private String nombre;
    private Puntaje puntaje;
    private Posicion posicionValida;

    public UnidadBasica(String nombre, Puntaje puntaje, Posicion posicionValida) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.posicionValida = posicionValida;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Puntaje getPuntaje(){ return this.puntaje;}

    @Override
    public void calcularPuntaje(List<Unidad> otrasUnidades, List<Efecto> efectos) {
        puntaje.resetearPuntaje();

        for(Efecto efecto: efectos){
            puntaje.aplicarEfecto(efecto);
        }
    }

    @Override
    public boolean sePuedeColocar(Posicion posicion){
        return posicionValida.esCompatible(posicion);
    }

    @Override
    public Atril atrilDestino(Jugador jugador, Jugador oponente){
        return jugador.getAtril();
    }

    @Override
    public void realizarAccionAdicional(Jugador jugador, Jugador oponente,
            Atril atril, Posicion posicionElegida){
        //La unidad Basica no realiza una accion adicional
        return;
    }

}
