package edu.fiuba.algo3.modelo.jugador;



import edu.fiuba.algo3.modelo.cartas.ICarta;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mazo {
    private List<ICarta> cartas;
    private Random random;
    private List<Runnable> observadores = new ArrayList<>();

    public Mazo(){
        this.cartas = new ArrayList<>();
        this.random = new Random();
    }

    public void agregarCarta(ICarta carta){
        this.cartas.add(carta);
    }
    public void agregarCarta(List<ICarta> cartas){
        this.cartas.addAll(cartas);
    }

    public void agregarObservador(Runnable obs) {
        this.observadores.add(obs);
    }

    private void notificar() {
        for (Runnable obs : observadores) {
            obs.run();
        }
    }

    public List<ICarta> darCartas(int cantidad){
        List<ICarta> cartasParaDar = new ArrayList<>();
        for (int i = 0; i < cantidad && !this.cartas.isEmpty(); i++) {
            cartasParaDar.add(agarrarCartaAleatoria());
        }
        notificar();
        return cartasParaDar;
    }

    private ICarta agarrarCartaAleatoria(){
        int indiceAleatorio = this.random.nextInt(this.cartas.size());
        return this.cartas.remove(indiceAleatorio);
    }

    public ICarta cambiarCarta(ICarta carta){
        ICarta cartaDelMazo = agarrarCartaAleatoria();
        agregarCarta(carta);
        return cartaDelMazo;
    }

    public int getCantidadCartas(){
        return this.cartas.size();
    }

}
