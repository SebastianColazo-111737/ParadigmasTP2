package edu.fiuba.algo3.clases;

public class Nieve extends Especial{

    public Nieve(String nombre, ZonaEspeciales zona){
        super(nombre,zona);
    }

    public void activar(Tablero tablero){
        tablero.aplicarNieveEnCuerpoACuerpo();
    }
}
