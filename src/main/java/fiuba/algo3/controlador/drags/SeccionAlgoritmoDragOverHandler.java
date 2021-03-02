package fiuba.algo3.controlador.drags;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;

public class SeccionAlgoritmoDragOverHandler implements EventHandler<DragEvent> {

    private VBox contenedorDeBloquesVertical;

    public SeccionAlgoritmoDragOverHandler(VBox contenedorDeBloquesVertical) {
        this.contenedorDeBloquesVertical = contenedorDeBloquesVertical;
    }

    @Override
    public void handle(DragEvent dragEvent) {
        if (dragEvent.getGestureSource() != this.contenedorDeBloquesVertical && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        dragEvent.consume();
    }
}
