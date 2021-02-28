package fiuba.algo3.controlador.drags;

import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;

public class BotonBloqueEspecialDragOverHandler extends BotonDragHandler {

    private VBox contenedorDeBloquesVertical;

    public BotonBloqueEspecialDragOverHandler(VBox contenedorDeBloquesVertical) {
        super();
        this.contenedorDeBloquesVertical = contenedorDeBloquesVertical;
    }

    @Override
    public void handle(DragEvent dragEvent) {
        if (dragEvent.getGestureSource() != this.contenedorDeBloquesVertical &&
                dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        dragEvent.consume();
    }
}
