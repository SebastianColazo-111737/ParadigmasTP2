package edu.fiuba.algo3.modeloTest.Juego;

import edu.fiuba.algo3.modelo.cartas.Unidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Seccion;
import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JuegoTest {

//    private List<ICarta> cartasJ1;
//    private List<ICarta> cartasJ2;
//    private Jugador jugador1;
//    private Jugador jugador2;
//    private Juego juego;
//
//    @BeforeEach
//    void setUp() {
//        cartasJ1 = new ArrayList<>();
//        cartasJ2 = new ArrayList<>();
//
//        for (int i = 0; i < 21; i++) {
//            cartasJ1.add(new Unidad("Catapulta", 8, new Asedio())); //algun metodos que cree el mazo?
//            cartasJ2.add(new Unidad("Catapulta", 8, new Asedio()));
//        }
//
//        jugador1 = new Jugador("Jugador1");
//        jugador2 = new Jugador("Jugador2");
//        juego = new Juego(jugador1, jugador2);
//    }
//
//    @Test
//    public void alRepartirCartasLosJugadoresPasanATener10CartasEnLaMano(){
//        // Arrange
//        jugador1.agregarCartasAlMazo(cartasJ1);
//        jugador2.agregarCartasAlMazo(cartasJ2);
//
//        // Act
//        int cantidadDeCartasInicialEnLaManoJ1 = jugador1.getCantidadCartasMano();
//        int cantidadDeCartasInicialEnLaManoJ2 = jugador2.getCantidadCartasMano();
//        juego.repartirCartasALosJugadores();
//        int cantidadDeCartasFinalEnLaManoJ1 = jugador1.getCantidadCartasMano();
//        int cantidadDeCartasFinalEnLaManoJ2 = jugador2.getCantidadCartasMano();
//
//        // Assert
//        assertEquals(0, cantidadDeCartasInicialEnLaManoJ1);
//        assertEquals(0, cantidadDeCartasInicialEnLaManoJ2);
//        assertEquals(10, cantidadDeCartasFinalEnLaManoJ1);
//        assertEquals(10, cantidadDeCartasFinalEnLaManoJ2);
//
//    }
//
//
//    @Test
//    public void unJugadortieneUnPuntajeParcialLuegoDeJugarUnaUnidad(){
//
//        // Arrange
//        List<ICarta> cartasDelMazoJugador1 = new ArrayList<>();
//        ICarta carta1 =  new Unidad("Catapulta", 8, new Asedio());
//        ICarta carta2 =  new Unidad("Guerrero", 4, new CuerpoACuerpo());
//        cartasDelMazoJugador1.add(carta1);
//        cartasDelMazoJugador1.add(carta2);
//        jugador1.agregarCartasAlMazo(cartasDelMazoJugador1);
//        jugador1.robarCartas(2);
//
//        // Act
//        juego.jugarCarta(jugador1, carta1, new Asedio());
//        juego.jugarCarta(jugador1, carta2, new CuerpoACuerpo());
//        int puntajeJugador = juego.calcularPuntaje(jugador1);
//        // Assert
//        assertEquals(12, puntajeJugador);
//
//    }

}
