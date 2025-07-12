package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.cartas.ICarta;

import java.util.ArrayList;
import java.util.List;


public class Mano {
    private List<ICarta> cartas;
    private List<Runnable> observadores = new ArrayList<>();

    public Mano(){
        this.cartas = new ArrayList<>();
    }

    public void agregarCarta(ICarta carta){
        this.cartas.add(carta);

    }
    public void agregarCarta(List<ICarta> cartas){
        this.cartas.addAll(cartas);
        notificarObservadores();
    }

    public List<ICarta> getCartas(){
        return this.cartas;
    }

    public int getCantidadCartas(){
        return this.cartas.size();
    }

    public void removerCarta(ICarta carta){
        if(!this.cartas.contains(carta)){
            throw new ManoNoContieneCartaException(
                    "La mano no puede remover una carta que no contiene"
            );
        }
        this.cartas.remove(carta);
        notificarObservadores();
    }

    public void agregarObservador(Runnable observador) {
        this.observadores.add(observador);
    }

    private void notificarObservadores() {
        for (Runnable obs : observadores) {
            obs.run();
        }
    }
}
