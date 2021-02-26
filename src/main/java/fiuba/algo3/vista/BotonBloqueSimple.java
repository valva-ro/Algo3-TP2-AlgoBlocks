package fiuba.algo3.vista;

import fiuba.algo3.controlador.BotonDragHandler;

public class BotonBloqueSimple extends Boton {

    public BotonBloqueSimple(String bloqueID, String texto) {
        super(bloqueID, texto);
        this.setOnDragDetected(new BotonDragHandler());
    }
}
