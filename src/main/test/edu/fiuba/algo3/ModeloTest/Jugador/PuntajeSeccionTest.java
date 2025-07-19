package edu.fiuba.algo3.ModeloTest.Jugador;


import edu.fiuba.algo3.modelo.carta.unidad.UnidadBasica;
import edu.fiuba.algo3.modelo.carta.unidad.modificadores.Animador;
import edu.fiuba.algo3.modelo.carta.unidad.modificadores.Legendaria;
import edu.fiuba.algo3.modelo.carta.unidad.modificadores.Unida;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.EfectoAumentar;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.posicion.*;


import edu.fiuba.algo3.modelo.carta.unidad.puntaje.EfectoBoost;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.EfectoDebilitar;
import edu.fiuba.algo3.modelo.carta.unidad.puntaje.Puntaje;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


public class PuntajeSeccionTest {

    @Test
    public void unaSeccionSinUnidadesTieneUnPuntajeDe0(){

        // Arrange
        Seccion seccion = new Seccion(new CuerpoACuerpo());

        // Act
        int puntajeSeccion = seccion.getPuntaje();

        // Assert
        assertEquals(0, puntajeSeccion);

    }

    @Test
    public void unaSeccionConUnidadesBasicasTieneUnPuntajeIgualALaSumaDeSusPuntajesBase(){

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

        Seccion seccion = new Seccion(new CuerpoACuerpo());

        seccion.colocarUnidad(unidad1);
        seccion.colocarUnidad(unidad2);

        // Act
        int puntajeSeccion = seccion.getPuntaje();
        // Assert
        assertEquals(10, puntajeSeccion);
    }


    @Test
    public void unaSeccionConUnidadesUnidasTieneUnPuntajeMultiplicado(){

        // Arrange
        UnidadBasica unidadBasica = new UnidadBasica(
                "Unidad1",
                new Puntaje(4),
                new Asedio()
        );

        UnidadBasica catapulta1 = new UnidadBasica(
                "catapulta",
                new Puntaje(8),
                new Asedio()
        );

        Unida unidadUnida1 = new Unida(catapulta1);

        UnidadBasica catapulta2 = new UnidadBasica(
                "catapulta",
                new Puntaje(8),
                new Asedio()
        );
        Unida unidadUnida2 = new Unida(catapulta2);

        UnidadBasica catapulta3 = new UnidadBasica(
                "catapulta",
                new Puntaje(8),
                new Asedio()
        );
        Unida unidadUnida3 = new Unida(catapulta3);

        Seccion seccion = new Seccion(new Asedio());

        seccion.colocarUnidad(unidadBasica);
        seccion.colocarUnidad(unidadUnida1);
        seccion.colocarUnidad(unidadUnida2);
        seccion.colocarUnidad(unidadUnida3);

        int puntajeEsperado = 4 + 8 * 3 + 8 * 3 + 8 * 3; // representa puntaje de cada carta
        // Act
        int puntajeSeccion = seccion.getPuntaje();

        // Assert
        assertEquals(puntajeEsperado, puntajeSeccion);
    }

    @Test
    public void unaSeccionConUnidadesBasicasYUnAnimadorLeAumentaSuPuntajeEn1ACadaUnidad(){
        // Arrange
        UnidadBasica unidadBasica1 = new UnidadBasica(
                "Unidad1",
                new Puntaje(4),
                new Distancia()
        );

        UnidadBasica unidadBasica2 = new UnidadBasica(
                "Unidad2",
                new Puntaje(6),
                new Distancia()
        );


        Animador animador = new Animador(
                new UnidadBasica(
                        "animador",
                        new Puntaje(2),
                        new Distancia()
                )
        );

        Seccion seccion = new Seccion(new Distancia());

        seccion.colocarUnidad(unidadBasica1);
        seccion.colocarUnidad(unidadBasica2);
        seccion.colocarUnidad(animador);

        int aumentoAnimador = 1;
        seccion.agregarEfecto(new EfectoAumentar(aumentoAnimador));

        int puntajeEsperado = (4 + aumentoAnimador) + (6 + aumentoAnimador) + (2 + aumentoAnimador);

        // Act
        int puntajeSeccion = seccion.getPuntaje();

        // Assert
        assertEquals(puntajeEsperado, puntajeSeccion);
    }

    @Test
    public void unaSeccionConUnidadAnimadoraYUnaLegendariaDevuelveElPuntajeCorrecto(){
        // Arrange
        Legendaria legendaria = new Legendaria(
                new UnidadBasica(
                        "legendaria",
                        new Puntaje(15),
                        new CuerpoACuerpo()
                )
        );

        Animador animador = new Animador(
                new UnidadBasica(
                        "animador",
                        new Puntaje(2),
                        new CuerpoACuerpo()
                )
        );

        Seccion seccion = new Seccion(new CuerpoACuerpo());

        seccion.colocarUnidad(legendaria);
        seccion.colocarUnidad(animador);
        int aumentoAnimador = 1;
        seccion.agregarEfecto(new EfectoAumentar(aumentoAnimador));

        int puntajeEsperado = 15 + (2 + aumentoAnimador);

        // Act
        int puntajeSeccion = seccion.getPuntaje();

        // Assert
        assertEquals(puntajeEsperado, puntajeSeccion);
    }

    @Test
    public void unaSeccionConUnidadesBasicasYUnEfectoBoostDuplicaElPuntajeBaseDeLasUnidades(){

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

        Seccion seccion = new Seccion(new CuerpoACuerpo());

        seccion.colocarUnidad(unidad1);
        seccion.colocarUnidad(unidad2);
        seccion.agregarEfecto(new EfectoBoost(2));

        // Act
        int puntajeEsperado = 6 * 2 + 4 * 2;
        int puntajeSeccion = seccion.getPuntaje();

        // Assert
        assertEquals(puntajeEsperado, puntajeSeccion);
    }

    @Test
    public void unaSeccionConUnaLegendariaYUnEfectoBoostDevuelveElValorDelPuntajeBaseDeLaLegendaria(){

        // Arrange
        Legendaria legendaria = new Legendaria(
                new UnidadBasica(
                        "legendaria",
                        new Puntaje(15),
                        new CuerpoACuerpo()
                )
        );
        Seccion seccion = new Seccion(new CuerpoACuerpo());
        seccion.colocarUnidad(legendaria);
        seccion.agregarEfecto(new EfectoBoost(2));

        // Act
        int puntajeSeccion = seccion.getPuntaje();

        // Assert
        assertEquals(15, puntajeSeccion);
    }

    @Test
    public void unaSeccionConUnidadesBasicasYUnEfectoDebilitadorReduceElPuntajeBaseDeLasUnidades(){

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

        Seccion seccion = new Seccion(new CuerpoACuerpo());

        seccion.colocarUnidad(unidad1);
        seccion.colocarUnidad(unidad2);
        seccion.agregarEfecto(new EfectoDebilitar());

        // Act
        int puntajeEsperado = 1 + 1;
        int puntajeSeccion = seccion.getPuntaje();

        // Assert
        assertEquals(puntajeEsperado, puntajeSeccion);
    }

    @Test
    public void unaSeccionConUnaLegendariaYUnEfectoDebilitadorDevuelveElValorDelPuntajeBaseDeLaLegendaria(){

        // Arrange
        Legendaria legendaria = new Legendaria(
                new UnidadBasica(
                        "legendaria",
                        new Puntaje(15),
                        new CuerpoACuerpo()
                )
        );
        Seccion seccion = new Seccion(new CuerpoACuerpo());
        seccion.colocarUnidad(legendaria);
        seccion.agregarEfecto(new EfectoDebilitar());

        // Act
        int puntajeSeccion = seccion.getPuntaje();

        // Assert
        assertEquals(15, puntajeSeccion);
    }

    @Test
    public void unaSeccionConVariasUnidadesYEfectosDevuelveElPuntajeEsperado(){

        // Arrange
        UnidadBasica unidadBasica = new UnidadBasica(
                "unidadBasica",
                new Puntaje(5),
                new CuerpoACuerpo()
        );

        Animador animador = new Animador(
                new UnidadBasica(
                        "animador",
                        new Puntaje(2),
                        new CuerpoACuerpo()
                )
        );

        Legendaria legendaria = new Legendaria(
                new UnidadBasica(
                        "legendaria",
                        new Puntaje(15),
                        new CuerpoACuerpo()
                )
        );


        Unida unida1 = new Unida(
                new UnidadBasica(
                        "catapulta",
                        new Puntaje(8),
                        new CuerpoACuerpo()
            )
        );

        Unida unida2 = new Unida(
                new UnidadBasica(
                        "catapulta",
                        new Puntaje(8),
                        new CuerpoACuerpo()
                )
        );

        Seccion seccion = new Seccion(new CuerpoACuerpo());

        seccion.colocarUnidad(legendaria);
        seccion.colocarUnidad(unida1);
        seccion.colocarUnidad(unida2);
        seccion.colocarUnidad(unidadBasica);
        seccion.colocarUnidad(animador);



        int multiplicador = 2;
        int debilitado = 1;
        int aumentoAnimador = 1;

        seccion.agregarEfecto(new EfectoAumentar(aumentoAnimador));
        // Act

        int puntajeEsperado0 = 15 + ((8+aumentoAnimador) * 2) + ((8+aumentoAnimador) * 2) + (5+aumentoAnimador) + (2+aumentoAnimador);
        int puntajeSeccion0 = seccion.getPuntaje();

        seccion.agregarEfecto(new EfectoDebilitar());
        int puntajeEsperado1 = 15 + ((debilitado + aumentoAnimador) * 2 ) + ((debilitado + aumentoAnimador) * 2 ) + (debilitado + aumentoAnimador) + (debilitado + aumentoAnimador);
        int puntajeSeccion1 = seccion.getPuntaje();

        seccion.agregarEfecto(new EfectoBoost(multiplicador));
        int puntajeEsperado2 = 15 + ((debilitado + aumentoAnimador)* multiplicador * 2 ) + ((debilitado + aumentoAnimador )* multiplicador * 2 )
                                    + ((debilitado + aumentoAnimador) * multiplicador) + ((debilitado + aumentoAnimador) * multiplicador);
        int puntajeSeccion2 = seccion.getPuntaje();



        // Assert
        assertEquals(puntajeEsperado0, puntajeSeccion0);
        assertEquals(puntajeEsperado1, puntajeSeccion1);
        assertEquals(puntajeEsperado2, puntajeSeccion2);

    }
}
