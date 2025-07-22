package edu.fiuba.algo3.vistas.Seccion;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.vistas.Cartas.CartaVista;
import edu.fiuba.algo3.modelo.posiciones.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class SeccionVista extends StackPane {

  private HBox contenedorCartas;
  private StackPane puntajePane;
  private Text puntajeText;
  private Seccion seccion;

  public SeccionVista(Seccion seccion) {
    this.seccion = seccion;

    // Cargar imagen de fondo
    Image imagenFondo = new Image(getClass().getResourceAsStream("/images/seccion.jpg"));
    BackgroundImage backgroundImage = new BackgroundImage(
        imagenFondo,
        BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.CENTER,
        new BackgroundSize(
            100, 100, true, true, false, true));
    this.setBackground(new Background(backgroundImage));

    // Borde blanco de 2px sólido
    this.setStyle("-fx-border-color: grey; -fx-border-width: 1px;");

    // Puntaje
    puntajeText = new Text();
    // Si quieres, puedes agregar estilo para mejor visibilidad sobre fondo
    // puntajeText.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-fill:
    // white;");

    javafx.scene.shape.Rectangle puntajeBg = new javafx.scene.shape.Rectangle(40, 40);
    puntajeBg.setFill(javafx.scene.paint.Color.GOLD);
    puntajePane = new StackPane(puntajeBg, puntajeText);
    puntajePane.setAlignment(Pos.CENTER);
    puntajePane.setPrefSize(50, 50);
    StackPane.setAlignment(puntajePane, Pos.CENTER_LEFT);

    Posicion pos = this.seccion.getPosicion();

    // Imagen según tipo de posición
    ImageView posicionImagenView = null;
    String rutaImagen = null;

    if (pos instanceof CuerpoACuerpo) {
      rutaImagen = "/images/sword.png";
    } else if (pos instanceof Distancia) {
      rutaImagen = "/images/bow.png";
    } else {
      rutaImagen = "/images/shield.png";
    }

    if (rutaImagen != null) {
      Image posicionImagen = new Image(getClass().getResourceAsStream(rutaImagen));
      posicionImagenView = new ImageView(posicionImagen);
      posicionImagenView.setPreserveRatio(true);
      posicionImagenView.setFitHeight(40);
      StackPane.setAlignment(posicionImagenView, Pos.CENTER);
    }

    // Contenedor cartas
    contenedorCartas = new HBox(10);
    contenedorCartas.setAlignment(Pos.CENTER);
    contenedorCartas.setPadding(new Insets(5));
    contenedorCartas.setFillHeight(true);
    contenedorCartas.setPrefHeight(60);
    contenedorCartas.setMaxWidth(Double.MAX_VALUE);
    HBox.setHgrow(contenedorCartas, Priority.ALWAYS);

    // Layout principal
    HBox layoutPrincipal = new HBox(15);
    layoutPrincipal.setAlignment(Pos.CENTER_LEFT);
    layoutPrincipal.setPadding(new Insets(10));
    layoutPrincipal.getChildren().addAll(puntajePane, contenedorCartas);

    if (posicionImagenView != null) {
      HBox.setHgrow(posicionImagenView, Priority.NEVER);
      layoutPrincipal.getChildren().add(posicionImagenView);
    }

    layoutPrincipal.setPrefSize(800, 70);

    this.getChildren().add(layoutPrincipal);

    this.setMinSize(800, 70);
    this.setPrefSize(800, 70);
    this.setMaxSize(800, 70);

    actualizarVista();
  }

  public void actualizarVista() {
    contenedorCartas.getChildren().clear();

    int cantidadCartas = seccion.getCartas().size();
    double anchoDisponible = 700 - (10 * (cantidadCartas - 1));
    double anchoCarta = cantidadCartas > 0 ? Math.min(100, anchoDisponible / cantidadCartas) : 100;

    for (Unidad u : seccion.getCartas()) {
      CartaVista uVista = new CartaVista(u);
      uVista.setPrefWidth(anchoCarta);
      uVista.setPrefHeight(50);
      contenedorCartas.getChildren().add(uVista);
    }

    puntajeText.setText(String.valueOf(seccion.calcularPuntajeActualUnidades().getPuntajeActual()));
  }
}
