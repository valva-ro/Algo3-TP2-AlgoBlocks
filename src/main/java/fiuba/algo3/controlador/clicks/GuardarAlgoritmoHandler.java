package fiuba.algo3.controlador.clicks;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.bloques.Bloque;
import fiuba.algo3.modelo.bloques.BloquePersonalizado;
import fiuba.algo3.vista.botones.BotonBloqueSimple;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuardarAlgoritmoHandler implements EventHandler<ActionEvent> {

    private final VBox contenedorBloques;
    private Algoritmo algoritmo;
    private final String etiquetaEspecial;
    private final Stage ventana;

    public GuardarAlgoritmoHandler(VBox contenedorBloques, TextField campoDeTexto, Algoritmo algoritmo, Stage ventana) {
        this.contenedorBloques = contenedorBloques;
        this.etiquetaEspecial = campoDeTexto.getText();
        this.algoritmo = algoritmo;
        this.ventana = ventana;
    }


    @Override
    public void handle(ActionEvent event) {
        BloquePersonalizado bloquePersonalizado = this.agregarAlgoritmoAlBloquePersonalizado();
        BotonBloqueSimple botonBloquePersonalizado = new BotonBloqueSimple("bloquePersonalizado",this.etiquetaEspecial);
        this.contenedorBloques.getChildren().add(botonBloquePersonalizado);
        this.ventana.close();
    }

    private BloquePersonalizado agregarAlgoritmoAlBloquePersonalizado() {
        Bloque[] bloquesEnAlgoritmo = this.algoritmo.obtenerBloques();
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        bloquePersonalizado.agregar(bloquesEnAlgoritmo);

        return bloquePersonalizado;
    }
}
