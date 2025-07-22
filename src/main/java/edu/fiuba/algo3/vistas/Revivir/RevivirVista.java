package edu.fiuba.algo3.vistas.Revivir;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.vistas.Cartas.CartaVista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import edu.fiuba.algo3.modelo.cartas.unidades.Medico;

import java.util.ArrayList;

public class RevivirVista extends StackPane {

  private Label cartaSeleccionadaLabel;

  public RevivirVista(Runnable onClose, ArrayList<ICarta> cartasRevivir, Medico medico) {
    Rectangle fondoOscuro = new Rectangle();
    fondoOscuro.widthProperty().bind(this.widthProperty());
    fondoOscuro.heightProperty().bind(this.heightProperty());
    fondoOscuro.setFill(Color.rgb(0, 0, 0, 0.5));

    // Cargar imagen de fondo para el modal
    Image bgImage = new Image(getClass().getResourceAsStream("/images/backgroundWindow.jpg"));

    // Contenedor principal del modal con imagen de fondo
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

    Label titulo = new Label("Seleccioná una carta para revivir");
    titulo.setFont(javafx.scene.text.Font.font("Georgia", 20));
    titulo.setTextFill(Color.WHITE);

    cartaSeleccionadaLabel = new Label("Seleccionado: -");
    cartaSeleccionadaLabel.setFont(javafx.scene.text.Font.font("Arial", 14));
    cartaSeleccionadaLabel.setTextFill(Color.BEIGE);

    VBox listaCartas = new VBox(10);
    listaCartas.setAlignment(Pos.CENTER);

    for (ICarta carta : cartasRevivir) {
      CartaVista vistaCarta = new CartaVista(carta);
      StackPane cartaContainer = new StackPane(vistaCarta);
      cartaContainer.setOnMouseClicked((MouseEvent e) -> {
        cartaSeleccionadaLabel.setText("Seleccionado: " + medico.getNombreRevivir());
        mostrarVentanaPosiciones(carta, medico);
      });
      listaCartas.getChildren().add(cartaContainer);
    }

    Button cerrarBtn = new Button("Cancelar");
    cerrarBtn.setStyle(
        "-fx-background-color: darkred;" +
            "-fx-text-fill: white;" +
            "-fx-font-weight: bold;" +
            "-fx-border-color: white;" +
            "-fx-border-width: 2;" +
            "-fx-background-radius: 5;" +
            "-fx-border-radius: 5;");
    cerrarBtn.setOnAction(e -> onClose.run());

    modalContent.getChildren().addAll(titulo, cartaSeleccionadaLabel, listaCartas, cerrarBtn);

    this.getChildren().addAll(fondoOscuro, modalContent);
    this.setAlignment(Pos.CENTER);
  }

  private void mostrarVentanaPosiciones(ICarta carta, Medico medico) {
    // Fondo oscuro semitransparente para el modal de posiciones
    Rectangle modalFondo = new Rectangle();
    modalFondo.widthProperty().bind(this.widthProperty());
    modalFondo.heightProperty().bind(this.heightProperty());
    modalFondo.setFill(Color.rgb(0, 0, 0, 0.5));

    // Imagen de fondo para el modal de posiciones
    Image bgImage = new Image(getClass().getResourceAsStream("/images/backgroundWindow.jpg"));

    VBox modalContent = new VBox(15);
    modalContent.setPadding(new Insets(20));
    modalContent.setAlignment(Pos.CENTER);
    modalContent.setMaxWidth(400);
    modalContent.setMaxHeight(300);
    modalContent.setBackground(new Background(new BackgroundImage(
        bgImage,
        BackgroundRepeat.REPEAT,
        BackgroundRepeat.REPEAT,
        BackgroundPosition.CENTER,
        new BackgroundSize(400, 300, true, true, true, false))));
    modalContent.setBorder(new Border(new BorderStroke(
        Color.BEIGE,
        BorderStrokeStyle.SOLID,
        new CornerRadii(10),
        new BorderWidths(3))));

    Label titulo = new Label("Posiciones para: " + carta.getClass().getSimpleName());
    titulo.setFont(javafx.scene.text.Font.font("Georgia", 18));
    titulo.setTextFill(Color.WHITE);

    VBox botonesPosiciones = new VBox(10);
    botonesPosiciones.setAlignment(Pos.CENTER);

    for (Posicion pos : carta.getTipo()) {
      Button btnPos = new Button(pos.getClass().getSimpleName());
      btnPos.setStyle(
          "-fx-background-color: #A0522D;" +
              "-fx-text-fill: white;" +
              "-fx-font-weight: bold;" +
              "-fx-border-color: white;" +
              "-fx-border-width: 1.5;" +
              "-fx-background-radius: 5;" +
              "-fx-border-radius: 5;");
      btnPos.setOnAction(e -> {
        medico.setUnidadParaRevivir(carta, pos);
        this.getChildren().removeAll(modalFondo, modalContent);
      });
      botonesPosiciones.getChildren().add(btnPos);
    }

    modalContent.getChildren().addAll(titulo, botonesPosiciones);

    this.getChildren().addAll(modalFondo, modalContent);
    this.setAlignment(Pos.CENTER);
  }
}
