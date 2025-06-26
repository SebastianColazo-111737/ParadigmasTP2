package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.*;
import java.util.ArrayList;
import java.util.List;

public class Gwent {
  private AdminTurnos<Jugador> adminTurnos;
  private List<Jugador> jugadores;

<<<<<<< interfaz-grafica
  public Gwent(Jugador jugador1, Jugador jugador2) {
    this.jugadores = new ArrayList<>();
    jugadores.add(jugador1);
    jugadores.add(jugador2);
=======
    // PRUEBA PARA INTERFAZ
    private int turno = 1;

    public Gwent(Jugador jugador1, Jugador jugador2){
        this.jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
>>>>>>> union-de-interfaces-forzada

    this.adminTurnos = new AdminTurnos<>(this.jugadores);
  }

<<<<<<< interfaz-grafica
  public void repartirCartasALosJugadores() {
    for (Jugador jugador : this.jugadores) {
      jugador.robarCartasDelMazo(10);
=======
    public List<Jugador> getJugadores(){
        return jugadores;
    }

    // PRUEBA PARA INTERFAZ USUARIO
    public Jugador jugadorActual() {
        return turno == 1 ? jugadores.get(0) : jugadores.get(1);
    }

    public void siguienteJugador() {
        turno++;
    }

    public boolean juegoCompleto() {
        return turno > 2;
    }

    public void repartirCartasALosJugadores(){
        for (Jugador jugador : this.jugadores) {
            jugador.robarCartasDelMazo(10);
        }
>>>>>>> union-de-interfaces-forzada
    }
  }

  public Jugador getJugadorActual() {
    return this.adminTurnos.getJugadorActual();
  }

  public Jugador getJugadorProximo() {
    return this.adminTurnos.getJugadorProximo();
  }

  public void setJugadorActual(Jugador jugador) {
    this.adminTurnos.setJugadorActual(jugador);
  }

  public void pasarTurno(){
    if(todosPasaron()){
      throw new AdminturnosTodosPasaronDeTurno("Todos los jugadores pasaron de turno");
    }
    adminTurnos.proximoTurno();
  }

  public void jugarCarta(ICarta carta, Posicion posicion) {
    Jugador jugador = adminTurnos.getJugadorActual();
    jugador.jugarCarta(carta, this.adminTurnos.getJugadorProximo(), posicion);
    // adminTurnos.proximoTurno();
  }

  public boolean finalizarParticipacion(){
    Jugador juego = adminTurnos.getJugadorActual();
    adminTurnos.jugadorPasaTurno(juego);

    boolean rondaTerminada = adminTurnos.todosPasaronTurno();
    if(!rondaTerminada) adminTurnos.proximoTurno();
    return rondaTerminada;
  }

  public boolean todosPasaron(){
    return adminTurnos.todosPasaronTurno();
  }

  public void reiniciarRonda(){
    adminTurnos.reiniciarAdminTurnos();
  }

}
