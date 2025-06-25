package edu.fiuba.algo3.modeloTest.cartasTest.UnidadesTest.Modificadores;

import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;
import edu.fiuba.algo3.modelo.cartas.unidades.modificadores.Medico;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.posiciones.*;
import edu.fiuba.algo3.modelo.tablero.Tablero;
import edu.fiuba.algo3.modelo.tablero.Atril;
import edu.fiuba.algo3.modelo.tablero.Seccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ModificadorMedicoTest {

    private Jugador jugador;

    private Tablero tablero;

    private Atril atril;
    private Seccion cuerpoACuerpo;
    private Seccion distancia;
    private Seccion asedio;


    @BeforeEach
    void setUp() {

        //setUpJugador
        jugador = new Jugador(new Mazo(), new Mano(), new Descarte());

        // setUp tablero
        tablero = new Tablero();

        atril = new Atril();
        cuerpoACuerpo = new Seccion(new CuerpoACuerpo());
        distancia = new Seccion(new Distancia());
        asedio = new Seccion(new Asedio());
        atril.agregarSeccion(cuerpoACuerpo);
        atril.agregarSeccion(distancia);
        atril.agregarSeccion(asedio);

        tablero.agregarJugador(jugador, atril);

    }

    @Test
    public void elModificadorMedicoPermiteJugarUnaSegundaUnidadAlSerJugada(){

        // Arrange
        UnidadBasica unidadParaRevirir = new UnidadBasica(
                "unidadBasica",
                new Puntaje(5),
                new CuerpoACuerpo()
        );

        UnidadBasica unidadBasica = new UnidadBasica(
                "medico",
                new Puntaje(2),
                new Distancia()
        );

        Medico medico = new Medico(
                unidadBasica,
                unidadParaRevirir,
                new CuerpoACuerpo()
        );

        // Act
        medico.jugarCarta(jugador, tablero, new Distancia());

        // Assert
        assertEquals(1, cuerpoACuerpo.getUnidadesColocadas().size());
        assertEquals(1, distancia.getUnidadesColocadas().size());
        assertTrue(cuerpoACuerpo.getUnidadesColocadas().contains(unidadParaRevirir));
        assertTrue(distancia.getUnidadesColocadas().contains(medico));
    }
}
