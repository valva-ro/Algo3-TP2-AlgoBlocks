package fiuba.algo3.controlador;

import fiuba.algo3.App;
import fiuba.algo3.vista.ContenedorPrincipal;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonAcercaDeHandler extends BotonClickHandler {

    private Stage escenario;
    private App aplicacion;
    private Button botonAtras;

    public BotonAcercaDeHandler(App aplicacion, Stage escenario) {
        super();
        this.escenario = escenario;
        this.aplicacion = aplicacion;

        this.botonAtras = new Button();
        this.botonAtras.getStyleClass().addAll("boton", "bloque");
        this.botonAtras.setId("botonAtras");
        this.botonAtras.setOnAction(new BotonAtrasHandler(this.aplicacion, this.escenario));
    }

    @Override
    public void handle(Event event) {
        super.handle(event);
        ContenedorPrincipal vistaPrincipal = new ContenedorPrincipal(this.aplicacion, this.escenario);
        Scene nuevaEscena = new Scene(vistaPrincipal, 800, 600);
        nuevaEscena.getStylesheets().add("style.css");

        Label texto = new Label("\nBla bla bla\nBla bla bla\nBla bla bla\nBla bla bla");
        texto.setId("informacion");

        VBox contenedor = new VBox(texto, this.botonAtras);
        contenedor.setAlignment(Pos.CENTER);
        nuevaEscena.setRoot(contenedor);

        escenario.setScene(nuevaEscena);
    }
}
