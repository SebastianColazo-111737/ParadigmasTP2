package edu.fiuba.algo3.vistas.Individuales;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.unidades.Unidad;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;
import java.util.function.Consumer;

public class VistaDescarte extends StackPane{
    private static VistaDescarte seleccionado = null;
    private Rectangle fondo;
    private final Jugador jugador;
    private VBox panelParaRevivir;

    public VistaDescarte(String nombre, Jugador jugador){
        this.jugador = jugador;

        fondo = new Rectangle(90,120);
        fondo.setFill(Color.LIGHTSTEELBLUE);
        fondo.setStroke(Color.BLACK);
        fondo.setStrokeWidth(2);

        Label etiqueta = new Label(nombre);
        etiqueta.setStyle("-fx-font-weight: bold;");
        this.getChildren().addAll(fondo,etiqueta);

        this.setOnMouseClicked(e -> seleccionar());

        panelParaRevivir = new VBox();
        panelParaRevivir.setVisible(false);
        panelParaRevivir.setAlignment(Pos.CENTER);
        panelParaRevivir.setPadding(new Insets(10));
        panelParaRevivir.setSpacing(10);

        panelParaRevivir.setBackground(new Background(
                new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, new CornerRadii(10), Insets.EMPTY)));

        panelParaRevivir.setBorder(new Border(
                new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, new CornerRadii(10),BorderWidths.DEFAULT)));

        Label mensajePanelRevivir = new Label("Elige tu carta para revivir");
        mensajePanelRevivir.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        panelParaRevivir.getChildren().add(mensajePanelRevivir);

        this.getChildren().add(panelParaRevivir);
    }

    private void seleccionar(){
        if(seleccionado !=null && seleccionado != this) seleccionado.deseleccionar();
        seleccionado = this;
        fondo.setStroke(Color.RED);
    }

    public void deseleccionar(){
        fondo.setStroke(Color.BLACK);
        if(seleccionado == this) seleccionado = null;
    }

    public static void limpiarSeccion(){
        if(seleccionado != null) seleccionado.deseleccionar();
    }

    public void mostrarPanelParaRevivir(Consumer<Unidad> callbackRevivir) {
        System.out.println("MOSTRANDO VENTANA DE SELECCIÓN");
        panelParaRevivir.getChildren().clear();
        List<ICarta> cartasDescarte = jugador.cartasDelDescarte();

        for (ICarta carta : cartasDescarte) {
            if (carta instanceof Unidad ) {
                Unidad unidad = (Unidad) carta;
                Button boton = new Button(unidad.nombre());
                boton.setOnAction(e -> {
                    panelParaRevivir.setVisible(false);
                    callbackRevivir.accept(unidad);
                });
                panelParaRevivir.getChildren().add(boton);
            }
        }

        panelParaRevivir.setVisible(true);
    }

    public void ocultarPanelParaRevivir(){
        panelParaRevivir.setVisible(false);
    }

}

