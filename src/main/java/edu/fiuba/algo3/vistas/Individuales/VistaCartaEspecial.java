package edu.fiuba.algo3.vistas.Individuales;

import edu.fiuba.algo3.modelo.cartas.ICarta;
import edu.fiuba.algo3.modelo.cartas.especiales.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.util.function.Consumer;

public class VistaCartaEspecial extends VistaCarta{

    public VistaCartaEspecial(ICarta cartaModelo, Consumer<VistaCarta> oneSeleccionar){
        super(cartaModelo, oneSeleccionar);

        this.setStyle("-fx-background-color: deepskyblue; -fx-border-color: black; -fx-border-width: 2px;");
        this.setPadding(new Insets(5));
        this.setPrefSize(80, 110);

        VBox contenido = new VBox(2);
        contenido.setAlignment(Pos.CENTER);

        Label nombreLabel = new Label(obtenerNombre(cartaModelo));
        nombreLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 17px;");
        nombreLabel.setWrapText(true);
        nombreLabel.setTextAlignment(TextAlignment.CENTER);

        Label descripcionLabel = new Label(obtenerDescripcion(cartaModelo));
        descripcionLabel.setWrapText(true);
        descripcionLabel.setStyle("-fx-font-size: 12px;");
        descripcionLabel.setTextAlignment(TextAlignment.CENTER);

        contenido.getChildren().addAll(nombreLabel,descripcionLabel);
        this.setGraphic(contenido);

        this.moverCarta();
    }

    private String obtenerNombre(ICarta cartaModelo){
        if (cartaModelo instanceof CEspecial) {
            String nombre = ((CEspecial) cartaModelo).nombre();

            switch(nombre){
                case "Escarcha":
                    return "❆ ➞ 🗡️";
                case "Lluvia":
                    return "☔ ➞ 🛡️";
                case "Tormeta":
                    return "⚡➞🗡️⋙";
                case "Cuerno":
                    return "🗡️ ⋙ \uD83D\uDEE1\uFE0F";
                case "Quemar":
                    return "⛭";
                case "Tiempo despejado":
                    return "༄";
                default:
                    return nombre;
            }
        }
        return "Especial";
    }

    private String obtenerDescripcion(ICarta carta) {
        if (carta instanceof BuffCartas) {
            return "Duplica la fuerza de una sección";
        } else if (carta instanceof Debuff) {
            return "Reduce a 1 las cartas de una sección";
        } else if (carta instanceof TierraArrasada) {
            return "Quema la carta más fuerte de cada atril";
        } else if (carta instanceof DeBuffCleaner) {
            return "Limpia todos los efectos de clima";
        }
        return "Carta especial.";
    }
}
