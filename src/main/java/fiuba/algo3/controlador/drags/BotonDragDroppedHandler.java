package fiuba.algo3.controlador.drags;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.vista.sectores.SectorBloquesDisponiblesVista;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;

import java.io.File;

public abstract class BotonDragDroppedHandler implements EventHandler<DragEvent> {

    private AudioClip sonidoClick;
    protected Algoritmo algoritmo;
    protected VBox vistaBloques;
    protected Interpretador interpretador;
    protected SectorBloquesDisponiblesVista sectorBloquesDisponiblesVista;

    public BotonDragDroppedHandler(Algoritmo algoritmo, Interpretador interpretador, VBox vistaBloques, SectorBloquesDisponiblesVista sectorBloquesDisponiblesVista) {
        this.algoritmo = algoritmo;
        this.vistaBloques = vistaBloques;
        this.interpretador = interpretador;
        this.sectorBloquesDisponiblesVista = sectorBloquesDisponiblesVista;
        this.sonidoClick = new AudioClip(new File("src/main/resources/drag_bloque.mp3").toURI().toString());
    }

    @Override
    public void handle(DragEvent dragEvent) {
        sonidoClick.play(0.5);
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            this.agregarUnBloque(db.getString());
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();
    }

    abstract void agregarUnBloque(String bloqueID);
}
