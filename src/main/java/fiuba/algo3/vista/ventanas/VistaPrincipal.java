package fiuba.algo3.vista.ventanas;

import fiuba.algo3.App;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.vista.sectores.SectorAlgoritmoVista;
import fiuba.algo3.vista.sectores.SectorBloquesDisponiblesVista;
import fiuba.algo3.vista.sectores.SectorDibujoVista;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VistaPrincipal extends BorderPane {

    public VistaPrincipal(App aplicacion, Stage escenario, Algoritmo algoritmo, Interpretador interpretador) {
        this.setStyle("-fx-background-color: #e0fee0");

        SectorBloquesDisponiblesVista bloquesDisponiblesVista = new SectorBloquesDisponiblesVista(algoritmo, interpretador);
        SectorDibujoVista sectorDibujoVista = new SectorDibujoVista();
        SectorAlgoritmoVista sectorAlgoritmoVista = new SectorAlgoritmoVista(algoritmo, aplicacion, escenario, interpretador, sectorDibujoVista, bloquesDisponiblesVista);

        this.setLeft(bloquesDisponiblesVista);
        this.setCenter(sectorAlgoritmoVista);
        this.setRight(sectorDibujoVista);
    }
}
