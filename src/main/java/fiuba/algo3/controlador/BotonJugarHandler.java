package fiuba.algo3.controlador;

import fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonJugarHandler implements EventHandler {

    private Stage escenario;
    //Proximamente -> private AlgoBlocks modelo.

    public BotonJugarHandler(Stage escenario) {
        this.escenario = escenario;
    }

    @Override
    public void handle(Event event) {
        ContenedorPrincipal vistaPrincipal = new ContenedorPrincipal(escenario);
        Scene nuevaScena = new Scene(vistaPrincipal);

        escenario.setScene(nuevaScena);
        escenario.setFullScreen(true);
        escenario.setFullScreenExitHint("");
        escenario.setMinHeight(1000);
        escenario.setMinWidth(1000);
    }
}
