package fiuba.algo3.vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Tablero extends Canvas {
    final int CENTRO_X = 250;
    final int CENTRO_Y = 250;
    private int xFinal;
    private int yFinal;

    public Tablero() {
        this.setStyle("-fx-border-color: #6495ed");
        this.setHeight(500);
        this.setWidth(500);
        this.xFinal = CENTRO_X;
        this.yFinal = CENTRO_Y;

        GraphicsContext graficador = this.getGraphicsContext2D();
        graficador.strokeLine(CENTRO_X,this.xFinal,CENTRO_Y,this.yFinal);
    }
    public Tablero(int x , int y) {
        this.setStyle("-fx-border-color: #6495ed");
        this.setHeight(500);
        this.setWidth(500);
        this.xFinal = CENTRO_X + x;
        this.yFinal = CENTRO_Y + y;

        GraphicsContext graficador = this.getGraphicsContext2D();
        graficador.strokeLine(CENTRO_X,this.xFinal,CENTRO_Y,this.yFinal);
    }


}
