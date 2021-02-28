package fiuba.algo3.controlador.drags;

import fiuba.algo3.vista.botones.Boton;
import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class BotonBloqueOnDragDetectedHandler implements EventHandler<MouseEvent> {

    private Boton boton;

    public BotonBloqueOnDragDetectedHandler(Boton boton){
        this.boton = boton;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Dragboard db = this.boton.startDragAndDrop(TransferMode.COPY);
        ClipboardContent content = new ClipboardContent();
        content.putString(this.boton.obtenerID());
        db.setContent(content);
        mouseEvent.consume();
    }
}
