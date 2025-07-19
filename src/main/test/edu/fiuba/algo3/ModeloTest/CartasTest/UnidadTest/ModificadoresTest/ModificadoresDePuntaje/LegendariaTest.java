package edu.fiuba.algo3.ModeloTest.CartasTest.UnidadTest.ModificadoresTest.ModificadoresDePuntaje;


import edu.fiuba.algo3.modelo.carta.unidad.UnidadFactory;
import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class LegendariaTest {

    @Test
    public void elPuntajeDeUnaLegendariaNoSeAfectaPorEfectos(){

        List<String> modificadores = new ArrayList<>();
        modificadores.add("Legendaria");
        List<String> posiciones = new ArrayList<>();
        posiciones.add("cuerpo a cuerpo");

        Unidad legendaria = UnidadFactory.crear("legendaria", 15, modificadores, posiciones);

        List<Efecto> efectos = new ArrayList<>();
        efectos.add(new EfectoDebilitar());
        efectos.add(new EfectoAumentar(10));
        efectos.add(new EfectoBoost(2));
        // Act

        int puntajeBase = legendaria.getPuntaje().getPuntajeActual();
        legendaria.calcularPuntaje(null, efectos);
        int puntajeLuegoDeAplicarEfectos = legendaria.getPuntaje().getPuntajeActual();

        // Assert
        assertEquals(puntajeBase, puntajeLuegoDeAplicarEfectos);
    }
}
