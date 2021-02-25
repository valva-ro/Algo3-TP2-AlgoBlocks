package fiuba.algo3.vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Tablero {

    Canvas canvasCentral;

    private int xFinal;
    private int yFinal;

    public Tablero(Canvas canvasCentral) {
        this.canvasCentral = canvasCentral;
        this.xFinal = (int) ((this.canvasCentral.getHeight()) / 2);
        this.yFinal = (int) ((this.canvasCentral.getHeight()) / 2);
    }

    private void dibujarMovimientos(){
        GraphicsContext graphicadorContext = this.canvasCentral.getGraphicsContext2D();
        graphicadorContext.strokeLine(0,this.xFinal,0,this.yFinal);
    }
    public void dibujar(){
        this.dibujarMovimientos();
    }




}
