package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.AdminTurnos;
import edu.fiuba.algo3.modelo.juego.AdminturnosTodosPasaronDeTurno;
import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vistas.Contenedores.VistaAtril;
import edu.fiuba.algo3.vistas.Individuales.VistaPuntosJugador;
import javafx.application.Platform;
import javafx.scene.control.Alert;

public class ControladorTurnos {
  private final Gwent juego;
  private  VistaAtril vistaAtril1;
  private  VistaAtril vistaAtril2;
  private  VistaPuntosJugador puntosJugador1;
  private  VistaPuntosJugador puntosJugador2;

  public ControladorTurnos(Gwent juego){
    this.juego = juego;
  }

  public void setVistas(VistaAtril atrilJugador1, VistaAtril atrilJugador2, VistaPuntosJugador jugador1, VistaPuntosJugador jugador2) {
    this.vistaAtril1 = atrilJugador1;
    this.vistaAtril2 = atrilJugador2;
    this.puntosJugador1 = jugador1;
    this.puntosJugador2 = jugador2;
  }

  public Jugador jugadorActual() {
    return juego.getJugadorActual();
  }

  public Jugador jugadorProximo() {
    return juego.getJugadorProximo();
  }

  public void AvanzarTurno() {
    juego.pasarTurno();
    System.out.println("Nuevo turno: " + juego.getJugadorActual());
  }

  public void finalizarParticipacion() {
    boolean rondaTerminada = juego.finalizarParticipacion();

    if (rondaTerminada) {
      System.out.println("RONDA TERMINADA");
      int puntaje1 = vistaAtril1.PuntajeTotalAtril();
      int puntaje2 = vistaAtril2.PuntajeTotalAtril();

      if(puntaje1 > puntaje2){
        puntosJugador1.ganarRonda();
      }else if(puntaje2 > puntaje1){
        puntosJugador2.ganarRonda();
      }

      if (puntosJugador1.getRondasGanadas() == 2) {
        mostrarGanador("¡EL GUERRERO GANA!");
      } else if (puntosJugador2.getRondasGanadas() == 2) {
        mostrarGanador("¡EL OGRO GANA!");
      }

      juego.reiniciarRonda();
      vistaAtril1.actualizar();
      vistaAtril2.actualizar();
    }
  }

  private void mostrarGanador(String mensaje) {
    Platform.runLater(() -> {
      Alert alerta = new Alert(Alert.AlertType.INFORMATION);
      alerta.setTitle("JUEGO TERMINADO!, gracias");
      alerta.setHeaderText(null);
      alerta.setContentText(mensaje);
      alerta.showAndWait();
    });
  }

  public boolean juegoCompleto() {
    return jugadorActual().mazo() != null && jugadorProximo().mazo() != null;
  }
}