package fiuba.algo3.controlador.clicks;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.vista.sectores.SectorAlgoritmoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class LimpiadorDeAlgoritmoHandler extends BotonClickHandler {

    private Algoritmo algoritmo;
    private VBox algoritmoVista;

    public LimpiadorDeAlgoritmoHandler(Algoritmo algoritmo, VBox algoritmoVista){
        this.algoritmo = algoritmo;
        this.algoritmoVista = algoritmoVista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //this.algoritmo.vaciar();
        this.algoritmoVista.getChildren().removeAll();
    }
}
