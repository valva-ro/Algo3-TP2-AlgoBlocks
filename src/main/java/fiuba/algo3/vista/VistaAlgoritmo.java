package fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaAlgoritmo extends VBox {

    Label etiqueta;

    public VistaAlgoritmo(){
        this.getStylesheets().add("style.css");
        this.etiqueta = new Label("Algoritmo");
        this.etiqueta.getStyleClass().add("subtitulo");
        this.getChildren().add(this.etiqueta);
        this.setAlignment(Pos.TOP_CENTER);
        this.setMinWidth(300);
    }
}
