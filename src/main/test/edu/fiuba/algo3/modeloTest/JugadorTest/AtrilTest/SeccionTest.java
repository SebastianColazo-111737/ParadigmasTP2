package edu.fiuba.algo3.modeloTest.JugadorTest.AtrilTest;

import edu.fiuba.algo3.modelo.cartas.Unidad;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class SeccionTest {

    @Test
    public void unaSeccionDejaColocarSiTieneElMismoTipoDePosicion(){

        // Arrange
        Posicion posicionDeEjemplo = new CuerpoACuerpo();
        Seccion seccion = new Seccion(posicionDeEjemplo);

        // Act
        boolean puedeColocarse = seccion.puedeColocarse(posicionDeEjemplo);

        // Assert
        assertTrue(puedeColocarse);
    }

    @Test
    public void unaSeccionNoDejaColocarSiTieneDiferenteTipoDePosicion(){

        // Arrange
        Posicion posicionDeSeccion = new CuerpoACuerpo();
        Posicion posicionDiferenteDeEjemplo = new Distancia();

        Seccion seccion = new Seccion(posicionDeSeccion);

        // Act
        boolean puedeColocarse = seccion.puedeColocarse(posicionDiferenteDeEjemplo);

        // Assert
        assertFalse(puedeColocarse);
    }

    @Test
    public void unaSeccionPermiteAgregarUnaUnidadASusUnidadesColocadas(){

        // Arrange
        Unidad unidad = new Unidad("Catapulta", 8, new Asedio());
        Seccion seccion = new Seccion(new Asedio());

        // Act
        seccion.colocarUnidad(unidad);

        // Assert
        assertEquals(1, seccion.getUnidadesColocadas().size());
        assertTrue(seccion.getUnidadesColocadas().contains(unidad));

    }

    @Test
    public void unaSeccionSinUnidadesTieneUnPuntajeDe0(){

        // Arrange
        Seccion seccion = new Seccion(new CuerpoACuerpo());

        // Act
        int puntajeSeccion = seccion.calcularPuntaje();
        // Assert
        assertEquals(0, puntajeSeccion);

    }

    @Test
    public void unaSeccionConUnidadesBasicasTieneUnPuntajeIgualALaSumaDeSusPuntajesBase(){

        // Arrange
        Unidad unidad1 = new Unidad("Unidad1", 10, new CuerpoACuerpo());
        Unidad unidad2 = new Unidad("Unidad2", 5, new CuerpoACuerpo());
        Seccion seccion = new Seccion(new CuerpoACuerpo());

        seccion.colocarUnidad(unidad1);
        seccion.colocarUnidad(unidad2);

        // Act
        int puntajeSeccion = seccion.calcularPuntaje();
        // Assert
        assertEquals(15, puntajeSeccion);

    }
}
