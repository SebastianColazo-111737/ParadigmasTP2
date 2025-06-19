package edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.cartas;

import edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.Jugador;
import edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.Seccion;
import edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.posiciones.Posicion;


public class Medico extends Unidad{
    private Unidad unidadParaRevivir;
    private Seccion seccionParaColocarLaCarta;

    public Medico(String nombre, int puntosBase, Posicion posicicon){
        super(nombre, puntosBase, posicicon);
        this.unidadParaRevivir = null;
        this.seccionParaColocarLaCarta = null;
    }

    @Override
    public int calcularPuntaje() {
        return this.puntosBase;
    }

    @Override
    public void jugar(Jugador jugador, Seccion seccion) {
//        if(!jugador.lePertenece(seccion)){ // si la seccion NO esta en su atril
//            throw new RuntimeException();
//        }
//
//        seccion.colocarUnidad(this); // si esto no lanza exepcion coloco la otra unidad
//        jugador.jugarCarta(this.unidadParaRevivir, this.seccionParaColocarLaCarta);// si esto lanza exepcion tengo que sacar al medico

    }
}
