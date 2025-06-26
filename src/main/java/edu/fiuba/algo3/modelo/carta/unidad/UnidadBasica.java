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
    public int getPuntajeActual(){ return this.puntaje.getPuntajeActual();}
    @Override
    public void setPuntajeActual(int puntajeActual){this.puntaje.setPuntajeActual(puntajeActual);}
    @Override
    public void resetearPuntaje(){ this.puntaje.resetearPuntaje();}

    @Override
    public void calcularPuntaje(List<Unidad> otrasUnidades, List<Efecto> efectos) {
        for(Efecto efecto: efectos){
            efecto.aplicar(this.puntaje);
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
    public void realizarAccionAdicional(Jugador jugador, Jugador oponente){
        return;
    }

}
