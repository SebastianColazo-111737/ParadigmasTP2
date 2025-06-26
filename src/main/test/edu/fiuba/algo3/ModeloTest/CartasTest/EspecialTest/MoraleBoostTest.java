package edu.fiuba.algo3.ModeloTest.CartasTest.EspecialTest;

import edu.fiuba.algo3.modelo.carta.Especial.MoraleBoost;
import edu.fiuba.algo3.modelo.carta.unidad.UnidadBasica;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.posicion.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class MoraleBoostTest {

    private Jugador jugador;
    private Jugador oponente;

    private Atril atrilJugador;
    private Seccion cuerpoACuerpo;
    private Seccion distancia;
    private Seccion asedio;


    @BeforeEach
    void setUp() {


        atrilJugador = new Atril();
        cuerpoACuerpo = new Seccion(new CuerpoACuerpo());
        distancia = new Seccion(new Distancia());
        asedio = new Seccion(new Asedio());
        atrilJugador.agregarSeccion(cuerpoACuerpo);
        atrilJugador.agregarSeccion(distancia);
        atrilJugador.agregarSeccion(asedio);


        jugador = new Jugador(new Mazo(), new Mano(), atrilJugador);
        oponente = new Jugador(new Mazo(), new Mano(), new Atril());
    }

    @Test
    public void alJugarUnaCartaDeMoraleBoostEnUnaPosicionLaSeccionDeEsaPosicionDelJugadorDuplicaLosPuntajesBases(){
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
        cuerpoACuerpo.colocarUnidad(unidad1);
        cuerpoACuerpo.colocarUnidad(unidad2);



        MoraleBoost moraleBoost = new MoraleBoost("Especial");


        int puntajeInicial = cuerpoACuerpo.getPuntaje();
        int puntajeEsperado = 4 * 2 + 6 * 2;
        // Act

        moraleBoost.jugarCarta(jugador, oponente, new CuerpoACuerpo());

        // Assert
        assertEquals(4 + 6, puntajeInicial);
        assertEquals(puntajeEsperado, cuerpoACuerpo.getPuntaje());

    }
}
