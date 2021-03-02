package fiuba.algo3.controlador.clicks;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.vista.sectores.SectorBloquesDisponiblesVista;
import fiuba.algo3.vista.ventanas.VentanaGuardarAlgoritmoPersonalizado;
import javafx.event.ActionEvent;

public class BotonGuardarAlgoritmoHandler extends BotonClickHandler {

    private final SectorBloquesDisponiblesVista contenedorBloques;
    private final Algoritmo algoritmo;

    public BotonGuardarAlgoritmoHandler(SectorBloquesDisponiblesVista contenedorBloques, Algoritmo algoritmo) {
        this.contenedorBloques = contenedorBloques;
        this.algoritmo = algoritmo;
    }

    @Override
    public void handle(ActionEvent event) {
        VentanaGuardarAlgoritmoPersonalizado.display(contenedorBloques, "Guardar bloque personalizado", "Ingrese un nombre para el bloque:", this.algoritmo);
    }
}
