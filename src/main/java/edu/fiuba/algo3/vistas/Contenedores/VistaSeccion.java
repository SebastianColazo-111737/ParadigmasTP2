package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.ControladorTurnos;
import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.unidades.Medico;
import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.jugador.Descarte;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.vistas.Individuales.VistaCarta;
import edu.fiuba.algo3.vistas.Individuales.VistaDescarte;
import edu.fiuba.algo3.vistas.Individuales.VistaPuntos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Font;

import java.util.List;
import java.util.Optional;

public class VistaSeccion extends HBox {

  private final Seccion seccionModelo;
  private final Jugador jugador;
  private final HBox cartasApoyadas;
  private final VistaPuntos vistaPuntos;
  private static final int CapacidadMaxima = 8;
  private final ControladorTurnos controladorTurnos;
  private final VistaTurnos vistaTurnos;
  private final VistaMano vistaMano;
  private final VistaDescarte vistaDescarte;

  public VistaSeccion(Seccion seccionModelo, Jugador jugador, VistaMano vistaMano, VistaTurnos vistaTurnos,
                      ControladorTurnos controladorTurnos, VistaDescarte vistaDescarte) {

    this.seccionModelo = seccionModelo;
    this.jugador = jugador;
    this.controladorTurnos = controladorTurnos;
    this.vistaTurnos = vistaTurnos;
    this.vistaMano = vistaMano;
    this.vistaDescarte = vistaDescarte;

    this.vistaPuntos = new VistaPuntos(seccionModelo);

    this.setSpacing(10);
    this.setAlignment(Pos.CENTER_LEFT);
    this.setPadding(new Insets(5));

    this.setPrefHeight(100);
    this.setMinHeight(100);

    this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    this.setBorder(new Border(new BorderStroke(
            Color.BLACK,
            BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY,
            new BorderWidths(2)
    )));

    Rectangle rectangulo = new Rectangle(380, 120);
    rectangulo.setFill(Color.LIGHTGRAY);
    rectangulo.setStroke(Color.BLACK);

    Label etiqueta = new Label(nombreDesdePos(seccionModelo));
    etiqueta.setFont(Font.font(24));

    StackPane contenedorEmoji = new StackPane(etiqueta);
    contenedorEmoji.setPrefSize(60, 80);

    this.cartasApoyadas = new HBox(5);
    this.cartasApoyadas.setAlignment(Pos.CENTER_LEFT);
    this.cartasApoyadas.setPrefHeight(110);
    this.cartasApoyadas.setMinHeight(110);

    this.getChildren().addAll(vistaPuntos, contenedorEmoji, cartasApoyadas);

    configurarDragYDrop();
    actualizar();
    this.setMinWidth(700);

  }

  private void configurarDragYDrop() {
    this.setOnDragOver(e -> {
      if (e.getGestureSource() instanceof VistaCarta
              && seccionModelo.getUnidadesColocadas().size() < CapacidadMaxima) {
        e.acceptTransferModes(TransferMode.MOVE);
      }
      e.consume();
    });

    this.setOnDragDropped(e -> {
      Dragboard tablaSeccion = e.getDragboard();
      boolean seMovio = false;

      if (tablaSeccion.hasString()
              && VistaCarta.cartaSeleccionada != null
              && seccionModelo.getUnidadesColocadas().size() < CapacidadMaxima
              && controladorTurnos.jugadorActual().equals(jugador)) {

        VistaCarta vistaCarta = VistaCarta.cartaSeleccionada;
        ICarta cartaModelo = vistaCarta.getCartaModelo();

        Jugador jugadorActual = controladorTurnos.jugadorActual();

        if (cartaModelo instanceof Medico) {
          Optional<ICarta> revivida = jugadorActual.revivirUltimaUnidadDescarte();
          if (revivida.isPresent()) {
            System.out.println("Carta revivida: " + revivida.get().nombre());
            vistaMano.recibirCartaRevivida(revivida.get());
          } else {
            System.out.println("No se revivió ninguna carta.");
          }
        }

        jugadorActual.jugarCarta(cartaModelo, controladorTurnos.jugadorProximo(), seccionModelo.getPosicion());
        vistaMano.removerVistaCarta(vistaCarta);

        System.out.println("Carta jugada: " + cartaModelo.getClass().getSimpleName());



        controladorTurnos.AvanzarTurno();
        vistaTurnos.actualizarTurnos();
        this.actualizar();

        seMovio = true;
      }
      e.setDropCompleted(seMovio);
      e.consume();
    });
  }

  public void actualizar(){
    cartasApoyadas.getChildren().clear();

    for (Unidad unidad : seccionModelo.getUnidadesColocadas()) {
      VistaCarta vistaCarta = new VistaCarta(unidad, vista -> {});
      cartasApoyadas.getChildren().add(vistaCarta);
    }

    vistaPuntos.actualizarPuntaje(seccionModelo.calcularPuntajeActualUnidades().getPuntajeActual());
  }

  private String nombreDesdePos(Seccion seccion) {
    Posicion pos = seccion.getPosicion();
    if (pos instanceof CuerpoACuerpo)
      return "\uD83D\uDDE1\uFE0F";
    if (pos instanceof Distancia)
      return "⋙";
    if (pos instanceof Asedio)
      return "\uD83D\uDEE1\uFE0F";
    return "La seccion no existe";
  }
}
