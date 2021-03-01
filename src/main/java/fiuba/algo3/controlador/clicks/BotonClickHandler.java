package fiuba.algo3.controlador.clicks;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class BotonClickHandler implements EventHandler<ActionEvent> {

    //TODO: arreglar sonido
    //private AudioClip sonidoClick;

    public BotonClickHandler() {
        //String audio = getClass().getResource("click_boton.mp3").toString();
        //this.sonidoClick = new AudioClip("click_boton.mp3");
    }

    @Override
    public void handle(ActionEvent event) {
        //sonidoClick.play();
    }
}
