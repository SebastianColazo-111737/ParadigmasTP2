package edu.fiuba.algo3.vistas.Individuales;
import edu.fiuba.algo3.modelo.jugador.Descarte;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaDescarte extends StackPane{
    private static VistaDescarte seleccionado = null;
    private Rectangle fondo;
    private final Jugador jugador;
    private final Label contador;
    private Descarte descarte;


    public VistaDescarte(String nombre, Jugador jugador){
        this.jugador = jugador;

        fondo = new Rectangle(90,120);
        fondo.setFill(Color.DARKOLIVEGREEN);
        fondo.setStroke(Color.BLACK);
        fondo.setStrokeWidth(2);

        Label etiqueta = new Label(nombre);
        etiqueta.setStyle("-fx-font-weight: bold;");
        etiqueta.setTextFill(Color.WHITE);

        contador = new Label("Cantidad: " + jugador.descarte().getCantidadCartas());
        contador.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: white;");
        contador.setTranslateY(35);
        etiqueta.setTranslateY(-30);

        this.getChildren().addAll(fondo,etiqueta, contador);
        this.setOnMouseClicked(e -> seleccionar());

        jugador.descarte().agregarObservador(this::actualizarContador);
    }

    private void seleccionar(){
        if(seleccionado !=null && seleccionado != this) seleccionado.deseleccionar();
        seleccionado = this;
        fondo.setStroke(Color.RED);
    }

    public void deseleccionar(){
        fondo.setStroke(Color.BLACK);
        if(seleccionado == this) seleccionado = null;
    }

    public static void limpiarSeccion(){
        if(seleccionado != null) seleccionado.deseleccionar();
    }

    public void actualizarContador() {
        contador.setText("Restantes: " + jugador.descarte().getCantidadCartas());
    }
}

