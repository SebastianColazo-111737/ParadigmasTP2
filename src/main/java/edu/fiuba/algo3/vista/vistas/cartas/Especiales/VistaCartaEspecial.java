package edu.fiuba.algo3.vista.vistas.cartas.Especiales;

import edu.fiuba.algo3.jsonParser.PosicionParser;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.vista.vistas.cartas.VistaCarta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class VistaCartaEspecial extends VistaCarta {

    private Carta especialModelo;
    private String nombreCarta;
    private Image imagenCarta;
    private BiConsumer<Carta, Posicion> eventoJugarCarta;
    private String descripcion;
    private String tipo;

    public VistaCartaEspecial(Carta especial, String descripcion, String tipo, List<String> posiciones, BiConsumer<Carta, Posicion> eventoJugarCarta) {
        this.especialModelo = especial;
        this.nombreCarta = especial.getNombre();
        String nombreLimpio = this.nombreCarta.toLowerCase().replaceAll("\\s+", "");
        this.imagenCarta = new Image(getClass().getResource("/imagenes/cartas/especiales/" + nombreLimpio + ".png").toExternalForm());
        this.eventoJugarCarta = eventoJugarCarta;
        this.descripcion = descripcion;
        this.tipo = tipo;

        ImageView vistaImagen = new ImageView(imagenCarta);
        vistaImagen.setPreserveRatio(false);
        vistaImagen.setFitWidth(90);
        vistaImagen.setFitHeight(105);

        this.setAlignment(Pos.TOP_CENTER);
        this.setStyle("-fx-border-color: darkred; -fx-background-color: mistyrose;");
        this.setPrefWidth(90);
        this.setPrefHeight(105);
        this.setMaxSize(90, 105);
        this.setMinSize(90, 105);

        this.getChildren().add(vistaImagen);

        this.setOnMouseClicked(e -> {
            StackPane detalle = getVentanaDetalle(true);
            Stage popup = new Stage();
            popup.setScene(new Scene(detalle, 300, 450));
            popup.setResizable(false);
            popup.focusedProperty().addListener((obs, oldVal, newVal) -> {
                if (!newVal) popup.close();
            });
            popup.show();
        });
    }

    @Override
    public StackPane getVentanaDetalle(Boolean sePuedeJugar){
        return crearVistaDetalle(this.descripcion, this.tipo, sePuedeJugar);
    }

    private StackPane crearVistaDetalle(String descripcion, String tipo, Boolean sePuedeJugar) {
        Region fondo = new Region();
        fondo.setPrefSize(300, 450);
        fondo.setBackground(new Background(new BackgroundImage(
                this.imagenCarta,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, false, true)
        )));

        Label nombreLabel = new Label(this.nombreCarta);
        nombreLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 24px; -fx-text-fill: white;");

        Label tipoLabel = new Label("Tipo: " + tipo);
        tipoLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: lightgray;");

        Text descripcionTexto = new Text(descripcion);
        descripcionTexto.setStyle("-fx-font-size: 18px; -fx-fill: white;");

        TextFlow descripcionFlow = new TextFlow(descripcionTexto);
        descripcionFlow.setMaxWidth(260);
        descripcionFlow.setLineSpacing(5);

        HBox botones = new HBox(10);
        botones.setAlignment(Pos.CENTER);
        if(sePuedeJugar){
            if (tipo.equalsIgnoreCase("Morale boost")) {
                List<String> posicionesParaMostrar = List.of("cuerpo a cuerpo", "rango", "asedio");
                for (String posicionTexto : posicionesParaMostrar) {
                    Posicion pos = PosicionParser.crearPosicion(posicionTexto);
                    Button botonPosicion = new Button(posicionTexto);
                    botonPosicion.setStyle(estiloBotonNormal());
                    botonPosicion.setOnMouseEntered(e -> botonPosicion.setStyle(estiloBotonHover()));
                    botonPosicion.setOnMouseExited(e -> botonPosicion.setStyle(estiloBotonNormal()));
                    botonPosicion.setOnAction(e -> {
                        if (eventoJugarCarta != null) {
                            eventoJugarCarta.accept(this.especialModelo, pos);
                        }
                        Stage stage = (Stage) botonPosicion.getScene().getWindow();
                        stage.close();
                    });
                    botones.getChildren().add(botonPosicion);
                }
            } else {
                Button botonJugar = new Button("Jugar");
                botonJugar.setStyle(estiloBotonNormal());
                botonJugar.setOnMouseEntered(e -> botonJugar.setStyle(estiloBotonHover()));
                botonJugar.setOnMouseExited(e -> botonJugar.setStyle(estiloBotonNormal()));
                botonJugar.setOnAction(e -> {
                    if (eventoJugarCarta != null) {
                        eventoJugarCarta.accept(this.especialModelo, null);
                    }
                    Stage stage = (Stage) botonJugar.getScene().getWindow();
                    stage.close();
                });
                botones.getChildren().add(botonJugar);
            }
        }

        VBox infoBox = new VBox(6, nombreLabel, tipoLabel, descripcionFlow, botones);
        infoBox.setPadding(new Insets(10));
        infoBox.setAlignment(Pos.CENTER_LEFT);

        StackPane capaInferior = new StackPane(infoBox);
        capaInferior.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0, 0.65), null, null)));
        capaInferior.setPrefHeight(160);
        capaInferior.setMaxHeight(160);
        StackPane.setAlignment(capaInferior, Pos.BOTTOM_CENTER);

        StackPane root = new StackPane(fondo, capaInferior);
        root.setPrefSize(300, 450);
        return root;
    }

}