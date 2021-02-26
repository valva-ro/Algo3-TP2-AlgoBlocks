package fiuba.algo3.controlador;

import fiuba.algo3.App;
import fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonMoverHandler implements EventHandler {

    private Stage escenario;
    private App aplicacion;

    public BotonMoverHandler(App aplicacion, Stage escenario) {
        this.aplicacion = aplicacion;
        this.escenario = escenario;
    }

    @Override
    public void handle(Event event) {
        ContenedorPrincipal vistaPrincipal = new ContenedorPrincipal(this.aplicacion, this.escenario);
        Scene nuevaScena = new Scene(vistaPrincipal, 800, 600);

        escenario.setScene(nuevaScena);
    }
}
