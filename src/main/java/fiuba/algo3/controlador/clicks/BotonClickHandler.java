package fiuba.algo3.controlador.clicks;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

import java.io.File;

public class BotonClickHandler implements EventHandler<ActionEvent> {

    private AudioClip sonidoClick;

    public BotonClickHandler() {
        this.sonidoClick = new AudioClip(new File("src/main/resources/click_boton.mp3").toURI().toString());
    }

    @Override
    public void handle(ActionEvent event) {
        sonidoClick.play(0.5);
    }
}
