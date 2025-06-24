package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.atril.Atril;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;

import java.util.List;

public class Jugador {
    private Mazo mazo;
    private Mano mano;
    private Atril atril;
    private String nombre;

    public Jugador(Mazo mazo, Mano mano, Atril atril) {
        this.mazo = mazo;
        this.mano = mano;
        this.atril = atril;
    }

    // PRUEBA PARA INTERFAZ USUARIO
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public String getNombre() {
        return nombre;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void robarCartasDelMazo(int cantidad){
        List<ICarta> cartasDelMazo = this.mazo.darCartas(cantidad);
        this.mano.agregarCarta(cartasDelMazo);
    }

    public void cambiarCartaDeLaManoAlMazo(ICarta carta){
        mano.removerCarta(carta);

        ICarta cartaDelMazo = this.mazo.cambiarCarta(carta);
        agregarCartaALaMano(cartaDelMazo);
    }

    public void agregarCartaALaMano(ICarta carta){
        this.mano.agregarCarta(carta);
    }

    public boolean lePertenece(Seccion seccion){
        return this.atril.contiene(seccion);
    }

    public void jugarCarta(ICarta carta, Seccion seccion){
        mano.removerCarta(carta);

        try {
            carta.jugarCarta(this, seccion);
        }catch (Exception e){
            mano.agregarCarta(carta);
            throw e;
        }

    }

    public Atril atril(){
        return this.atril;
    }
    public Mano mano(){
        return this.mano;
    }

//    public int getPuntajeActual(){
//        return atril.getPuntajeActual();
//    }
}
