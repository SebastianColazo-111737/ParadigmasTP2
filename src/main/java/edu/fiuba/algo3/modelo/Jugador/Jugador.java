package edu.fiuba.algo3.modelo.Jugador;


import edu.fiuba.algo3.modelo.Jugador.Mazo.*;
import edu.fiuba.algo3.modelo.Carta.*;


import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;

    private Mazo mazo;
    private List<ICarta> mano;
    private List<ICarta> descarte;

    public Jugador(String nombre, Mazo mazo){
        this.nombre = nombre;
        this.mazo = mazo;
        this.mano = new ArrayList<>();
        this.descarte = new ArrayList<>();
    }

    public void robarCartas(int cantidad){mano.addAll(mazo.darCartas(cantidad));}
    public void removerCartaDeLaMano(ICarta carta){mano.remove(carta);}
    public void descartarCartas(List<ICarta> cartas){
        descarte.addAll(cartas);
    }

    public Mazo getMazo(){return this.mazo;}
    public List<ICarta> getMano(){return this.mano;}
    public List<ICarta> getDescarte(){return this.descarte;}
}
