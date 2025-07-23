package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.modelo.gwent.Resultado;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

public class VistaJugador extends StackPane {

    private Jugador jugadorModelo;
    private String nombreJugador;
    private Image imagenJugador;
    private Label puntajeLabel;
    private HBox rondasGanadasBox;
    private Label puntajeCirculoLabel;

    public VistaJugador(Jugador jugadorModelo, String nombre, Image imagenJugador) {
        this.jugadorModelo = jugadorModelo;
        this.nombreJugador = nombre;
        this.imagenJugador = imagenJugador;

        ImageView avatar = new ImageView(imagenJugador);
        avatar.setFitWidth(80);
        avatar.setFitHeight(80);
        avatar.setPreserveRatio(true);

        Circle clip = new Circle(40, 40, 40);
        avatar.setClip(clip);

        StackPane avatarContainer = new StackPane(avatar);
        avatarContainer.setPrefSize(80, 80);

        Label nombreLabel = new Label(nombre);
        nombreLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 20px; -fx-text-fill: #ffffff;");

        puntajeLabel = new Label();
        puntajeLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #dddddd;");

        rondasGanadasBox = new HBox(5);
        rondasGanadasBox.setAlignment(Pos.CENTER_LEFT);

        VBox infoJugador = new VBox(5, nombreLabel, rondasGanadasBox);
        infoJugador.setAlignment(Pos.CENTER_LEFT);

        Circle circulo = new Circle(25, Color.WHITE);
        circulo.setStroke(Color.BLACK);
        circulo.setStrokeWidth(2);

        puntajeCirculoLabel = new Label(String.valueOf(jugadorModelo.getPuntaje()));
        puntajeCirculoLabel.setTextFill(Color.BLACK);
        puntajeCirculoLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        StackPane puntajeContainer = new StackPane(circulo, puntajeCirculoLabel);
        puntajeContainer.setPrefSize(50, 50);
        puntajeContainer.setMaxSize(50, 50);
        puntajeContainer.setAlignment(Pos.CENTER);

        HBox contenido = new HBox(10, avatarContainer, infoJugador, puntajeContainer);
        contenido.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(infoJugador, Priority.ALWAYS);
        contenido.setPadding(new Insets(0, 10, 0, 0));

        this.getChildren().add(contenido);
        this.setPadding(new Insets(10));
        this.setStyle("-fx-background-color: rgba(20, 20, 20, 0.7); -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color: #888;");
        this.setEffect(new DropShadow(10, Color.BLACK));
        this.setPrefSize(300, 120);
        this.setMaxSize(300, 120);

        actualizar(0);
    }

    public void actualizar(int cantidadDeRondasGanadas) {
        int puntaje = jugadorModelo.getPuntaje();
        puntajeCirculoLabel.setText(String.valueOf(puntaje));

        rondasGanadasBox.getChildren().clear();
        for (int i = 0; i < 2; i++) {
            ImageView monedaView;
            if (i < cantidadDeRondasGanadas) {
                Image monedaGanada = new Image("/imagenes/moneda.png");
                monedaView = new ImageView(monedaGanada);
            } else {
                Image monedaPerdida = new Image("/imagenes/monedaApagada.png");
                monedaView = new ImageView(monedaPerdida);
            }

            monedaView.setFitWidth(60);
            monedaView.setFitHeight(60);
            monedaView.setPreserveRatio(true);

            rondasGanadasBox.getChildren().add(monedaView);
        }
    }

    public void resaltarTurno(boolean esTurno) {
        if (esTurno) {
            this.setStyle("-fx-background-color: rgba(20, 20, 20, 0.7);"
                    + " -fx-background-radius: 10;"
                    + " -fx-border-radius: 10;"
                    + " -fx-border-color: #FFD700;"
                    + " -fx-border-width: 3;");
        } else {
            this.setStyle("-fx-background-color: rgba(20, 20, 20, 0.7);"
                    + " -fx-background-radius: 10;"
                    + " -fx-border-radius: 10;"
                    + " -fx-border-color: transparent;"
                    + " -fx-border-width: 0;");
        }
    }

    public void mostrarPantallaGanador(List<Resultado> resultados) {
        Stage ventana = new Stage();
        ventana.setTitle("¡Victoria!");
        ventana.initModality(Modality.APPLICATION_MODAL);

        ImageView imagen = new ImageView(this.imagenJugador);
        imagen.setFitWidth(200);
        imagen.setPreserveRatio(true);

        Label nombre = new Label("¡Victoria " + this.nombreJugador + "!");
        nombre.setStyle("-fx-font-size: 28px; -fx-text-fill: gold; -fx-font-weight: bold;");

        VBox tablaResultados = new VBox(20);
        tablaResultados.setAlignment(Pos.CENTER);

        HBox filaRondas = new HBox(30);
        filaRondas.setAlignment(Pos.CENTER);
        for (int i = 0; i < resultados.size(); i++) {
            Label rondaLabel = new Label("Ronda " + (i + 1));
            rondaLabel.setMinWidth(120);
            rondaLabel.setAlignment(Pos.CENTER);
            rondaLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 18px;"
                    + "-fx-border-color: gold; -fx-border-width: 1; -fx-padding: 10;");
            filaRondas.getChildren().add(rondaLabel);
        }

        HBox filaPuntos = new HBox(30);
        filaPuntos.setAlignment(Pos.CENTER);
        for (Resultado resultado : resultados) {
            var puntuacion = resultado.getPuntuacion();
            Jugador[] jugadores = puntuacion.keySet().toArray(new Jugador[0]);

            if (jugadores.length != 2) continue;
            int p1 = puntuacion.get(jugadores[0]);
            int p2 = puntuacion.get(jugadores[1]);

            Label puntosLabel = new Label(p1 + " - " + p2);
            puntosLabel.setMinWidth(120);
            puntosLabel.setAlignment(Pos.CENTER);
            puntosLabel.setStyle("-fx-text-fill: white; -fx-font-size: 18px;"
                    + "-fx-border-color: silver; -fx-border-width: 1; -fx-padding: 10;");
            filaPuntos.getChildren().add(puntosLabel);
        }

        tablaResultados.getChildren().addAll(filaRondas, filaPuntos);

        VBox contenedor = new VBox(30, imagen, nombre, tablaResultados);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setPadding(new Insets(30));
        contenedor.setStyle("-fx-background-color: #222;");

        Scene escena = new Scene(contenedor, 800, 500);
        ventana.setScene(escena);
        ventana.setOnCloseRequest(e -> Platform.exit());
        ventana.showAndWait();
    }

}
