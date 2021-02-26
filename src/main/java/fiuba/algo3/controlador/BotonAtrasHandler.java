package fiuba.algo3.controlador;

import fiuba.algo3.App;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonAtrasHandler extends BotonClickHandler {

    private final App aplicacion;
    private final Stage escenario;

    public BotonAtrasHandler(App aplicacion, Stage escenario) {
        super();
        this.aplicacion = aplicacion;
        this.escenario = escenario;
    }

    @Override
    public void handle(Event actionEvent) {
        super.handle(actionEvent);
        this.aplicacion.start(this.escenario);
    }
}
