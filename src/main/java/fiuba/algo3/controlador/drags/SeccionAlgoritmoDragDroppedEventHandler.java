package fiuba.algo3.controlador.drags;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import fiuba.algo3.vista.botones.BotonBloqueEspecial;
import fiuba.algo3.vista.botones.BotonBloqueSimple;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;

public class SeccionAlgoritmoDragDroppedEventHandler implements EventHandler<DragEvent> {

    private final Algoritmo algoritmo;
    private final VBox algoritmoVista;
    private FabricaAbstractaDeBloques fabricaDeBloques;
    private Interpretador interpretador;

    public SeccionAlgoritmoDragDroppedEventHandler(Algoritmo algoritmo, VBox algoritmoVista, FabricaAbstractaDeBloques fabricaDeBloques) {
        this.algoritmo = algoritmo;
        this.algoritmoVista = algoritmoVista;
        this.fabricaDeBloques = fabricaDeBloques;
        this.interpretador = new Interpretador();
    }

    @Override
    public void handle(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            this.agregarUnBloqueAlAlgoritmo(db.getString());
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();
    }
    private void agregarUnBloqueAlAlgoritmo(String bloqueId){
        if (this.interpretador.esBloqueEspecial(bloqueId)){
            BotonBloqueEspecial bloqueEspecial = this.interpretador.obtenerBotonEspecialPorId(bloqueId,this.algoritmo,this.fabricaDeBloques );
            this.algoritmo.agregar(bloqueEspecial.obtenerBloque());
            this.algoritmoVista.getChildren().add(bloqueEspecial);

            this.algoritmoVista.getChildren().add(bloqueEspecial);
        }
        else{
            BotonBloqueSimple bloqueSimple = this.interpretador.agregarBloqueSiempleAlAlgoritmo(bloqueId,this.algoritmo,this.fabricaDeBloques);
            this.algoritmoVista.getChildren().add(bloqueSimple);
        }
    }

}
