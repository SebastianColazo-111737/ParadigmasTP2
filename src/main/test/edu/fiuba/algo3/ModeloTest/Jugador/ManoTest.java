package edu.fiuba.algo3.ModeloTest.Jugador;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.unidad.UnidadBasica;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.jugador.Mano;
import edu.fiuba.algo3.modelo.jugador.ManoNoContieneCartaException;
import edu.fiuba.algo3.modelo.posicion.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManoTest {

    private List<Carta> cartas;
    @BeforeEach
    void setUp() {
        cartas = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            cartas.add(new UnidadBasica("Guerrero", new Puntaje(5), new CuerpoACuerpo()));
        }
    }

    @Test
    public void aUnaManoSeLePuedeAgregarCartas() {
        // Arrange
        Mano mano = new Mano();

        // Act
        int cantidadDeCartasInicial = mano.getCantidadCartas();
        mano.agregarCarta(cartas);
        int cantidadDeCartasFinal = mano.getCantidadCartas();

        // Assert
        assertEquals(0, cantidadDeCartasInicial);
        assertEquals(21, cantidadDeCartasFinal);
    }


    @Test
    public void sePuedeRemoverUnaCartaDeLaMano() {
        // Arrange
        Mano mano = new Mano();
        UnidadBasica unidadMago = new UnidadBasica("Mago", new Puntaje(5), new Distancia());
        mano.agregarCarta(unidadMago);

        // Act
        int cantidadDeCartasInicial = mano.getCantidadCartas();
        boolean contieneMago = mano.getCartas().contains(unidadMago);

        mano.removerCarta(unidadMago);
        int cantidadDeCartasFinal = mano.getCantidadCartas();

        // Assert
        assertTrue(contieneMago);
        assertEquals(1, cantidadDeCartasInicial);

        assertEquals(0, cantidadDeCartasFinal);
        assertFalse(mano.getCartas().contains(unidadMago));

    }

    @Test
    public void removerUnaCartaQueNoEstaEnLaManoLanzaExcepcion() {
        // Arrange
        Mano mano = new Mano();
        UnidadBasica unidadMago = new UnidadBasica("Mago", new Puntaje(5), new Distancia());

        // Act

        // Assert
        assertThrows(ManoNoContieneCartaException.class, () -> {
            mano.removerCarta(unidadMago);
        });
    }
}
