package fiuba.algo3.vista.botones;

import fiuba.algo3.controlador.drags.BotonBloqueEspecialDragDroppedHandler;
import fiuba.algo3.controlador.drags.DragOverHandler;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.modelo.bloques.Bloques;
import fiuba.algo3.vista.sectores.SectorBloquesDisponiblesVista;
import javafx.geometry.Pos;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;

public class BotonBloqueEspecial extends VBox {

    private Bloques bloquePersonalizado;
    private Interpretador interpretador;
    private Algoritmo algoritmo;
    private SectorBloquesDisponiblesVista sectorBloquesDisponiblesVista;

    public BotonBloqueEspecial(String bloqueID, Algoritmo algoritmo, Interpretador interpretador, SectorBloquesDisponiblesVista sectorBloquesDisponiblesVista) {

        this.setId(bloqueID);
        this.getStyleClass().addAll("boton", "bloqueEspecial");
        this.setAlignment(Pos.BOTTOM_RIGHT);
        this.interpretador = interpretador;
        this.bloquePersonalizado = this.interpretador.obtenerBloqueEspecialPorId(bloqueID);
        this.algoritmo = algoritmo;
        this.sectorBloquesDisponiblesVista = sectorBloquesDisponiblesVista;

        this.setOnDragDetected((MouseEvent mouseEvent) -> {
            Dragboard db = this.startDragAndDrop(TransferMode.COPY);
            ClipboardContent content = new ClipboardContent();
            content.putString(bloqueID);
            db.setContent(content);
            mouseEvent.consume();
        });

    }

    public Bloques obtenerBloque() {
        return this.bloquePersonalizado;
    }

    public void setModoAlgoritmo() {
        this.setOnDragOver(new DragOverHandler(this));
        this.setOnDragDropped(new BotonBloqueEspecialDragDroppedHandler(this, this.bloquePersonalizado, this.algoritmo, this.interpretador, this.sectorBloquesDisponiblesVista));
    }
}
