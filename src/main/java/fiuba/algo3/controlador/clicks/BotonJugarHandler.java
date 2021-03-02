package fiuba.algo3.controlador.clicks;

import fiuba.algo3.App;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.vista.ventanas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonJugarHandler extends BotonClickHandler {

    private final Stage escenario;
    private final VistaPrincipal vistaPrincipal;

    public BotonJugarHandler(App aplicacion, Stage escenario, Algoritmo algoritmo, Interpretador interpretador) {
        super();
        this.escenario = escenario;
        this.vistaPrincipal = new VistaPrincipal(aplicacion, escenario, algoritmo, interpretador);
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        Scene nuevaScena = new Scene(this.vistaPrincipal);

        escenario.setScene(nuevaScena);
        escenario.setFullScreen(true);
        escenario.setFullScreenExitHint("");
        escenario.setMinHeight(600);
        escenario.setMinWidth(1200);
    }
}
