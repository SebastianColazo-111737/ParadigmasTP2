package edu.fiuba.algo3.vistas.Contenedores;
import edu.fiuba.algo3.ControladorTurnos;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.atril.Atril;
import edu.fiuba.algo3.vistas.Individuales.VistaDescarte;
import edu.fiuba.algo3.vistas.OrdenadorSecciones;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import java.util.List;

public class VistaAtril extends VBox {
    private final Atril atril;

    public VistaAtril(Atril atril, boolean estaArriba, Jugador jugador, VistaMano vistaMano,
                      VistaTurnos vistaTurnos, ControladorTurnos controladorTurnos, VistaDescarte vistaDescarte) {
        this.atril = atril;
        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);

        List<Seccion> secciones = atril.getSecciones();
        List<Seccion> ordenadas = OrdenadorSecciones.ordenar(secciones, estaArriba);

        for (Seccion seccion : ordenadas) {
            VistaSeccion vistaSeccion = new VistaSeccion(seccion, jugador, vistaMano, vistaTurnos, controladorTurnos);
            this.getChildren().add(vistaSeccion);
        }
    }

    public void actualizar(){
        for(Node nodo : this.getChildren()){
            if (nodo instanceof VistaSeccion) {
                VistaSeccion vistaSeccion = (VistaSeccion) nodo;
                vistaSeccion.actualizar();
            }
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