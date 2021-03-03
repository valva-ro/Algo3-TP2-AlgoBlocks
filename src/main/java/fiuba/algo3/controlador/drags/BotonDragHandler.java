package fiuba.algo3.controlador.drags;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.media.AudioClip;

import java.io.File;

public class BotonDragHandler implements EventHandler<DragEvent> {

    private AudioClip sonidoClick;

    public BotonDragHandler() {
        this.sonidoClick = new AudioClip(new File("src/main/resources/drag_bloque.mp3").toURI().toString());
    }

    @Override
    public void handle(DragEvent event) {
        sonidoClick.play(0.5);
    }
}
