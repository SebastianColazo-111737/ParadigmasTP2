package edu.fiuba.algo3.vistas.VentanaJugar;

import java.util.ArrayList;

import edu.fiuba.algo3.Controller.GameController;
import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.especiales.CEspecial;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.modelo.cartas.unidades.*;
import edu.fiuba.algo3.vistas.Revivir.RevivirVista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import edu.fiuba.algo3.vistas.MusicaPlayer.*;

public class VentanaJugarCarta extends StackPane {

  public VentanaJugarCarta(MusicPlayer player, ICarta carta, Jugador jugadorPerteneciente, GameController game,
      StackPane root,
      Runnable onClose) {

    if (!jugadorPerteneciente.equals(game.getJugadorActual())) {
      return;
    }
    Rectangle fondoOscuro = new Rectangle();
    fondoOscuro.widthProperty().bind(root.widthProperty());
    fondoOscuro.heightProperty().bind(root.heightProperty());
    fondoOscuro.setFill(Color.rgb(0, 0, 0, 0.5));

    Image bgImage = new Image(getClass().getResourceAsStream("/images/backgroundWindow.jpg"));

    VBox modalContent = new VBox(15);
    modalContent.setPadding(new Insets(20));
    modalContent.setAlignment(Pos.CENTER);
    modalContent.setMaxWidth(400);
    modalContent.setMaxHeight(350);
    modalContent.setBackground(new Background(new BackgroundImage(
        bgImage,
        BackgroundRepeat.REPEAT,
        BackgroundRepeat.REPEAT,
        BackgroundPosition.CENTER,
        new BackgroundSize(400, 350, true, true, true, false))));
    modalContent.setBorder(new Border(new BorderStroke(
        Color.BEIGE,
        BorderStrokeStyle.SOLID,
        new CornerRadii(10),
        new BorderWidths(3))));

    // Título
    Label titulo = new Label(carta.nombre());
    titulo.setFont(new Font("Georgia", 20));
    titulo.setTextFill(Color.WHITE);

    Label tipo = new Label("Tipo: " + carta.getClass().getSimpleName());
    tipo.setFont(new Font("Arial", 14));
    tipo.setTextFill(Color.BEIGE);

    modalContent.getChildren().addAll(titulo, tipo);

    if (carta instanceof Unidad) {
      Label danoLabel = new Label("Daño: " + ((Unidad) carta).getPuntaje().getPuntajeBase());
      danoLabel.setFont(new Font("Arial", 14));
      danoLabel.setTextFill(Color.ORANGERED);
      modalContent.getChildren().add(danoLabel);
    }

    if (carta instanceof CEspecial) {
      CEspecial ccarta = (CEspecial) carta;

      Label descripcion = new Label(ccarta.descripcion());
      descripcion.setWrapText(true);
      descripcion.setTextAlignment(TextAlignment.CENTER);
      descripcion.setFont(new Font(13));
      descripcion.setTextFill(Color.LIGHTGOLDENRODYELLOW);
      modalContent.getChildren().add(descripcion);

      ArrayList<Posicion> posiciones = ccarta.posicionesAfectar();
      if (posiciones != null) {
        StringBuilder textoPosiciones = new StringBuilder("Posiciones: ");
        for (Posicion posicion : posiciones) {
          textoPosiciones.append(posicion.getClass().getSimpleName()).append(" ");
        }
        Label posicionesLabel = new Label(textoPosiciones.toString());
        posicionesLabel.setFont(new Font(12));
        posicionesLabel.setTextFill(Color.BURLYWOOD);
        posicionesLabel.setWrapText(true);
        posicionesLabel.setTextAlignment(TextAlignment.CENTER);
        modalContent.getChildren().add(posicionesLabel);
      }
    }

    HBox botones = new HBox(10);
    botones.setAlignment(Pos.CENTER);

    for (Posicion posicion : carta.getTipo()) {
      String nombrePosicion = posicion.getClass().getSimpleName();
      Button boton = new Button(nombrePosicion);
      boton.setStyle(
          "-fx-background-color: #A0522D;" +
              "-fx-text-fill: white;" +
              "-fx-font-weight: bold;" +
              "-fx-border-color: white;" +
              "-fx-border-width: 1.5;" +
              "-fx-background-radius: 5;" +
              "-fx-border-radius: 5;");
      boton.setOnAction(e -> {
        game.jugar(carta, posicion);

        try {
          player.cargarAudio("src/main/resources/sounds/playcard.wav");
          player.reproducir();
        } catch (Exception a) {
          a.printStackTrace();
        }

        onClose.run();
      });
      botones.getChildren().add(boton);
    }

    if (carta instanceof Medico) {
      Button revivir = new Button("Revivir");
      Medico medico = (Medico) carta;
      revivir.setStyle(
          "-fx-background-color: #8B4513;" +
              "-fx-text-fill: white;" +
              "-fx-font-weight: bold;" +
              "-fx-border-color: white;" +
              "-fx-border-width: 1.5;" +
              "-fx-background-radius: 5;" +
              "-fx-border-radius: 5;");
      final RevivirVista[] ventanaRevivir = new RevivirVista[1];
      revivir.setOnAction(e -> {
        ventanaRevivir[0] = new RevivirVista(() -> root.getChildren().remove(ventanaRevivir[0]),
            game.getCartasDelDescarteJugadorActual(), medico);
        root.getChildren().add(ventanaRevivir[0]);
      });
      botones.getChildren().add(revivir);
    }

    Button cerrarBtn = new Button("Salir");
    cerrarBtn.setStyle(
        "-fx-background-color: darkred;" +
            "-fx-text-fill: white;" +
            "-fx-font-weight: bold;" +
            "-fx-border-color: white;" +
            "-fx-border-width: 2;" +
            "-fx-background-radius: 5;" +
            "-fx-border-radius: 5;");
    cerrarBtn.setOnAction(e -> onClose.run());
    botones.getChildren().add(cerrarBtn);

    modalContent.getChildren().add(botones);

    this.getChildren().addAll(fondoOscuro, modalContent);
    this.setAlignment(Pos.CENTER);
  }
}
