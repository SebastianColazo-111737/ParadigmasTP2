package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;

import java.util.ArrayList;
import java.util.List;

public class Gwent {
    private AdminTurnos<Jugador> adminTurnos;
    private List<Jugador> jugadores;

    public Gwent(Jugador jugador1, Jugador jugador2){
        this.jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        this.adminTurnos = new AdminTurnos<>(this.jugadores);
    }

    public void repartirCartasALosJugadores(){
        for (Jugador jugador : this.jugadores) {
            jugador.robarCartasDelMazo(10);
        }
    }

    public Jugador getJugadorActual(){
        return this.adminTurnos.getJugadorActual();
    }

    public void setJugadorActual(Jugador jugador){
        this.adminTurnos.setJugadorActual(jugador);
    }

    public void pasarTurno(){
        Jugador jugador = adminTurnos.getJugadorActual();
        //adminTurnos.jugadorPasaTurno(jugador);
        adminTurnos.proximoTurno();
        /*
        if(adminTurnos.todosPasaronTurno()){
            //registro la ronda

            // si no termino la partida --> inicio una nueva
            // adminTurnos.reiniciarAdminTurnos();
        }else{
            adminTurnos.proximoTurno();
        }*/
    }

    public void jugarCarta(ICarta carta, Seccion seccion){
        Jugador jugador = adminTurnos.getJugadorActual();
        jugador.jugarCarta(carta, seccion);
        //adminTurnos.proximoTurno();
    }
}
