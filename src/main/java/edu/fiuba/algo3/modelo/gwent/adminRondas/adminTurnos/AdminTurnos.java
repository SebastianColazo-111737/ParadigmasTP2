package edu.fiuba.algo3.modelo.gwent.adminRondas.adminTurnos;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class AdminTurnos<T> {
    private List<T> jugadores;
    private int indiceJugadorActual;
    private HashMap<T, Boolean> pasoDeTurno;

    public AdminTurnos(List<T> jugadores){
        this.jugadores = jugadores;
        this.pasoDeTurno = new HashMap<>();

        inicializarAdminTurnos();
    }

    private void inicializarAdminTurnos(){
        for(T jugador: jugadores){
            this.pasoDeTurno.put(jugador, false);
        }
        this.indiceJugadorActual = 0;
    }

    public T getJugadorActual(){
        return this.jugadores.get(indiceJugadorActual);
    }

    public void setJugadorActual(T jugador){
        this.indiceJugadorActual = jugadores.indexOf(jugador);
    }

    public boolean esSuTurno(T jugador){
        return this.jugadores.get(indiceJugadorActual).equals(jugador);
    }

    public void jugadorPasaTurno(T jugador){
        this.pasoDeTurno.put(jugador, true);
    }

    public boolean todosPasaronTurno(){
        Collection<Boolean> pasoDeTurno = this.pasoDeTurno.values();
        for(boolean pasoTurno: pasoDeTurno){
            if(!pasoTurno){
                return false;
            }
        }
        return  true;
    }

    public void proximoTurno(){
        if(todosPasaronTurno()){
            throw new AdminturnosTodosPasaronDeTurno("Todos los jugadores pasaron de turno");
        }

        int cantidadDeJugadores = jugadores.size();
        T siguiente;
        do {
            this.indiceJugadorActual = (this.indiceJugadorActual + 1) % cantidadDeJugadores;
            siguiente = jugadores.get(indiceJugadorActual);
        } while (pasoDeTurno.get(siguiente));
    }

    public void reiniciarAdminTurnos(){
        inicializarAdminTurnos();
    }

}
