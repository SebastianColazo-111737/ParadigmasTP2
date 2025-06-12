package edu.fiuba.algo3.clases.Jugador;

import edu.fiuba.algo3.clases.Carta.Unidad;
import edu.fiuba.algo3.clases.Mano.Mano;
import edu.fiuba.algo3.modelo.Jugador.Mazo.Mazo;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;

    private List<Unidad> descarte = new ArrayList<>();
    private Mazo mazo;
    private Mano mano;

    public Jugador(String nombre, Mazo mazo, Mano mano) {
        this.nombre = nombre;

        this.mazo = mazo;
        this.mano = mano;

    }

    public Jugador(String nombre, Mazo mazo) {
        this(nombre, mazo, new Mano());
    }

    public void robarCartas(int cantidad){
        mano.agregarCartas(mazo.darCartas(cantidad));
    }


    public int getCantidadCartasMazo(){
        return mazo.getCantidadCartas();
    }
    public int getCantidadCartasMano(){
        return mano.getCantidadCartas();
    }
}
