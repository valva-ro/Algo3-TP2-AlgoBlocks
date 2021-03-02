package fiuba.algo3.vista.ventanas;

import fiuba.algo3.App;
import fiuba.algo3.controlador.clicks.BotonAtrasHandler;
import fiuba.algo3.vista.botones.Boton;
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

        VBox contenedor = new VBox(javaVersion, javafxVersion, integrantes, botonAtras);
        contenedor.setAlignment(Pos.CENTER);

        nuevaEscena.setRoot(contenedor);

        escenario.setScene(nuevaEscena);
    }
}
