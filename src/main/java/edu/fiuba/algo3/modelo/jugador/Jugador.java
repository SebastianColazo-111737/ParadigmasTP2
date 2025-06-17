package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.cartas.ICarta;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;
    private Mazo mazo;

    private List<ICarta> mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mazo = new Mazo();
        this.mano = new ArrayList<>();

    }

    public void agregarCartasAlMazo(List<ICarta> cartas){
        this.mazo.agregarCartas(cartas);
    }

    public void robarCartas(int cantidad){
        List<ICarta> entregadas = this.mazo.darCartas(cantidad);
        this.mano.addAll(entregadas);
    }

    public void removerCartaDeLaMano(ICarta carta){
        this.mano.remove(carta);
    }

    public void cambiarCarta(ICarta carta){
        removerCartaDeLaMano(carta);
        this.mano.add(this.mazo.cambiarCarta(carta));
    }


    public int getCantidadCartasMazo(){
        return this.mazo.getCantidadCartas();
    }

    public List<ICarta> getCartasMano(){
        return this.mano;
    }

    public int getCantidadCartasMano(){
        return this.mano.size();
    }
}
