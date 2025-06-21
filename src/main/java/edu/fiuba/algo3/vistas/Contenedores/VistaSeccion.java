package edu.fiuba.algo3.vistas.Contenedores;

import edu.fiuba.algo3.modelo.jugador.atril.Seccion;
import edu.fiuba.algo3.modelo.posiciones.Asedio;
import edu.fiuba.algo3.modelo.posiciones.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.posiciones.Distancia;
import edu.fiuba.algo3.modelo.posiciones.Posicion;
import edu.fiuba.algo3.vistas.Individuales.VistaPuntos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;

public class VistaSeccion extends StackPane {

    private final Seccion seccion;

    public VistaSeccion(Seccion seccion){
        this.seccion = seccion;

        VistaPuntos puntos = new VistaPuntos();

        Rectangle rectangulo = new Rectangle(240,70);
        rectangulo.setFill(Color.LIGHTGRAY);
        rectangulo.setStroke(Color.BLACK);

        Label etiqueta = new Label(nombreDesdePos(seccion));
        StackPane rectanguloConTexto = new StackPane(rectangulo, etiqueta);

        HBox contenido = new HBox(-5, puntos, rectanguloConTexto);
        contenido.setAlignment(Pos.CENTER_LEFT);

        this.getChildren().add(contenido);
    }

    private String nombreDesdePos(Seccion seccion){
        Posicion pos = seccion.getPosicion();
        if (pos instanceof CuerpoACuerpo) return "CUERPO";
        if (pos instanceof Distancia) return "DISTANCIA";
        if (pos instanceof Asedio) return "ASEDIO";
        return "La seccion no existe";
    }
}
