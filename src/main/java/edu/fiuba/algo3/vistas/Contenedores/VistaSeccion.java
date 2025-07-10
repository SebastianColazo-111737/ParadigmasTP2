package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.ControladorTurnos;
import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.especiales.BuffCartas;
import edu.fiuba.algo3.modelo.cartas.especiales.DeBuffCleaner;
import edu.fiuba.algo3.modelo.cartas.especiales.Debuff;
import edu.fiuba.algo3.modelo.cartas.unidades.Medico;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.jugador.atril.SeccionNoPermiteColocarUnidadesConPosicionIncompatible;
import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.vistas.Individuales.VistaCarta;
import edu.fiuba.algo3.vistas.Individuales.VistaPuntos;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VistaSeccion extends HBox implements IEfectoVisual{

  private final Seccion seccionModelo;
  private final Jugador jugador;
  private final HBox cartasApoyadas;
  private final VistaPuntos vistaPuntos;
  private static final int CapacidadMaxima = 8;
  private final ControladorTurnos controladorTurnos;
  private final VistaTurnos vistaTurnos;
  private final VistaMano vistaMano;
  private Region espacioBuff;
  private StackPane contenedorBuff;
  private CambiosEspecialesSecciones efectosVisuales;

  public VistaSeccion(Seccion seccionModelo, Jugador jugador, VistaMano vistaMano, VistaTurnos vistaTurnos,
                      ControladorTurnos controladorTurnos) {

    this.seccionModelo = seccionModelo;
    this.jugador = jugador;
    this.controladorTurnos = controladorTurnos;
    this.vistaTurnos = vistaTurnos;
    this.vistaMano = vistaMano;

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

    this.espacioBuff = new Region();
    this.espacioBuff.setPrefWidth(40);

    this.contenedorBuff = new StackPane();
    this.contenedorBuff.setPrefWidth(40);
    this.contenedorBuff.setAlignment(Pos.TOP_RIGHT);

    this.efectosVisuales = new CambiosEspecialesSecciones(contenedorBuff,espacioBuff,this);

    configurarDragYDrop();
    actualizar();
    this.setMinWidth(700);

    seccionModelo.agregarObservador(()-> Platform.runLater(this::actualizar));
    this.getChildren().addAll(vistaPuntos, contenedorEmoji, cartasApoyadas, contenedorBuff, espacioBuff);
  }

  private void configurarDragYDrop() {
    this.setOnDragOver(e -> {
      if (esDragValido(e)) {
        e.acceptTransferModes(TransferMode.MOVE);
      }
      e.consume();
    });

    this.setOnDragDropped(e -> {
      boolean seMovio = procesarDrop(e);
      e.setDropCompleted(seMovio);
      e.consume();
    });
  }

  private boolean esDragValido(DragEvent e) {
    return e.getGestureSource() instanceof VistaCarta
            && seccionModelo.getUnidadesColocadas().size() < CapacidadMaxima;
  }

  private boolean procesarDrop(DragEvent e) {
    Dragboard tablaSeccion = e.getDragboard();

    if (!tablaSeccion.hasString()
            || VistaCarta.cartaSeleccionada == null
            || seccionModelo.getUnidadesColocadas().size() >= CapacidadMaxima
            || !controladorTurnos.jugadorActual().equals(jugador)) {
      return false;
    }

    VistaCarta vistaCarta = VistaCarta.cartaSeleccionada;
    ICarta cartaModelo = vistaCarta.getCartaModelo();

    try{
      seccionModelo.validarCartaEspecial(cartaModelo);
    }catch (SeccionNoPermiteColocarUnidadesConPosicionIncompatible ex){
      System.out.println("Carta especial colocada en sección incompatible: " + ex.getMessage());
      return false;
    }

    Jugador jugadorActual = controladorTurnos.jugadorActual();
    jugadorActual.jugarCarta(cartaModelo, controladorTurnos.jugadorProximo(), seccionModelo.getPosicion());

    if (cartaModelo instanceof Medico) {
      manejarCartaMedico((Medico) cartaModelo);
    }else{
      EfectosEspecialesDispatcher.aplicar(cartaModelo,this,controladorTurnos,this);
    }

    vistaMano.removerVistaCarta(vistaCarta);
    controladorTurnos.AvanzarTurno();
    vistaTurnos.actualizarTurnos();
    this.actualizar();

    System.out.println("Carta jugada: " + cartaModelo.getClass().getSimpleName());

    return true;
  }

  private void manejarCartaMedico(Medico medico) {
    Jugador jugadorActual = controladorTurnos.jugadorActual();
    Optional<ICarta> revivida = jugadorActual.revivirUltimaUnidadDescarte();
    if (revivida.isPresent()) {
      System.out.println("Carta revivida: " + revivida.get().nombre());
      vistaMano.recibirCartaRevivida(revivida.get());
    } else {
      System.out.println("No se revivio ninguna carta.");
    }
  }

  public void actualizar() {
    List<ICarta> cartasModelo = seccionModelo.getUnidadesColocadas().stream()
            .map(c -> (ICarta) c)
            .collect(Collectors.toList());

    List<Node> nodosAEliminar = new ArrayList<>();
    for (Node nodo : cartasApoyadas.getChildren()) {
      VistaCarta vista = (VistaCarta) nodo;
      if (!cartasModelo.contains(vista.getCartaModelo())) {
        nodosAEliminar.add(nodo);
      }
    }

    //Esto es para el efecto de transicion al eliminar las cartas

    for (Node nodo : nodosAEliminar) {
      FadeTransition fadeOut = new FadeTransition(Duration.millis(300), nodo);
      fadeOut.setFromValue(1.0);
      fadeOut.setToValue(0.0);
      fadeOut.setOnFinished(e -> cartasApoyadas.getChildren().remove(nodo));
      fadeOut.play();
    }

    List<ICarta> cartasActuales = cartasApoyadas.getChildren().stream()
            .map(n -> ((VistaCarta) n).getCartaModelo())
            .collect(Collectors.toList());

    for (ICarta carta : cartasModelo) {
      if (!cartasActuales.contains(carta)) {
        VistaCarta nuevaVista = new VistaCarta(carta, v -> {});
        cartasApoyadas.getChildren().add(nuevaVista);
      }
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

  public void desactivarDebuff(){ //Tambien sirve para desactivar visualmente Buffs, es lo mismo
    efectosVisuales.limpiar();
  }

  public Posicion getPosicion(){
    return seccionModelo.getPosicion();
  }

  @Override
  public void activarBuff(){
    efectosVisuales.activarBuff();
  }

  @Override
  public void activarDebuffEscarcha() {
    efectosVisuales.activarDebuffEscarcha();
  }

  @Override
  public void activarDebuffLluvia() {
    efectosVisuales.activarDebuffLluvia();
  }

  @Override
  public void activarDebuffTormenta() {
    efectosVisuales.activarDebuffTormenta();
  }
}
