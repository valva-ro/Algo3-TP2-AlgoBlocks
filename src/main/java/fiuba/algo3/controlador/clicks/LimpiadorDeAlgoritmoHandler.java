package fiuba.algo3.controlador.clicks;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.vista.sectores.SectorDibujoVista;
import javafx.event.ActionEvent;

public class LimpiadorDeAlgoritmoHandler extends BotonClickHandler {

    private final Algoritmo algoritmo;
    private final SectorDibujoVista sectorDibujoVista;
    private final Interpretador interpretador;

    public LimpiadorDeAlgoritmoHandler(Algoritmo algoritmo, SectorDibujoVista sectorDibujoVista, Interpretador interpretador){
        this.algoritmo = algoritmo;
        this.sectorDibujoVista = sectorDibujoVista;
        this.interpretador = interpretador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.algoritmo.vaciar();
        this.sectorDibujoVista.borrarDibujo();

        this.interpretador.resetearFabrica();
    }
}
