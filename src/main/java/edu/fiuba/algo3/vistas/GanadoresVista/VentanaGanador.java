package edu.fiuba.algo3.vistas.GanadoresVista;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VentanaGanador extends StackPane {
  private Label mensaje;

  public VentanaGanador(Runnable onCerrar) {
    Rectangle fondo = new Rectangle();
    fondo.setFill(Color.rgb(0, 0, 0, 0.6));
    fondo.widthProperty().bind(this.widthProperty());
    fondo.heightProperty().bind(this.heightProperty());

    VBox contenido = new VBox(15);
    contenido.setPadding(new Insets(25));
    contenido.setAlignment(Pos.CENTER);
    contenido.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
    contenido.setMaxWidth(300);
    contenido.setMaxHeight(200);

    Label titulo = new Label("¡Fin del juego!");
    titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

    this.mensaje = new Label("Ganador: ");
    mensaje.setStyle("-fx-font-size: 16px;");

    Button cerrarBtn = new Button("Cerrar");
    cerrarBtn.setOnAction(e -> {
      if (onCerrar != null) {
        onCerrar.run();
      }
      this.setVisible(false);
      this.getChildren().clear();
    });

    contenido.getChildren().addAll(titulo, mensaje, cerrarBtn);
    this.getChildren().addAll(fondo, contenido);
    this.setAlignment(Pos.CENTER);
  }

  public void actualizarVista(Jugador ganador) {
    this.mensaje.setText("Ganador: " + ganador.nombre());
  }
}
