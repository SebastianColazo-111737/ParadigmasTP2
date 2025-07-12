package edu.fiuba.algo3.vistas.Contenedores;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.Region;



public class CambiosEspecialesSecciones {
    private final StackPane contenedorBuff;
    private final Region espacioBuff;
    private final VistaSeccion vistaSeccion;

    private Label efectoLabel;

    public CambiosEspecialesSecciones(StackPane contenedorBuff, Region espacioBuff, VistaSeccion vistaSeccion){
        this.contenedorBuff = contenedorBuff;
        this.espacioBuff = espacioBuff;
        this.vistaSeccion = vistaSeccion;
    }

    public void activarBuff(){
        vistaSeccion.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        mostrarEtiqueta("x2",Color.WHITE);
    }

    public void activarDebuffEscarcha(){
        vistaSeccion.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE,CornerRadii.EMPTY,Insets.EMPTY)));
        mostrarEtiqueta("❆", Color.WHITE);
    }

    public void activarDebuffLluvia(){
        vistaSeccion.setBackground(new Background(new BackgroundFill(Color.CADETBLUE,CornerRadii.EMPTY,Insets.EMPTY)));
        mostrarEtiqueta("☔", Color.WHITE);
    }

    public void activarDebuffTormenta(){
        vistaSeccion.setBackground(new Background(new BackgroundFill(Color.TOMATO,CornerRadii.EMPTY,Insets.EMPTY)));
        mostrarEtiqueta("⚡", Color.WHITE);
    }

    public void limpiar(){
        vistaSeccion.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY,CornerRadii.EMPTY,Insets.EMPTY)));
        if(efectoLabel != null){
            contenedorBuff.getChildren().remove(efectoLabel);
            efectoLabel = null;
        }
    }

    private void mostrarEtiqueta(String texto, Color color){
        if(efectoLabel == null){
            efectoLabel = new Label(texto);
            efectoLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 16));
            efectoLabel.setTextFill(color);
            efectoLabel.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6); -fx-padding: 2 6 2 6;");
            contenedorBuff.getChildren().add(efectoLabel);
        }
    }
}
