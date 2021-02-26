package fiuba.algo3.controlador;

import fiuba.algo3.App;
import fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonJugarHandler extends BotonClickHandler {

    private Stage escenario;
    private App aplicacion;
    //Proximamente -> private AlgoBlocks modelo.

    public BotonJugarHandler(App aplicacion, Stage escenario) {
        super();
        this.aplicacion = aplicacion;
        this.escenario = escenario;
    }

    @Override
    public void handle(Event event) {
        super.handle(event);
        ContenedorPrincipal vistaPrincipal = new ContenedorPrincipal(aplicacion, escenario);
        Scene nuevaScena = new Scene(vistaPrincipal);

        escenario.setScene(nuevaScena);
        escenario.setFullScreen(true);
        escenario.setFullScreenExitHint("");
        escenario.setMinHeight(600);
        escenario.setMinWidth(1200);
    }
}
