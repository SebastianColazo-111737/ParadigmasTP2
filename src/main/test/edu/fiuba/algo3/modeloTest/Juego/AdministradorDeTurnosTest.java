package edu.fiuba.algo3.modeloTest.Juego;


import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Juego.AdminTurnos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AdministradorDeTurnosTest {

    private List<Jugador> jugadores;
    private Jugador jugador1;
    private Jugador jugador2;

    @BeforeEach
    void setUp() {
        jugadores = new ArrayList<>();
        jugador1 = new Jugador("J1");
        jugador2 = new Jugador("J2");

        jugadores.add(jugador1);
        jugadores.add(jugador2);
    }

    @Test
    public void elAdminDeTurnosPermiteObtenerElJugadorActual(){

        // Arrange
        AdminTurnos adminTurnos = new AdminTurnos(jugadores);

        // Act
        boolean esElTurnoDelJ1 = adminTurnos.esSuTurno(jugador1);
        Jugador jugadorActual = adminTurnos.getJugadorActual();

        // Assert
        assertTrue(esElTurnoDelJ1);
        assertEquals(jugador1, jugadorActual);
    }

    @Test
    public void elAdminDeTurnosPermiteSetearElJugadorActualDentroDeSusJugadores(){

        // Arrange
        AdminTurnos adminTurnos = new AdminTurnos(jugadores);
        adminTurnos.setJugadorActual(jugador2);
        // Act
        boolean esElTurnoDelJ2 = adminTurnos.esSuTurno(jugador2);
        Jugador jugadorActual = adminTurnos.getJugadorActual();

        // Assert
        assertTrue(esElTurnoDelJ2);
        assertEquals(jugador2, jugadorActual);
    }

    @Test
    public void elAdminDeTurnosPermiteAvanzarAlProximoturnoCambiandoAlJugadorActual(){

        // Arrange
        AdminTurnos adminTurnos = new AdminTurnos(jugadores);
        Jugador primerJugador = adminTurnos.getJugadorActual();

        // Act
        adminTurnos.proximoTurno();
        Jugador segundoJugador = adminTurnos.getJugadorActual();

        // Assert
        assertNotEquals(primerJugador, segundoJugador);
    }

    @Test
    public void elAdminDeTurnosPermiteQueUnJugadorPaseDeTurno(){

        // Arrange
        AdminTurnos adminTurnos = new AdminTurnos(jugadores);
        Jugador primerJugador = adminTurnos.getJugadorActual();

        // Act
        adminTurnos.jugadorPasaTurno(primerJugador);

        adminTurnos.proximoTurno();
        Jugador segundoJugador = adminTurnos.getJugadorActual();
        adminTurnos.proximoTurno();
        Jugador tercerJugador = adminTurnos.getJugadorActual();


        // Assert
        assertNotEquals(primerJugador, segundoJugador);
        Assertions.assertEquals(tercerJugador, segundoJugador);

    }

    @Test
    public void elAdminDeTurnosTerminaLaRondaCuandoAmbosJugadoresPasan(){

        // Arrange
        AdminTurnos adminTurnos = new AdminTurnos(jugadores);
        Jugador primerJugador = adminTurnos.getJugadorActual();

        // Act
        adminTurnos.jugadorPasaTurno(primerJugador);
        boolean terminoPrimerIntento = adminTurnos.ambosPasaronTurno();

        adminTurnos.proximoTurno();
        Jugador segundoJugador = adminTurnos.getJugadorActual();
        adminTurnos.jugadorPasaTurno(segundoJugador);
        boolean terminoSegundoIntento = adminTurnos.ambosPasaronTurno();


        // Assert
        assertFalse(terminoPrimerIntento);
        assertTrue(terminoSegundoIntento);
    }

    @Test
    public void elAdminDeTurnosPermiteReiniciarLaRonda(){

        // Arrange
        AdminTurnos adminTurnos = new AdminTurnos(jugadores);
        Jugador primerJugador = adminTurnos.getJugadorActual();
        adminTurnos.jugadorPasaTurno(primerJugador);
        adminTurnos.proximoTurno();
        Jugador segundoJugador = adminTurnos.getJugadorActual();
        adminTurnos.jugadorPasaTurno(segundoJugador);
        // Act

        boolean terminoPrimerIntento = adminTurnos.ambosPasaronTurno();
        adminTurnos.reiniciarRonda();
        boolean terminoSegundoIntento = adminTurnos.ambosPasaronTurno();

        // Assert
        assertTrue(terminoPrimerIntento);
        assertFalse(terminoSegundoIntento);

    }
}
