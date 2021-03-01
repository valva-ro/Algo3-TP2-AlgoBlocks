package fiuba.algo3.vista.botones;

import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class BotonBloqueSimple extends Boton {

    public BotonBloqueSimple(String bloqueID, String texto) {
        super(bloqueID, texto);
        this.setOnDragDetected((MouseEvent mouseEvent) -> {
            Dragboard db = this.startDragAndDrop(TransferMode.COPY_OR_MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(this.getId());
            db.setContent(content);
            mouseEvent.consume();
        });
    }
}