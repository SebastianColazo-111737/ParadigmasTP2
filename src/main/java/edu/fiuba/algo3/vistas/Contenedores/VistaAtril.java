package edu.fiuba.algo3.vistas.Contenedores;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.atril.Atril;
import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import edu.fiuba.algo3.vistas.OrdenadorSecciones;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class VistaAtril extends VBox {
    private final Atril atril;
    private final Jugador jugador;

    public VistaAtril(Atril atril, boolean estaArriba, Jugador jugador, VistaMano vistaMano) {
        this.atril = atril;
        this.jugador = jugador;
        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);

        List<Seccion> secciones = atril.getSecciones();
        List<Seccion> ordenadas = OrdenadorSecciones.ordenar(secciones, estaArriba);

        for (Seccion seccion : ordenadas) {
            VistaSeccion vistaSeccion = new VistaSeccion(seccion, jugador, vistaMano);
            this.getChildren().add(vistaSeccion);
        }
    }

    //Esto es basicamente el puntaje del jugador en cada ronda
    public int PuntajeTotalAtril(){
        return atril.getPuntajeActual();
    }

    public Atril getAtril() {
        return this.atril;
    }
}