package edu.fiuba.algo3.ModeloTest.Jugador;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.Especial.Clima;
import edu.fiuba.algo3.modelo.carta.Especial.MoraleBoost;
import edu.fiuba.algo3.modelo.carta.unidad.UnidadBasica;
import edu.fiuba.algo3.modelo.carta.unidad.modificadores.Animador;
import edu.fiuba.algo3.modelo.carta.unidad.modificadores.Legendaria;
import edu.fiuba.algo3.modelo.carta.unidad.modificadores.Unida;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;
import edu.fiuba.algo3.modelo.jugador.Atril.Atril;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mano;
import edu.fiuba.algo3.modelo.carta.coleccionDeCartas.Mazo;
import edu.fiuba.algo3.modelo.posicion.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class JugadorTest {

    private Jugador jugador;
    private Jugador oponente;
    private Mano mano;
    private Mazo mazo;
    private Atril atril;
    private Seccion cuerpoACuerpo;
    private Seccion distancia;
    private Seccion asedio;

    @BeforeEach
    void setUp() {
        mano = new Mano();
        mazo = new Mazo();
        atril = new Atril();
        cuerpoACuerpo = new Seccion(new CuerpoACuerpo());
        distancia = new Seccion(new Distancia());
        asedio = new Seccion(new Asedio());

        atril.agregarSeccion(cuerpoACuerpo);
        atril.agregarSeccion(distancia);
        atril.agregarSeccion(asedio);

        jugador = new Jugador(mazo, mano, atril);

        Atril atrilOponente = new Atril();
        atrilOponente.agregarSeccion(new Seccion(new CuerpoACuerpo()));
        oponente = new Jugador(new Mazo(), new Mano(),atrilOponente);
    }

    @Test
    public void unJugadorPuedeRobarCartasDeSuMazoParaAgreagarlasASuMano(){
        // Arrange
        Carta cartaParaAgregarAlMazo1 = new UnidadBasica("Unidad1", new Puntaje(5), new CuerpoACuerpo());
        Carta cartaParaAgregarAlMazo2 = new UnidadBasica("Unidad2", new Puntaje(4), new Asedio());
        mazo.agregarCarta(cartaParaAgregarAlMazo1);
        mazo.agregarCarta(cartaParaAgregarAlMazo2);
        int cantidadDeCartasEnElMazoInicial = mazo.getCantidadCartas();
        int cantidadDeCartasEnLaManoInicial = mano.getCantidadCartas();
        // Act
        jugador.robarCartasDelMazo(2);

        // Assert
        assertEquals(2, cantidadDeCartasEnElMazoInicial);
        assertEquals(0, cantidadDeCartasEnLaManoInicial);
        assertEquals(0, mazo.getCantidadCartas());
        assertEquals(2, mano.getCantidadCartas());
    }

    @Test
    public void unJugadorPuedeCambiarUnaCartaDeSuManoPorOtraDeSuMazo(){
        // Arrange
        Carta cartaQueEmpiezaEnLaMano = new UnidadBasica("Unidad1", new Puntaje(5), new CuerpoACuerpo());
        mano.agregarCarta(cartaQueEmpiezaEnLaMano);

        Carta cartaQueEmpiezaEnElMazo = new UnidadBasica("Unidad2", new Puntaje(4), new Asedio());
        mazo.agregarCarta(cartaQueEmpiezaEnElMazo);

        int cantidadDeCartasEnElMazoInicial = mazo.getCantidadCartas();
        int cantidadDeCartasEnLaManoInicial = mano.getCantidadCartas();

        // Act
        jugador.cambiarCartaDeLaManoAlMazo(cartaQueEmpiezaEnLaMano);

        // Assert

        assertEquals(cantidadDeCartasEnElMazoInicial, mazo.getCantidadCartas());
        assertTrue(mano.getCartas().contains(cartaQueEmpiezaEnElMazo));
        assertEquals(cantidadDeCartasEnLaManoInicial, mano.getCantidadCartas());
    }

    @Test
    public void unJugadorPuedeJugarUnaUnidadDeSuManoYObtenerUnPuntajeParcial(){
        // Arrange
        Carta unidadParaJugar = new UnidadBasica(
                "Unidad1",
                new Puntaje(5),
                new CuerpoACuerpo()
        );
        mano.agregarCarta(unidadParaJugar);

        // Act
        jugador.jugarCarta(unidadParaJugar, oponente, new CuerpoACuerpo());

        // Assert
        assertEquals(0, mano.getCantidadCartas());
        assertTrue(cuerpoACuerpo.getUnidadesColocadas().contains(unidadParaJugar));
        assertEquals(5, jugador.getPuntaje());


    }

    @Test
    public void unJugadorPuedeJugarDiferentesTiposDeCartasYElPuntajeEsElEsperado(){

        // Arrange
        Carta unidadBasica = new UnidadBasica(
                "Unidad1",
                new Puntaje(5),
                new CuerpoACuerpo()
        );
        mano.agregarCarta(unidadBasica);

        Animador animador = new Animador(
                new UnidadBasica(
                        "animador",
                        new Puntaje(2),
                        new CuerpoACuerpo()
                )
        );
        mano.agregarCarta(animador);

        Legendaria legendaria = new Legendaria(
                new UnidadBasica(
                        "legendaria",
                        new Puntaje(15),
                        new CuerpoACuerpo()
                )
        );
        mano.agregarCarta(legendaria);


        Unida unida1 = new Unida(
                new UnidadBasica(
                        "catapulta",
                        new Puntaje(8),
                        new CuerpoACuerpo()
                )
        );
        mano.agregarCarta(unida1);

        Unida unida2 = new Unida(
                new UnidadBasica(
                        "catapulta",
                        new Puntaje(8),
                        new CuerpoACuerpo()
                )
        );
        mano.agregarCarta(unida2);


        Carta clima = new Clima("Nieve", List.of(new CuerpoACuerpo()));
        mano.agregarCarta(clima);

        Carta moraleBoost = new MoraleBoost("Duplicador");
        mano.agregarCarta(moraleBoost);

        int multiplicador = 2;       //afectado por moraleBost
        int debilitado = 1;          //afectado por clima
        int aumentoAnimador = 1;     //afectado por animador

        int puntajeEsperado1 =
                        15 +
                        ((8 + aumentoAnimador) * 2) +
                        ((8 + aumentoAnimador) * 2) +
                        (5 + aumentoAnimador) +
                        (2 + aumentoAnimador);

        int puntajeEsperado2 =
                        15 +                                                     //legendaria
                        ((debilitado + aumentoAnimador) * multiplicador * 2 ) +  //CartaUnida1
                        ((debilitado + aumentoAnimador) * multiplicador * 2 ) +  //CartaUnida2
                        ((debilitado + aumentoAnimador) * multiplicador) +       //UnidadBasica
                        ((debilitado + aumentoAnimador) * multiplicador);        //Animador

        // Act
        jugador.jugarCarta(unidadBasica, oponente, new CuerpoACuerpo());
        jugador.jugarCarta(animador, oponente, new CuerpoACuerpo());
        jugador.jugarCarta(legendaria, oponente, new CuerpoACuerpo());
        jugador.jugarCarta(unida1, oponente, new CuerpoACuerpo());
        jugador.jugarCarta(unida2, oponente, new CuerpoACuerpo());
        int puntajeJugador1 = jugador.getPuntaje();

        jugador.jugarCarta(clima, oponente, new CuerpoACuerpo());
        jugador.jugarCarta(moraleBoost, oponente, new CuerpoACuerpo());
        int puntajeJugador2 = jugador.getPuntaje();

        // Assert
        assertEquals(puntajeEsperado1, puntajeJugador1);
        assertEquals(puntajeEsperado2, puntajeJugador2);

    }
}
