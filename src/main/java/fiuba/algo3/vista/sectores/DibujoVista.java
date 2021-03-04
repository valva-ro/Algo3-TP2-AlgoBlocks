package fiuba.algo3.vista.sectores;

import fiuba.algo3.modelo.Posicion;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.TRANSPARENT;

public class DibujoVista extends Canvas {

    private int xCentro;
    private int yCentro;
    private GraphicsContext graficador;

    private final double ANCHO_CANVAS;
    private final double ALTO_CANVAS;
    private final int GROSOR_TRAZO = 5;
    private final int LONGITUD_TRAZO = 40;

    public DibujoVista(double ancho, double alto) {
        super(ancho, alto);
        this.ANCHO_CANVAS = ancho;
        this.ALTO_CANVAS = alto;
        this.xCentro = (int) ((this.getWidth()) / 2);
        this.yCentro = (int) ((this.getHeight()) / 2);
        this.graficador = this.getGraphicsContext2D();
        this.graficador.setLineWidth(GROSOR_TRAZO);
    }

    private void dibujarMovimientos(Posicion posicionInicial, Posicion posicionFinal) {
        int xI = this.xCentro + (posicionInicial.obtenerX() * LONGITUD_TRAZO);
        int yI = (this.yCentro + (posicionInicial.obtenerY() * (-LONGITUD_TRAZO)));
        int xF = this.xCentro + (posicionFinal.obtenerX() * LONGITUD_TRAZO);
        int yF = (this.yCentro + (posicionFinal.obtenerY() * (-LONGITUD_TRAZO)));
        this.graficador.strokeLine(xI, yI, xF, yF);
    }

    public void dibujar(Posicion posicionInicial, Posicion posicionFinal) {
        this.graficador.setStroke(BLACK);
        this.dibujarMovimientos(posicionInicial, posicionFinal);
    }

    public void noDibujar(Posicion posicionInicial, Posicion posicionFinal) {
        this.graficador.setStroke(TRANSPARENT);
        graficador.moveTo(posicionInicial.obtenerX(),posicionFinal.obtenerY());
    }

    public void borrar() {
        this.graficador.clearRect(0, 0, ANCHO_CANVAS, ALTO_CANVAS);
    }
}