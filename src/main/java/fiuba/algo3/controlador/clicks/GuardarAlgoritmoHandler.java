package fiuba.algo3.controlador.clicks;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.bloques.Bloque;
import fiuba.algo3.modelo.bloques.BloquePersonalizado;
import fiuba.algo3.vista.botones.BotonBloquePersonalizado;
import fiuba.algo3.vista.sectores.SectorBloquesDisponiblesVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuardarAlgoritmoHandler implements EventHandler<ActionEvent> {

    private final SectorBloquesDisponiblesVista contenedorBloques;
    private Algoritmo algoritmo;
    private final TextField etiquetaEspecial;
    private final Stage ventana;

    public GuardarAlgoritmoHandler(SectorBloquesDisponiblesVista contenedorBloques, TextField campoDeTexto, Algoritmo algoritmo, Stage ventana) {
        this.contenedorBloques = contenedorBloques;
        this.etiquetaEspecial = campoDeTexto;
        this.algoritmo = algoritmo;
        this.ventana = ventana;
    }


    @Override
    public void handle(ActionEvent event) {
        BloquePersonalizado bloquePersonalizado = this.agregarAlgoritmoAlBloquePersonalizado();
        BotonBloquePersonalizado botonBloquePersonalizado = new BotonBloquePersonalizado( this.etiquetaEspecial.getText(), this.etiquetaEspecial.getText(), bloquePersonalizado);
        this.contenedorBloques.agregarBotonPersonalizado(botonBloquePersonalizado);
        this.ventana.close();
    }

    private BloquePersonalizado agregarAlgoritmoAlBloquePersonalizado() {
        Bloque[] bloquesEnAlgoritmo = this.algoritmo.obtenerBloques();
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        bloquePersonalizado.agregar(bloquesEnAlgoritmo);

        return bloquePersonalizado;
    }
}
