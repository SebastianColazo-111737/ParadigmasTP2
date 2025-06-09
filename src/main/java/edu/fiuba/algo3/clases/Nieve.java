package edu.fiuba.algo3.clases;

public class Nieve extends Especial{

    public Nieve(String nombre, ZonaEspeciales zona){
        super(nombre,zona);
    }

    public void activar(Tablero tablero){
        System.out.println("Se activó la carta Nieve");
        tablero.aplicarNieveEnCuerpoACuerpo();
    }
    public void desactivar(Tablero tablero){
        System.out.println("Se desactivo la carta Nieve");
        tablero.desactivarNieveEnCuerpoACuerpo();
    }
}
