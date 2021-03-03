package fiuba.algo3.controlador.drags;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.modelo.bloques.Bloques;
import fiuba.algo3.vista.botones.BotonBloqueEspecial;
import fiuba.algo3.vista.botones.BotonBloquePersonalizado;
import fiuba.algo3.vista.botones.BotonBloqueSimple;
import fiuba.algo3.vista.sectores.SectorBloquesDisponiblesVista;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;

public class BotonBloqueEspecialDragDroppedHandler extends BotonDragDroppedHandler {

    private final Bloques bloqueEspecial;

    public BotonBloqueEspecialDragDroppedHandler(VBox vistaBloques, Bloques bloqueEspecial, Algoritmo algoritmo, Interpretador interpretador, SectorBloquesDisponiblesVista sectorBloquesDisponiblesVista) {
        super(algoritmo, interpretador, vistaBloques, sectorBloquesDisponiblesVista);
        this.bloqueEspecial = bloqueEspecial;
    }

    @Override
    void agregarUnBloque(String bloqueID) {
        if (this.interpretador.esBloqueEspecial(bloqueID)) {
            BotonBloqueEspecial nuevoBoton = this.interpretador.obtenerBotonEspecialPorId(bloqueID, this.algoritmo, this.sectorBloquesDisponiblesVista);
            this.bloqueEspecial.agregar(nuevoBoton.obtenerBloque());
            this.vistaBloques.getChildren().add(nuevoBoton);
        } else if (this.sectorBloquesDisponiblesVista.existeGuardadoConId(bloqueID)) {
            BotonBloquePersonalizado nuevoBoton = sectorBloquesDisponiblesVista.obtenerCopiaPorId(bloqueID);
            nuevoBoton.setDisable(true);
            this.algoritmo.agregar(nuevoBoton.obtenerPersonalizado());
            this.vistaBloques.getChildren().add(nuevoBoton);
        } else {
            BotonBloqueSimple nuevoBoton = this.interpretador.agregarBloqueSiempleAlBloqueEspecial(bloqueID, this.bloqueEspecial);
            this.vistaBloques.getChildren().add(nuevoBoton);
        }
    }
}
