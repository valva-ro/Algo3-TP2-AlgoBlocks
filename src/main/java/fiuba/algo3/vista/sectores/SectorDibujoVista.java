package fiuba.algo3.vista.sectores;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class SectorDibujoVista extends BorderPane {

    private DibujoVista dibujo;

    public SectorDibujoVista() {

        this.getStylesheets().add("style.css");
        this.setStyle("-fx-background-color: #f5fff5");

        Label etiqueta = new Label("Dibujo");
        etiqueta.getStyleClass().add("subtitulo");

        this.dibujo = new DibujoVista(450, 600);
        this.setTop(etiqueta);
        this.setCenter(this.dibujo);
    }

    public void dibujar() {
        this.dibujo.dibujar();
    }
}