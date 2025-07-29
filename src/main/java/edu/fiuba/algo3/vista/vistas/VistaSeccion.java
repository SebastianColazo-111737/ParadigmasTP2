package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.modelo.Observer.Observador;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.posicion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posicion.Distancia;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.vista.vistas.controladoresVistas.ControladorSeccion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;



public class VistaSeccion extends StackPane  implements Observador{

    private HBox contenedorCartas;
    private Text puntajeText;
    private ControladorSeccion controlador;

    public VistaSeccion(Seccion seccion) {
        this.controlador = new ControladorSeccion(seccion);
        seccion.agregarObservador(this);

        Image imagenFondo = new Image(getClass().getResourceAsStream("/images/seccion.jpg"));
        BackgroundImage backgroundImage = new BackgroundImage(
                imagenFondo,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, false, true));
        this.setBackground(new Background(backgroundImage));

        this.setStyle("-fx-border-color: grey; -fx-border-width: 1px;");

        puntajeText = new Text();

        javafx.scene.shape.Rectangle puntajeBg = new javafx.scene.shape.Rectangle(40, 40);
        puntajeBg.setFill(Color.GOLD);
        StackPane puntajePane = new StackPane(puntajeBg, puntajeText);
        puntajePane.setAlignment(Pos.CENTER);
        puntajePane.setPrefSize(50, 50);
        StackPane.setAlignment(puntajePane, Pos.CENTER_LEFT);

        Posicion pos = seccion.getPosicion();

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

        contenedorCartas = new HBox(10);
        contenedorCartas.setAlignment(Pos.CENTER);
        contenedorCartas.setPadding(new Insets(5));
        contenedorCartas.setFillHeight(true);
        contenedorCartas.setPrefHeight(60);
        contenedorCartas.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(contenedorCartas, Priority.ALWAYS);

        HBox layoutPrincipal = new HBox(15);
        layoutPrincipal.setAlignment(Pos.CENTER_LEFT);
        layoutPrincipal.setPadding(new Insets(10));
        layoutPrincipal.getChildren().addAll(puntajePane, contenedorCartas);

        if (posicionImagenView != null) {
            HBox.setHgrow(posicionImagenView, Priority.NEVER);
            layoutPrincipal.getChildren().add(posicionImagenView);
        }

        layoutPrincipal.setPrefSize(1100, 110);

        this.getChildren().add(layoutPrincipal);

        this.setMinSize(1100, 110);
        this.setPrefSize(1100, 110);
        this.setMaxSize(1100, 110);
    }

    @Override
    public void notificar() {
        controlador.actualizarVista(contenedorCartas, puntajeText);
    }
}
