package edu.fiuba.algo3.modeloTest.JugadorTest;


import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.juego.Puntaje;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;
import edu.fiuba.algo3.modelo.jugador.Mazo;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MazoTest {

    private List<ICarta> cartas;
    @BeforeEach
    void setUp() {
        cartas = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            cartas.add(new UnidadBasica("Guerrero", new Puntaje(5), new CuerpoACuerpo()));
        }
    }

    @Test
    public void aUnMazoSeLePuedeAgregarCartas() {
        // Arrange
        Mazo mazo = new Mazo();

        // Act
        int cantidadDeCartasInicial = mazo.getCantidadCartas();
        mazo.agregarCarta(cartas);
        int cantidadDeCartasFinal = mazo.getCantidadCartas();

        // Assert
        assertEquals(0, cantidadDeCartasInicial);
        assertEquals(21, cantidadDeCartasFinal);
    }


    @Test
    public void unMazoPuedeDarUnaCantidadDeCartasPedidaPorElUsuario() {
        // Arrange
        Mazo mazo = new Mazo();
        mazo.agregarCarta(cartas);

        // Act
        List<ICarta> cartasSacadasDelMazo = mazo.darCartas(10);
        int cantidadDeCartasSacadasDelMazo = cartasSacadasDelMazo.size();
        int cantidadDeCartasDelMazo = mazo.getCantidadCartas();

        // Assert
        assertEquals(10, cantidadDeCartasSacadasDelMazo);
        assertEquals(11, cantidadDeCartasDelMazo);
    }

    @Test
    public void unMazoTePermiteIntercambiarUnaCartaPorOtra() {
        // Arrange
        Mazo mazo = new Mazo();
        mazo.agregarCarta(cartas);

        ICarta cartaParaIntercambiar = new UnidadBasica("Mago", new Puntaje(5), new CuerpoACuerpo());

        // Act
        ICarta cartaDelMazo = mazo.cambiarCarta(cartaParaIntercambiar);

        // Assert
        assertEquals(21, mazo.getCantidadCartas());
        assertNotEquals(cartaDelMazo, cartaParaIntercambiar);
    }
}
