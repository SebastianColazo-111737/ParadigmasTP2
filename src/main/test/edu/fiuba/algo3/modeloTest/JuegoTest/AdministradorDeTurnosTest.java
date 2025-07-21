// package edu.fiuba.algo3.modeloTest.JuegoTest;
//
//
// import edu.fiuba.algo3.modelo.juego.AdminTurnos;
// import edu.fiuba.algo3.modelo.juego.AdminturnosTodosPasaronDeTurno;
//
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
//
// import java.util.ArrayList;
// import java.util.List;
//
// import static org.junit.Assert.*;
// import static org.junit.jupiter.api.Assertions.assertNotEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
//
// public class AdministradorDeTurnosTest {
//
// private List<String> jugadores;
// String jugador1 = "J1";
// String jugador2 = "J2";
//
// @BeforeEach
// void setUp() {
// jugadores = new ArrayList<>();
// jugadores.add(jugador1);
// jugadores.add(jugador2);
// }
//
// @Test
// public void elAdminDeTurnosPermiteObtenerElJugadorActual(){
//
// // Arrange
// AdminTurnos<String> adminTurnos = new AdminTurnos(jugadores);
//
// // Act
// boolean esElTurnoDelJ1 = adminTurnos.esSuTurno(jugador1);
// String jugadorActual = adminTurnos.getJugadorActual();
//
// // Assert
// assertTrue(esElTurnoDelJ1);
// assertEquals(jugador1, jugadorActual);
// }
//
// @Test
// public void
// elAdminDeTurnosPermiteSetearElJugadorActualDentroDeSusJugadores(){
//
// // Arrange
// AdminTurnos<String> adminTurnos = new AdminTurnos(jugadores);
// adminTurnos.setJugadorActual(jugador2);
// // Act
// boolean esElTurnoDelJ2 = adminTurnos.esSuTurno(jugador2);
// String jugadorActual = adminTurnos.getJugadorActual();
//
// // Assert
// assertTrue(esElTurnoDelJ2);
// assertEquals(jugador2, jugadorActual);
// }
//
// @Test
// public void
// elAdminDeTurnosPermiteAvanzarAlProximoturnoCambiandoAlJugadorActual(){
//
// // Arrange
// AdminTurnos<String> adminTurnos = new AdminTurnos(jugadores);
// String primerJugador = adminTurnos.getJugadorActual();
//
// // Act
// adminTurnos.proximoTurno();
// String segundoJugador = adminTurnos.getJugadorActual();
//
// // Assert
// assertNotEquals(primerJugador, segundoJugador);
// }
//
// @Test
// public void elAdminDeTurnosPermiteQueUnJugadorPaseDeTurno(){
//
// // Arrange
// AdminTurnos<String> adminTurnos = new AdminTurnos(jugadores);
// String primerJugador = adminTurnos.getJugadorActual();
//
// // Act
// adminTurnos.jugadorPasaTurno(primerJugador);
//
// adminTurnos.proximoTurno();
// String segundoJugador = adminTurnos.getJugadorActual();
// adminTurnos.proximoTurno();
// String tercerJugador = adminTurnos.getJugadorActual();
//
//
// // Assert
// assertNotEquals(primerJugador, segundoJugador);
// Assertions.assertEquals(tercerJugador, segundoJugador);
//
// }
//
// @Test
// public void elAdminDeTurnosTerminaLaRondaCuandoAmbosJugadoresPasan(){
//
// // Arrange
// AdminTurnos<String> adminTurnos = new AdminTurnos(jugadores);
// String primerJugador = adminTurnos.getJugadorActual();
//
// // Act
// adminTurnos.jugadorPasaTurno(primerJugador);
// boolean terminoPrimerIntento = adminTurnos.todosPasaronTurno();
//
// adminTurnos.proximoTurno();
// String segundoJugador = adminTurnos.getJugadorActual();
// adminTurnos.jugadorPasaTurno(segundoJugador);
// boolean terminoSegundoIntento = adminTurnos.todosPasaronTurno();
//
//
// // Assert
// assertFalse(terminoPrimerIntento);
// assertTrue(terminoSegundoIntento);
// }
//
// @Test
// public void elAdminDeTurnosPermiteReiniciarLaRonda(){
//
// // Arrange
// AdminTurnos<String> adminTurnos = new AdminTurnos(jugadores);
// String primerJugador = adminTurnos.getJugadorActual();
// adminTurnos.jugadorPasaTurno(primerJugador);
// adminTurnos.proximoTurno();
// String segundoJugador = adminTurnos.getJugadorActual();
// adminTurnos.jugadorPasaTurno(segundoJugador);
// // Act
//
// boolean terminoPrimerIntento = adminTurnos.todosPasaronTurno();
// adminTurnos.reiniciarAdminTurnos();
// boolean terminoSegundoIntento = adminTurnos.todosPasaronTurno();
//
// // Assert
// assertTrue(terminoPrimerIntento);
// assertFalse(terminoSegundoIntento);
//
// }
//
// @Test
// public void
// devuelveExcepcionSiVasAlProximoTurnoCuandoTodosLosJugadoresPasaron(){
//
// // Arrange
// AdminTurnos<String> adminTurnos = new AdminTurnos(jugadores);
//
// String primerJugador = adminTurnos.getJugadorActual();
// adminTurnos.jugadorPasaTurno(primerJugador);
//
// adminTurnos.proximoTurno();
//
// String segundoJugador = adminTurnos.getJugadorActual();
// adminTurnos.jugadorPasaTurno(segundoJugador);
// // Act
//
// // Assert
// assertThrows(AdminturnosTodosPasaronDeTurno.class, () -> {
// adminTurnos.proximoTurno();
// });
//
// }
// }
