package edu.fiuba.algo3.vista.pantallas;

import edu.fiuba.algo3.vista.controlador.ControladorPantallaInicial;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PantallaInicial {
    private final ControladorPantallaInicial controlador;

    public PantallaInicial(Stage stage) {
        this.controlador = new ControladorPantallaInicial(stage);

        Image logoImg = new Image(getClass().getResource("/images/logogwent.png").toExternalForm());
        ImageView logoView = new ImageView(logoImg);
        logoView.setPreserveRatio(true);
        logoView.setSmooth(true);
        logoView.setFitWidth(400);

        Button btnJugar = new Button("Jugar");
        btnJugar.setPrefWidth(300);
        btnJugar.setPrefHeight(70);
        btnJugar.setStyle(estiloBotonNormal());
        btnJugar.setOnAction(e -> controlador.iniciarPartida());
        btnJugar.setOnMouseEntered(e -> btnJugar.setStyle(estiloBotonHover()));
        btnJugar.setOnMouseExited(e -> btnJugar.setStyle(estiloBotonNormal()));

        Button btnSalir = new Button("Salir");
        btnSalir.setPrefWidth(300);
        btnSalir.setPrefHeight(70);
        btnSalir.setStyle(estiloBotonNormal());
        btnSalir.setOnAction(e -> System.exit(0));
        btnSalir.setOnMouseEntered(e -> btnSalir.setStyle(estiloBotonHover()));
        btnSalir.setOnMouseExited(e -> btnSalir.setStyle(estiloBotonNormal()));

        VBox layout = new VBox(30);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(logoView, btnJugar, btnSalir);

        Scene scene = new Scene(layout, 800, 600);

        Image fondoImg = new Image(getClass().getResource("/images/gwentbg.jpg").toExternalForm());
        BackgroundImage fondo = new BackgroundImage(
                fondoImg,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true)
        );
        layout.setBackground(new Background(fondo));

        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    private String estiloBotonNormal() {
        return "-fx-background-color: #333333;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Georgia';" +
                "-fx-font-size: 24px;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-border-color: gold;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, black, 10, 0.5, 0, 2);";
    }

    private String estiloBotonHover() {
        return "-fx-background-color: #555555;" +
                "-fx-text-fill: gold;" +
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Georgia';" +
                "-fx-font-size: 24px;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-border-color: gold;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, gold, 12, 0.6, 0, 0);";
    }
}