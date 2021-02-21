package fiuba.algo3.controllers;

import fiuba.algo3.vista.VistaPrincipal;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonJugarHandler implements EventHandler {

    private Stage escenario;
    //Proximamente -> private AlgoBlocks modelo.

    public BotonJugarHandler( Stage escenario) {
        this.escenario = escenario;
    }

    @Override
    public void handle(Event event) {
        VistaPrincipal vistaPrincipal = new VistaPrincipal(escenario);
        Scene nuevaScena = new Scene(vistaPrincipal, 800, 600);

        escenario.setScene(nuevaScena);
        escenario.setMaxHeight(600);
        escenario.setMaxWidth(800);
    }
}
