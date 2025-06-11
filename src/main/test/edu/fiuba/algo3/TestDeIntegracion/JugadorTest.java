package edu.fiuba.algo3.TestDeIntegracion;

import edu.fiuba.algo3.clases.Carta.*;
import edu.fiuba.algo3.clases.Jugador.Jugador;
import edu.fiuba.algo3.clases.Mano.Mano;
import edu.fiuba.algo3.clases.Mazo.Mazo;
import edu.fiuba.algo3.clases.Posicion.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


public class JugadorTest {

    private List<ICarta> cartas;
    private Jugador jugador;

    @BeforeEach
    void setUp() {
        cartas = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            if(i < 8) cartas.add(new Unidad(new CuerpoACuerpo(),i));
            else if (i < 16) cartas.add(new Unidad(new Distancia(),i));
            else cartas.add(new Unidad(new Asedio(),i));
        }
        jugador = new Jugador("Jugador1",new Mazo(cartas), new Mano());
        jugador.robarCartas(10);
    }

    @Test
    public void unJugadorPuedeJugarUnaCartaEnUnaSeccionDelTablero(){
        // Arrange
        IPosicion posicion = new CuerpoACuerpo();
        // Act
        jugador.jugarCartaDeLaMano(0,posicion);
        // Assert
        assertEquals(1, jugador.getCantidadCartasEnSeccion(posicion));
    }

    @Test
    public void unJugadorObtieneUnPuntajeParcialLuegoDeJugarUnaCarta(){
        // Arrange
        IPosicion posicion = new CuerpoACuerpo();

        // Act
        int puntajeInicial = jugador.getPuntajeSeccion(posicion);
        jugador.jugarCartaDeLaMano(0,posicion);
        int puntajeFinal = jugador.getPuntajeSeccion(posicion);

        // Assert
        assertEquals(0, puntajeInicial);
        assertNotSame(0, puntajeFinal);
    }

    @Test
    public void unJugadorPuedeDescartarUnaCartaDeUnaSeccion(){
        // Arrange
        IPosicion posicion = new CuerpoACuerpo();

        // Act
        jugador.jugarCartaDeLaMano(0,posicion);
        int canitdadDeCartasEnLaSeccionInicial = jugador.getCantidadCartasEnSeccion(posicion);
        int cantidadDeCartasEnDescarteInicial = jugador.getCantidadCartasDescarte();
        jugador.descartarCartasDeLaSeccion(posicion);
        int canitdadDeCartasEnLaSeccionFinal = jugador.getCantidadCartasEnSeccion(posicion);
        int cantidadDeCartasEnDescarteFinal = jugador.getCantidadCartasDescarte();

        // Assert
        assertEquals(1, canitdadDeCartasEnLaSeccionInicial);
        assertEquals(0, cantidadDeCartasEnDescarteInicial);

        assertEquals(0, canitdadDeCartasEnLaSeccionFinal);
        assertEquals(1, cantidadDeCartasEnDescarteFinal);
    }
}
