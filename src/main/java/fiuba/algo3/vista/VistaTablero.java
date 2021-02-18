package fiuba.algo3.vista;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaTablero extends VBox {
    Stage escenario;

    public VistaTablero(Stage escenario){
        this.escenario = escenario;
        this.setStyle("-fx-background-color: #FFFFFF");

        BorderPane layout = new BorderPane();
        Label encabezadoBotonera = new Label("Botones disponibles");
        encabezadoBotonera.setStyle("-fx-font-size: 22px;-fx-end-margin: 10px");

        Button botonArriba = new Button("Moviento Arriba");
        Button botonAbajo = new Button("Movimiento Abajo");
        Button botonDerecha = new Button("Movimiento Derecha");
        Button botonIzquierda = new Button("Movimiento Izquierda");

        VBox contenedorDeBloques  = new VBox(encabezadoBotonera,
                botonArriba,
                botonAbajo,
                botonDerecha,
                botonIzquierda);
        contenedorDeBloques.setStyle("-fx-padding: 30px");
        contenedorDeBloques.setSpacing(10);

        Canvas zonaDeDibujo = new Canvas();
        zonaDeDibujo.setStyle("-fx-border-color: #6495ed");
        zonaDeDibujo.setHeight(500);
        zonaDeDibujo.setWidth(500);

        Button botonSalir = new Button("Salir");
        botonSalir.setStyle("-fx-background-color: #FF6347; -fx-padding: 10px");
        botonSalir.setId("botonSalir");
        botonSalir.setOnAction(actionEvent -> Platform.exit());

        VBox contenedorCentral = new VBox(zonaDeDibujo,botonSalir);
        contenedorCentral.setStyle("-fx-border-color: #6495ed");
        contenedorCentral.setMaxSize(500,500);

        layout.setLeft(contenedorDeBloques);
        layout.setCenter(contenedorCentral);

        this.getChildren().add(layout);
    }


}
