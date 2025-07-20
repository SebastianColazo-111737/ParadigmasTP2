package edu.fiuba.algo3.modelo.carta.coleccionDeCartas;

import edu.fiuba.algo3.modelo.Observer.Observador;
import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<Carta> cartas;
    private List<Observador> observadores;

    public Mano(){
        this.cartas = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    public void agregarCarta(Carta carta){
        this.cartas.add(carta);
        notificarObservadores();
    }

    public void agregarCarta(List<Carta> cartas) {
        this.cartas.addAll(cartas);
        notificarObservadores();
    }

    public void removerCarta(Carta carta){
        if(!this.cartas.contains(carta)){
            throw new ManoNoContieneCartaException(
                    "La mano no puede remover una carta que no contiene"
            );
        }
        this.cartas.remove(carta);
        notificarObservadores();
    }

    public List<Carta> getCartas(){
        return this.cartas;
    }
    public int getCantidadCartas(){
        return this.cartas.size();
    }


    public void agregarObservador(Observador observador) {
        this.observadores.add(observador);
    }

    private void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.notificar();
        }
    }

}
