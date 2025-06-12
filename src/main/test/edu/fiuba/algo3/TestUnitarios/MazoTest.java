package edu.fiuba.algo3.TestUnitarios;

import edu.fiuba.algo3.clases.Carta.ICarta;


import edu.fiuba.algo3.modelo.Jugador.Mazo.Mazo;
import edu.fiuba.algo3.modelo.Jugador.Mazo.MazoCantidadDeCartasPedidasInvalido;
import edu.fiuba.algo3.modelo.Jugador.Mazo.MazoNoPuedeCambiarCartasVacio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class MazoTest {

    private List<ICarta> cartasMock;
    private ICarta cartaMock;

    @BeforeEach
    void setUp() {
        cartasMock = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            cartasMock.add(mock(ICarta.class));
        }

        cartaMock = mock(ICarta.class);
    }

    @Test
    public void unMazoPorDefectoSeCreaSinCartas(){
        // Arrange
        Mazo mazoVacio = new Mazo();
        // Act
        int cantidadDeCartas = mazoVacio.getCantidadCartas();
        // Assert
        assertEquals(0, cantidadDeCartas);
    }

    @Test
    public void aUnMazoSeLePuedeAgregarUnaListaDeCartas(){
        // Arrange
        Mazo mazo = new Mazo();
        // Act
        mazo.agregarCartas(cartasMock);
        int cantidadDeCartas = mazo.getCantidadCartas();
        // Assert
        assertEquals(21, cantidadDeCartas);
    }

    @Test
    public void unMazoSePuedeCrearConCartas(){
        // Arrange
        Mazo mazoConCartas = new Mazo(cartasMock);
        // Act
        int cantidadDeCartas = mazoConCartas.getCantidadCartas();
        // Assert
        assertEquals(21, cantidadDeCartas);
    }

    @Test
    public void aUnMazoSeLePuedenAgregarUnaListaDeCartasVacia(){
        // Arrange
        Mazo mazo = new Mazo();
        List<ICarta> cartasVacias = new ArrayList<>();
        // Act
        mazo.agregarCartas(cartasVacias);
        int cantidadDeCartas = mazo.getCantidadCartas();
        // Assert
        assertEquals(0, cantidadDeCartas);
    }


    @Test
    public void aUnMazoPuedeDarUnaCantidadDeCartas(){
        // Arrange
        Mazo mazo = new Mazo();
        mazo.agregarCartas(cartasMock);
        // Act

        int cantidadDeCartasInicial = mazo.getCantidadCartas();
        List<ICarta> cartasDelMazo = mazo.darCartas(2);
        int cantidadDeCartasFinal = mazo.getCantidadCartas();

        // Assert
        assertEquals(21, cantidadDeCartasInicial);
        assertEquals(2, cartasDelMazo.size());
        assertEquals(19, cantidadDeCartasFinal);
    }

    @Test
    public void aUnMazoLanzaExepcionSiPedisMasCartasDeLasQueTiene(){
        // Arrange
        Mazo mazo = new Mazo();
        // Act

        // Assert
        assertThrows(
                MazoCantidadDeCartasPedidasInvalido.class,
                () -> mazo.darCartas(1)
        );
    }

    @Test
    public void aUnMazoTePermiteCambiarUnaCartaPorOtraDelMazo(){
        // Arrange
        Mazo mazo = new Mazo();
        mazo.agregarCartas(cartasMock);
        // Act
        ICarta cartaDelMazo = mazo.cambiarCarta(cartaMock);

        // Assert
        assertNotSame(cartaMock, cartaDelMazo);
        assertEquals(21, mazo.getCantidadCartas());
        assertTrue(mazo.getCartas().contains(cartaMock));
    }

    @Test
    public void aUnMazoVacionNoTePermiteCambiarCartas(){
        // Arrange
        Mazo mazo = new Mazo();
        // Act

        // Assert
        assertThrows(
                MazoNoPuedeCambiarCartasVacio.class,
                () -> mazo.cambiarCarta(cartaMock)
        );
    }
}
