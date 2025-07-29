package edu.fiuba.algo3.vista.pantallas;

import edu.fiuba.algo3.vista.controlador.ControladorPantallaInicial;
import edu.fiuba.algo3.vista.vistas.EstilosPantalla;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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
        btnJugar.setStyle(EstilosPantalla.botonEstiloNormal());
        btnJugar.setOnAction(e -> controlador.iniciarPartida());
        btnJugar.setOnMouseEntered(e -> btnJugar.setStyle(EstilosPantalla.botonEstiloHover()));
        btnJugar.setOnMouseExited(e -> btnJugar.setStyle(EstilosPantalla.botonEstiloNormal()));

        Button btnSalir = new Button("Salir");
        btnSalir.setPrefWidth(300);
        btnSalir.setPrefHeight(70);
        btnSalir.setStyle(EstilosPantalla.botonEstiloNormal());
        btnSalir.setOnAction(e -> System.exit(0));
        btnSalir.setOnMouseEntered(e -> btnSalir.setStyle(EstilosPantalla.botonEstiloHover()));
        btnSalir.setOnMouseExited(e -> btnSalir.setStyle(EstilosPantalla.botonEstiloNormal()));

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
}