package edu.fiuba.algo3.modeloTest.CartasTest;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.cartas.unidades.Espia;
import edu.fiuba.algo3.modelo.cartas.unidades.Medico;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Juego.Tablero.Seccion;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MedicoTest {

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
    public void alJugarseUnMedicoSeColocanEnElJuegoElMedicoYLaUnidadSeteadaParaRevivir(){

        // Arrange
        Medico medico = new Medico("DrHouse",2,new Distancia());
        UnidadBasica unidadBasica = new UnidadBasica("Pepe", 4, new CuerpoACuerpo());
        medico.setUnidadParaRevivir(unidadBasica, new CuerpoACuerpo());
        jugador1.agregarCartasAlMazo(List.of(medico));
        jugador1.robarCartas(1);

        // Act
        juego.jugarCarta(jugador1, medico, new Distancia());

        // Assert

        Seccion seccionCuerpoACuerpoJ1 = juego.getAtril(jugador1).getSeccion(new CuerpoACuerpo());
        Seccion seccionDistanciaJ1 = juego.getAtril(jugador1).getSeccion(new Distancia());

        assertEquals(1, seccionCuerpoACuerpoJ1.getUnidadesColocadas().size());
        assertEquals(1, seccionDistanciaJ1.getUnidadesColocadas().size());
        assertTrue(seccionCuerpoACuerpoJ1.getUnidadesColocadas().contains(unidadBasica));
        assertTrue(seccionDistanciaJ1.getUnidadesColocadas().contains(medico));
    }

    @Test
    public void unMedicoReviveUnaCartaDeEspiaYSeJuegaEnLaSeccionDelOtroJugadorYRoba2Cartas(){

        // Arrange
        Medico medico = new Medico("DrHouse",2,new Distancia());
        Espia espia007 = new Espia("espia007", 10, new CuerpoACuerpo());
        medico.setUnidadParaRevivir(espia007, new CuerpoACuerpo());

        jugador1.agregarCartasAlMazo(List.of(medico));
        jugador1.robarCartas(1);



        UnidadBasica cartaCualquiera1 = new UnidadBasica("id1", 10, new CuerpoACuerpo());
        UnidadBasica cartaCualquiera2 = new UnidadBasica("id2", 1, new CuerpoACuerpo());
        jugador1.agregarCartasAlMazo(List.of(cartaCualquiera1, cartaCualquiera2));

        // Act
        int cantidadDeCartasEnLaManoInicial = jugador1.getCantidadCartasMano();
        juego.jugarCarta(jugador1, medico, new Distancia());

        int cantidadDeCartasEnLaManoFinal = jugador1.getCantidadCartasMano();
        // Assert

        Seccion seccionCuerpoACuerpoJ2 = juego.getAtril(jugador2).getSeccion(new CuerpoACuerpo());
        Seccion seccionDistanciaJ1 = juego.getAtril(jugador1).getSeccion(new Distancia());


        assertEquals(1, cantidadDeCartasEnLaManoInicial);
        assertEquals(1, seccionCuerpoACuerpoJ2.getUnidadesColocadas().size());
        assertEquals(1, seccionDistanciaJ1.getUnidadesColocadas().size());
        assertTrue(seccionCuerpoACuerpoJ2.getUnidadesColocadas().contains(espia007));
        assertTrue(seccionDistanciaJ1.getUnidadesColocadas().contains(medico));
        assertEquals(2, cantidadDeCartasEnLaManoFinal);

    }
}
