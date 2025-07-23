package edu.fiuba.algo3.vista.controlador;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.gwent.AdminturnosTodosPasaronDeTurno;
import edu.fiuba.algo3.modelo.gwent.Gwent;

import edu.fiuba.algo3.modelo.gwent.Resultado;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;

import java.util.List;

public class ControladorJuego {

    private Gwent juego;
    private Jugador jugador1;
    private Jugador jugador2;

    private MusicJuego musica;

    public ControladorJuego(MusicJuego musicJuego){

        try {
            this.juego = GeneradorDeGwent.construirGwent("src/main/resources/json/gwent3.json");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.jugador1 = this.juego.getJugadorActual();
        this.jugador2 = this.juego.getJugadorProximo();

        this.musica = musicJuego;
    }

    public Jugador getJugador1() {
        return jugador1;
    }
    public Jugador getJugador2() {
        return jugador2;
    }
    public Jugador getJugadorActual() {
        return this.juego.getJugadorActual();
    }
    public Jugador getProximoJugador() {
        return this.juego.getJugadorProximo();
    }


    public void repartirCartas(){
        this.juego.repartirCartasALosJugadores();
    }

    public void jugarCarta(Carta carta, Posicion posicion){
        this.juego.jugarCarta(carta, posicion);
        this.juego.proximoTurno();
    }

    public void pasarTurno(){
        try {
            this.juego.finalizarParticipacion();
            this.juego.proximoTurno();

        } catch (AdminturnosTodosPasaronDeTurno e) {
            System.out.println("todos pasaron de turno, termino la ronda");
        }
    }

    public boolean terminoLaRonda(){
        return this.juego.terminoLaRonda();
    }

    public void iniciarNuevaRonda(){
        this.juego.iniciarNuevaRonda();
    }

    public boolean terminoElJuego(){
        return this.juego.terminoElJuego();
    }

    public Jugador getGanador(){
        return this.juego.getGanador();
    }

    public int getRondasGanadas(Jugador jugador){
        int ganadas = 0;
        List<Resultado> marcadorPartido = this.juego.getResultados();
        for(Resultado ronda: marcadorPartido){
            if(ronda.getGanador().equals(jugador)){
                ganadas+=1;
            }
        }
        return ganadas;
    }

    public List<Resultado> getResultados(){
        return this.juego.getResultados();
    }
}