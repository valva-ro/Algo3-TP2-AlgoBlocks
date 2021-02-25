package fiuba.algo3.vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Tablero extends Canvas {

    private int xFinal;
    private int yFinal;

    public Tablero(double ancho, double alto) {
        super(ancho,alto);
        this.setStyle("-fx-border-color: blue");
        this.xFinal = (int) ((this.getHeight()) / 2);
        this.yFinal = (int) ((this.getHeight()) / 2);
    }

    private void dibujarMovimientos(){
        GraphicsContext graphicadorContext = this.getGraphicsContext2D();
        graphicadorContext.strokeLine(0,10,0,10);
        System.out.println("Se ejecuto");
    }
    public void dibujar(){
        this.dibujarMovimientos();
    }




}
