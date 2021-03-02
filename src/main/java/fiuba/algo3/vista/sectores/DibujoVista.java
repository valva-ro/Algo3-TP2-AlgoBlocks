package fiuba.algo3.vista.sectores;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import fiuba.algo3.modelo.Posicion;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.TRANSPARENT;

public class DibujoVista extends Canvas {

    private int xCentro;
    private int yCentro;
    private GraphicsContext graficador;

    public DibujoVista(double ancho, double alto) {
        super(ancho, alto);
        this.xCentro = (int) ((this.getWidth()) / 2);
        this.yCentro = (int) ((this.getHeight()) / 2);
        this.graficador = this.getGraphicsContext2D();
        this.graficador.setLineWidth(5);
    }

    private void dibujarMovimientos(Posicion posicionInicial, Posicion posicionFinal) {
        int constanteAlargarTrazo = 40;
        int xI = this.xCentro + (posicionInicial.obtenerX() * constanteAlargarTrazo);
        int yI = (this.yCentro + (posicionInicial.obtenerY() * (-constanteAlargarTrazo)));
        int xF = this.xCentro + (posicionFinal.obtenerX() * constanteAlargarTrazo);
        int yF = (this.yCentro + (posicionFinal.obtenerY() * (-constanteAlargarTrazo)));
        this.graficador.strokeLine(xI, yI, xF, yF);
    }

    public void dibujar(Posicion posicionInicial, Posicion posicionFinal) {
        this.graficador.setStroke(BLACK);
        this.dibujarMovimientos(posicionInicial, posicionFinal);
    }

    public void noDibujar(Posicion posicionInicial, Posicion posicionFinal) {
        this.graficador.setStroke(TRANSPARENT);
        this.dibujarMovimientos(posicionInicial, posicionFinal);
    }

    public void borrar() {
        double ancho, alto;
        ancho = graficador.getCanvas().getWidth();
        alto = graficador.getCanvas().getHeight();
        this.graficador.clearRect(0, 0, ancho, alto);
        //TODO: Intentar volver a la posicion original.
    }
}