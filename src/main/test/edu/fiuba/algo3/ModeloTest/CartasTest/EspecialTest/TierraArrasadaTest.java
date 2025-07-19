package edu.fiuba.algo3.ModeloTest.CartasTest.EspecialTest;

import edu.fiuba.algo3.modelo.carta.Especial.TierraArrasada;
import edu.fiuba.algo3.modelo.carta.unidad.UnidadBasica;
import edu.fiuba.algo3.modelo.carta.unidad.modificadores.Legendaria;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mano;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mazo;
import edu.fiuba.algo3.modelo.posicion.Asedio;
import edu.fiuba.algo3.modelo.posicion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posicion.Distancia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class TierraArrasadaTest {

    private Jugador jugador;
    private Jugador oponente;


    private Atril atrilOponente;
    private Seccion cuerpoACuerpoOponente;
    private Seccion distanciaOponente;
    private Seccion asedioOponente;


    @BeforeEach
    void setUp() {

        atrilOponente = new Atril();
        cuerpoACuerpoOponente = new Seccion(new CuerpoACuerpo());
        distanciaOponente = new Seccion(new Distancia());
        asedioOponente = new Seccion(new Asedio());

        atrilOponente.agregarSeccion(cuerpoACuerpoOponente);
        atrilOponente.agregarSeccion(distanciaOponente);
        atrilOponente.agregarSeccion(asedioOponente);

        jugador = new Jugador(new Mazo(), new Mano(), new Atril());
        oponente = new Jugador(new Mazo(), new Mano(), atrilOponente);
    }

    @Test
    public void alJugarUnaCartaDeTierraArrasadaSeEliminaLasCartasDeMasPuntajeDelOponente(){

        // Arrange
        UnidadBasica unidad1 = new UnidadBasica(
                "Unidad1",
                new Puntaje(8),
                new CuerpoACuerpo()
        );
        cuerpoACuerpoOponente.colocarUnidad(unidad1);

        UnidadBasica unidad2 = new UnidadBasica(
                "Unidad2",
                new Puntaje(6),
                new Distancia()
        );
        distanciaOponente.colocarUnidad(unidad2);

        UnidadBasica unidadDeMaxPuntaje = new UnidadBasica(
                "Unidad2",
                new Puntaje(10),
                new Asedio()
        );
        asedioOponente.colocarUnidad(unidadDeMaxPuntaje);


        TierraArrasada quemar = new TierraArrasada("quemar");

        // Act
        quemar.jugarCarta(jugador, oponente, new CuerpoACuerpo());

        // Assert
        assertTrue(cuerpoACuerpoOponente.getUnidadesColocadas().contains(unidad1));
        assertTrue(distanciaOponente.getUnidadesColocadas().contains(unidad2));
        assertFalse(asedioOponente.getUnidadesColocadas().contains(unidadDeMaxPuntaje));

    }

    @Test
    public void alJugarUnaCartaDeTierraArrasadaIgnoraLasUnidadesLegendarias(){

        // Arrange
        UnidadBasica unidadDeMaxPuntajeNoLegendaria = new UnidadBasica(
                "Unidad1",
                new Puntaje(8),
                new CuerpoACuerpo()
        );
        cuerpoACuerpoOponente.colocarUnidad(unidadDeMaxPuntajeNoLegendaria);

        UnidadBasica unidad = new UnidadBasica(
                "Unidad",
                new Puntaje(6),
                new Distancia()
        );
        distanciaOponente.colocarUnidad(unidad);

        UnidadBasica unidadDeMaxPuntaje = new UnidadBasica(
                "Unidad2",
                new Puntaje(10),
                new Asedio()
        );

        Legendaria unidadDeMaxPuntajeLegendaria = new Legendaria(unidadDeMaxPuntaje);
        asedioOponente.colocarUnidad(unidadDeMaxPuntajeLegendaria);


        TierraArrasada quemar = new TierraArrasada("quemar");

        // Act
        quemar.jugarCarta(jugador, oponente, new CuerpoACuerpo());

        // Assert
        assertTrue(asedioOponente.getUnidadesColocadas().contains(unidadDeMaxPuntajeLegendaria));
        assertFalse(cuerpoACuerpoOponente.getUnidadesColocadas().contains(unidadDeMaxPuntajeNoLegendaria));

    }
}
