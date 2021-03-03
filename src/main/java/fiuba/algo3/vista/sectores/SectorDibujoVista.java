package fiuba.algo3.vista.sectores;

import fiuba.algo3.modelo.ObservadorDibujo;
import fiuba.algo3.modelo.Posicion;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class SectorDibujoVista extends StackPane implements ObservadorDibujo {

    private final DibujoVista dibujo;
    private final SectorPersonaje personaje;
    private final int ANCHO = 480,
                      ALTO = 640;

    public SectorDibujoVista() {

        this.getStylesheets().add("style.css");
        this.setStyle("-fx-background-color: #f5fff5");

        Label etiqueta = new Label("Dibujo");
        etiqueta.getStyleClass().add("subtitulo");

        this.dibujo = new DibujoVista(ANCHO, ALTO);

        personaje = new SectorPersonaje(ANCHO,ALTO);

        this.getChildren().addAll(this.dibujo,this.personaje);
    }

    @Override
    public void actualizar(Boolean bool, Posicion posicionInicial, Posicion posicionFinal) {
        if (bool) {
            this.dibujo.dibujar(posicionInicial, posicionFinal);
            this.personaje.moverse(posicionInicial,posicionFinal);
        } else {
            this.dibujo.noDibujar(posicionInicial, posicionFinal);
            this.personaje.moverse(posicionInicial,posicionFinal);
        }
    }

    public void borrarDibujo() {
        this.dibujo.borrar();
        this.personaje.reiniciarPersonaje();
    }
}