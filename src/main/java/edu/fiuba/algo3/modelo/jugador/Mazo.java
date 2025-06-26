package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mazo {
    private List<Carta> cartas;
    private Random random;

    public Mazo(){
        this.cartas = new ArrayList<>();
        this.random = new Random();
    }

    public void agregarCarta(Carta carta){
        this.cartas.add(carta);
    }
    public void agregarCarta(List<Carta> cartas){
        this.cartas.addAll(cartas);
    }


    private Carta agarrarCartaAleatoria(){
        int indiceAleatorio = this.random.nextInt(this.cartas.size());
        return this.cartas.remove(indiceAleatorio);
    }

    public List<Carta> darCartas(int cantidad){
        List<Carta> cartasParaDar = new ArrayList<>();
        for (int i = 0; i < cantidad && !this.cartas.isEmpty(); i++) {
            cartasParaDar.add(agarrarCartaAleatoria());
        }
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
}
