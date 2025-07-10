package edu.fiuba.algo3.vistas.Individuales;
import edu.fiuba.algo3.ControladorTurnos;
import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.especiales.CEspecial;
import edu.fiuba.algo3.modelo.cartas.especiales.DeBuffCleaner;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Atril;
import edu.fiuba.algo3.vistas.Contenedores.VistaMano;
import edu.fiuba.algo3.vistas.Contenedores.VistaTurnos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaSeccionEspecial extends StackPane {

    private final Label infoEspecialActivaJ1 = new Label("J1: -");
    private final Label infoEspecialActivaJ2 = new Label("J2: -");

    public VistaSeccionEspecial(String mensajeAyuda, Atril atrilJ1, Atril atrilJ2) {
        Rectangle fondo = new Rectangle(190, 140);
        fondo.setFill(Color.STEELBLUE);
        fondo.setStroke(Color.BLACK);

        Label etiqueta = new Label(mensajeAyuda);
        etiqueta.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);
        etiqueta.setAlignment(Pos.CENTER);
        etiqueta.setWrapText(true);
        etiqueta.setMaxWidth(140);

        infoEspecialActivaJ1.setFont(Font.font("Verdana",15));
        infoEspecialActivaJ1.setTextFill(Color.WHITE);

        infoEspecialActivaJ2.setFont(Font.font("Verdana",15));
        infoEspecialActivaJ2.setTextFill(Color.WHITE);

        VBox contenido = new VBox(5,etiqueta,infoEspecialActivaJ2,infoEspecialActivaJ1);
        contenido.setAlignment(Pos.CENTER);

        this.getChildren().addAll(fondo, contenido);
        this.setPadding(new Insets(5));
        this.setAlignment(Pos.CENTER);

        atrilJ1.getSeccionEspecial().agregarObservador(() -> actualizarJ1(atrilJ1));
        atrilJ2.getSeccionEspecial().agregarObservador(() -> actualizarJ2(atrilJ2));

        actualizarJ1(atrilJ1);
        actualizarJ2(atrilJ2);
    }

    private void actualizarJ1(Atril atril){
        String nombre = atril.nombreCartaEspecialActiva().orElse(null);
        setInfoEspecialActivaJ1(nombre);
    }

    private void actualizarJ2(Atril atril){
        String nombre = atril.nombreCartaEspecialActiva().orElse(null);
        setInfoEspecialActivaJ2(nombre);
    }

    public void setInfoEspecialActivaJ1(String efecto){
        this.infoEspecialActivaJ1.setText("J1: " + (efecto == null ? "-" : efecto));
    }

    public void setInfoEspecialActivaJ2(String efecto){
        this.infoEspecialActivaJ2.setText("J2: " + (efecto == null ? "-" : efecto));
    }
}
