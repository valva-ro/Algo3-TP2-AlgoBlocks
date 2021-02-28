package fiuba.algo3.controlador.clicks;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.SectorDibujo;
import javafx.event.ActionEvent;

public class BotonEjecutarAlgoritmoHandler extends BotonClickHandler {

    private SectorDibujo sectorDibujo;
    private Algoritmo algoritmo;

    public BotonEjecutarAlgoritmoHandler(SectorDibujo sectorDibujo, Algoritmo algoritmo) {
        this.sectorDibujo = sectorDibujo;
        this.algoritmo = algoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        algoritmo.ejecutar(sectorDibujo);
    }
}
