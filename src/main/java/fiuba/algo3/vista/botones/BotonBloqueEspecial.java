package fiuba.algo3.vista.botones;

import fiuba.algo3.controlador.drags.BotonBloqueEspecialDragDroppedHandler;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.modelo.bloques.BloquePersonalizado;
import fiuba.algo3.modelo.bloques.Bloques;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;

public class BotonBloqueEspecial extends VBox {

    private Bloques bloquePersonalizado;
    private Interpretador interpretador;
    private Algoritmo algoritmo;
    private FabricaAbstractaDeBloques fabricaAbstractaDeBloques;

    public BotonBloqueEspecial(String bloqueID, Algoritmo algoritmo, FabricaAbstractaDeBloques fabricaDeBloques) {

        this.setId(bloqueID);
        this.getStyleClass().addAll("boton", "bloqueEspecial");
        this.setAlignment(Pos.BOTTOM_RIGHT);
        this.interpretador = new Interpretador();
        this.bloquePersonalizado = this.interpretador.obtenerBloqueEspecialPorId(bloqueID);
        this.algoritmo = algoritmo;
        this.fabricaAbstractaDeBloques = fabricaDeBloques;

        this.setOnDragDetected((MouseEvent mouseEvent) -> {
            Dragboard db = this.startDragAndDrop(TransferMode.COPY);
            ClipboardContent content = new ClipboardContent();
            content.putString(bloqueID);
            db.setContent(content);
            mouseEvent.consume();
        });

    }

    public BotonBloqueEspecial(String bloqueID, Label nombrePersonalizado, BloquePersonalizado bloquePersonalizado) {

        this.setId(bloqueID);
        this.getStyleClass().addAll("boton", "bloqueEspecial,bloquePersonalizado");
        this.setAlignment(Pos.BOTTOM_RIGHT);
        this.getChildren().add(nombrePersonalizado);
        this.interpretador = new Interpretador();
        this.bloquePersonalizado = bloquePersonalizado;

        this.setOnDragDetected((MouseEvent mouseEvent) -> {
            Dragboard db = this.startDragAndDrop(TransferMode.COPY);
            ClipboardContent content = new ClipboardContent();
            content.putString(bloqueID);
            db.setContent(content);
            mouseEvent.consume();
        });

    }

    public Bloques obtenerBloque() {
        return this.bloquePersonalizado;
    }


    public void setModoAlgoritmo() {
        this.setOnDragOver((DragEvent dragEvent) -> {
            if (dragEvent.getGestureSource() != this && dragEvent.getDragboard().hasString()) {
                dragEvent.acceptTransferModes(TransferMode.COPY);
            }
            dragEvent.consume();
        });

        this.setOnDragDropped(new BotonBloqueEspecialDragDroppedHandler(this, this.bloquePersonalizado, algoritmo, fabricaAbstractaDeBloques));
    }
}
