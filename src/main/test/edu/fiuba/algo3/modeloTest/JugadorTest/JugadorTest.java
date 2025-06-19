package edu.fiuba.algo3.modeloTest.JugadorTest;

import edu.fiuba.algo3.aux.cartas.*;
import edu.fiuba.algo3.aux.cartas.unidades.UnidadBasica;
import edu.fiuba.algo3.aux.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class JugadorTest {

    private List<ICarta> cartas;
    private Jugador jugador;

    @BeforeEach
    void setUp() {
        cartas = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            cartas.add(new UnidadBasica("Unidad", 0 , new CuerpoACuerpo()));
        }

        jugador = new Jugador("Jugador1");
    }

//    @Test
//    public void unJugadorTieneCartasSuficientesEnSuMazoParaIniciarLaPartida(){
//        // Arrange
//        jugador.agregarCartasAlMazo(cartas);
//        // Act
//        int cantidadDeCartas = jugador.getCantidadCartasMazo();
//
//        // Assert
//        assertEquals(21, cantidadDeCartas);
//
//    }
//
//    @Test
//    public void unJugadorSeCreaSinCartasEnElMazo(){
//        // Arrange
//        // Act
//        int cantidadDeCartas = jugador.getCantidadCartasMazo();
//
//        // Assert
//        assertEquals(0, cantidadDeCartas);
//
//    }
//
//    @Test
//    public void unJugadorPuedeSacarUnaCartaDeSuMano(){
//        // Arrange
//        jugador.agregarCartasAlMazo(cartas);
//        jugador.robarCartas(10); // pasa a tener 10 cartas en la mano
//        ICarta cartaParaRemover = jugador.getCartasMano().get(0);
//
//        // Act
//        int cantidadDeCartasInicial = jugador.getCantidadCartasMano();
//        jugador.removerCartaDeLaMano(cartaParaRemover);
//        int cantidadDeCartasFinal = jugador.getCantidadCartasMano();
//
//        // Assert
//        assertEquals(10, cantidadDeCartasInicial);
//        assertEquals(9, cantidadDeCartasFinal);
//
//    }
}
