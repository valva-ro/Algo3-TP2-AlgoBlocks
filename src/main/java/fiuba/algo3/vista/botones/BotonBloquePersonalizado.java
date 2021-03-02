package fiuba.algo3.vista.botones;

import fiuba.algo3.modelo.bloques.BloquePersonalizado;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class BotonBloquePersonalizado extends BotonBloqueSimple {

    private BloquePersonalizado bloquePersonalizado;

    public BotonBloquePersonalizado(String bloqueID, String texto, BloquePersonalizado bloquePersonalizado) {
        super(bloqueID, texto);

        this.setOnDragDetected((MouseEvent mouseEvent) -> {
            Dragboard db = this.startDragAndDrop(TransferMode.COPY_OR_MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(bloqueID);
            db.setContent(content);
            mouseEvent.consume();
        });


        this.getStyleClass().add("bloquePersonalizado");
        this.bloquePersonalizado = bloquePersonalizado;
    }

    public BloquePersonalizado obtenerPersonalizado() {
        return this.bloquePersonalizado;
    }

    public BotonBloquePersonalizado crearCopia() {
        return new BotonBloquePersonalizado(this.getId(), this.getText(), this.obtenerPersonalizado());
    }
}
