package fiuba.algo3.vista.botones;

import fiuba.algo3.controlador.drags.BotonBloqueEspecialDragDroppedHandler;
import fiuba.algo3.controlador.drags.BotonBloqueOnDragDetectedHandler;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.bloques.BloquePersonalizado;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import javafx.scene.layout.VBox;

public class BotonBloqueEspecial extends Boton {

    private VBox bloquesContenidos = new VBox();

    public BotonBloqueEspecial(String bloqueID, String texto, Algoritmo algoritmo, FabricaAbstractaDeBloques fabricaDeBloques) {
        super(bloqueID, texto);
        this.setOnDragDetected(new BotonBloqueOnDragDetectedHandler(this));
        this.setOnDragDropped(new BotonBloqueEspecialDragDroppedHandler(bloquesContenidos, new BloquePersonalizado(), algoritmo, fabricaDeBloques));
    }
}
