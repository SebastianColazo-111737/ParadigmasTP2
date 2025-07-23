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
        btnJugar.setFont(Font.font(18));
        btnJugar.setStyle(controlador.botonEstiloNormal());
        btnJugar.setOnAction(e -> controlador.iniciarPartida());

        // Hover efecto
        btnJugar.setOnMouseEntered(e -> btnJugar.setStyle(controlador.botonEstiloHover()));
        btnJugar.setOnMouseExited(e -> btnJugar.setStyle(controlador.botonEstiloNormal()));

        Button btnSalir = new Button("Salir");
        btnSalir.setFont(Font.font(18));
        btnSalir.setStyle(controlador.botonEstiloNormal());
        btnSalir.setOnAction(e -> System.exit(0));

        btnSalir.setOnMouseEntered(e -> btnSalir.setStyle(controlador.botonEstiloHover()));
        btnSalir.setOnMouseExited(e -> btnSalir.setStyle(controlador.botonEstiloNormal()));

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
                new BackgroundSize(100, 100, true, true, true, true));
        layout.setBackground(new Background(fondo));

        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            double nuevoAncho = newVal.doubleValue() * 0.5;
            logoView.setFitWidth(nuevoAncho);
        });

        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
            layout.setBackground(new Background(fondo));
        });

        stage.setScene(scene);
        stage.setFullScreen(true); // 👈 Pantalla completa
        stage.show();
    }
}
