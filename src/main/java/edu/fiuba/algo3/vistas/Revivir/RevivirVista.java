package edu.fiuba.algo3.vistas.Revivir;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.vistas.Cartas.CartaVista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import edu.fiuba.algo3.modelo.cartas.unidades.Medico;
import java.util.ArrayList;

public class RevivirVista extends StackPane {

  public RevivirVista(Runnable onClose, ArrayList<ICarta> cartasRevivir, Medico medico) {
    Rectangle fondo = new Rectangle();
    fondo.setFill(Color.rgb(0, 0, 0, 0.5));
    fondo.setMouseTransparent(false);
    fondo.widthProperty().bind(this.widthProperty());
    fondo.heightProperty().bind(this.heightProperty());

    Label titulo = new Label("Seleccioná una carta para revivir");
    titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

    VBox listaCartas = new VBox(10);
    listaCartas.setAlignment(Pos.CENTER);

    Button cerrarBtn = new Button("Cancelar");
    cerrarBtn.setOnAction(e -> onClose.run());

    for (ICarta carta : cartasRevivir) {
      CartaVista vistaCarta = new CartaVista(carta);
      StackPane cartaContainer = new StackPane(vistaCarta);
      cartaContainer.setOnMouseClicked((MouseEvent e) -> mostrarVentanaPosiciones(carta, medico));
      listaCartas.getChildren().add(cartaContainer);
    }

    VBox contenido = new VBox(20, titulo, listaCartas, cerrarBtn);
    contenido.setAlignment(Pos.CENTER);
    contenido.setPadding(new Insets(20));
    contenido.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 1px;");

    this.getChildren().addAll(fondo, contenido);
    this.setAlignment(Pos.CENTER);
  }

  private void mostrarVentanaPosiciones(ICarta carta, Medico m) {
    // Crear fondo modal
    Rectangle modalFondo = new Rectangle();
    modalFondo.setFill(Color.rgb(0, 0, 0, 0.7));
    modalFondo.widthProperty().bind(this.widthProperty());
    modalFondo.heightProperty().bind(this.heightProperty());

    // Contenedor modal
    VBox modalContent = new VBox(15);
    modalContent.setPadding(new Insets(20));
    modalContent.setAlignment(Pos.CENTER);
    modalContent.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
    modalContent.setMaxWidth(350);
    modalContent.setMaxHeight(300);

    Label titulo = new Label("Posiciones para: " + carta.getClass().getSimpleName());
    titulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

    VBox botonesPosiciones = new VBox(10);
    botonesPosiciones.setAlignment(Pos.CENTER);

    for (Posicion pos : carta.getTipo()) {
      Button btnPos = new Button(pos.getClass().getSimpleName());
      btnPos.setOnAction(e -> {
        m.setUnidadParaRevivir(carta, pos);
        this.getChildren().removeAll(modalFondo, modalContent);
      });
      botonesPosiciones.getChildren().add(btnPos);
    }

    modalContent.getChildren().addAll(titulo, botonesPosiciones);

    this.getChildren().addAll(modalFondo, modalContent);
    this.setAlignment(Pos.CENTER);
  }
}
