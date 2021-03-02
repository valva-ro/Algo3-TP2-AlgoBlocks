package fiuba.algo3.controlador.clicks;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.SectorDibujo;
import fiuba.algo3.vista.sectores.SectorDibujoVista;
import javafx.event.ActionEvent;

public class BotonEjecutarAlgoritmoHandler extends BotonClickHandler {

    private final SectorDibujo sectorDibujo;
    private final Algoritmo algoritmo;
    private final SectorDibujoVista sectorDibujoVista;

    public BotonEjecutarAlgoritmoHandler(Algoritmo algoritmo, SectorDibujoVista sectorDibujoVista) {
        this.algoritmo = algoritmo;
        this.sectorDibujoVista = sectorDibujoVista;
        this.sectorDibujo = new SectorDibujo();
        this.sectorDibujo.agregarObservador(this.sectorDibujoVista);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.sectorDibujoVista.borrarDibujo();
        algoritmo.ejecutar(sectorDibujo);
    }
}
