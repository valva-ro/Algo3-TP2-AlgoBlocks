package fiuba.algo3.vista.botones;

import javafx.scene.control.Button;

public class Boton extends Button {

    public Boton(String botonID, String texto) {
        super(texto);
        this.setId(botonID);
        this.getStyleClass().add("boton");
    }

}
