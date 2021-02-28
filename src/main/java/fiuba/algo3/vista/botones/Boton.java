package fiuba.algo3.vista.botones;

import javafx.scene.control.Button;

public class Boton extends Button {

    public Boton(String bloqueID, String texto) {
        super(texto);
        this.setId(bloqueID);
        this.getStyleClass().addAll("boton", "bloque", "bloqueMovimiento");
    }

    public String obtenerID() {
        return this.getClass().getSimpleName();
    }
}
