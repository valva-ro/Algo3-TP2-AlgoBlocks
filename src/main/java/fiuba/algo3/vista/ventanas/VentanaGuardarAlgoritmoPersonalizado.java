package fiuba.algo3.vista.ventanas;

import fiuba.algo3.controlador.clicks.GuardarAlgoritmoHandler;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.vista.botones.Boton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaGuardarAlgoritmoPersonalizado {

    public static void display(VBox contenedorBloques, String titulo, String mensaje, Algoritmo algoritmo){

        Stage ventana = new Stage();
        ventana.setResizable(false);
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle(titulo);
        ventana.setMinWidth(500);

        Label label = new Label();
        label.setText(mensaje);
        label.setId("informacion");

        TextField campoDeTexto = new TextField();
        campoDeTexto.setMaxWidth(200);
        campoDeTexto.setOnAction(new GuardarAlgoritmoHandler(contenedorBloques, campoDeTexto, algoritmo, ventana));
        campoDeTexto.setId("informacion");

        Boton botonAceptar = new Boton("botonAceptar", "Aceptar");
        botonAceptar.setOnAction(new GuardarAlgoritmoHandler(contenedorBloques, campoDeTexto, algoritmo, ventana));

        Boton botonCancelar = new Boton("botonCancelar", "Cancelar");
        botonCancelar.setOnAction(e -> ventana.close());

        HBox contenedorHorizontal = new HBox(10);
        contenedorHorizontal.getChildren().addAll(botonAceptar, botonCancelar);
        contenedorHorizontal.setAlignment(Pos.CENTER);

        VBox contenedorVertical = new VBox(10);
        contenedorVertical.setStyle("-fx-background-color: #e0fee0");
        contenedorVertical.getChildren().addAll(label, campoDeTexto, contenedorHorizontal);
        contenedorVertical.setAlignment(Pos.CENTER);

        Scene escena = new Scene(contenedorVertical, 500, 300);
        escena.getStylesheets().add("style.css");
        ventana.setScene(escena);
        ventana.showAndWait();
    }
}
