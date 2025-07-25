package edu.fiuba.algo3.ModeloTest.PosicionesTest;

import edu.fiuba.algo3.modelo.posicion.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AsedioTest {

    @Test
    public void unaPosicionAsedioEsCompatibleConOtraPosicionAsedio(){
        //Arrange
        Posicion asedio1 = new Asedio();
        Posicion asedio2 = new Asedio();

        //Act
        boolean esCompatible = asedio1.esCompatible(asedio2);

        //Assert
        assertTrue(esCompatible);
    }

    @Test
    public void unaPosicionCuerpoACuerpoNoEsCompatibleConOtroTipoDePosicion(){
        //Arrange
        Posicion asedio = new Asedio();
        Posicion cuerpoACuerpo = new CuerpoACuerpo();
        Posicion aDistancia = new Distancia();

        //Act
        boolean esCompatibleAsedioYCuerpoACuerpo = asedio.esCompatible(cuerpoACuerpo);
        boolean esCompatibleAsedioYDistancia = asedio.esCompatible(aDistancia);

        //Assert
        assertFalse(esCompatibleAsedioYCuerpoACuerpo);
        assertFalse(esCompatibleAsedioYDistancia);
    }
}
