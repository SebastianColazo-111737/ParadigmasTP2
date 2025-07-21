package edu.fiuba.algo3.vistas.Escenas;

import edu.fiuba.algo3.Controller.GameController;
import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vistas.App;
import edu.fiuba.algo3.vistas.EstadoJugador.EstadoJugadorVista;
import edu.fiuba.algo3.vistas.GanadoresVista.VentanaGanador;
import edu.fiuba.algo3.vistas.Info.InfoVista;
import edu.fiuba.algo3.vistas.Mano.ManoVista;
import edu.fiuba.algo3.vistas.Seccion.SeccionEspecialVista;
import edu.fiuba.algo3.vistas.Tablero.TableroVista;
import edu.fiuba.algo3.vistas.VentanaJugar.VentanaJugarCarta;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;

public class GameVista {
  private Scene scene;
  private TableroVista tableroVista;
  private GameController game;
  private ManoVista mano1;
  private ManoVista mano2;
  private InfoVista info;
  private StackPane root;
  private EstadoJugadorVista vistaJ1;
  private EstadoJugadorVista vistaJ2;
  private SeccionEspecialVista especialJ2;
  private SeccionEspecialVista especialJ1;
  private VentanaGanador ganador;

  public GameVista(App app, GameController gameController) {
    this.game = gameController;
    this.tableroVista = new TableroVista(this.game.getTodasLasSecciones());
    this.mano1 = new ManoVista(this.game.getManoJ1(), this.game.getJugador1());
    this.mano2 = new ManoVista(this.game.getManoJ2(), this.game.getJugador2());
    this.info = new InfoVista();

    this.ganador = new VentanaGanador(() -> {
      System.out.println("El juego terminó");
    });

    this.especialJ2 = new SeccionEspecialVista();

    this.especialJ1 = new SeccionEspecialVista();
    VBox infoConTestIzquierda = new VBox(20, especialJ2, info, this.especialJ1);
    infoConTestIzquierda.setAlignment(Pos.CENTER);
    infoConTestIzquierda.setPadding(new Insets(30));
    infoConTestIzquierda.setPrefWidth(250);
    VBox.setVgrow(info, Priority.ALWAYS);

    this.vistaJ2 = new EstadoJugadorVista(game.getJugador2());
    this.vistaJ1 = new EstadoJugadorVista(game.getJugador1());

    VBox testDerecha = new VBox(20, this.vistaJ2, this.vistaJ1);
    testDerecha.setAlignment(Pos.CENTER);
    testDerecha.setPadding(new Insets(10));
    testDerecha.setPrefWidth(150);

    VBox layoutCentro = new VBox(20, mano2, tableroVista, mano1);
    layoutCentro.setAlignment(Pos.CENTER);
    layoutCentro.setPadding(new Insets(20));
    layoutCentro.setMaxWidth(600);
    layoutCentro.setPrefSize(600, 400);

    HBox layoutComplete = new HBox(40, infoConTestIzquierda, layoutCentro, testDerecha);
    layoutComplete.setAlignment(Pos.CENTER);
    layoutComplete.setPadding(new Insets(20));
    layoutComplete.setMaxWidth(app.getAncho());
    layoutComplete.setPrefSize(app.getAncho(), app.getAlto());

    this.root = new StackPane(layoutComplete);
    this.scene = new Scene(root, app.getAncho(), app.getAlto());

    this.ganador.setVisible(false);
    root.getChildren().add(this.ganador);

    GameVista self = this;
    AnimationTimer gameLoop = new AnimationTimer() {
      @Override
      public void handle(long now) {
        game.chequearEstado();
        tableroVista.actualizarVista();
        mano1.actualizarVista(self);
        mano2.actualizarVista(self);
        info.actualizarVista(game);
        vistaJ1.actualizarVista(game);
        vistaJ2.actualizarVista(game);
        especialJ2.actualizarVista(game.getJugador2().atril().getSeccionEspecial());
        especialJ1.actualizarVista(game.getJugador1().atril().getSeccionEspecial());
        self.mostrarVentanaGanador();

      }
    };
    gameLoop.start();
  }

  public Scene getScene() {
    return scene;
  }

  private void mostrarVentanaGanador() {
    if (!this.game.esFinDePartida()) {
      return;
    }
    this.ganador.actualizarVista(this.game.getGanador());
    this.ganador.setVisible(true);
  }

  public void mostrarVentanaCarta(ICarta carta, Jugador jugadorPerteneciente) {
    if (!jugadorPerteneciente.equals(this.game.getJugadorActual()))
      return;

    final VentanaJugarCarta[] ventanaRef = new VentanaJugarCarta[1];

    ventanaRef[0] = new VentanaJugarCarta(carta, jugadorPerteneciente, game, root, () -> {
      root.getChildren().remove(ventanaRef[0]);
      ventanaRef[0] = null;
    });

    root.getChildren().add(ventanaRef[0]);
  }

}
