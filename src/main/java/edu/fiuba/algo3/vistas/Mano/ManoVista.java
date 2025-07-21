package edu.fiuba.algo3.vistas.Mano;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.Mano;
import edu.fiuba.algo3.vistas.Cartas.CartaVista;
import edu.fiuba.algo3.vistas.Escenas.GameVista;
import javafx.geometry.Pos;
import edu.fiuba.algo3.modelo.jugador.*;

public class ManoVista extends StackPane {

  private Mano mano;
  private Rectangle fondo;
  private HBox contenedorCartas;
  private ArrayList<CartaVista> cartasVistas;
  private Jugador jugadorPoseedor;

  public ManoVista(Mano mano, Jugador jugadorPoseedor) {
    this.mano = mano;
    this.jugadorPoseedor = jugadorPoseedor;
    this.cartasVistas = new ArrayList<>();
    fondo = new Rectangle(800, 90);
    fondo.setFill(Color.WHITE);
    fondo.setStroke(Color.BLACK);

    contenedorCartas = new HBox(20);
    contenedorCartas.setAlignment(Pos.CENTER);
    contenedorCartas.setMinSize(800, 150);
    contenedorCartas.setMaxSize(800, 150);

    this.setMinSize(800, 150);
    this.setMaxSize(800, 150);
    this.getChildren().addAll(fondo, contenedorCartas);
  }

  public void actualizarLista() {
    ArrayList<CartaVista> vistasAEliminar = new ArrayList<>();

    for (CartaVista vista : this.cartasVistas) {
      if (!this.mano.contieneA(vista.getCarta())) {
        this.contenedorCartas.getChildren().remove(vista);
        vistasAEliminar.add(vista);
      }
    }

    this.cartasVistas.removeAll(vistasAEliminar);
  }

  public void addCartaVista(GameVista view) {
    for (ICarta carta : this.mano.getCartas()) {
      boolean existe = false;
      for (CartaVista vista : this.cartasVistas) {
        if (vista.getCarta().equals(carta)) {
          existe = true;
          break;
        }
      }
      if (!existe) {
        CartaVista vistaNueva = new CartaVista(carta);
        this.cartasVistas.add(vistaNueva);
        vistaNueva.setOnMouseClicked(e -> {
          view.mostrarVentanaCarta(carta, this.jugadorPoseedor);
        });
        this.contenedorCartas.getChildren().add(vistaNueva);
      }
    }
  }

  public void actualizarVista(GameVista view) {
    this.actualizarLista();
    this.addCartaVista(view);
  }
}
