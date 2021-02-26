package fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    Tablero vistaTablero;
    Canvas canvasCentral;
    VBox contenedorCentral;

    public ContenedorPrincipal(Stage stage) {
        this.setBotoneraVerticalPrincipal();
        this.setVistaTablero();
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

    private HBox setBotoneraAbajo(){
        Button botonGuardar = new Button("Guardar   ");
        botonGuardar.setMinSize(200,20);
        Button botonEjectuar = new Button("Ejecutar    ");
        botonEjectuar.setMinSize(200,20);
        Button botonSalir = new Button("Derecha ");
        botonSalir.setMinSize(200,20);

        HBox botonera = new HBox();
        botonera.setAlignment(Pos.CENTER);
        botonera.setSpacing(10);
        botonera.setStyle("-fx-padding: 10px");
        botonera.getChildren().addAll(botonEjectuar,botonGuardar,botonSalir);

        return botonera;
    }

    private  void setVistaTablero(){
        this.vistaTablero = new Tablero(800,600);
        this.vistaTablero.dibujar();
        VistaAlgoritmo contenedorVerticalAlgoritmo = new VistaAlgoritmo();
        HBox contenedorTableroAlgoritmo = new HBox();
        contenedorTableroAlgoritmo.getChildren().addAll(contenedorVerticalAlgoritmo,this.vistaTablero);
        contenedorTableroAlgoritmo.setAlignment(Pos.TOP_CENTER);

        this.contenedorCentral = new VBox();
        this.contenedorCentral.setMinSize(1000,1000);
        this.contenedorCentral.getChildren().addAll(contenedorTableroAlgoritmo,this.setBotoneraAbajo());
        this.contenedorCentral.setStyle("-fx-border-color: #5959d0");
        this.contenedorCentral.setAlignment(Pos.TOP_CENTER);

        this.setRight(this.contenedorCentral);
    }

}
