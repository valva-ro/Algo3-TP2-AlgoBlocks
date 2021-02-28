package fiuba.algo3.vista.botones;

import fiuba.algo3.controlador.drags.BotonBloqueOnDragDetectedHandler;

public class BotonBloqueSimple extends Boton {

    public BotonBloqueSimple(String bloqueID, String texto) {
        super(bloqueID, texto);
        this.setOnDragDetected(new BotonBloqueOnDragDetectedHandler(this));
    }
}
