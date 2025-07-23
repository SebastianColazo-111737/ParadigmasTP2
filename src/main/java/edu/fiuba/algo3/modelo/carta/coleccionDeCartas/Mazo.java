package edu.fiuba.algo3.modelo.carta.coleccionDeCartas;

import edu.fiuba.algo3.modelo.Observer.Observador;
import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mazo {
    private List<Carta> cartas;
    private Random random;
    private List<Observador> observadores;

    public Mazo(){
        this.cartas = new ArrayList<>();
        this.random = new Random();
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


    private Carta agarrarCartaAleatoria(){
        int indiceAleatorio = this.random.nextInt(this.cartas.size());
        Carta cartaParaDar = this.cartas.remove(indiceAleatorio);
        notificarObservadores();
        return cartaParaDar;
    }
    public List<Carta> darCartas(int cantidad){
        List<Carta> cartasParaDar = new ArrayList<>();
        for (int i = 0; i < cantidad && !this.cartas.isEmpty(); i++) {
            cartasParaDar.add(agarrarCartaAleatoria());
        }
        notificarObservadores();
        return cartasParaDar;
    }

    public Carta cambiarCarta(Carta carta){
        Carta cartaDelMazo = agarrarCartaAleatoria();
        agregarCarta(carta);
        return cartaDelMazo;
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
