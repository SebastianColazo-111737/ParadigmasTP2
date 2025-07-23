package edu.fiuba.algo3.vista.vistas.cartas;

import java.util.HashMap;

public class CacheEstilosVistaCarta {
    private final HashMap<String, EstiloVistaCarta> estilosPorNombre = new HashMap<>();
    private static final CacheEstilosVistaCarta instancia = new CacheEstilosVistaCarta();

    private CacheEstilosVistaCarta() {
    }

    public static CacheEstilosVistaCarta getInstancia() {
        return instancia;
    }

    public void agregarEstilo(String nombre, EstiloVistaCarta estilo) {
        this.estilosPorNombre.put(nombre, estilo);
    }

    public boolean contieneEstilo(String nombre) {
        return estilosPorNombre.containsKey(nombre);
    }

    public EstiloVistaCarta getEstiloVistaCarta(String nombre){
        return this.estilosPorNombre.get(nombre);
    }
}

