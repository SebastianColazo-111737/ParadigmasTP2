package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.cartas.Carta;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;

    // PRUEBA PARA INTERFAZ USUARIO
    private Mazo mazo;     //private List<Carta> mazo;

    private List<Carta> mano;
    private List<Carta> descarte;


    // PRUBA PARA INTERFAZ USUARIO
    public Jugador(){

    }


//    public Jugador(String nombre) {
//        this.nombre = nombre;
//        this.mazo = new ArrayList<>();
//        this.mano = new ArrayList<>();
//        this.descarte = new ArrayList<>();
//    }

//    public void agregarCartasAlMazo(List<ICarta> cartas){
//        this.mazo.agregarCartas(cartas);
//    }
//
//    public void robarCartas(int cantidad){
//        List<ICarta> entregadas = this.mazo.darCartas(cantidad);
//        this.mano.addAll(entregadas);
//    }
//
//    public void removerCartaDeLaMano(ICarta carta){
//        this.mano.remove(carta);
//    }
//
//    public int getCantidadCartasMazo(){
//        return this.mazo.getCantidadCartas();
//    }
//
//    public List<Carta> getCartasMano(){
//        return this.mano;
//    }
//
//    public int getCantidadCartasMano(){
//        return this.mano.size();
//    }

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

    public List<Carta> getDescarte(){
        return descarte;
    }

    public void enviarAlDescarte(Carta carta){
        descarte.add(carta);
    }
}
