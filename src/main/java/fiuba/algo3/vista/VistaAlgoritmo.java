package fiuba.algo3.vista;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaAlgoritmo extends VBox {
    Label etiqueta;

    public  VistaAlgoritmo(){
        this.etiqueta = new Label("Algoritmo");
        this.etiqueta.setStyle("-fx-font-size: 20px;-fx-start-margin: 20px;-fx-end-margin: 20px ");
        this.getChildren().add(this.etiqueta);
        this.setMinSize(300,300);
    }
}
