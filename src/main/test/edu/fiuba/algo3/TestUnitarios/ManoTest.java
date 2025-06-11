package edu.fiuba.algo3.TestUnitarios;

import edu.fiuba.algo3.clases.Carta.ICarta;
import edu.fiuba.algo3.clases.Mano.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class ManoTest {

    private List<ICarta> cartasMock;

    @BeforeEach
    void setUp() {
        cartasMock = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cartasMock.add(mock(ICarta.class));
        }
    }

    @Test
    public void unaManoSeCreaSinCartas(){
        // Arrange
        Mano manoVacia = new Mano();
        // Act
        int cantidadDeCartas = manoVacia.getCantidadCartas();
        // Assert
        assertEquals(0, cantidadDeCartas);
    }

    @Test
    public void aUnaManoSeLePuedeAgregarUnaListaDeCartas(){
        // Arrange
        Mano mano = new Mano();
        // Act
        mano.agregarCartas(cartasMock);
        int cantidadDeCartas = mano.getCantidadCartas();
        // Assert
        assertEquals(10, cantidadDeCartas);
    }

    @Test
    public void unaManoPuedeDevolverUnaCarta(){
        // Arrange
        Mano mano = new Mano();
        mano.agregarCartas(cartasMock);
        // Act
        int cantidadDeCartasInicial = mano.getCantidadCartas();
        ICarta primeraCarta = mano.getCarta(0);
        ICarta segundaCarta = mano.getCarta(0);
        int cantidadDeCartasFinal = mano.getCantidadCartas();

        // Assert
        assertEquals(10, cantidadDeCartasInicial);
        assertNotSame(primeraCarta, segundaCarta);
        assertEquals(8, cantidadDeCartasFinal);
    }

    @Test
    public void unaManoLanzaExepcionSiAlPedirUnaCartaElIndiceEsMayorALaCantidadDeCartasEnLaMano(){
        // Arrange
        Mano mano = new Mano();
        mano.agregarCartas(cartasMock);
        // Act

        // Assert
        assertThrows(
                ManoIndiceDeCartaInvalido.class,
                () -> mano.getCarta(100)
        );
    }
}
