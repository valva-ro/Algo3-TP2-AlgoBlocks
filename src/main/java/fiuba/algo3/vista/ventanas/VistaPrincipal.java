package fiuba.algo3.vista.ventanas;

import fiuba.algo3.App;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.SectorBloques;
import fiuba.algo3.modelo.SectorDibujo;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import fiuba.algo3.vista.sectores.SectorAlgoritmoVista;
import fiuba.algo3.vista.sectores.SectorBloquesDisponiblesVista;
import fiuba.algo3.vista.sectores.SectorDibujoVista;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VistaPrincipal extends BorderPane {

    public VistaPrincipal(App aplicacion, Stage escenario, SectorDibujo sectorDibujo, SectorBloques sectorBloques, Algoritmo algoritmo, FabricaAbstractaDeBloques fabricaDeBloques) {
        this.setStyle("-fx-background-color: #e0fee0");

        SectorBloquesDisponiblesVista bloquesDisponiblesVista = new SectorBloquesDisponiblesVista(sectorBloques, algoritmo, fabricaDeBloques);
        SectorAlgoritmoVista sectorAlgoritmoVista = new SectorAlgoritmoVista(algoritmo, sectorDibujo, aplicacion, escenario, fabricaDeBloques);
        SectorDibujoVista sectorDibujoVista = new SectorDibujoVista();

        this.setLeft(bloquesDisponiblesVista);
        this.setCenter(sectorAlgoritmoVista);
        this.setRight(sectorDibujoVista);
    }
}
