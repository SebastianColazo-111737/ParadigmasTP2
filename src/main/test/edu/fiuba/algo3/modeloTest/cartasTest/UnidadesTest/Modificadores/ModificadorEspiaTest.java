package edu.fiuba.algo3.modeloTest.cartasTest.UnidadesTest.Modificadores;

import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.cartas.Carta;

import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;

import edu.fiuba.algo3.modelo.cartas.unidades.modificadores.Agil;
import edu.fiuba.algo3.modelo.cartas.unidades.modificadores.Espia;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.posiciones.*;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.tablero.Atril;
import edu.fiuba.algo3.modelo.tablero.Seccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ModificadorEspiaTest {

    private Mazo mazoJugador1;
    private Mano manoJugador1;
    private Jugador jugador1;

    private Jugador jugador2;

    private Tablero tablero;

    private Atril atrilJ2;
    private Seccion cuerpoACuerpoJ2;
    private Seccion distanciaJ2;
    private Seccion asedioJ2;

    private Carta cartaParaRobar1;
    private Carta cartaParaRobar2;

    @BeforeEach
    void setUp() {

        //setUpJugador
        mazoJugador1 = new Mazo();
        manoJugador1 = new Mano();

        jugador1 = new Jugador(mazoJugador1, manoJugador1, new Descarte());

        jugador2 = new Jugador(new Mazo(), new Mano(), new Descarte());

        // setUp tablero
        tablero = new Tablero();

        atrilJ2 = new Atril();
        cuerpoACuerpoJ2 = new Seccion(new CuerpoACuerpo());
        distanciaJ2 = new Seccion(new Distancia());
        asedioJ2 = new Seccion(new Asedio());
        atrilJ2.agregarSeccion(cuerpoACuerpoJ2);
        atrilJ2.agregarSeccion(distanciaJ2);
        atrilJ2.agregarSeccion(asedioJ2);

        tablero.agregarJugador(jugador1, new Atril());
        tablero.agregarJugador(jugador2, atrilJ2);


        cartaParaRobar1 = new Agil(
                new UnidadBasica(
                        "UnidadParaRobar1",
                        new Puntaje(0),
                        new CuerpoACuerpo()),
                new Distancia()
        );

        cartaParaRobar2 = new UnidadBasica(
                "UnidadParaRobar2",
                new Puntaje(0),
                new Distancia()
        );
    }

    @Test
    public void elModificadorEspiaColocaLaUnidadEnElAtrilDelOponenteYLePermiteRobar2CartasAlJugador(){

        // Arrange
        UnidadBasica unidadBasica = new UnidadBasica(
                "Unidad",
                new Puntaje(0),
                new Distancia()
        );

        Espia unidadEspia = new Espia(unidadBasica);

        mazoJugador1.agregarCarta(cartaParaRobar1);
        mazoJugador1.agregarCarta(cartaParaRobar2);

        int cantidadDeCartasEnLaManoInicial = manoJugador1.getCantidadCartas();
        int cantidadDeCartasEnElMazoInicial = mazoJugador1.getCantidadCartas();

        // Act
        unidadEspia.jugarCarta(jugador1, tablero, new Distancia());


        // Assert
        assertEquals(0, cantidadDeCartasEnLaManoInicial);
        assertEquals(2, cantidadDeCartasEnElMazoInicial);

        assertEquals(1, distanciaJ2.getUnidadesColocadas().size());
        assertTrue(distanciaJ2.getUnidadesColocadas().contains(unidadEspia));

        assertEquals(2, manoJugador1.getCantidadCartas());
        assertEquals(0, mazoJugador1.getCantidadCartas());
        assertTrue(manoJugador1.getCartas().contains(cartaParaRobar1));
        assertTrue(manoJugador1.getCartas().contains(cartaParaRobar2));

    }
}
