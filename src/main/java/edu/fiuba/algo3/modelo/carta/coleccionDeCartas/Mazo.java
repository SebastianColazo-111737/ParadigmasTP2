package edu.fiuba.algo3.modelo.carta.coleccionDeCartas;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mazo extends ColeccionDeCartas{
    private Random random;

    public Mazo(){
        super();
        this.random = new Random();
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

}
