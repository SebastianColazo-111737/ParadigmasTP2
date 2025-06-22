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


public class VistaSeccion extends StackPane {

    private final Seccion seccionModelo;
    private final Jugador jugador;
    private final HBox contenido;

    public VistaSeccion(Seccion seccionModelo, Jugador jugador, VistaMano vistaMano){
        this.seccionModelo = seccionModelo;
        this.jugador = jugador;

        VistaPuntos puntos = new VistaPuntos();

        Rectangle rectangulo = new Rectangle(240,70);
        rectangulo.setFill(Color.LIGHTGRAY);
        rectangulo.setStroke(Color.BLACK);

        Label etiqueta = new Label(nombreDesdePos(seccionModelo));
        this.contenido = new HBox(-5, puntos, new StackPane(rectangulo, etiqueta));
        contenido.setAlignment(Pos.CENTER_LEFT);

        this.getChildren().add(contenido);
        this.recibirCarta(vistaMano);
    }

    private String nombreDesdePos(Seccion seccion){
        Posicion pos = seccion.getPosicion();
        if (pos instanceof CuerpoACuerpo) return "CUERPO";
        if (pos instanceof Distancia) return "DISTANCIA";
        if (pos instanceof Asedio) return "ASEDIO";
        return "La seccion no existe";
    }

    private void recibirCarta(VistaMano vistaMano){
        this.setOnDragOver(e->{
            if(e.getGestureSource() instanceof VistaCarta){
                e.acceptTransferModes(TransferMode.MOVE);
            }
            e.consume();
        });

        this.setOnDragDropped(e->{
            Dragboard tablaSeccion = e.getDragboard();
            boolean seMovio = false;

            if(tablaSeccion.hasString() && VistaCarta.cartaSeleccionada != null){
                VistaCarta vistaCarta = VistaCarta.cartaSeleccionada;
                ICarta cartaModelo = vistaCarta.getCartaModelo();

                this.contenido.getChildren().add(vistaCarta);

                jugador.jugarCarta(cartaModelo, this.seccionModelo);

                vistaMano.removerVistaCarta(vistaCarta);
                System.out.println("Carta colocada en: " + this.seccionModelo.getPosicion());

                seMovio = true;
                VistaCarta.cartaSeleccionada = null;
            }
            e.setDropCompleted(seMovio);
            e.consume();
        });
    }
}
