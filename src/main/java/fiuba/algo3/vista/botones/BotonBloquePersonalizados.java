package fiuba.algo3.vista.botones;

import fiuba.algo3.modelo.bloques.BloquePersonalizado;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class BotonBloquePersonalizados extends BotonBloqueSimple{

    private BloquePersonalizado bloquePersonalizado;

    public BotonBloquePersonalizados(String bloqueID, String texto, BloquePersonalizado bloquePersonalizado) {
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

    public BloquePersonalizado obtenerPerzonalizado() {
        return this.bloquePersonalizado;
    }

    public BotonBloquePersonalizados crearCopia(){
        return  new BotonBloquePersonalizados(this.getId(),this.getText(),this.obtenerPerzonalizado());
    }
}
