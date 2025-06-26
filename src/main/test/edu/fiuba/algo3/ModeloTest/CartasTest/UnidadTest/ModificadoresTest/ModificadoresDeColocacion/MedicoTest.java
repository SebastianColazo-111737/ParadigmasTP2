package edu.fiuba.algo3.ModeloTest.CartasTest.UnidadTest.ModificadoresTest.ModificadoresDeColocacion;

import edu.fiuba.algo3.modelo.carta.unidad.UnidadBasica;
import edu.fiuba.algo3.modelo.carta.unidad.modificadores.Medico;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.posicion.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MedicoTest {

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
    public void elModificadorMedicoPermiteJugarUnaSegundaUnidadAlSerJugada(){

        // Arrange
        UnidadBasica unidadParaRevirir = new UnidadBasica(
                "unidadBasica",
                new Puntaje(5),
                new CuerpoACuerpo()
        );

        Posicion posicionParaRevivir = new CuerpoACuerpo();

        Medico medico = new Medico(
                new UnidadBasica(
                        "medico",
                        new Puntaje(2),
                        new Distancia()
                ),
                unidadParaRevirir,
                posicionParaRevivir
        );

        // Act
        medico.jugarCarta(jugador, oponente, new Distancia());

        // Assert
        assertEquals(1, cuerpoACuerpo.getUnidadesColocadas().size());
        assertEquals(1, distancia.getUnidadesColocadas().size());
        assertTrue(cuerpoACuerpo.getUnidadesColocadas().contains(unidadParaRevirir));
        assertTrue(distancia.getUnidadesColocadas().contains(medico));
    }
}
