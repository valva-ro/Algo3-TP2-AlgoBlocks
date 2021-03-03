package fiuba.algo3.vista.sectores;

import fiuba.algo3.modelo.Posicion;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SectorPersonaje extends Canvas {

        private int xCentro;
        private int yCentro;
        private GraphicsContext graficador;
        private Image personaje;

        private final double ANCHO_CANVAS;
        private final double ALTO_CANVAS;
        private final String RUTA_IMAGEN_INICIAL = "personaje_abajo_sin_lapiz.png";
        private final int ALTO_IMAGEN = 50;
        private final int ANCHO_IMAGEN = 50;
        private final int LONGITUD_TRAZO = 40;

        public SectorPersonaje(double ancho, double alto) {
            super(ancho, alto);
            this.ANCHO_CANVAS = ancho;
            this.ALTO_CANVAS = alto;
            this.xCentro = (int) ((this.getWidth()) / 2);
            this.yCentro = (int) ((this.getHeight()) / 2);
            this.graficador = this.getGraphicsContext2D();
            this.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");
            this.reiniciarPersonaje();
        }

        private void dibujarMovimientos(Posicion posicionInicial, Posicion posicionFinal) {
            int xF = this.xCentro + (posicionFinal.obtenerX() * LONGITUD_TRAZO);
            int yF = (this.yCentro + (posicionFinal.obtenerY() * (-LONGITUD_TRAZO)));
            this.moverPersonaje(xF, yF);
        }

        public void moverse(Posicion posicionInicial, Posicion posicionFinal) {
            String rutaImagen = this.seleccionarImagenDelPersonaje(true, posicionInicial, posicionFinal);
            this.personaje = new Image(rutaImagen, ANCHO_IMAGEN, ALTO_IMAGEN, true, true);
            this.dibujarMovimientos(posicionInicial, posicionFinal);
        }

        private void moverPersonaje(int xFinal, int yFinal) {
            this.graficador.clearRect(0, 0, ANCHO_CANVAS, ALTO_CANVAS);
            int desplazamientoX = (int) (this.personaje.getWidth() / 2);
            int desplazamientoY = (int) (this.personaje.getHeight() / 2);

            if (xFinal - desplazamientoX >= 0 && xFinal + desplazamientoX <= ANCHO_CANVAS &&
                    yFinal - desplazamientoY >= 0 && yFinal + desplazamientoY <= ALTO_CANVAS) {
                this.graficador.drawImage(this.personaje, xFinal - desplazamientoX, yFinal - desplazamientoY);
            }
        }

        public void reiniciarPersonaje() {
            this.personaje = new Image(this.RUTA_IMAGEN_INICIAL, ANCHO_IMAGEN, ALTO_IMAGEN, true, true);
            this.moverPersonaje(this.xCentro, this.yCentro);
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

