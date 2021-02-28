package fiuba.algo3.controlador.clicks;

import fiuba.algo3.modelo.Algoritmo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LimpiadorDeAlgoritmoHandler extends BotonClickHandler {

    private Algoritmo algoritmo;

    public LimpiadorDeAlgoritmoHandler(Algoritmo algoritmo){
        this.algoritmo = algoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.algoritmo.vaciar();
    }
}
