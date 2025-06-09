package edu.fiuba.algo3.entrega_2;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import edu.fiuba.algo3.clases.*;
import edu.fiuba.algo3.clases.Modificadores.Unidas;

public class Semana2 {

    @Mock
    private Mazo mazoMock;

    @Mock
    private ArrayList<Carta> cartasMock1;

    @Mock
    private ArrayList<Carta> cartasMock2;

    @Mock
    private ZonaEspeciales zonaEspeciales;


    private Unidad cartaMock1;
    private Unidad cartaMock2;
    private Especial cartaMock3;
    private Unidad cartaMock4;
    private Unidad cartaMock5;
    private Unidad cartaMock6;
    private Unidad cartaMock7;
    private Especial cartaMock8;
    private Unidad cartaMock9;
    private Unidad cartaMock10;
    private Unidad cartaMock11;
    private Unidad cartaMock12;
    private Unidad cartaMock13;
    private Especial cartaMock14;
    private Unidad cartaMock15;
    private Unidad cartaMock16;
    private Unidad cartaMock17;
    private Unidad cartaMock18;
    private Especial cartaMock19;
    private Unidad cartaMock20;
    private Unidad cartaMock21;

    @BeforeEach
    public void setup() {
        this.cartaMock1 = new Unidad("Asesino", 8, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock2 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA, null);
        this.cartaMock3 = new Nieve("Nieve", zonaEspeciales);
        this.cartaMock4 = new Unidad("Medico", 2, Posicion.ASEDIO, null);
        this.cartaMock5 = new Unidad("Asesino", 8, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock6 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA, null);
        this.cartaMock7 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock8 = new Nieve("Nieve", zonaEspeciales);
        this.cartaMock9 = new Unidad("Asesino", 10, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock10 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA, null);
        this.cartaMock11 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock12 = new Unidad("Catapulta", 8, Posicion.ASEDIO, new Unidas());
        this.cartaMock13 = new Unidad("Asesino", 8, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock14 = new Nieve("Nieve", zonaEspeciales);
        this.cartaMock15 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock16 = new Unidad("Medico", 2, Posicion.ASEDIO, null);
        this.cartaMock17 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA, null);
        this.cartaMock18 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);
        this.cartaMock19 = new Nieve("Nieve", zonaEspeciales);
        this.cartaMock20 = new Unidad("Arquero", 4, Posicion.A_DISTANCIA, null);
        this.cartaMock21 = new Unidad("Guerrero", 6, Posicion.CUERPO_A_CUERPO, null);

        this.cartasMock1 = new ArrayList<>(Arrays.asList(
                cartaMock1, cartaMock2, cartaMock3, cartaMock4, cartaMock5,
                cartaMock6, cartaMock7, cartaMock8, cartaMock9, cartaMock10,
                cartaMock11, cartaMock12, cartaMock13, cartaMock14, cartaMock15,
                cartaMock16, cartaMock17, cartaMock18, cartaMock19, cartaMock20, cartaMock21));

        this.cartasMock2 = new ArrayList<>();
        for (Carta carta : this.cartasMock1) {
            if (carta instanceof Unidad) {
                Unidad unidad = (Unidad) carta;
                cartasMock2.add(new Unidad(unidad.getName(), unidad.obtenerPuntosBase(), unidad.getPosicion(), null));
            }
        }
    }
