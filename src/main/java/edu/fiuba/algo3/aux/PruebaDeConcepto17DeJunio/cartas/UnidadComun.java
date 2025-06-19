package edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.cartas;

import edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.Jugador;
import edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.Seccion;
import edu.fiuba.algo3.aux.PruebaDeConcepto17DeJunio.posiciones.Posicion;

public class UnidadComun extends Unidad{

    public UnidadComun(String nombre, int puntosBase, Posicion posicion){
        super(nombre,puntosBase,posicion);
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
//        seccion.colocarUnidad(this);
    }
}
