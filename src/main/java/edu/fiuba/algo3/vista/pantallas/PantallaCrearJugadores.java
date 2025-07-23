package edu.fiuba.algo3.vista.pantallas;



import edu.fiuba.algo3.vista.controlador.ControladorCrearJugadores;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class PantallaCrearJugadores {
    public PantallaCrearJugadores(Stage stage) {

        Image imagenDeFondo = new Image("/imagenes/fondoInicio.png");
        ImageView fondo = new ImageView(imagenDeFondo);
        fondo.setPreserveRatio(false);
        fondo.setSmooth(true);

        List<String> rutaImagenesUsuarios = new ArrayList<>();
        rutaImagenesUsuarios.add("/imagenes/usuarios/brujo.png");
        rutaImagenesUsuarios.add("/imagenes/usuarios/nortenio.png");
        rutaImagenesUsuarios.add("/imagenes/usuarios/tabernera.png");


        Label labelJ1 = new Label("Jugador 1");
        labelJ1.setFont(Font.font("Georgia", 28));
        labelJ1.setStyle("-fx-text-fill: white;");

        TextField inputNombreJ1 = new TextField();
        inputNombreJ1.setPromptText("Nombre Jugador 1");
        inputNombreJ1.setStyle(estiloInput());

        ImageView imagenJ1 = new ImageView();
        imagenJ1.setFitHeight(120);
        imagenJ1.setFitWidth(120);
        imagenJ1.setPreserveRatio(true);
        imagenJ1.setStyle("-fx-border-color: gold; -fx-border-width: 2;");

        HBox seccionImagenesJ1 = crearSeccionImagenes(imagenJ1, rutaImagenesUsuarios);

        VBox vboxJ1Contenido = new VBox(10, labelJ1, inputNombreJ1, imagenJ1, seccionImagenesJ1);
        vboxJ1Contenido.setAlignment(Pos.CENTER);
        vboxJ1Contenido.setPadding(new Insets(20));

        VBox vboxJ1Caja = new VBox(vboxJ1Contenido);
        vboxJ1Caja.setAlignment(Pos.CENTER);
        vboxJ1Caja.setStyle("-fx-background-color: rgba(255,255,255,0.8); -fx-background-radius: 10; -fx-border-color: black; -fx-border-radius: 10;");
        vboxJ1Caja.setPadding(new Insets(10));
        vboxJ1Caja.setMaxWidth(300);
        vboxJ1Caja.setStyle(estiloInput());

        Label labelJ2 = new Label("Jugador 2");
        labelJ2.setFont(Font.font("Georgia", 28));
        labelJ2.setStyle("-fx-text-fill: white;");

        TextField inputNombreJ2 = new TextField();
        inputNombreJ2.setPromptText("Nombre Jugador 2");
        inputNombreJ2.setStyle(estiloInput());

        ImageView imagenJ2 = new ImageView();
        imagenJ2.setFitHeight(120);
        imagenJ2.setFitWidth(120);
        imagenJ2.setPreserveRatio(true);
        imagenJ2.setStyle("-fx-border-color: gold; -fx-border-width: 2;");

        HBox seccionImagenesJ2 = crearSeccionImagenes(imagenJ2, rutaImagenesUsuarios);

        VBox vboxJ2Contenido = new VBox(10, labelJ2, inputNombreJ2, imagenJ2, seccionImagenesJ2);
        vboxJ2Contenido.setAlignment(Pos.CENTER);
        vboxJ2Contenido.setPadding(new Insets(20));

        VBox vboxJ2Caja = new VBox(vboxJ2Contenido);
        vboxJ2Caja.setAlignment(Pos.CENTER);
        vboxJ2Caja.setStyle("-fx-background-color: rgba(255,255,255,0.8); -fx-background-radius: 10; -fx-border-color: black; -fx-border-radius: 10;");
        vboxJ2Caja.setPadding(new Insets(10));
        vboxJ2Caja.setMaxWidth(300);
        vboxJ2Caja.setStyle(estiloInput());


        Button botonAceptar = new Button("Aceptar");
        botonAceptar.setFont(Font.font("Georgia", 24));
        botonAceptar.setPrefWidth(250);
        botonAceptar.setPrefHeight(60);
        botonAceptar.setStyle(estiloBotonNormal());
        botonAceptar.setOnMouseEntered(e -> botonAceptar.setStyle(estiloBotonHover()));
        botonAceptar.setOnMouseExited(e -> botonAceptar.setStyle(estiloBotonNormal()));


        HBox hboxJugadores = new HBox(50, vboxJ1Caja, vboxJ2Caja);
        hboxJugadores.setAlignment(Pos.CENTER);

        VBox contenido = new VBox(30, hboxJugadores, botonAceptar);
        contenido.setAlignment(Pos.CENTER);
        contenido.setPadding(new Insets(20));

        StackPane root = new StackPane(fondo, contenido);
        StackPane.setAlignment(contenido, Pos.CENTER);

        Scene scene = new Scene(root, 1000, 800);

        fondo.fitWidthProperty().bind(scene.widthProperty());
        fondo.fitHeightProperty().bind(scene.heightProperty());

        stage.setScene(scene);
        stage.setTitle("Seleccionar Jugadores");
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.show();

        new ControladorCrearJugadores(stage, inputNombreJ1, imagenJ1,
                inputNombreJ2, imagenJ2,
                botonAceptar);
    }

    private HBox crearSeccionImagenes(ImageView preview, List<String> rutas) {
        HBox seccion = new HBox(10);
        seccion.setAlignment(Pos.CENTER);

        for (String ruta : rutas) {
            Image imagen = new Image(ruta, 60, 60, true, true);
            ImageView miniatura = new ImageView(imagen);
            miniatura.setStyle("-fx-border-color: gray; -fx-cursor: hand;");
            miniatura.setOnMouseClicked(e -> {
                preview.setImage(imagen);
            });
            seccion.getChildren().add(miniatura);
        }

        return seccion;
    }

    private String estiloInput() {
        return "-fx-background-color: #333333;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 18px;" +
                "-fx-font-family: 'Georgia';" +
                "-fx-border-color: gold;" +
                "-fx-border-width: 2px;" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-padding: 8 10 8 10;";
    }

    private String estiloBotonNormal() {
        return "-fx-background-color: #333333;" +
                "-fx-text-fill: gold;" +
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Georgia';" +
                "-fx-font-size: 22px;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-border-color: gold;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, gold, 10, 0.4, 0, 0);";
    }

    private String estiloBotonHover() {
        return "-fx-background-color: #555555;" +
                "-fx-text-fill: gold;" +
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Georgia';" +
                "-fx-font-size: 22px;" +
                "-fx-background-radius: 12;" +
                "-fx-border-radius: 12;" +
                "-fx-border-color: gold;" +
                "-fx-border-width: 3px;" +
                "-fx-effect: dropshadow(gaussian, gold, 12, 0.6, 0, 0);";
    }
}
