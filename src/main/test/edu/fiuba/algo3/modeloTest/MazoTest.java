package edu.fiuba.algo3.modeloTest;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.Unidad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class MazoTest {

    private List<ICarta> cartas;

    @BeforeEach
    void setUp() {
        cartas = new ArrayList<>();

        for (int i = 0; i < 21; i++) {
            cartas.add(new Unidad());
        }
    }

    @Test
    public void aUnMazoSeLePuedeAgregarCartas() {
        // Arrange
        Mazo mazo = new Mazo();

        // Act
        int cantidadDeCartasInicial = mazo.getCantidadCartas();
        mazo.agregarCartas(cartas);
        int cantidadDeCartasFinal = mazo.getCantidadCartas();

        // Assert
        assertEquals(0, cantidadDeCartasInicial);
        assertEquals(21, cantidadDeCartasFinal);
    }


    @Test
    public void unMazoPuedeDarUnaCantidadDeCartasPedidaPorElUsuario() {
        // Arrange
        Mazo mazo = new Mazo();
        mazo.agregarCartas(cartas);

        // Act
        List<ICarta> cartasSacadasDelMazo = mazo.darCartas(10);
        int cantidadDeCartasSacadasDelMazo = cartasSacadasDelMazo.size();
        int cantidadDeCartasDelMazo = mazo.getCantidadCartas();

        // Assert
        assertEquals(10, cantidadDeCartasSacadasDelMazo);
        assertEquals(11, cantidadDeCartasDelMazo);
    }
}
