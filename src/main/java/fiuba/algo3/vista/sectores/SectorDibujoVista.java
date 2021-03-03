package fiuba.algo3.vista.sectores;

import fiuba.algo3.modelo.ObservadorDibujo;
import fiuba.algo3.modelo.Posicion;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class SectorDibujoVista extends StackPane implements ObservadorDibujo {

    private final DibujoVista dibujo;
    private final SectorPersonaje sectorPersonaje;
    private final int ANCHO = 480,
                      ALTO = 640;

    public SectorDibujoVista() {

        this.getStylesheets().add("style.css");
        this.setStyle("-fx-background-color: #f5fff5");

        Label etiqueta = new Label("Dibujo");
        etiqueta.getStyleClass().add("subtitulo");

        this.dibujo = new DibujoVista(ANCHO, ALTO);
        this.sectorPersonaje = new SectorPersonaje(ANCHO, ALTO);

        this.getChildren().addAll(this.dibujo, this.sectorPersonaje);
    }

    @Override
    public void actualizar(Boolean dibuja, Posicion posicionInicial, Posicion posicionFinal) {
        this.sectorPersonaje.moverse(dibuja, posicionInicial, posicionFinal);
        if (dibuja) {
            this.dibujo.dibujar(posicionInicial, posicionFinal);
        } else {
            this.dibujo.noDibujar(posicionInicial, posicionFinal);
        }
    }

    public void borrarDibujo() {
        this.dibujo.borrar();
        this.sectorPersonaje.reiniciarPersonaje();
    }
}