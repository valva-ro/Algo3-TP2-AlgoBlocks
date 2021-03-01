package fiuba.algo3.controlador.clicks;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.vista.ventanas.VentanaGuardarAlgoritmoPersonalizado;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;

public class BotonGuardarAlgoritmoHandler extends BotonClickHandler {

    private final VBox contenedorBloques;
    private final Algoritmo algoritmo;

    public BotonGuardarAlgoritmoHandler(VBox contenedorBloques, Algoritmo algoritmo) {
        this.contenedorBloques = contenedorBloques;
        this.algoritmo = algoritmo;
    }

    @Override
    public void handle(ActionEvent event) {
        VentanaGuardarAlgoritmoPersonalizado.display(contenedorBloques, "Guardar bloque personalizado", "Ingrese un nombre para el bloque:", this.algoritmo);
    }
}
