package edu.fiuba.algo3.modelo.carta.unidad.modificadores;

import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Efecto;

import java.util.List;

public class Animador extends UnidadModificada{

    public Animador(Unidad unidad) {
        super(unidad);
    }

    @Override
    public void calcularPuntaje(List<Unidad> otrasUnidades, List<Efecto> efectos) {
        super.calcularPuntaje(otrasUnidades, efectos);

        for (Unidad otraUnidad : otrasUnidades) {
            int nuevoPuntaje = otraUnidad.getPuntajeActual() + 1;
            otraUnidad.setPuntajeActual(nuevoPuntaje);
        }
    }
}
