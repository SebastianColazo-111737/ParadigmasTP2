package edu.fiuba.algo3.ModeloTest.PosicionesTest;


import edu.fiuba.algo3.modelo.posicion.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DistanciaTest {

    @Test
    public void unaPosicionDistanciaEsCompatibleConOtraPosicionDistancia(){
        //Arrange
        Posicion distancia1 = new Distancia();
        Posicion distancia2 = new Distancia();

        //Act
        boolean esCompatible = distancia1.esCompatible(distancia2);

        //Assert
        assertTrue(esCompatible);
    }

    @Test
    public void unaPosicionCuerpoACuerpoNoEsCompatibleConOtroTipoDePosicion(){
        //Arrange

        Posicion aDistancia = new Distancia();
        Posicion  cuerpoACuerpo = new CuerpoACuerpo();
        Posicion asedio = new Asedio();

        //Act
        boolean esCompatibleDistanciaYCuerpoACuerpo = aDistancia.esCompatible(cuerpoACuerpo);
        boolean esCompatibleDistanciaYAsedio = aDistancia.esCompatible(asedio);

        //Assert
        assertFalse(esCompatibleDistanciaYCuerpoACuerpo);
        assertFalse(esCompatibleDistanciaYAsedio);
    }
}
