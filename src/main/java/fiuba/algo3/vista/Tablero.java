package fiuba.algo3.vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Tablero {
    Canvas canvasCentral;
    GraphicsContext graphicadorContext;

    private int xFinal;
    private int yFinal;

    public Tablero(Canvas canvasCentral) {
        this.canvasCentral = canvasCentral;
        this.xFinal = (int) ((this.canvasCentral.getHeight()) / 2);
        this.yFinal = (int) ((this.canvasCentral.getHeight()) / 2);

    }

    private void dibujarMovimientos(){
        this.graphicadorContext = this.canvasCentral.getGraphicsContext2D();
        this.canvasCentral.getGraphicsContext2D().setFill(Color.BLUE);

        graphicadorContext.strokeLine(this.canvasCentral.getHeight(),this.xFinal,this.canvasCentral.getWidth(),this.yFinal);
    }
    public void dibujar(){
        this.dibujarMovimientos();
    }




}
