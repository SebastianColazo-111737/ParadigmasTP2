package edu.fiuba.algo3.modeloTest;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.cartas.*;
import edu.fiuba.algo3.modelo.posiciones.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JuegoTest {

    private List<ICarta> cartasJ1;
    private List<ICarta> cartasJ2;
    private Jugador jugador1;
    private Jugador jugador2;
    private Juego juego;

    @BeforeEach
    void setUp() {
        cartasJ1 = new ArrayList<>();
        cartasJ2 = new ArrayList<>();

        for (int i = 0; i < 21; i++) {
            cartasJ1.add(new Unidad("Catapulta", 8, new Asedio())); //algun metodos que cree el mazo?
            cartasJ2.add(new Unidad("Catapulta", 8, new Asedio()));
        }

        Jugador jugador1 = new Jugador("Jugador1");
        Jugador jugador2 = new Jugador("Jugador2");
        Juego juego = new Juego(jugador1, jugador2);
    }

    @Test
    public void alRepartirCartasLosJugadoresPasanATener10CartasEnLaMano(){
        // Arrange
        jugador1.agregarCartasAlMazo(cartasJ1);
        jugador2.agregarCartasAlMazo(cartasJ2);

        // Act
        int cantidadDeCartasInicialEnLaManoJ1 = jugador1.getCantidadCartasMano();
        int cantidadDeCartasInicialEnLaManoJ2 = jugador2.getCantidadCartasMano();
        juego.repartirCartasALosJugadores();
        int cantidadDeCartasFinalEnLaManoJ1 = jugador1.getCantidadCartasMano();
        int cantidadDeCartasFinalEnLaManoJ2 = jugador2.getCantidadCartasMano();

        // Assert
        assertEquals(0, cantidadDeCartasInicialEnLaManoJ1);
        assertEquals(0, cantidadDeCartasInicialEnLaManoJ2);
        assertEquals(10, cantidadDeCartasFinalEnLaManoJ1);
        assertEquals(10, cantidadDeCartasFinalEnLaManoJ2);

    }

    @Test
    public void unJugadorPuedeColocarUnaCartaDeUnidadEnUnaSeccionConLaPosicionElegida(){


        // Arrange

        List<ICarta> cartasDelMazoJugador1 = new ArrayList<>();
        ICarta cartaElegida =  new Unidad("Catapulta", 8, new Asedio());
        Posicion posicionElegida = new Asedio();
        cartasDelMazoJugador1.add(cartaElegida);

        jugador1.agregarCartasAlMazo(cartasDelMazoJugador1);
        jugador1.robarCartas(1); //ahora la tiene en la mano


        // Act
        juego.jugarCarta(jugador1, cartaElegida, posicionElegida);

        // Assert
        assertFalse(jugador1.tieneCartaEnLaMano(cartaElegida));

        Seccion seccionJ1 = jugador1.getAtril().getSeccion(posicionElegida);
        assertTrue(seccionJ1.contieneLaCarta(cartaElegida));

    }
}
