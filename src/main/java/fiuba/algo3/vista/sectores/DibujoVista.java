package fiuba.algo3.vista.sectores;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class DibujoVista extends Canvas {

    private int xFinal;
    private int yFinal;

    public DibujoVista(double ancho, double alto) {
        super(ancho, alto);
        this.xFinal = (int) ((this.getWidth()) / 2);
        this.yFinal = (int) ((this.getHeight()) / 2);
    }

    public void dibujar() {
        this.dibujarMovimientos();
    }

    private void dibujarMovimientos() {
        GraphicsContext graphicadorContext = this.getGraphicsContext2D();
        graphicadorContext.strokeLine(0, this.xFinal, 0, this.yFinal);
    }
}