package edu.fiuba.algo3.modeloTest.CartasTest;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.cartas.unidades.Agil;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Juego.Tablero.Seccion;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AgilesTest {

    private Jugador jugador1;
    private Jugador jugador2;
    private Juego juego;

    @BeforeEach
    void setUp() {

        jugador1 = new Jugador("Jugador1");
        jugador2 = new Jugador("Jugador2");
        juego = new Juego(jugador1, jugador2);
        juego.setJugadorActual(jugador1);
    }

    @Test
    public void unaCartaAgilSePuedeColocarEnDosSeccionesDiferentes(){

        // Arrange
        Agil agil1 = new Agil("agil1", 5, new CuerpoACuerpo(), new Distancia());
        Agil agil2 = new Agil("agil2", 5, new CuerpoACuerpo(), new Distancia());
        jugador1.agregarCartasAlMazo(List.of(agil1,agil2));
        jugador1.robarCartas(2);

        // Act
        juego.jugarCarta(jugador1, agil1, new CuerpoACuerpo());
        juego.jugarCarta(jugador1, agil2, new Distancia());

        Seccion seccionCuerpoACuerpoJ1 = juego.getAtril(jugador1).getSeccion(new CuerpoACuerpo());
        Seccion seccionDistanciaJ1 = juego.getAtril(jugador1).getSeccion(new Distancia());


        // Assert
        assertEquals(1, seccionCuerpoACuerpoJ1.getUnidadesColocadas().size());
        assertEquals(1, seccionDistanciaJ1.getUnidadesColocadas().size());
        assertTrue(seccionCuerpoACuerpoJ1.getUnidadesColocadas().contains(agil1));
        assertTrue(seccionDistanciaJ1.getUnidadesColocadas().contains(agil2));

    }
}
