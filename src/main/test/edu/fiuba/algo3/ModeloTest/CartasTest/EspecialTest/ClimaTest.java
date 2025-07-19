package edu.fiuba.algo3.ModeloTest.CartasTest.EspecialTest;

import edu.fiuba.algo3.modelo.carta.Especial.Clima;
import edu.fiuba.algo3.modelo.carta.Especial.ClimaSoleado;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mano;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mazo;
import edu.fiuba.algo3.modelo.carta.unidad.UnidadBasica;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.posicion.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClimaTest {

    private Jugador jugador;
    private Jugador oponente;

    private Atril atrilJugador;
    private Seccion cuerpoACuerpoJugador;

    private Atril atrilOponente;
    private Seccion cuerpoACuerpoOponente;

    @BeforeEach
    void setUp() {

        atrilJugador = new Atril();
        cuerpoACuerpoJugador = new Seccion(new CuerpoACuerpo());
        atrilJugador.agregarSeccion(cuerpoACuerpoJugador);

        atrilOponente = new Atril();
        cuerpoACuerpoOponente = new Seccion(new CuerpoACuerpo());
        atrilOponente.agregarSeccion(cuerpoACuerpoOponente);

        jugador = new Jugador(new Mazo(), new Mano(), atrilJugador);
        oponente = new Jugador(new Mazo(), new Mano(), atrilOponente);
    }


    @Test
    public void alJugarUnaCartaDeClimaLasSeccionesConLaPosicionAfectadaReducenElPuntajeBaseDeSusUnidadesA1(){
        // Arrange
        UnidadBasica unidad1 = new UnidadBasica(
                "Unidad1",
                new Puntaje(4),
                new CuerpoACuerpo()
        );

        UnidadBasica unidad2 = new UnidadBasica(
                "Unidad2",
                new Puntaje(6),
                new CuerpoACuerpo()
        );

        cuerpoACuerpoJugador.colocarUnidad(unidad1);
        cuerpoACuerpoOponente.colocarUnidad(unidad2);

        List<Posicion> posicionesAfectadas = new ArrayList<>();
        posicionesAfectadas.add(new CuerpoACuerpo());
        Clima clima = new Clima("Nieve", posicionesAfectadas);


        int puntajeInicialJugador = cuerpoACuerpoJugador.getPuntaje();
        int puntajeInicialOponente = cuerpoACuerpoOponente.getPuntaje();

        int puntajeEsperadoJugador = 1;
        int puntajeEsperadoOponente = 1;

        // Act

        clima.jugarCarta(jugador, oponente, new CuerpoACuerpo());

        // Assert
        assertEquals(4 , puntajeInicialJugador);
        assertEquals(6 , puntajeInicialOponente);

        assertEquals(puntajeEsperadoJugador, cuerpoACuerpoJugador.getPuntaje());
        assertEquals(puntajeEsperadoOponente, cuerpoACuerpoOponente.getPuntaje());

    }

    @Test
    public void alJugarUnaCartaDeClimaSoleadoLosClimasQueAfectanAlasSeccionesDeLosJugadoresSeDesactivan(){
        // Arrange
        UnidadBasica unidad1 = new UnidadBasica(
                "Unidad1",
                new Puntaje(4),
                new CuerpoACuerpo()
        );

        UnidadBasica unidad2 = new UnidadBasica(
                "Unidad2",
                new Puntaje(6),
                new CuerpoACuerpo()
        );

        cuerpoACuerpoJugador.colocarUnidad(unidad1);
        cuerpoACuerpoOponente.colocarUnidad(unidad2);

        List<Posicion> posicionesAfectadas1 = new ArrayList<>();
        posicionesAfectadas1.add(new CuerpoACuerpo());
        Clima clima = new Clima("Nieve", posicionesAfectadas1);

        List<Posicion> posicionesAfectadas2 = new ArrayList<>();
        posicionesAfectadas2.add(new CuerpoACuerpo());
        ClimaSoleado soleado = new ClimaSoleado("Sol", posicionesAfectadas2);

        int puntajeSinClimaJugador = cuerpoACuerpoJugador.getPuntaje();
        int puntajeSinClimaOponente = cuerpoACuerpoOponente.getPuntaje();



        // Act
        clima.jugarCarta(jugador, oponente, new CuerpoACuerpo()); // activo un cima
        soleado.jugarCarta(jugador, oponente, new CuerpoACuerpo());

        // Assert
        assertEquals(puntajeSinClimaJugador, cuerpoACuerpoJugador.getPuntaje());
        assertEquals(puntajeSinClimaOponente, cuerpoACuerpoOponente.getPuntaje());

    }
}
