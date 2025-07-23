package edu.fiuba.algo3.vista.vistas;

import edu.fiuba.algo3.modelo.Observer.Observador;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.unidad.Unidad;
import edu.fiuba.algo3.modelo.jugador.Atril.Seccion;
import edu.fiuba.algo3.modelo.posicion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posicion.Distancia;
import edu.fiuba.algo3.modelo.posicion.Posicion;
import edu.fiuba.algo3.vista.vistas.cartas.CacheEstilosVistaCarta;
import edu.fiuba.algo3.vista.vistas.cartas.EstiloVistaCarta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class VistaSeccion extends StackPane implements Observador {

    private HBox contenedorCartas;
    private StackPane puntajePane;
    private Text puntajeText;
    private Seccion seccion;
    private final List<Node> cartasVistas = new ArrayList<>();

    public VistaSeccion(Seccion seccion) {
        this.seccion = seccion;
        this.seccion.agregarObservador(this);

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
        puntajePane = new StackPane(puntajeBg, puntajeText);
        puntajePane.setAlignment(Pos.CENTER);
        puntajePane.setPrefSize(50, 50);
        StackPane.setAlignment(puntajePane, Pos.CENTER_LEFT);

        Posicion pos = this.seccion.getPosicion();

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

        actualizarVista();
    }

    public void actualizarVista() {
        contenedorCartas.getChildren().clear();
        cartasVistas.clear();

        int cantidadCartas = seccion.getUnidadesColocadas().size();
        double anchoDisponible = 700 - (10 * (cantidadCartas - 1));
        double anchoCarta = cantidadCartas > 0 ? Math.min(100, anchoDisponible / cantidadCartas) : 100;

        for (Carta cartaModelo : seccion.getUnidadesColocadas()) {
            EstiloVistaCarta estilo = CacheEstilosVistaCarta.getInstancia().getEstiloVistaCarta(cartaModelo.getNombre());
            Node vistaCarta = estilo.construir(cartaModelo, null);
            vistaCarta.setDisable(true);
            contenedorCartas.getChildren().add(vistaCarta);
            cartasVistas.add(vistaCarta);
        }

        puntajeText.setText(String.valueOf(seccion.getPuntaje()));
    }

    @Override
    public void notificar() {
        actualizarVista();
    }
}
