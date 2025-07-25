package edu.fiuba.algo3.modelo.carta.coleccionDeCartas;

import edu.fiuba.algo3.modelo.Observer.Observable;
import edu.fiuba.algo3.modelo.Observer.Observador;
import edu.fiuba.algo3.modelo.carta.Carta;
import java.util.ArrayList;
import java.util.List;

public abstract class ColeccionDeCartas implements Observable {
    protected List<Carta> cartas;
    protected List<Observador> observadores;

    public ColeccionDeCartas(){
        this.cartas = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    public void agregarCarta(Carta carta){
        this.cartas.add(carta);
        notificarObservadores();

    }
    public void agregarCarta(List<Carta> cartas){
        this.cartas.addAll(cartas);
        notificarObservadores();

    }

    public List<Carta> getCartas(){
        return this.cartas;
    }

    public int getCantidadCartas(){
        return this.cartas.size();
    }

    @Override
    public void agregarObservador(Observador observador) {
        this.observadores.add(observador);
    }

    @Override
    public void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.notificar();
        }
    }
}
