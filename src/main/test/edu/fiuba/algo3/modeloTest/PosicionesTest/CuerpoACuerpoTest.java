package edu.fiuba.algo3.modeloTest.PosicionesTest;

import edu.fiuba.algo3.modelo.posiciones.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CuerpoACuerpoTest {

    @Test
    public void unaPosicionCuerpoACuerpoEsCompatibleConOtraPosicionCuerpoACuerpo(){
        //Arrange
        Posicion cuerpoACuerpo1 = new CuerpoACuerpo();
        Posicion cuerpoACuerpo2 = new CuerpoACuerpo();

        //Act
        boolean esCompatible = cuerpoACuerpo1.esCompatible(cuerpoACuerpo2);

        //Assert
        assertTrue(esCompatible);
    }

    @Test
    public void unaPosicionCuerpoACuerpoNoEsCompatibleConOtroTipoDePosicion(){
        //Arrange
        Posicion cuerpoACuerpo = new CuerpoACuerpo();
        Posicion aDistancia = new Distancia();
        Posicion asedio = new Asedio();

        //Act
        boolean esCompatibleCuerpoACuerpoYDistancia = cuerpoACuerpo.esCompatible(aDistancia);
        boolean esCompatibleCuerpoACuerpoYAsedio = cuerpoACuerpo.esCompatible(asedio);

        //Assert
        assertFalse(esCompatibleCuerpoACuerpoYDistancia);
        assertFalse(esCompatibleCuerpoACuerpoYAsedio);
    }
}
