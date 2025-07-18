package edu.fiuba.algo3.modeloTest.JugadorTest.AtrilTest;

import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;
import edu.fiuba.algo3.modelo.jugador.Puntaje;

import edu.fiuba.algo3.modelo.jugador.atril.SeccionNoPermiteColocarUnidadesConPosicionIncompatible;
import edu.fiuba.algo3.modelo.posiciones.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SeccionTest {

    @Test
    public void unaSeccionTieneUnaPosicionYSePuedeCompararConOtrasPosiciones(){

        // Arrange
        Seccion seccion = new Seccion(new CuerpoACuerpo());

        // Act
        boolean esCompatibleConPosicionCuerpoACuerpo = seccion.compararPosiciones(new CuerpoACuerpo());
        boolean esCompatibleConPosicionDistancia = seccion.compararPosiciones(new Distancia());
        boolean esCompatibleConPosicionAsedio = seccion.compararPosiciones(new Asedio());

        // Assert
        assertTrue(esCompatibleConPosicionCuerpoACuerpo);
        assertFalse(esCompatibleConPosicionDistancia);
        assertFalse(esCompatibleConPosicionAsedio);

    }

    @Test
    public void unaSeccionPermiteAgregarUnaUnidadASusUnidadesColocadasCuandoTienenLaMismaPosicion(){

        // Arrange
        UnidadBasica guerrero = new UnidadBasica("Guerrero", new Puntaje(8), new CuerpoACuerpo());
        Seccion seccion = new Seccion(new CuerpoACuerpo());

        // Act
        seccion.colocarUnidad(guerrero);

        // Assert
        assertEquals(1, seccion.getUnidadesColocadas().size());
        assertTrue(seccion.getUnidadesColocadas().contains(guerrero));

    }

    @Test
    public void unaSeccionNoPermiteAgregarUnaUnidadASusUnidadesColocadasCuandoNoTienenLaMismaPosicion(){

        // Arrange
        Seccion seccion = new Seccion(new Asedio());

        UnidadBasica guerrero = new UnidadBasica("Guerrero", new Puntaje(8), new CuerpoACuerpo());
        UnidadBasica mago = new UnidadBasica("mago", new Puntaje(5), new Distancia());

        // Act

        // Assert
        assertThrows(SeccionNoPermiteColocarUnidadesConPosicionIncompatible.class, () -> {
            seccion.colocarUnidad(guerrero);
        });
        assertThrows(SeccionNoPermiteColocarUnidadesConPosicionIncompatible.class, () -> {
            seccion.colocarUnidad(mago);
        });

    }

    @Test
    public void unaSeccionPermiteRemoverLasUnidadesColocadas(){

        // Arrange
        Seccion seccion = new Seccion(new CuerpoACuerpo());

        UnidadBasica guerrero1 = new UnidadBasica("Guerrero1", new Puntaje(8), new CuerpoACuerpo());
        UnidadBasica guerrero2 = new UnidadBasica("Guerrero2", new Puntaje(8), new CuerpoACuerpo());
        UnidadBasica guerrero3 = new UnidadBasica("Guerrero3", new Puntaje(8), new CuerpoACuerpo());

        seccion.colocarUnidad(guerrero1);
        seccion.colocarUnidad(guerrero2);
        seccion.colocarUnidad(guerrero3);

        // Act

        int cantidadDeUnidadesEnSeccionInicial = seccion.getUnidadesColocadas().size();
        List<Unidad> unidadesDescartadas = seccion.removerCartasJugadas();
        int cantidadDeUnidadesEnSeccionFinal = seccion.getUnidadesColocadas().size();

        // Assert
        assertEquals(3, cantidadDeUnidadesEnSeccionInicial);
        assertTrue(unidadesDescartadas.contains(guerrero1));
        assertTrue(unidadesDescartadas.contains(guerrero2));
        assertTrue(unidadesDescartadas.contains(guerrero3));
        assertEquals(0, cantidadDeUnidadesEnSeccionFinal);

    }

//    @Test
//    public void unaSeccionSinUnidadesTieneUnPuntajeDe0(){
//
//        // Arrange
//        Seccion seccion = new Seccion(new CuerpoACuerpo());
//
//        // Act
//        int puntajeSeccion = seccion.calcularPuntaje();
//        // Assert
//        assertEquals(0, puntajeSeccion);
//
//    }
//
//    @Test
//    public void unaSeccionConUnidadesBasicasTieneUnPuntajeIgualALaSumaDeSusPuntajesBase(){
//
//        // Arrange
//        Unidad unidad1 = new UnidadBasica("Unidad1", 10, new CuerpoACuerpo());
//        Unidad unidad2 = new UnidadBasica("Unidad2", 5, new CuerpoACuerpo());
//        Seccion seccion = new Seccion(new CuerpoACuerpo());
//
//        seccion.colocarUnidad(unidad1);
//        seccion.colocarUnidad(unidad2);
//
//        // Act
//        int puntajeSeccion = seccion.calcularPuntaje();
//        // Assert
//        assertEquals(15, puntajeSeccion);
//
//    }
}
