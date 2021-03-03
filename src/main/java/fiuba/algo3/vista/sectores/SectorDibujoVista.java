package fiuba.algo3.vista.sectores;

import fiuba.algo3.modelo.ObservadorDibujo;
import fiuba.algo3.modelo.Posicion;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class SectorDibujoVista extends BorderPane implements ObservadorDibujo {

    private final DibujoVista dibujo;

    public SectorDibujoVista() {

        this.getStylesheets().add("style.css");
        this.setStyle("-fx-background-color: #f5fff5");

        Label etiqueta = new Label("Dibujo");
        etiqueta.getStyleClass().add("subtitulo");

        this.dibujo = new DibujoVista(450, 600);
        this.setTop(etiqueta);
        this.setCenter(this.dibujo);
    }

    @Override
    public void actualizar(Boolean bool, Posicion posicionInicial, Posicion posicionFinal) {
        if (bool) {
            this.dibujo.dibujar(posicionInicial, posicionFinal);
        } else {
            this.dibujo.noDibujar(posicionInicial, posicionFinal);
        }
    }

    public void borrarDibujo() { this.dibujo.borrar(); }
}