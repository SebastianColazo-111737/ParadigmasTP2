package edu.fiuba.algo3.modelo.gwent;


import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.gwent.reglaDeCierre.MejorDe3;
import edu.fiuba.algo3.modelo.gwent.reglaDeCierre.ReglaDeCierre;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;

import java.util.ArrayList;
import java.util.List;

public class Gwent {

    private List<Jugador> jugadores;
    private AdminTurnos<Jugador> adminTurnos;

    private List<Resultado> resultados;
    private ReglaDeCierre reglaDeCierre;

    public Gwent(Jugador jugador1, Jugador jugador2) {
        this.jugadores = new ArrayList<>();
        this.jugadores.add(jugador1);
        this.jugadores.add(jugador2);

        this.adminTurnos = new AdminTurnos<>(this.jugadores);

        this.resultados = new ArrayList<>();
        this.reglaDeCierre = new MejorDe3();
    }

    public Jugador getJugadorActual() {
        return this.adminTurnos.getJugadorActual();
    }
    public Jugador getJugadorProximo() {return this.adminTurnos.getJugadorProximo();}
    public void setJugadorActual(Jugador jugador) {
        this.adminTurnos.setJugadorActual(jugador);
    }


    public Boolean terminoLaRonda(){
        return this.adminTurnos.todosPasaronTurno();
    }

    public void iniciarNuevaRonda(){
        this.adminTurnos.reiniciarAdminTurnos();
        for (Jugador jugador : this.jugadores) {
            jugador.getAtril().descartarUnidadesJugadas();
        }
    }

    public Boolean terminoElJuego(){return reglaDeCierre.terminoElJuego(this.resultados);}

    public Jugador getGanador(){return reglaDeCierre.getGanador();}
    public List<Resultado> getResultados(){
        return this.resultados;
    }


    public void repartirCartasALosJugadores(int cantidad) {
        for (Jugador jugador : this.jugadores) {
            jugador.robarCartasDelMazo(cantidad);
        }
    }


    public void jugarCarta(Carta carta, Posicion posicion) {
        if(terminoLaRonda()){
            throw new GwentAccionInvalidaRondaTerminadaError("La ronda ya termino, no se puede seguir jugando");
        }
        Jugador jugador = getJugadorActual();
        Jugador oponente = getJugadorProximo();

        jugador.jugarCarta(carta, oponente, posicion);
    }

    public void finalizarParticipacion(){
        if(terminoLaRonda()){
            throw new GwentAccionInvalidaRondaTerminadaError("La ronda ya termino, no se puede seguir jugando");
        }
        Jugador jugador = getJugadorActual();
        adminTurnos.jugadorPasaTurno(jugador);

        if(terminoLaRonda()){
            this.resultados.add(new Resultado(jugadores.get(0), jugadores.get(1)));
        }
    }

    public void proximoTurno(){
        if(terminoLaRonda()){
            throw new AdminturnosTodosPasaronDeTurno("Todos los jugadores pasaron de turno");
        }
        adminTurnos.proximoTurno();
    }
}
