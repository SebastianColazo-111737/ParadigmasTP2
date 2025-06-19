package edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.cartas;

import edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.Jugador;
import edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.Seccion;
import edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.posiciones.Posicion;

public class Espia extends Unidad{

    public Espia(String nombre, int puntosBase, Posicion posicion){
        super(nombre,puntosBase,posicion);
    }

    @Override
    public int calcularPuntaje() {
        return this.puntosBase;
    }

    @Override
    public void jugar(Jugador jugador, Seccion seccion) {
//        if(jugador.lePertenece(seccion)){ //si el jugador TIENE la seccion en su atril
//            throw new RuntimeException();
//        }
//        jugador.robarCarta(2);
//        seccion.colocarUnidad(this);
    }
}
