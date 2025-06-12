package edu.fiuba.algo3.TestUnitarios;

import edu.fiuba.algo3.clases.Carta.ICarta;
import edu.fiuba.algo3.clases.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.Mazo.Mazo;
import edu.fiuba.algo3.clases.Mano.Mano;

import static org.junit.Assert.assertEquals;

import edu.fiuba.algo3.modelo.Posicion.IPosicion;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.*;


public class JugadorTest {

    @Mock
    private Mazo mazoMock = mock(Mazo.class);
    private Mano manoMock = mock(Mano.class);
    private List<ICarta> cartasMock;
    private ICarta cartaMock = mock(ICarta.class);
    private IPosicion posicionMock = mock(IPosicion.class);

    @Test
    public void jugadorTieneCartasSuficientesEnSuMazoParaIniciarElJuego() {
        // Arrange
        when(mazoMock.getCantidadCartas()).thenReturn(21);
        // Act
        Jugador jugador = new Jugador("Jugador1", mazoMock);
        // Assert
        assertEquals(21, jugador.getCantidadCartasMazo());
    }

    @Test
    public void jugadorReparte10CartasDeSuMazoASuMano() {
        // Arrange
        Jugador jugador1 = new Jugador("Jugador1", mazoMock, manoMock);
        when(mazoMock.darCartas(10)).thenReturn(cartasMock);
        // Act
        jugador1.robarCartas(10);
        // Assert
        verify(mazoMock, times(1)).darCartas(10);
        verify(manoMock, times(1)).agregarCartas(cartasMock);

    }


}
