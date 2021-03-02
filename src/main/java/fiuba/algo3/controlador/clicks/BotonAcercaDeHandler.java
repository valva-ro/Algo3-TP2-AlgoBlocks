package fiuba.algo3.controlador.clicks;

import fiuba.algo3.App;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.vista.ventanas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonAcercaDeHandler extends BotonClickHandler {

    private final Stage escenario;
    private final Button botonAtras;
    private final VistaPrincipal vistaPrincipal;

    public BotonAcercaDeHandler(App aplicacion, Stage escenario, Algoritmo algoritmo, Interpretador interpretador) {
        super();
        this.escenario = escenario;
        this.vistaPrincipal = new VistaPrincipal(aplicacion, escenario, algoritmo, interpretador);

        this.botonAtras = new Button();
        this.botonAtras.getStyleClass().addAll("boton", "bloque");
        this.botonAtras.setId("botonAtras");
        this.botonAtras.setOnAction(new BotonAtrasHandler(aplicacion, this.escenario));
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        Scene nuevaEscena = new Scene(this.vistaPrincipal, 800, 600);
        nuevaEscena.getStylesheets().add("style.css");

        Label javaVersion = new Label("Version de Java:\n" + System.getProperty("java.version"));
        Label javafxVersion = new Label("Version de JavaFX:\n" + System.getProperty("javafx.version"));
        Label integrantes = new Label("Desarrolladores:\nAlejo Villores\nAndreas Kuballa\nKevin Meaca\nValentina Varela Rodriguez");

        javaVersion.setId("informacion");
        javafxVersion.setId("informacion");
        integrantes.setId("informacion");

        VBox contenedor = new VBox(javaVersion, javafxVersion, integrantes, this.botonAtras);
        contenedor.setAlignment(Pos.CENTER);

        nuevaEscena.setRoot(contenedor);

        this.escenario.setScene(nuevaEscena);
    }
}
