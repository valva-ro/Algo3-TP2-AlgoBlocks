package fiuba.algo3.controlador.clicks;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.SectorBloques;
import fiuba.algo3.vista.ventanas.VentanaGuardarAlgoritmoPersonalizado;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;

public class BotonGuardarAlgoritmoHandler extends BotonClickHandler {

    VBox contenedorBloques;
    Algoritmo algoritmo;
    SectorBloques sectorBloques;

    public BotonGuardarAlgoritmoHandler(VBox contenedorBloques, SectorBloques sectorBloques, Algoritmo algoritmo) {
        this.contenedorBloques = contenedorBloques;
        this.sectorBloques = sectorBloques;
        this.algoritmo = algoritmo;
    }

    @Override
    public void handle(ActionEvent event) {
        VentanaGuardarAlgoritmoPersonalizado.display(contenedorBloques, "Guardar bloque personalizado", "Ingrese un nombre para el bloque:", this.algoritmo, this.sectorBloques);
    }
}
