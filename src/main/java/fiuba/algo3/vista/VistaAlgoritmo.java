package fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaAlgoritmo extends VBox {
    Label etiqueta;

    public  VistaAlgoritmo(){
        this.etiqueta = new Label("Algoritmo");
        this.etiqueta.setStyle("-fx-font-size: 20px;-fx-start-margin: 20px;-fx-end-margin: 20px ");

        this.getChildren().add(this.etiqueta);
        this.setMinSize(300,300);
        this.setSpacing(30);
        this.setAlignment(Pos.TOP_CENTER);
        this.setStyle("-fx-padding: 20px;-fx-border-color: yellow");;
    }
}
