package edu.fiuba.algo3.TestUnitarios;


import edu.fiuba.algo3.clases.Carta.Unidad;
import edu.fiuba.algo3.clases.Seccion.*;

import edu.fiuba.algo3.modelo.Posicion.IPosicion;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SeccionTest {

    @Mock
    IPosicion posicionSeccionMock = mock(IPosicion.class);
    IPosicion posicionUnidadMock = mock(IPosicion.class);
    Unidad unidadMock = mock(Unidad.class);

    @Test
    public void unaSeccionSeCreaSinCartasDeUnidadColocadas(){
        // Arrange
        Seccion seccionNueva = new Seccion(posicionSeccionMock);
        // Act
        int cantidadDeUnidades = seccionNueva.getCantidadDeUnidadesColocadas();

        // Assert
        assertEquals(0, cantidadDeUnidades);
    }

    @Test
    public void unaSeccionPuedeAgregarUnaUnidadConUnaPosicionCompatible(){
        // Arrange
        Seccion seccion = new Seccion(posicionSeccionMock);
        when(unidadMock.sePuedeColocarEnLaPosicion(posicionSeccionMock)).thenReturn(true);
        // Act
        int cantidadDeUnidadesInicial = seccion.getCantidadDeUnidadesColocadas();
        seccion.colocarUnidad(unidadMock);
        int cantidadDeUnidadesFinal = seccion.getCantidadDeUnidadesColocadas();

        // Assert
        assertEquals(0, cantidadDeUnidadesInicial);
        assertEquals(1, cantidadDeUnidadesFinal);
    }

    @Test
    public void unaSeccionNoPuedeAgregarUnaUnidadConUnaPosicionIncompatible(){
        // Arrange
        Seccion seccion = new Seccion(posicionSeccionMock);
        Unidad unidadParaColocar = new Unidad(posicionUnidadMock, 10);
        when(posicionSeccionMock.esCompatible(posicionUnidadMock)).thenReturn(false);
        // Act
        int cantidadDeUnidadesInicial = seccion.getCantidadDeUnidadesColocadas();
        seccion.colocarUnidad(unidadParaColocar);
        int cantidadDeUnidadesFinal = seccion.getCantidadDeUnidadesColocadas();

        // Assert
        assertEquals(0, cantidadDeUnidadesInicial);
        assertEquals(0, cantidadDeUnidadesFinal);
    }
}
