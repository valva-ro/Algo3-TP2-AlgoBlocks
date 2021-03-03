package fiuba.algo3.vista.ventanas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaAcercaDe {

    public static void display(Stage escenario, VistaPrincipal vistaPrincipal, Button botonAtras) {

        Scene nuevaEscena = new Scene(vistaPrincipal, 800, 600);
        nuevaEscena.getStylesheets().add("style.css");

        Label javaVersion = new Label("Version de Java:\n" + System.getProperty("java.version"));
        Label javafxVersion = new Label("Version de JavaFX:\n" + System.getProperty("javafx.version"));
        Label integrantes = new Label("Desarrolladores:\nAlejo Villores\nAndreas Kuballa\nKevin Meaca\nValentina Varela Rodriguez");

        javaVersion.setId("informacion");
        javafxVersion.setId("informacion");
        integrantes.setId("informacion");

        VBox contenedorVertical = new VBox(javaVersion, javafxVersion, integrantes, botonAtras);
        contenedorVertical.setStyle("-fx-background-color: #abe389");
        contenedorVertical.setAlignment(Pos.CENTER);

        nuevaEscena.setRoot(contenedorVertical);

        escenario.setScene(nuevaEscena);
    }
}
