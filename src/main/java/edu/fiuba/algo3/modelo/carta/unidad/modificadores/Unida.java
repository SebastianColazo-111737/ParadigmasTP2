package edu.fiuba.algo3.modelo.carta.unidad.modificadores;

import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Efecto;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.EfectoBoost;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;


import java.util.List;

public class Unida extends UnidadModificada {

    public Unida(Unidad unidad) {
        super(unidad);
    }

    @Override
    public void calcularPuntaje(List<Unidad> Unidades, List<Efecto> efectos) {
        super.calcularPuntaje(Unidades, efectos);
        Puntaje puntajeUnidad = super.getPuntaje();

        int unidadesIguales = 0;
        for (Unidad unidad : Unidades) {
            if (unidad.getNombre().equals(this.getNombre())) {
                unidadesIguales++;
            }
        }
        puntajeUnidad.aplicarEfecto(new EfectoBoost(unidadesIguales));
    }
}
