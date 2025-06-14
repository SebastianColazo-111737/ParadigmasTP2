package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.cartas.ICarta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mazo {

    private List<ICarta> cartas;
    private Random random;

    public Mazo(){
        this.cartas = new ArrayList<>();
        this.random = new Random();
    }

    public void agregarCartas(List<ICarta> cartas){
        this.cartas.addAll(cartas);
    }

    public List<ICarta> darCartas(int cantidad){
        List<ICarta> cartasParaDar = new ArrayList<>();
        for (int i = 0; i < cantidad && !this.cartas.isEmpty(); i++) {
            cartasParaDar.add(agarrarCartaAleatoria());
        }
        return cartasParaDar;
    }

    private ICarta agarrarCartaAleatoria(){
        int indiceAleatorio = this.random.nextInt(this.cartas.size());
        return this.cartas.remove(indiceAleatorio);
    }

    public int getCantidadCartas(){
        return this.cartas.size();
    }
}
