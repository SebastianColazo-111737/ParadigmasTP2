package edu.fiuba.algo3.modeloTest.CartasTest;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.cartas.unidades.Espia;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Juego.Tablero.Seccion;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EspiaTest {

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
    public void unEspiaAlJugarseSePosicionaEnLaSeccionDelOtroJugadorYElJugadorQueLoJugoRoba2Cartas(){

        // Arrange
        Espia agente007 = new Espia("agente007", 2, new CuerpoACuerpo());
        jugador1.agregarCartasAlMazo(List.of(agente007));
        jugador1.robarCartas(1);

        UnidadBasica cartaCualquiera1 = new UnidadBasica("id1", 10, new CuerpoACuerpo());
        UnidadBasica cartaCualquiera2 = new UnidadBasica("id2", 1, new CuerpoACuerpo());
        jugador1.agregarCartasAlMazo(List.of(cartaCualquiera1, cartaCualquiera2));

        // Act
        int cantidadDeCartasEnLaManoInicial = jugador1.getCantidadCartasMano();
        juego.jugarCarta(jugador1, agente007, new CuerpoACuerpo());
        Seccion seccionCuerpoACuerpoJ2 = juego.getAtril(jugador2).getSeccion(new CuerpoACuerpo());
        int cantidadDeCartasEnLaManofinal = jugador1.getCantidadCartasMano();


        // Assert
        assertEquals(1, cantidadDeCartasEnLaManoInicial);
        assertEquals(1, seccionCuerpoACuerpoJ2.getUnidadesColocadas().size());
        assertTrue(seccionCuerpoACuerpoJ2.getUnidadesColocadas().contains(agente007));
        assertEquals(2, cantidadDeCartasEnLaManofinal);

    }
}
