package fiuba.algo3.vista.sectores;

import fiuba.algo3.modelo.Posicion;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class SectorPersonaje extends GridPane {

    private Image imagen;
    private final String rutaImagenInicial;
    private final int ANCHO;
    private final int ALTO;
    private final int TAMANIO_CELDA = 20;

    public SectorPersonaje(String rutaImagen, int ancho, int alto) {

        this.ANCHO = ancho;
        this.ALTO = alto;
        this.rutaImagenInicial = rutaImagen;

        this.reiniciar();
    }

    public void mover(Boolean dibuja, Posicion posicionInicial, Posicion posicionFinal) {

        for (Node node : this.getChildren()) {

            if (getColumnIndex(node) == posicionInicial.obtenerX() && getRowIndex(node) == posicionInicial.obtenerY()) {
                ((Pane) node).setBackground(Background.EMPTY);
            }

            if (getColumnIndex(node) == posicionFinal.obtenerX() && getRowIndex(node) == posicionFinal.obtenerY()) {
                this.cambiarImagen(dibuja, posicionInicial, posicionFinal);
                BackgroundSize tamanioImagen = new BackgroundSize(40, 40, true, true, false, true);
                BackgroundImage imagenDeFondo = new BackgroundImage(this.imagen, null, null, null, tamanioImagen);
                ((Pane) node).setBackground(new Background(imagenDeFondo));
            }
        }
    }

    public void reiniciar() {
        this.imagen = new Image(this.rutaImagenInicial);
        int columnas = ANCHO / TAMANIO_CELDA;
        int filas = ALTO / TAMANIO_CELDA;
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
                Pane celda = new Pane();
                celda.setMaxSize(TAMANIO_CELDA, TAMANIO_CELDA);
                celda.setMinSize(TAMANIO_CELDA, TAMANIO_CELDA);
                celda.setBackground(Background.EMPTY);
                if (i == columnas / 2 && j == filas / 2) {
                    BackgroundSize tamanioImagen = new BackgroundSize(40, 40, true, true, false, true);
                    BackgroundImage imagenDeFondo = new BackgroundImage(this.imagen, null, null, null, tamanioImagen);
                    celda.setBackground(new Background(imagenDeFondo));
                }
                this.add(celda, i, j);
            }
        }
    }

    private void cambiarImagen(Boolean dibuja, Posicion posicionInicial, Posicion posicionFinal) {
        String rutaImagen = this.seleccionarImagenDelPersonaje(dibuja, posicionInicial, posicionFinal);
        this.imagen = new Image(rutaImagen);
    }

    private String seleccionarImagenDelPersonaje(Boolean dibuja, Posicion posicionInicial, Posicion posicionFinal) {

        String rutaImagen = "";

        if (posicionInicial.obtenerX() > posicionFinal.obtenerX()) {
            rutaImagen = "personaje_izquierda";
        } else if (posicionInicial.obtenerX() < posicionFinal.obtenerX()) {
            rutaImagen = "personaje_derecha";
        } else if (posicionInicial.obtenerY() > posicionFinal.obtenerY()) {
            rutaImagen = "personaje_abajo";
        } else if (posicionInicial.obtenerY() < posicionFinal.obtenerY()) {
            rutaImagen = "personaje_arriba";
        }

        if (dibuja) {
            rutaImagen += "_con_lapiz.png";
        } else {
            rutaImagen += "_sin_lapiz.png";
        }

        return rutaImagen;
    }
}
