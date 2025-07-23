package edu.fiuba.algo3.ModeloTest.CartasTest.UnidadTest.ModificadoresTest.ModificadoresMesclados;

import edu.fiuba.algo3.modelo.carta.unidad.UnidadFactory;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mano;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mazo;
import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.carta.unidad.UnidadBasica;

import edu.fiuba.algo3.modelo.carta.unidad.modificadores.*;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.EfectoBoost;

import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Atril.Descarte;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import edu.fiuba.algo3.modelo.posicion.CuerpoACuerpo;

import edu.fiuba.algo3.modelo.posicion.Distancia;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CombinacionesTest {

    private Jugador jugador;
    private Mazo mazoJugador1;
    private Mano manoJugador1;

    private Jugador oponente;

    private Atril atrilJugador;
    private Seccion seccionJugador;

    private Atril atrilOponente;
    private Seccion seccionOponente;



    @BeforeEach
    void setUp() {

        atrilJugador = new Atril();
        seccionJugador = new Seccion(new CuerpoACuerpo());
        atrilJugador.agregarSeccion(seccionJugador);

        atrilOponente = new Atril();
        seccionOponente = new Seccion(new CuerpoACuerpo());
        atrilOponente.agregarSeccion(seccionOponente);

        mazoJugador1 = new Mazo();
        manoJugador1 = new Mano();
        jugador = new Jugador(mazoJugador1, manoJugador1, atrilJugador);

        oponente = new Jugador(new Mazo(), new Mano(), atrilOponente);
    }

    @Test
    public void seLePuedeAgregarAUnaUnidadLosModificadoresDeLegendariaYEspia(){

        // Arrange
        List<String> modificadores = new ArrayList<>();
        modificadores.add("Legendaria");
        modificadores.add("Espia");
        List<String> posiciones = new ArrayList<>();
        posiciones.add("cuerpo a cuerpo");

        Unidad legendariaYEspia = UnidadFactory.crear("cartaCombinada", 2, modificadores, posiciones);


        seccionOponente.agregarEfecto(new EfectoBoost(10));

        // Act
        legendariaYEspia.jugarCarta(jugador, oponente, new CuerpoACuerpo());

        // Assert
        assertTrue(seccionOponente.getUnidadesColocadas().contains(legendariaYEspia));
        assertEquals(2, seccionOponente.getPuntaje());

    }

    @Test
    public void seLePuedeAgregarAUnaUnidadLosModificadoresDeUnidaYAnimadorOUnidaYLegendaria(){

        // Arrange
        List<String> posiciones = new ArrayList<>();
        posiciones.add("cuerpo a cuerpo");

        List<String> modificadores1 = new ArrayList<>();
        modificadores1.add("Carta unida");
        modificadores1.add("impulso de moral");

        List<String> modificadores2 = new ArrayList<>();
        modificadores2.add("Carta unida");
        modificadores2.add("legendaria");

        Unidad unidaYAnimador = UnidadFactory.crear("cartaCombinada", 8, modificadores1, posiciones);
        Unidad unidaYLegendaria = UnidadFactory.crear("cartaCombinada", 8, modificadores2, posiciones);



        // Act
        unidaYAnimador.jugarCarta(jugador, oponente, new CuerpoACuerpo());
        unidaYLegendaria.jugarCarta(jugador, oponente, new CuerpoACuerpo());

        int puntajeEsperado =
                        (8 + 1) * 2 +  //unidaYAnimador
                        8;             //unidaYLegendaria

        // Assert
        assertTrue(seccionJugador.getUnidadesColocadas().contains(unidaYAnimador));
        assertTrue(seccionJugador.getUnidadesColocadas().contains(unidaYLegendaria));
        assertEquals(puntajeEsperado, seccionJugador.getPuntaje());

    }

    @Test
    public void seLePuedeAgregarAUnaUnidadLosModificadoresDeAgilMedicoYLegendaria(){

        // Arrange
        Unidad unidadParaRevirir = new UnidadBasica(
                "unidadBasica",
                new Puntaje(5),
                new CuerpoACuerpo()
        );
        Unidad unidadParaRevivirModificada = new Animador(unidadParaRevirir);
        Descarte descarte = atrilJugador.getDescarte();
        descarte.descartarUnidad(unidadParaRevivirModificada);

        Unidad medico = new Medico(
                new UnidadBasica(
                        "medico",
                        new Puntaje(2),
                        new Distancia()
                )
        );

        Unidad medicoAgil = new Agil(medico, new CuerpoACuerpo());
        Unidad medicoAgilYLegendaria = new Legendaria(medicoAgil);

        // Act
        medicoAgilYLegendaria.jugarCarta(jugador, oponente, new CuerpoACuerpo());

        int puntajeEsperado =
                            (5 + 1) +          //unidadRevividaYAnimador
                             2;                //medicoAgilYLegendaria

        // Assert
        assertTrue(seccionJugador.getUnidadesColocadas().contains(medicoAgilYLegendaria));
        assertTrue(seccionJugador.getUnidadesColocadas().contains(unidadParaRevivirModificada));
        assertEquals(puntajeEsperado, seccionJugador.getPuntaje());
    }
}
