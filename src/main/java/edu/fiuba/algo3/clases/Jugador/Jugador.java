package edu.fiuba.algo3.clases.Jugador;

import edu.fiuba.algo3.clases.Carta.ICarta;
import edu.fiuba.algo3.clases.Carta.Unidad;
import edu.fiuba.algo3.clases.Mano.Mano;
import edu.fiuba.algo3.clases.Mazo.Mazo;
import edu.fiuba.algo3.clases.Posicion.*;
import edu.fiuba.algo3.clases.Seccion.Seccion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jugador {

    private String nombre;

    private List<Unidad> descarte = new ArrayList<>();
    private int puntaje;

    private Mazo mazo;
    private Mano mano;

    private Map<Class<? extends IPosicion>, Seccion> secciones = new HashMap<>();

    public Jugador(String nombre, Mazo mazo, Mano mano) {
        this.nombre = nombre;
        this.puntaje = 0;

        this.mazo = mazo;
        this.mano = mano;

        secciones.put(CuerpoACuerpo.class, new Seccion(new CuerpoACuerpo()));
        secciones.put(Distancia.class, new Seccion(new Distancia()));
        secciones.put(Asedio.class, new Seccion(new Asedio()));

    }

    public Jugador(String nombre, Mazo mazo) {
        this(nombre, mazo, new Mano());
    }

    public void robarCartas(int cantidad){
        mano.agregarCartas(mazo.darCartas(cantidad));
    }

    public void jugarCartaDeLaMano(int indiceCarta, IPosicion posicion){
        Seccion seccion = secciones.get(posicion.getClass());
        ICarta cartaParaJugar = mano.getCarta(indiceCarta);

        cartaParaJugar.jugarCarta(seccion);

    }

    public int getPuntajeSeccion(IPosicion posicion){
        Seccion seccion = secciones.get(posicion.getClass());
        return seccion.getPuntaje();
    }

    public int getCantidadCartasEnSeccion(IPosicion posicion){
        Seccion seccion = secciones.get(posicion.getClass());
        return seccion.getCantidadDeUnidadesColocadas();
    }




    public void descartarCartasDeLaSeccion(IPosicion posicion){
        Seccion seccion = secciones.get(posicion.getClass());
        descarte.addAll(seccion.getUnidadesColocadas());
    }

    public int getCantidadCartasDescarte(){
        return descarte.size();
    }


    public int getCantidadCartasMazo(){
        return mazo.getCantidadCartas();
    }

    public int getCantidadCartasMano(){
        return mano.getCantidadCartas();
    }
}
