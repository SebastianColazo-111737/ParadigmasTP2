package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.vistas.Individuales.VistaCarta;
import edu.fiuba.algo3.vistas.Individuales.VistaPuntos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import java.util.Stack;


public class VistaSeccion extends StackPane {

    private final Seccion seccionModelo;
    private final Jugador jugador;
    private final Pane cartasApoyadas;
    private final VistaPuntos vistaPuntos;
    private static final int CapacidadMaxima = 8;

    public VistaSeccion(Seccion seccionModelo, Jugador jugador, VistaMano vistaMano){
        this.seccionModelo = seccionModelo;
        this.jugador = jugador;

        this.vistaPuntos = new VistaPuntos(seccionModelo.getPuntajeActual());

        Rectangle rectangulo = new Rectangle(380,90);
        rectangulo.setFill(Color.LIGHTGRAY);
        rectangulo.setStroke(Color.BLACK);

        Label etiqueta = new Label(nombreDesdePos(seccionModelo));
        StackPane fondo = new StackPane(rectangulo,etiqueta);
        HBox base = new HBox(-5,vistaPuntos,fondo);
        base.setAlignment(Pos.CENTER_LEFT);

        this.cartasApoyadas = new Pane();
        this.cartasApoyadas.setPickOnBounds(false);

        this.getChildren().addAll(base,cartasApoyadas);
        this.recibirCarta(vistaMano);
    }

    private void recibirCarta(VistaMano vistaMano){
        this.setOnDragOver(e->{
            if(e.getGestureSource() instanceof VistaCarta
                && seccionModelo.getUnidadesColocadas().size() < CapacidadMaxima ){
                e.acceptTransferModes(TransferMode.MOVE);
            }
            e.consume();
        });

        this.setOnDragDropped(e->{
            Dragboard tablaSeccion = e.getDragboard();
            boolean seMovio = false;

            if(tablaSeccion.hasString()
                    && VistaCarta.cartaSeleccionada != null
                    && seccionModelo.getUnidadesColocadas().size() < CapacidadMaxima ){

                VistaCarta vistaCarta = VistaCarta.cartaSeleccionada;
                ICarta cartaModelo = vistaCarta.getCartaModelo();

                jugador.jugarCarta(cartaModelo, this.seccionModelo);

                vistaCarta.setLayoutX(seccionModelo.getUnidadesColocadas().size()*30);
                vistaCarta.setLayoutY(0);
                cartasApoyadas.getChildren().add(vistaCarta);

                vistaPuntos.actualizarPuntaje(seccionModelo.getPuntajeActual());
                vistaMano.removerVistaCarta(vistaCarta);

                System.out.println("Carta colocada en: " + this.seccionModelo.getPosicion());
                VistaCarta.cartaSeleccionada = null;
                seMovio = true;
            }
            e.setDropCompleted(seMovio);
            e.consume();
        });
    }

    private String nombreDesdePos(Seccion seccion){
        Posicion pos = seccion.getPosicion();
        if (pos instanceof CuerpoACuerpo) return "\uD83D\uDDE1\uFE0F";
        if (pos instanceof Distancia) return "⋙";
        if (pos instanceof Asedio) return "\uD83D\uDEE1\uFE0F";
        return "La seccion no existe";
    }
}
