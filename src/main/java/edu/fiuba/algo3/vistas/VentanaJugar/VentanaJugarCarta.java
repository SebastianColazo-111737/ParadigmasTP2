package edu.fiuba.algo3.vistas.VentanaJugar;

import edu.fiuba.algo3.Controller.GameController;
import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.modelo.cartas.unidades.*;
import edu.fiuba.algo3.vistas.Revivir.RevivirVista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class VentanaJugarCarta extends StackPane {

  public VentanaJugarCarta(ICarta carta, Jugador jugadorPerteneciente, GameController game, StackPane root,
      Runnable onClose) {
    if (!jugadorPerteneciente.equals(game.getJugadorActual())) {
      return;
    }

    Rectangle fondo = new Rectangle();
    fondo.widthProperty().bind(root.widthProperty());
    fondo.heightProperty().bind(root.heightProperty());
    fondo.setFill(Color.rgb(0, 0, 0, 0.5));

    VBox modalContent = new VBox(20);
    modalContent.setPadding(new Insets(20));
    modalContent.setAlignment(Pos.CENTER);
    modalContent.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
    modalContent.setPrefSize(400, 300);

    Label descripcion = new Label("¿Dónde querés jugar la carta?");
    descripcion.setWrapText(true);
    descripcion.setTextAlignment(TextAlignment.CENTER);
    descripcion.setFont(new Font(16));

    HBox botones = new HBox(20);
    botones.setAlignment(Pos.CENTER);

    modalContent.getChildren().addAll(descripcion, botones);
    this.getChildren().addAll(fondo, modalContent);
    this.setAlignment(Pos.CENTER);

    for (Posicion posicion : carta.getTipo()) {
      String nombrePosicion = posicion.getClass().getSimpleName();
      Button boton = new Button(nombrePosicion);
      boton.setOnAction(e -> {
        game.jugar(carta, posicion);
        onClose.run();
      });
      botones.getChildren().add(boton);
    }

    if (carta instanceof Medico) {
      Button revivir = new Button("Revivir");
      final RevivirVista[] ventanaRevivir = new RevivirVista[1];
      Medico m = (Medico) carta;
      revivir.setOnAction(e -> {
        ventanaRevivir[0] = new RevivirVista(() -> root.getChildren().remove(ventanaRevivir[0]),
            game.getCartasDelDescarteJugadorActual(), m);
        root.getChildren().add(ventanaRevivir[0]);
      });

      botones.getChildren().add(revivir);
    }

    Button cerrarBtn = new Button("Salir");
    cerrarBtn.setOnAction(e -> onClose.run());
    botones.getChildren().add(cerrarBtn);
  }
}
