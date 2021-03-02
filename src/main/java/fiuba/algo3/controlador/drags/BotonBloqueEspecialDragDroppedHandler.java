package fiuba.algo3.controlador.drags;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.modelo.bloques.Bloques;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import fiuba.algo3.vista.botones.BotonBloqueEspecial;
import fiuba.algo3.vista.botones.BotonBloquePersonalizados;
import fiuba.algo3.vista.botones.BotonBloqueSimple;
import fiuba.algo3.vista.sectores.SectorBloquesDisponiblesVista;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;

public class BotonBloqueEspecialDragDroppedHandler implements EventHandler<DragEvent> {

    private final VBox bloqueEspecialVista;
    private final Bloques bloqueEspecial;
    private final Algoritmo algoritmo;
    private FabricaAbstractaDeBloques fabricaDeBloques;
    private Interpretador interpretador;
    private SectorBloquesDisponiblesVista sectorBloquesDisponiblesVista;

    public BotonBloqueEspecialDragDroppedHandler(VBox bloqueEspecialVista, Bloques bloqueEspecial, Algoritmo algoritmo, FabricaAbstractaDeBloques fabricaDeBloques, SectorBloquesDisponiblesVista sectorBloquesDisponiblesVista) {
        this.bloqueEspecialVista = bloqueEspecialVista;
        this.bloqueEspecial = bloqueEspecial;
        this.fabricaDeBloques = fabricaDeBloques;
        this.algoritmo = algoritmo;
        this.interpretador = new Interpretador();
        this.sectorBloquesDisponiblesVista = sectorBloquesDisponiblesVista;
    }

    @Override
    public void handle(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            this.agregarUnBloqueAlBloqueContenedor(db.getString());
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();
    }

    private void agregarUnBloqueAlBloqueContenedor(String bloqueId){
        if (this.interpretador.esBloqueEspecial(bloqueId)){
            BotonBloqueEspecial nuevoBoton = this.interpretador.obtenerBotonEspecialPorId(bloqueId,this.algoritmo,this.fabricaDeBloques,this.sectorBloquesDisponiblesVista);
            this.bloqueEspecialVista.getChildren().add(nuevoBoton);
        }
        else if(this.sectorBloquesDisponiblesVista.obtenerGuardadorPorId(bloqueId) != null){
            BotonBloquePersonalizados nuevoBoton = sectorBloquesDisponiblesVista.obtenerGuardadorPorId(bloqueId);
            this.algoritmo.agregar(nuevoBoton.obtenerPerzonalizado());
            this.bloqueEspecialVista.getChildren().add(nuevoBoton);
        }
        else{
            BotonBloqueSimple nuevoBoton = this.interpretador.agregarBloqueSiempleAlBloqueEspecial(bloqueId,this.bloqueEspecial,this.fabricaDeBloques);
            this.bloqueEspecialVista.getChildren().add(nuevoBoton);
        }
    }
}
