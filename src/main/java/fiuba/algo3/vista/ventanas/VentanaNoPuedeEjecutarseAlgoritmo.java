package fiuba.algo3.vista.ventanas;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.vista.botones.Boton;
import fiuba.algo3.vista.sectores.SectorDibujoVista;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaNoPuedeEjecutarseAlgoritmo {

    public static void display(String mensaje) {

        Stage ventana = new Stage();
        ventana.setResizable(false);
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setMinWidth(500);
        ventana.setMinHeight(300);
        ventana.setTitle("Error - Algoritmo no puede ejecutarse");
        ventana.getIcons().add(new Image("logo.png"));

        Label mensajeError = new Label();
        mensajeError.setText(mensaje);
        mensajeError.setId("informacion");

        Boton botonAceptar = new Boton("botonAceptar", "Aceptar");
        botonAceptar.setOnAction(e -> ventana.close());

        VBox contenedorVertical = new VBox(10);
        contenedorVertical.setStyle("-fx-background-color: #e0fee0");
        contenedorVertical.getChildren().addAll(mensajeError, botonAceptar);
        contenedorVertical.setAlignment(Pos.CENTER);

        Scene escena = new Scene(contenedorVertical);
        escena.getStylesheets().add("style.css");
        ventana.setScene(escena);
        ventana.showAndWait();
    }
}
