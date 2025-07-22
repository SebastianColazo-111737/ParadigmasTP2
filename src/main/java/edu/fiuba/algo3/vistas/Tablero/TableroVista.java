package edu.fiuba.algo3.vistas.Tablero;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Region;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.vistas.Seccion.SeccionVista;

public class TableroVista extends StackPane {

  private VBox seccionesC;
  private ArrayList<Seccion> secciones;

  public TableroVista(ArrayList<Seccion> secciones) {

    this.secciones = new ArrayList<>();
    this.secciones.addAll(secciones);

    seccionesC = new VBox(10);
    seccionesC.setAlignment(Pos.CENTER);
    seccionesC.setPadding(new Insets(2));

    double alturaSecciones = (70 + 10) * 6;
    seccionesC.setPrefHeight(alturaSecciones);
    seccionesC.setMaxHeight(alturaSecciones);

    VBox layout = new VBox(20, seccionesC);
    layout.setAlignment(Pos.CENTER);
    layout.setPadding(new Insets(0));

    layout.setPrefSize(1200, 200);
    layout.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

    this.setPrefSize(1200, 200);
    this.getChildren().add(layout);
    actualizarVista();
  }

  public void actualizarVista() {
    seccionesC.getChildren().clear();

    for (Seccion s : this.secciones) {
      SeccionVista vista = new SeccionVista(s);
      vista.actualizarVista();

      seccionesC.getChildren().add(vista);

      VBox.setMargin(vista, new Insets(5, 0, 5, 0));
    }
  }
}
