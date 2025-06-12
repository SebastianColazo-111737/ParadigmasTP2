package edu.fiuba.algo3.TestUnitarios;

import edu.fiuba.algo3.clases.Carta.Unidad;
import edu.fiuba.algo3.modelo.Posicion.IPosicion;
import edu.fiuba.algo3.clases.Seccion.Seccion;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class UnidadTest {

    IPosicion posicionMock = mock(IPosicion.class);
    Seccion seccionMock = mock(Seccion.class);

    @Test
    public void unaUnidadSeColocaEnLaSeccionAlSerJugada(){
        // Arrange
        Unidad unidad = new Unidad(posicionMock, 10);
        // Act
        unidad.jugarCarta(seccionMock);

        // Assert
        verify(seccionMock, times(1)).colocarUnidad(unidad);
    }
}
