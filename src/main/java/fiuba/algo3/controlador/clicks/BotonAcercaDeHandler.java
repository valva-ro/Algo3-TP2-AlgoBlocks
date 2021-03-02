package fiuba.algo3.controlador.clicks;

import fiuba.algo3.App;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.vista.ventanas.VistaAcercaDe;
import fiuba.algo3.vista.ventanas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
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
        VistaAcercaDe.display(escenario, vistaPrincipal, botonAtras);
    }
}
