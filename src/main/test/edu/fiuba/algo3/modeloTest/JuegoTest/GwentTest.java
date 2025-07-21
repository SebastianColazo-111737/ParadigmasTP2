// package edu.fiuba.algo3.modeloTest.JuegoTest;
//
// import edu.fiuba.algo3.modelo.cartas.ICarta;
// import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;
// import edu.fiuba.algo3.modelo.juego.Gwent;
// import edu.fiuba.algo3.modelo.jugador.Jugador;
//
// import edu.fiuba.algo3.modelo.jugador.Mano;
// import edu.fiuba.algo3.modelo.jugador.Mazo;
// import edu.fiuba.algo3.modelo.jugador.Puntaje;
// import edu.fiuba.algo3.modelo.jugador.atril.Atril;
// import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
// import edu.fiuba.algo3.modelo.posiciones.Asedio;
// import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
// import edu.fiuba.algo3.modelo.posiciones.Distancia;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
//
// import java.util.ArrayList;
// import java.util.List;
//
// import static org.junit.Assert.*;
//
// public class GwentTest {
//
// private Jugador jugador1;
// private Mazo mazoJ1;
// private Mano manoJ1;
// private Atril atrilJ1;
// private Seccion cuerpoACuerpoJ1;
// private Seccion distanciaJ1;
// private Seccion asedioJ1;
//
// private Jugador jugador2;
// private Mazo mazoJ2;
// private Mano manoJ2;
// private Atril atrilJ2;
// private Seccion cuerpoACuerpoJ2;
// private Seccion distanciaJ2;
// private Seccion asedioJ2;
//
// private Gwent juego;
//
// @BeforeEach
// void setUp() {
//
// List<ICarta> cartasJ1 = new ArrayList<>();
// List<ICarta> cartasJ2 = new ArrayList<>();
//
// for (int i = 0; i < 21; i++) {
// cartasJ1.add(new UnidadBasica("CatapultaJ1", new Puntaje(8), new Asedio()));
// cartasJ2.add(new UnidadBasica("CatapultaJ2", new Puntaje(8), new Asedio()));
// }
//
// // setUpJugador1
// mazoJ1 = new Mazo();
// mazoJ1.agregarCarta(cartasJ1);
//
// manoJ1 = new Mano();
//
// atrilJ1 = new Atril();
// cuerpoACuerpoJ1 = new Seccion(new CuerpoACuerpo());
// distanciaJ1 = new Seccion(new Distancia());
// asedioJ1 = new Seccion(new Asedio());
// atrilJ1.agregarSeccion(cuerpoACuerpoJ1);
// atrilJ1.agregarSeccion(distanciaJ1);
// atrilJ1.agregarSeccion(asedioJ1);
//
// jugador1 = new Jugador(mazoJ1, manoJ1, atrilJ1);
//
// // setUpJugador2
// mazoJ2 = new Mazo();
// mazoJ2.agregarCarta(cartasJ2);
//
// manoJ2 = new Mano();
//
// atrilJ2 = new Atril();
// cuerpoACuerpoJ2 = new Seccion(new CuerpoACuerpo());
// distanciaJ2 = new Seccion(new Distancia());
// asedioJ2 = new Seccion(new Asedio());
// atrilJ2.agregarSeccion(cuerpoACuerpoJ2);
// atrilJ2.agregarSeccion(distanciaJ2);
// atrilJ2.agregarSeccion(asedioJ2);
//
// jugador2 = new Jugador(mazoJ2, manoJ2, atrilJ2);
//
// juego = new Gwent(jugador1, jugador2);
// }
//
// @Test
// public void alRepartirCartasLosJugadoresPasanATener10CartasEnLaMano() {
// // Arrange
// int cantidadDeCartasInicialEnElMazoJ1 = mazoJ1.getCantidadCartas();
// int cantidadDeCartasInicialEnLaManoJ1 = manoJ1.getCantidadCartas();
//
// int cantidadDeCartasInicialEnElMazoJ2 = mazoJ2.getCantidadCartas();
// int cantidadDeCartasInicialEnLaManoJ2 = manoJ2.getCantidadCartas();
// // Act
//
// juego.repartirCartasALosJugadores();
//
// // Assert
// assertEquals(21, cantidadDeCartasInicialEnElMazoJ1);
// assertEquals(0, cantidadDeCartasInicialEnLaManoJ1);
// assertEquals(11, mazoJ1.getCantidadCartas());
// assertEquals(10, manoJ1.getCantidadCartas());
//
// assertEquals(21, cantidadDeCartasInicialEnElMazoJ2);
// assertEquals(0, cantidadDeCartasInicialEnLaManoJ2);
// assertEquals(11, mazoJ2.getCantidadCartas());
// assertEquals(10, manoJ2.getCantidadCartas());
//
// }
//
// @Test
// public void sePuedeSetearElJugadorActualParaQueNoSeaElJugadorPorDefecto() {
//
// // Arrange
// Jugador jugadorPorDefecto = juego.getJugadorActual();
// Jugador jugadorElegido = jugador2;
//
// // Act
// juego.setJugadorActual(jugadorElegido);
//
// // Assert
// assertNotSame(jugadorPorDefecto, jugador2);
// assertEquals(jugadorElegido, juego.getJugadorActual());
// }
//
// @Test
// public void unJugadorPuedeJugarUnaCartaDeSuManoEnUnaSeccionElegida() {
//
// // Arrange
// juego.repartirCartasALosJugadores();
//
// // En el controlador el usuario deberia elegir la carta del modelo
// // haciendo click en la vista-carta asociada
// ICarta cartaElegida = manoJ1.getCartas().get(0);
//
// // Act
// juego.setJugadorActual(jugador1);
// juego.jugarCarta(cartaElegida, cartaElegida.getTipo().get(0));
//
// // Assert
// assertEquals(9, manoJ1.getCantidadCartas());
// assertFalse(manoJ1.getCartas().contains(cartaElegida)); // el jugador ya no
// tiene la carta en la mano
// assertTrue(asedioJ1.getUnidadesColocadas().contains(cartaElegida)); // la
// Unidad ahora esta en la seccion
//
// }
//
// @Test
// public void unJugadorPuedePasarDeTurnoFinalizandoSuParticipacion() {
//
// // Arrange
// juego.repartirCartasALosJugadores();
//
// ICarta cartaElegida = manoJ2.getCartas().get(0);
//
// // Act
// juego.setJugadorActual(jugador1);
// juego.pasarTurno();
//
// Jugador jugadorSegundoTurno = juego.getJugadorActual();
// juego.jugarCarta(cartaElegida, cartaElegida.getTipo().get(0));
// Jugador jugadorTercerTurno = juego.getJugadorActual();
//
// // Assert
// assertNotSame(jugador1, jugadorSegundoTurno);
// assertNotSame(jugador1, jugadorTercerTurno);
// assertEquals(jugadorSegundoTurno, jugadorTercerTurno);
//
// }
// }
