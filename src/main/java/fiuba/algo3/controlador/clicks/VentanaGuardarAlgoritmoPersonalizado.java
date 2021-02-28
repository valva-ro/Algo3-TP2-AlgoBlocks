package fiuba.algo3.controlador.clicks;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.SectorBloques;
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

    public static void display(VBox contenedorBloques, String titulo, String mensaje, Algoritmo algoritmo, SectorBloques sectorBloques){

        Stage ventana = new Stage();
        ventana.setResizable(false);
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle(titulo);
        ventana.setMinWidth(400);

        Label label = new Label();
        label.setText(mensaje);

        TextField campoDeTexto = new TextField();
        campoDeTexto.setOnAction(new GuardarAlgoritmoHandler(contenedorBloques, campoDeTexto, algoritmo, sectorBloques, ventana));
        campoDeTexto.getStyleClass().add("informacion");

        Boton botonAceptar = new Boton("botonAceptar", "Aceptar");
        botonAceptar.setOnAction(new GuardarAlgoritmoHandler(contenedorBloques, campoDeTexto, algoritmo, sectorBloques, ventana));

        Boton botonCancelar = new Boton("botonCancelar", "Cancelar");
        botonCancelar.setOnAction(e -> ventana.close());

        HBox contenedorHorizontal = new HBox(10);
        contenedorHorizontal.getChildren().addAll(botonAceptar, botonCancelar);
        contenedorHorizontal.setAlignment(Pos.CENTER);

        VBox contenedorVertical = new VBox(10);
        contenedorVertical.getChildren().addAll(label, campoDeTexto, contenedorHorizontal);
        contenedorVertical.setAlignment(Pos.CENTER);

        Scene escena = new Scene(contenedorVertical, 325, 125);
        escena.getStylesheets().add("style.css");
        ventana.setScene(escena);
        ventana.showAndWait();
    }
}
