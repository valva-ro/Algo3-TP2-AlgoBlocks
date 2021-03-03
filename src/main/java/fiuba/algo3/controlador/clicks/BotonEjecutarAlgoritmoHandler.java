package fiuba.algo3.controlador.clicks;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.SectorDibujo;
import fiuba.algo3.vista.sectores.SectorDibujoVista;
import javafx.event.ActionEvent;

public class BotonEjecutarAlgoritmoHandler extends BotonClickHandler {

    private final Algoritmo algoritmo;
    private final SectorDibujoVista sectorDibujoVista;

    public BotonEjecutarAlgoritmoHandler(Algoritmo algoritmo, SectorDibujoVista sectorDibujoVista) {
        this.algoritmo = algoritmo;
        this.sectorDibujoVista = sectorDibujoVista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        SectorDibujo sectorDibujo = new SectorDibujo();
        sectorDibujo.agregarObservador(this.sectorDibujoVista);
        this.sectorDibujoVista.borrarDibujo();
        algoritmo.ejecutar(sectorDibujo);
    }
}
