package fiuba.algo3.controlador.drags;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;

public class DragOverHandler implements EventHandler<DragEvent> {

    private VBox contenedorDeBloquesVertical;

    public DragOverHandler(VBox contenedorDeBloquesVertical) {
        this.contenedorDeBloquesVertical = contenedorDeBloquesVertical;
    }

    @Override
    public void handle(DragEvent dragEvent) {
        if (dragEvent.getGestureSource() != this.contenedorDeBloquesVertical && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.COPY);
        }
        dragEvent.consume();
    }
}
