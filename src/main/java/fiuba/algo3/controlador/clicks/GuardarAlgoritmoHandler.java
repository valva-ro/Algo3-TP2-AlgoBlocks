package fiuba.algo3.controlador.clicks;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.AlgoritmoNoTieneBloquesError;
import fiuba.algo3.modelo.SectorBloques;
import fiuba.algo3.modelo.bloques.Bloque;
import fiuba.algo3.vista.botones.BotonBloqueSimple;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuardarAlgoritmoHandler implements EventHandler<ActionEvent> {

    VBox contenedorBloques;
    private Algoritmo algoritmo;
    private SectorBloques sectorBloques;
    private TextField campoDeTexto;
    private Stage ventana;

    public GuardarAlgoritmoHandler(VBox contenedorBloques, TextField campoDeTexto, Algoritmo algoritmo, SectorBloques sectorBloques, Stage ventana) {
        this.contenedorBloques = contenedorBloques;
        this.campoDeTexto = campoDeTexto;
        this.algoritmo = algoritmo;
        this.sectorBloques = sectorBloques;
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            Bloque[] bloques = algoritmo.obtenerBloques();
            sectorBloques.guardarBloqueAlgoritmoPersonalizado(campoDeTexto.getText(), bloques);
            BotonBloqueSimple bloquePersonalizado = new BotonBloqueSimple("bloquePersonalizado", campoDeTexto.getText());
            contenedorBloques.getChildren().add(bloquePersonalizado);
            ventana.close();
        } catch (AlgoritmoNoTieneBloquesError e) {
            System.out.println("ERROR");
        }
    }
}
