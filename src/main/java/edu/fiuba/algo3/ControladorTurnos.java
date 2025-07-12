package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.Gwent;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.vistas.Contenedores.VistaAtril;
import edu.fiuba.algo3.vistas.Contenedores.VistaSeccion;
import edu.fiuba.algo3.vistas.Individuales.VistaPuntosJugador;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class ControladorTurnos {
  private final Gwent juego;
  private  VistaAtril vistaAtril1;
  private  VistaAtril vistaAtril2;
  private  VistaPuntosJugador puntosJugador1;
  private  VistaPuntosJugador puntosJugador2;
  private final String nomJ1;
  private final String nomJ2;
  private final List<VistaSeccion> seccionesBuffeadas = new ArrayList<>();
  private final ArrayList<VistaSeccion> seccionesDebuffeadas = new ArrayList<>();

  public ControladorTurnos(Gwent juego, String nomJ1, String nomJ2){
    this.juego = juego;
    this.nomJ1 = nomJ1;
    this.nomJ2 = nomJ2;
  }

  public void setVistas(VistaAtril atrilJugador1, VistaAtril atrilJugador2,
                        VistaPuntosJugador jugador1, VistaPuntosJugador jugador2){

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
        mostrarGanador("¡" + nomJ1.toUpperCase()+" GANA!");
      } else if (puntosJugador2.getRondasGanadas() == 2) {
        mostrarGanador("¡" + nomJ2.toUpperCase()+" GANA!");
      }

      for (Jugador jugador : juego.getJugadores()) {
        jugador.limpiarTodo();
      }

      for(VistaSeccion seccion: seccionesBuffeadas){
        seccion.desactivarDebuff();
      }
      seccionesBuffeadas.clear();

      for(VistaSeccion seccion: seccionesDebuffeadas){
        seccion.desactivarDebuff();
      }

      seccionesDebuffeadas.clear();

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

  public void registrarSeccionBuffeada(VistaSeccion seccion){
    if(!seccionesBuffeadas.contains(seccion)){
      seccionesBuffeadas.add(seccion);
    }
  }

  public void registrarSeccionDebuffeada(VistaSeccion seccion){
    seccionesDebuffeadas.add(seccion);
  }

  //Hago este metodo aca porque afecta a todo el tablero el TiempoDespejado
  public void activarTiempoDespejado(){
    for(VistaSeccion seccion : seccionesDebuffeadas){
      seccion.desactivarDebuff();
    }
    seccionesDebuffeadas.clear();
  }


}