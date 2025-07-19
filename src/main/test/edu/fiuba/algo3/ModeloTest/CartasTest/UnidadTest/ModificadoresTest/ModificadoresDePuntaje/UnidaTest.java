package edu.fiuba.algo3.ModeloTest.CartasTest.UnidadTest.ModificadoresTest.ModificadoresDePuntaje;

import edu.fiuba.algo3.modelo.carta.unidad.UnidadFactory;
import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.posicion.Asedio;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UnidaTest {

    @Test
    public void unaSeccionConUnidadesUnidasTieneUnPuntajeMultiplicado(){

        // Arrange
        List<String> modificadores = new ArrayList<>();
        modificadores.add("carta unida");
        List<String> posiciones = new ArrayList<>();
        posiciones.add("asedio");

        Unidad unidadUnida1 = UnidadFactory.crear("catapulta", 8, modificadores, posiciones);
        Unidad unidadUnida2 = UnidadFactory.crear("catapulta", 8, modificadores, posiciones);
        Unidad unidadUnida3 = UnidadFactory.crear("catapulta", 8, modificadores, posiciones);



        Seccion seccion = new Seccion(new Asedio());

        int puntajeBaseCatapultas = 8;
        int cantidadDeCatapultasUnidas = 3;
        int puntajeEsperado = (puntajeBaseCatapultas * cantidadDeCatapultasUnidas) +
                              (puntajeBaseCatapultas * cantidadDeCatapultasUnidas) +
                              (puntajeBaseCatapultas * cantidadDeCatapultasUnidas); // representa puntaje de cada carta

        // Act
        seccion.colocarUnidad(unidadUnida1);
        seccion.colocarUnidad(unidadUnida2);
        seccion.colocarUnidad(unidadUnida3);
        int puntajeSeccion = seccion.getPuntaje();

        // Assert
        assertEquals(puntajeEsperado, puntajeSeccion);
    }
}
