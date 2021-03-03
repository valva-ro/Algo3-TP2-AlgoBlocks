package fiuba.algo3.vista.sectores;

import fiuba.algo3.modelo.ObservadorDibujo;
import fiuba.algo3.modelo.Posicion;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class SectorDibujoVista extends BorderPane implements ObservadorDibujo {

    private final DibujoVista dibujo;
    private SectorPersonaje sectorPersonaje;
    private final int ANCHO = 480,
                      ALTO = 640;

    public SectorDibujoVista() {

        this.getStylesheets().add("style.css");
        this.setStyle("-fx-background-color: #f5fff5");

        Label etiqueta = new Label("Dibujo");
        etiqueta.getStyleClass().add("subtitulo");

        this.dibujo = new DibujoVista(ANCHO, ALTO);
        this.sectorPersonaje = new SectorPersonaje("personaje_abajo_sin_lapiz.png", ANCHO, ALTO);

        Pane panel = new Pane();
        panel.getChildren().addAll(dibujo, sectorPersonaje);

        this.setTop(etiqueta);
        this.setCenter(panel);
    }

    @Override
    public void actualizar(Boolean bool, Posicion posicionInicial, Posicion posicionFinal) {
        if (bool) {
            this.dibujo.dibujar(posicionInicial, posicionFinal);
        } else {
            this.dibujo.noDibujar(posicionInicial, posicionFinal);
        }
    }

    public void borrarDibujo() {
        this.dibujo.borrar();
    }
}