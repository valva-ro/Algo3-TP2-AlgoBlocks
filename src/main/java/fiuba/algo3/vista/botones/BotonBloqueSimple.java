package fiuba.algo3.vista.botones;

import fiuba.algo3.controlador.drags.BotonBloqueOnDragDetectedHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class BotonBloqueSimple extends Boton {

    public BotonBloqueSimple(String bloqueID, String texto) {
        super(bloqueID, texto);
        this.setOnDragDetected(new BotonBloqueOnDragDetectedHandler(this));
        this.getStyleClass().addAll("bloque");
    }

    public void setModoAlgoritmo() {
        this.setOnDragDetected(event -> {
            Dragboard db = this.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(this.obtenerID());
            db.setContent(content);
            event.consume();
        });
    }
}
