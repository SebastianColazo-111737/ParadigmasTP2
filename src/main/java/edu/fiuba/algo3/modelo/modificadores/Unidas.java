package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.cartas.Unidad;
import edu.fiuba.algo3.modelo.jugador.Seccion;

import java.util.List;

// QUE PASARIA SI SE ELIMINA LA CARTA CON ESTE MODIFICADOR?
public class Unidas implements Modificador{
    private String nombre;

    public Unidas(String nombre){
        this.nombre = nombre;
    }

    @Override
    public void aplicarEfecto(Seccion seccion){
        int nuevoPuntaje;
        List<Unidad> iguales = seccion.unidadesIguales(nombre);
        for (Unidad unidad: iguales){
            nuevoPuntaje = unidad.getPuntosBase() * iguales.size();
            unidad.setPuntosBase(nuevoPuntaje);
        }
    }
}
