package edu.fiuba.algo3.modeloTest.JugadorTest.AtrilTest;


import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.cartas.unidades.UnidadBasica;
import edu.fiuba.algo3.modelo.jugador.Puntaje;
import edu.fiuba.algo3.modelo.jugador.atril.*;
import edu.fiuba.algo3.modelo.posiciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AtrilTest {

    private Atril atril;
    private Seccion cuerpoACuerpo;
    private Seccion distancia;
    private Seccion asedio;

    @BeforeEach
    void setUp() {
        atril = new Atril();
        cuerpoACuerpo = new Seccion(new CuerpoACuerpo());
        distancia = new Seccion(new Distancia());
        asedio = new Seccion(new Asedio());
    }

    @Test
    public void aUnAtrilSeLePuedeAgregarSecciones(){

        // Arrange
        // Act
        atril.agregarSeccion(cuerpoACuerpo);
        atril.agregarSeccion(distancia);
        atril.agregarSeccion(asedio);

        // Assert
        assertEquals(3, atril.getSecciones().size());
    }


    @Test
    public void elAtrilSePuedeLimpiarDescartandoTodasLasCartasDeLasSecciones(){

        // Arrange
        atril.agregarSeccion(cuerpoACuerpo);
        atril.agregarSeccion(distancia);
        atril.agregarSeccion(asedio);

        Unidad unidad1 = new UnidadBasica("Guerrero", new Puntaje(5), new CuerpoACuerpo());
        cuerpoACuerpo.colocarUnidad(unidad1);

        Unidad unidad2 = new UnidadBasica("Arquero", new Puntaje(4), new Distancia());
        distancia.colocarUnidad(unidad2);

        Unidad unidad3 = new UnidadBasica("Catapulta", new Puntaje(8), new Asedio());
        asedio.colocarUnidad(unidad3);

        // Act
       atril.descartarCartas();

        // Assert
        assertEquals(3, atril.getDescarte().size());
    }
}
