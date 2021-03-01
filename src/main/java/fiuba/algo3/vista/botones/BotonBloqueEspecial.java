package fiuba.algo3.vista.botones;

import fiuba.algo3.controlador.drags.BotonBloqueEspecialDragDroppedHandler;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.bloques.BloqueInvertir;
import fiuba.algo3.modelo.bloques.BloqueRepetirDosVeces;
import fiuba.algo3.modelo.bloques.BloqueRepetirTresVeces;
import fiuba.algo3.modelo.bloques.Bloques;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import javafx.geometry.Pos;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;

public class BotonBloqueEspecial extends VBox {

    private Bloques bloquePersonalizado;

    public BotonBloqueEspecial(String bloqueID, Algoritmo algoritmo, FabricaAbstractaDeBloques fabricaDeBloques) {

        this.setId(bloqueID);
        this.getStyleClass().addAll("boton", "bloqueEspecial");
        this.setAlignment(Pos.BOTTOM_RIGHT);

        switch (bloqueID) {
            case "bloqueInvertir":
                this.bloquePersonalizado = new BloqueInvertir();
                break;
            case "bloqueRepeticionDoble":
                this.bloquePersonalizado = new BloqueRepetirDosVeces();
                break;
            case "bloqueRepeticionTriple":
                this.bloquePersonalizado = new BloqueRepetirTresVeces();
                break;
        }

        this.setOnDragOver((DragEvent dragEvent) -> {
            if (dragEvent.getGestureSource() != this && dragEvent.getDragboard().hasString()) {
                dragEvent.acceptTransferModes(TransferMode.COPY);
            }
            dragEvent.consume();
        });

        this.setOnDragDetected((MouseEvent mouseEvent) -> {
            Dragboard db = this.startDragAndDrop(TransferMode.COPY);
            ClipboardContent content = new ClipboardContent();
            content.putString(this.getId());
            db.setContent(content);
            mouseEvent.consume();
        });

        this.setOnDragDropped(new BotonBloqueEspecialDragDroppedHandler(this, this.bloquePersonalizado, algoritmo, fabricaDeBloques));
    }
}
