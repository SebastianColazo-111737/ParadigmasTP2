package edu.fiuba.algo3.modelo.carta.unidad.modificadores;

import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Efecto;


import java.util.List;

public class Unida extends UnidadModificada {

    public Unida(Unidad unidad) {
        super(unidad);
    }

    @Override
    public void calcularPuntaje(List<Unidad> otrasUnidades, List<Efecto> efectos) {
        super.calcularPuntaje(otrasUnidades, efectos);

        int unidadesIguales = 0;
        for (Unidad unidad : otrasUnidades) {
            if (unidad.getNombre().equals(this.getNombre())) {
                unidadesIguales++;
            }
        }
        int nuevoPuntaje = this.getPuntajeActual() * (unidadesIguales + 1);
        this.setPuntajeActual(nuevoPuntaje);
    }
}
