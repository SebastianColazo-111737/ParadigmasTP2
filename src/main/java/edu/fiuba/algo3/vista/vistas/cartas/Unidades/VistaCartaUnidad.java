package edu.fiuba.algo3.vista.vistas.cartas.Unidades;

import edu.fiuba.algo3.jsonParser.PosicionParser;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
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
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import java.util.function.BiConsumer;


public class VistaCartaUnidad extends VistaCarta {

    private Unidad unidadModelo;
    private String nombreUnidad;
    private Image imagenUnidad;
    private List<String> modificadores;
    private List<String> posiciones;

    private BiConsumer<Carta, Posicion> eventoJugarCarta;


    public VistaCartaUnidad(Unidad unidad, List<String> modificadores, List<String> posiciones, BiConsumer<Carta, Posicion> eventoJugarCarta) {
        this.unidadModelo = unidad;
        this.nombreUnidad = unidad.getNombre();
        String nombreLimpio = this.nombreUnidad.toLowerCase().replaceAll("\\s+", "");
        this.imagenUnidad = new Image(getClass().getResource("/imagenes/cartas/unidades/" + nombreLimpio + ".png").toExternalForm());
        this.eventoJugarCarta = eventoJugarCarta;
        this.posiciones = posiciones;
        this.modificadores = modificadores;

        BackgroundImage bgImage = new BackgroundImage(
                this.imagenUnidad,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(90, 105, false, false, false, false)
        );
        this.setBackground(new Background(bgImage));
        this.setPrefSize(90, 105);
        this.setMaxSize(90, 105);
        this.setMinSize(90, 105);

        Pane capaTransparente = new Pane();
        capaTransparente.setPrefSize(90, 105);
        capaTransparente.setBackground(new Background(new BackgroundFill(Color.color(0, 0, 0, 0.0), null, null)));

        Circle circuloPuntaje = new Circle(20);
        circuloPuntaje.setFill(Color.WHITE);

        Text textoPuntaje = new Text(String.valueOf(unidad.getPuntaje().getPuntajeActual()));
        if (unidadModelo.getPuntaje().getPuntajeActual() < unidadModelo.getPuntaje().getPuntajeBase()) {
            textoPuntaje.setFill(Color.RED);
        } else if (unidadModelo.getPuntaje().getPuntajeActual() > unidadModelo.getPuntaje().getPuntajeBase()) {
            textoPuntaje.setFill(Color.GREEN);
        } else {
            textoPuntaje.setFill(Color.BLACK);
        }

        textoPuntaje.setFont(Font.font(18));

        StackPane circuloConTexto = new StackPane(circuloPuntaje, textoPuntaje);
        circuloConTexto.setPrefSize(24, 24);

        circuloConTexto.setLayoutX(5);
        circuloConTexto.setLayoutY(5);

        capaTransparente.getChildren().add(circuloConTexto);


        HBox iconosModificadores = crearIconosModificadores(modificadores);
        iconosModificadores.setLayoutX(5);
        iconosModificadores.setLayoutY(50);
        capaTransparente.getChildren().add(iconosModificadores);

        this.getChildren().add(capaTransparente);

        this.setOnMouseClicked(e -> {
            StackPane vistaDetalle = getVentanaDetalle(true);
            Stage popup = new Stage();
            popup.setTitle(nombreUnidad);
            popup.setScene(new Scene(vistaDetalle, 300, 450));
            popup.setResizable(false);
            popup.focusedProperty().addListener((obs, oldVal, newVal) -> {
                if (!newVal) popup.close();
            });
            popup.show();
        });
    }

    @Override
    public StackPane getVentanaDetalle(Boolean sePuedeJugar){
        return crearVistaDetalles(sePuedeJugar);
    }

    public StackPane crearVistaDetalles(boolean sePuedeJugar) {
        Region fondo = new Region();
        fondo.setPrefSize(300, 450);
        fondo.setBackground(new Background(new BackgroundImage(
                this.imagenUnidad,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, false, true)
        )));

        Label nombreLabel = new Label(this.nombreUnidad);
        nombreLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 24px; -fx-text-fill: white;");

        Circle circuloPuntaje = new Circle(16);
        circuloPuntaje.setFill(Color.WHITE);

        Text textoPuntaje = new Text(String.valueOf(unidadModelo.getPuntaje().getPuntajeActual()));
        textoPuntaje.setFill(Color.BLACK);
        textoPuntaje.setFont(Font.font(18));

        StackPane circuloConTexto = new StackPane(circuloPuntaje, textoPuntaje);
        circuloConTexto.setPrefSize(32, 32);

        HBox nombreYPuntaje = new HBox(10, nombreLabel, circuloConTexto);
        nombreYPuntaje.setAlignment(Pos.CENTER_LEFT);

        HBox iconosModificadores = crearIconosModificadores(modificadores);

        HBox botonesPosiciones = new HBox(10);
        botonesPosiciones.setAlignment(Pos.CENTER);

        if (sePuedeJugar) {
            for (String posicionTexto : posiciones) {
                Posicion pos = PosicionParser.crearPosicion(posicionTexto);

                Button botonPosicion = new Button(posicionTexto);
                botonPosicion.setStyle(super.estiloBotonNormal());
                botonPosicion.setOnMouseEntered(e -> botonPosicion.setStyle(super.estiloBotonHover()));
                botonPosicion.setOnMouseExited(e -> botonPosicion.setStyle(super.estiloBotonNormal()));

                botonPosicion.setOnAction(e -> {
                    if (eventoJugarCarta != null) {
                        eventoJugarCarta.accept(unidadModelo, pos);
                    }
                    Stage stage = (Stage) botonPosicion.getScene().getWindow();
                    stage.close();
                });

                botonesPosiciones.getChildren().add(botonPosicion);
            }
        }

        VBox infoBox = new VBox(8, nombreYPuntaje, iconosModificadores, botonesPosiciones);
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




    private HBox crearIconosModificadores(List<String> modificadores) {
        HBox contenedor = new HBox(5);
        contenedor.setAlignment(Pos.CENTER_LEFT);

        for (String mod : modificadores) {
            String modLimpio = mod.toLowerCase().replaceAll("\\s+", "");
            Image imagenMod;
            try {
                imagenMod = new Image(getClass().getResource("/imagenes/modificadores/" + modLimpio + ".png").toExternalForm());
            } catch (Exception e) {
                continue;
            }
            ImageView iv = new ImageView(imagenMod);
            iv.setFitWidth(40);
            iv.setFitHeight(40);
            iv.setPreserveRatio(true);
            contenedor.getChildren().add(iv);
        }

        return contenedor;
    }
}