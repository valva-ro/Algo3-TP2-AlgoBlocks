package fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    Tablero vistaTablero;
    Canvas canvasCentral;
    VBox contenedorCentral;

    public ContenedorPrincipal(Stage stage) {
        this.setBotoneraVerticalPrincipal();
        this.setVistaTablero();
        this.setAlgoritmoEnPantalla();

    }

    private void setBotoneraVerticalPrincipal(){
        Label etiqueta = new Label("Botones Disponibles");
        etiqueta.setStyle("-fx-font-size: 20px;-fx-start-margin: 20px;-fx-end-margin: 20px ");

        Button botonMovimietoArriba = new Button("Arriba   ");
        botonMovimietoArriba.setMinSize(250,40);
        Button botonMovimietoAbajo = new Button("Abajo    ");
        botonMovimietoAbajo.setMinSize(250,40);
        Button botonMovimietoDerecha = new Button("Derecha ");
        botonMovimietoDerecha.setMinSize(250,40);
        Button botonMovimietoIzquierda = new Button("Izquierda");
        botonMovimietoIzquierda.setMinSize(250,40);


        VBox contenedorVerticalBotones = new VBox();

        contenedorVerticalBotones.setSpacing(30);
        contenedorVerticalBotones.setAlignment(Pos.TOP_CENTER);

        contenedorVerticalBotones.setStyle("-fx-padding: 20px;");

        contenedorVerticalBotones.getChildren().addAll(etiqueta,botonMovimietoAbajo,botonMovimietoArriba,botonMovimietoDerecha,botonMovimietoIzquierda);
        this.setLeft(contenedorVerticalBotones);
    }

    private  void setVistaTablero(){
        this.vistaTablero = new Tablero(500,500);
        this.vistaTablero.dibujar();

        this.contenedorCentral = new VBox();
        this.contenedorCentral.getChildren().add(this.vistaTablero);

        this.contenedorCentral.setAlignment(Pos.CENTER);

        this.setRight(this.contenedorCentral);
    }

    private void setAlgoritmoEnPantalla(){
        VistaAlgoritmo contenedorVerticalAlgoritmo = new VistaAlgoritmo();

        contenedorVerticalAlgoritmo.setSpacing(30);
        contenedorVerticalAlgoritmo.setAlignment(Pos.TOP_CENTER);
        contenedorVerticalAlgoritmo.setStyle("-fx-padding: 20px;");;

        this.setCenter(contenedorVerticalAlgoritmo);
    }



}
