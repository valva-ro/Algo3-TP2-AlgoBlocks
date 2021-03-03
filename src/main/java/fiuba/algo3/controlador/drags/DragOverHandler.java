package fiuba.algo3.controlador.drags;

import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;

public class DragOverHandler extends BotonDragHandler {

    private VBox contenedorDeBloquesVertical;

    public DragOverHandler(VBox contenedorDeBloquesVertical) {
        this.contenedorDeBloquesVertical = contenedorDeBloquesVertical;
    }

    @Override
    public void handle(DragEvent dragEvent) {
        super.handle(dragEvent);
        if (dragEvent.getGestureSource() != this.contenedorDeBloquesVertical && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.COPY);
        }
        dragEvent.consume();
    }
}
