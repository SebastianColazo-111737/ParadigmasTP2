package edu.fiuba.algo3.vista.vistas.cartas.Especiales;

import edu.fiuba.algo3.jsonParser.PosicionParser;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class VistaCartaEspecial extends StackPane {

    private Carta especialModelo;
    private String nombreCarta;
    private Image imagenCarta;
    private BiConsumer<Carta, Posicion> eventoJugarCarta;

    public VistaCartaEspecial(Carta especial, String descripcion, String tipo, List<String> posiciones, BiConsumer<Carta, Posicion> eventoJugarCarta) {
        this.especialModelo = especial;
        this.nombreCarta = especial.getNombre();
        String nombreLimpio = this.nombreCarta.toLowerCase().replaceAll("\\s+", "");
        this.imagenCarta = new Image(getClass().getResource("/imagenes/cartas/especiales/" + nombreLimpio + ".png").toExternalForm());
        this.eventoJugarCarta = eventoJugarCarta;

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

        this.setOnMouseClicked(e -> mostrarVentanaDetalle(descripcion, tipo, posiciones));
    }

    private void mostrarVentanaDetalle(String descripcion, String tipo, List<String> posicionesTexto) {
        Stage popup = new Stage();
        popup.setTitle(this.nombreCarta);

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
        nombreLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 18px; -fx-text-fill: white;");

        Label tipoLabel = new Label("Tipo: " + tipo);
        tipoLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: lightgray;");

        Label descripcionLabel = new Label(descripcion);
        descripcionLabel.setWrapText(true);
        descripcionLabel.setMaxWidth(280);
        descripcionLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: white;");

        HBox botones = new HBox(10);
        botones.setAlignment(Pos.CENTER_LEFT);

        if (tipo.equalsIgnoreCase("Morale boost")) {
            List<String> posicionesParaMostrar = new ArrayList<>();
            posicionesParaMostrar.add("cuerpo a cuerpo");
            posicionesParaMostrar.add("rango");
            posicionesParaMostrar.add("asedio");

            for (String posicionTexto : posicionesParaMostrar) {
                Posicion pos = PosicionParser.crearPosicion(posicionTexto);
                Button btnPos = new Button(posicionTexto);
                btnPos.setOnAction(e -> {
                    if (eventoJugarCarta != null) {
                        eventoJugarCarta.accept(this.especialModelo, pos);
                    }
                    popup.close();
                });
                botones.getChildren().add(btnPos);
            }
        } else {
            Button jugarBtn = new Button("Jugar");
            jugarBtn.setOnAction(e -> {
                if (eventoJugarCarta != null) {
                    eventoJugarCarta.accept(this.especialModelo, null);
                }
                popup.close();
            });
            botones.getChildren().add(jugarBtn);
        }

        VBox infoBox = new VBox(6, nombreLabel, tipoLabel, descripcionLabel, botones);
        infoBox.setPadding(new Insets(10));
        infoBox.setAlignment(Pos.CENTER_LEFT);

        StackPane capaInferior = new StackPane(infoBox);
        capaInferior.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0, 0.65), null, null)));
        capaInferior.setPrefHeight(160);
        capaInferior.setMaxHeight(160);
        StackPane.setAlignment(capaInferior, Pos.BOTTOM_CENTER);

        StackPane root = new StackPane(fondo, capaInferior);

        Scene scene = new Scene(root, 300, 450);
        popup.setScene(scene);
        popup.setResizable(false);

        popup.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) popup.close();
        });

        popup.show();
    }


}