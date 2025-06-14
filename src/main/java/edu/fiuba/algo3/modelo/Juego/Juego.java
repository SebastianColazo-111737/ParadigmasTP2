package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.jugador.atril.*;
import edu.fiuba.algo3.modelo.posiciones.Posicion;


import java.util.ArrayList;
import java.util.HashMap;


public class Juego {

    private HashMap<Jugador, Atril> atriles;
    private AdminTurnos adminTurnos;

    public Juego(Jugador jugador1, Jugador jugador2){
        this.atriles = new HashMap<>();
        this.atriles.put(jugador1, new Atril());
        this.atriles.put(jugador2, new Atril());

        this.adminTurnos = new AdminTurnos(new ArrayList<>(this.atriles.keySet()));
    }

    public void repartirCartasALosJugadores(){
        for (Jugador jugador : this.atriles.keySet()) {
            jugador.robarCartas(10);
        }
    }

    public void setJugadorActual(Jugador jugador){
       this.adminTurnos.setJugadorActual(jugador);
    }

    public Jugador getJugadorActual(){
        return adminTurnos.getJugadorActual();
    }

    // ACCIONES DEL USUARIO EN EL TURNO

    public void pasarTurno(Jugador jugador){
        if(!this.adminTurnos.esSuTurno(jugador)){
            throw new JuegoExepcionJugadorJuegaFueraDeSuTurno();
        }
        this.adminTurnos.jugadorPasaTurno(jugador);
    }

    public void jugarCarta(Jugador jugador, ICarta cartaElegida, Posicion posiccionElegida){
        if(!this.adminTurnos.esSuTurno(jugador)){
            throw new JuegoExepcionJugadorJuegaFueraDeSuTurno();
        }

        // if(! posiccionElegida.esCompatible(cartaElegida.getPosiccion)) tambien lanza exepcion

        jugador.removerCartaDeLaMano(cartaElegida); //Supongo que en la app no podes jugar cartas que no estan ya en tu mano
        cartaElegida.jugarEnJuego(jugador, this, posiccionElegida); //le paso el juego y que la carta decida que hacer
    }

    // ----------------------------------------------------------------------------
    public void proximoTurno(){
        this.adminTurnos.proximoTurno();
        if(adminTurnos.terminoLaRonda()){
            // veo quien gano la ronda
            // registro la ronda
            // limpio los atriles --> las cartas van a sus pilas de descarte
            // si el juego no termino --> inicio otra ronda
            // si no termino el juego.
        }
    }

    public boolean terminoLaRonda(){
        return this.adminTurnos.terminoLaRonda();
    }

    public Atril getAtril(Jugador jugador){
        return this.atriles.get(jugador);
    }

    public int calcularPuntaje(Jugador jugador){
        return this.atriles.get(jugador).calcularPuntaje();
    }
}
