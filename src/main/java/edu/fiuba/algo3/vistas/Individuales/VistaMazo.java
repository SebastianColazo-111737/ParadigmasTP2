package edu.fiuba.algo3.vistas.Individuales;

import edu.fiuba.algo3.modelo.jugador.Mazo;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaMazo extends StackPane{
    private static VistaMazo seleccionado = null;
    private Rectangle fondo;
    private Label contador;
    private Mazo mazo;


    public VistaMazo(String nombre, Mazo mazo){
        this.mazo = mazo;

        fondo = new Rectangle(100,120);
        fondo.setFill(Color.SIENNA);
        fondo.setStroke(Color.BLACK);
        fondo.setStrokeWidth(2);

        Label etiqueta = new Label(nombre);
        etiqueta.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");

        contador = new Label("Restantes: " + mazo.getCantidadCartas());
        contador.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: white;");
        contador.setTranslateY(20);

        this.getChildren().addAll(fondo,etiqueta, contador);
        this.setOnMouseClicked(e -> seleccionar());

        mazo.agregarObservador(() -> actualizar());
    }

    public void actualizar() {
        contador.setText("Cartas: " + mazo.getCantidadCartas());
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
}



