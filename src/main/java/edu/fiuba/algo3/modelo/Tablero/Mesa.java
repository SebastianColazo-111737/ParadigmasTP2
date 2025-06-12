package edu.fiuba.algo3.modelo.Tablero;



import edu.fiuba.algo3.modelo.Posicion.*;
import edu.fiuba.algo3.modelo.Carta.*;

import java.util.HashMap;
import java.util.Map;

public class Mesa {
    private Map<Class<? extends IPosicion>, Seccion> secciones;
    public Mesa() {
        this.secciones = new HashMap<>();
        this.secciones.put(CuerpoACuerpo.class, new Seccion(new CuerpoACuerpo()));
        this.secciones.put(Distancia.class, new Seccion(new Distancia()));
        this.secciones.put(Asedio.class, new Seccion(new Asedio()));
    }

    public void colocarUnidad(Unidad unidad, IPosicion posicion){
        secciones.get(posicion.getClass()).colocarUnidad(unidad);
    }
}
