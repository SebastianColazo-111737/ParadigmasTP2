package edu.fiuba.algo3.modelo.gwent;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.gwent.adminRondas.AdminRondas;
import edu.fiuba.algo3.modelo.gwent.adminRondas.Ronda;
import edu.fiuba.algo3.modelo.gwent.adminRondas.adminTurnos.AdminTurnos;
import edu.fiuba.algo3.modelo.gwent.adminRondas.reglaDeCierre.MejorDe3;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gwent {
//    private List<Jugador> jugadores;
//
//    private AdminRondas adminRondas;
//
//    public Gwent(Jugador jugador1, Jugador jugador2){
//        this.jugadores = new ArrayList<>();
//        jugadores.add(jugador1);
//        jugadores.add(jugador2);
//
//        // fase inicial (falta que puedan cambiar cartas)
//        repartirCartasALosJugadores();
//        AdminTurnos<Jugador> adminTurnos = new AdminTurnos<>(this.jugadores);
//        adminTurnos.setJugadorActual(tirarMoneda());
//
//        this.adminRondas = new AdminRondas(this.jugadores, adminTurnos, new MejorDe3());
//    }
//
//    private void repartirCartasALosJugadores(){
//        for (Jugador jugador : this.jugadores) {
//            jugador.robarCartasDelMazo(10);
//        }
//    }
//
//    private Jugador tirarMoneda(){
//        Random random = new Random();
//        return random.nextBoolean()? jugadores.get(0): jugadores.get(1);
//    }
//
//
//
//
//    public void pasarTurno(){
//        this.adminRondas.pasarTurno(); // se hace un pasa manos bastante largo
//        // no se si vale la pena hacer ese paso manos
//        // solo para el mecanismo de las rondas y turnos
//
//        // juego --> adminRondas ---> rondaActual ---> adminturnos
//        //                                         <-- jugador actual
//        //                            hace la jugada
//        //                             proximo turno --->
//        //                             termino?    --->
//        //                                          <--- si
//        //                  termino -->
//        //                         <--- si
//        //             registra ronda
//        //             y le pregunta a
//        //             ReglaDeCierre
//        //             si termino el juego
//        //             Si le dice que no
//        //             crea una nueva ronda
//
//        //if(adminRondas.terminoElJuego())
//    }
//
//    public void jugarCarta(Carta carta, Posicion posicion){
//        this.adminRondas.jugarCarta(carta, posicion);
//    }
}
