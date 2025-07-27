package edu.fiuba.algo3.vista.controlador;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.gwent.AdminturnosTodosPasaronDeTurno;
import edu.fiuba.algo3.modelo.gwent.Gwent;

import edu.fiuba.algo3.modelo.gwent.Resultado;
import edu.fiuba.algo3.modelo.gwent.reglaDeCierre.NoSePudoDefinirUnGanadorError;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.vista.pantallas.PantallaCambiarCartas;

import java.util.List;
import java.util.Random;

public class ControladorJuego {

    private Gwent juego;
    private Jugador jugador1;
    private Jugador jugador2;


    public ControladorJuego(){

        try {
            this.juego = GeneradorDeGwent.construirGwent("src/main/resources/json/gwent3.json");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.jugador1 = this.juego.getJugadorActual();
        this.jugador2 = this.juego.getJugadorProximo();
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


    public void iniciarJuego(){
        this.juego.repartirCartasALosJugadores(10);

        Random random = new Random();
        Jugador moneda = random.nextBoolean()? jugador1: jugador2;
        this.juego.setJugadorActual(moneda);

        new PantallaCambiarCartas(jugador1, jugador2);
    }

    public void jugarCarta(Carta carta, Posicion posicion){
        this.juego.jugarCarta(carta, posicion);
    }

    public void finalizarParticipacion(){
        this.juego.finalizarParticipacion();
    }

    public void proximoTurno(){
        if(!terminoLaRonda()){
            this.juego.proximoTurno();
            if(!juego.getJugadorActual().puedeSeguirJugando()){
                finalizarParticipacion();
                proximoTurno();
            }
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
            if(ronda.empato()) continue;
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