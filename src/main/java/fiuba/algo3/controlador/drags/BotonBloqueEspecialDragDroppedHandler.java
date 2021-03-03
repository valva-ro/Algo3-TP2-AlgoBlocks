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

public class BotonBloqueEspecialDragDroppedHandler extends BotonDragHandler {

    private final VBox bloqueEspecialVista;
    private final Bloques bloqueEspecial;
    private final Algoritmo algoritmo;
    private Interpretador interpretador;
    private SectorBloquesDisponiblesVista sectorBloquesDisponiblesVista;

    public BotonBloqueEspecialDragDroppedHandler(VBox bloqueEspecialVista, Bloques bloqueEspecial, Algoritmo algoritmo, Interpretador interpretador, SectorBloquesDisponiblesVista sectorBloquesDisponiblesVista) {
        this.bloqueEspecialVista = bloqueEspecialVista;
        this.bloqueEspecial = bloqueEspecial;
        this.algoritmo = algoritmo;
        this.interpretador = interpretador;
        this.sectorBloquesDisponiblesVista = sectorBloquesDisponiblesVista;
    }

    @Override
    public void handle(DragEvent dragEvent) {
        super.handle(dragEvent);
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            this.agregarUnBloqueAlBloqueContenedor(db.getString());
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();
    }

    private void agregarUnBloqueAlBloqueContenedor(String bloqueId) {
        if (this.interpretador.esBloqueEspecial(bloqueId)) {
            BotonBloqueEspecial nuevoBoton = this.interpretador.obtenerBotonEspecialPorId(bloqueId, this.algoritmo, this.sectorBloquesDisponiblesVista);
            this.bloqueEspecial.agregar(nuevoBoton.obtenerBloque());
            this.bloqueEspecialVista.getChildren().add(nuevoBoton);
        }

        else if (this.sectorBloquesDisponiblesVista.existeGuardadoConId(bloqueId)) {
            BotonBloquePersonalizado nuevoBoton = sectorBloquesDisponiblesVista.obtenerCopiaPorId(bloqueId);
            nuevoBoton.setDisable(true);
            this.algoritmo.agregar(nuevoBoton.obtenerPersonalizado());
            this.bloqueEspecialVista.getChildren().add(nuevoBoton);
        }

        else {
            BotonBloqueSimple nuevoBoton = this.interpretador.agregarBloqueSiempleAlBloqueEspecial(bloqueId, this.bloqueEspecial);
            this.bloqueEspecialVista.getChildren().add(nuevoBoton);
        }
    }
}
