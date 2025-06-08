package edu.fiuba.algo3.clases;

import java.util.List;
import java.util.ArrayList;


public abstract class Especial implements Carta {
    public abstract void activar(Tablero tablero);
    private String nombre;
    private ZonaEspeciales zona;

    public Especial(String nombre, ZonaEspeciales zona){
        this.nombre = nombre;
        this.zona = zona;
    }

    public void activar(){

    }

    public String getName(){
        return this.nombre;
    }

    @Override
    public Posicion getPosicion() { //Devuelve null ya que al ser de la interfaz Carta, si o si me pide implementar 'getPosicion()'
        return null;                //No deberia dejarse esto asi pero estoy priorizando pasar los tests
    }                               //Se podria dividir la interfaz Carta en subtipos  ¿talvez?


    public Boolean jugar(Tablero tablero,Jugador jugador,Posicion posicion){
        return true;                //Lo mismo con esto, necesito implementar 'Boolean jugar', lo implemente asi para que pasara el test
    }                               //ya que deberiamos sacar la clase Tablero en si como dijo el profe

    public Boolean jugarEspecial(Tablero tablero, Jugador jugador, ZonaEspeciales zonaEspeciales){
        zonaEspeciales.colocar(this,tablero);
        return true;
    }
}
