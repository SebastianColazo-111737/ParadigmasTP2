package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.cartas.Carta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.modelo.tablero.Tablero;


import java.util.ArrayList;
import java.util.List;

public class Gwent {
    private AdminTurnos<Jugador> adminTurnos;
    private List<Jugador> jugadores;
    private Tablero tablero;

    public Gwent(Jugador jugador1, Jugador jugador2, Tablero tablero){
        this.jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        this.adminTurnos = new AdminTurnos<>(this.jugadores);

        this.tablero = tablero;
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
        adminTurnos.jugadorPasaTurno(jugador);
        if(adminTurnos.todosPasaronTurno()){
            //registro la ronda

            // si no termino la partida --> inicio una nueva
            // adminTurnos.reiniciarAdminTurnos();
        }else{
            adminTurnos.proximoTurno();
        }

    }

    public void jugarCarta(Carta carta, Posicion posicion){
        Jugador jugador = adminTurnos.getJugadorActual();

        // puede lanzar exepcion si el jugador no tiene la carta en la mano
        jugador.removerCartaDeLaMano(carta);

        // puede lanzar exepciones
        carta.jugarCarta(jugador, tablero, posicion);


        adminTurnos.proximoTurno();
    }
}
