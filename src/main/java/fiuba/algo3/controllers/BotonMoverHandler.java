package fiuba.algo3.controllers;

import fiuba.algo3.vista.VistaPrincipal;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonMoverHandler implements EventHandler {

    private Stage escenario;

    public BotonMoverHandler(Stage escenario) {
        this.escenario = escenario;
    }

    @Override
    public void handle(Event event) {
        VistaPrincipal vistaPrincipal = new VistaPrincipal(escenario,40,0);
        Scene nuevaScena = new Scene(vistaPrincipal, 800, 600);

        escenario.setScene(nuevaScena);
        escenario.setMaxHeight(600);
        escenario.setMaxWidth(800);
    }
}
