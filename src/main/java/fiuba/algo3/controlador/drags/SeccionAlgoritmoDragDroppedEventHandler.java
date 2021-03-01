package fiuba.algo3.controlador.drags;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.bloques.*;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueDibuja;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueNoDibuja;
import fiuba.algo3.vista.botones.BotonBloqueEspecial;
import fiuba.algo3.vista.botones.BotonBloqueSimple;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;

public class SeccionAlgoritmoDragDroppedEventHandler implements EventHandler<DragEvent> {

    private final Algoritmo algoritmo;
    private final VBox algoritmoVista;
    private FabricaAbstractaDeBloques fabricaDeBloques;

    public SeccionAlgoritmoDragDroppedEventHandler(Algoritmo algoritmo, VBox algoritmoVista, FabricaAbstractaDeBloques fabricaDeBloques) {
        this.algoritmo = algoritmo;
        this.algoritmoVista = algoritmoVista;
        this.fabricaDeBloques = fabricaDeBloques;
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

    private void agregarUnBloqueAlAlgoritmo(String bloqueId) {
        Button bloque;
        switch (bloqueId) {
            case "bloqueMovimientoArriba":
                this.algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoArriba());
                bloque = new BotonBloqueSimple(bloqueId, "");
                bloque.getStyleClass().add("bloqueMovimiento");
                bloque.setDisable(true);
                this.algoritmoVista.getChildren().add(bloque);
                break;
            case "bloqueMovimientoAbajo":
                this.algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoAbajo());
                bloque = new BotonBloqueSimple(bloqueId, "");
                bloque.getStyleClass().add("bloqueMovimiento");
                bloque.setDisable(true);
                this.algoritmoVista.getChildren().add(bloque);
                break;
            case "bloqueMovimientoIzquierda":
                this.algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoIzquierda());
                bloque = new BotonBloqueSimple(bloqueId, "");
                bloque.getStyleClass().add("bloqueMovimiento");
                bloque.setDisable(true);
                this.algoritmoVista.getChildren().add(bloque);
                break;
            case "bloqueMovimientoDerecha":
                this.algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoDerecha());
                bloque = new BotonBloqueSimple(bloqueId, "");
                bloque.getStyleClass().add("bloqueMovimiento");
                bloque.setDisable(true);
                this.algoritmoVista.getChildren().add(bloque);
                break;
            case "bloqueLapizNoDibuja":
                this.fabricaDeBloques = new FabricaConcretaBloqueQueNoDibuja();
                bloque = new BotonBloqueSimple(bloqueId, "");
                bloque.setDisable(true);
                this.algoritmoVista.getChildren().add(bloque);
                break;
            case "bloqueLapizDibuja":
                this.fabricaDeBloques = new FabricaConcretaBloqueQueDibuja();
                bloque = new BotonBloqueSimple(bloqueId, "");
                bloque.setDisable(true);
                this.algoritmoVista.getChildren().add(bloque);
                break;
            case "bloqueInvertir":
                this.algoritmo.agregar(new BloqueInvertir());
                BotonBloqueEspecial bloqueEspecial = new BotonBloqueEspecial(bloqueId, this.algoritmo, this.fabricaDeBloques);
                bloqueEspecial.getStyleClass().add("bloqueInvertir");
                this.algoritmoVista.getChildren().add(bloqueEspecial);
                break;
            case "bloqueRepeticionDoble":
                this.algoritmo.agregar(new BloqueRepetirDosVeces());
                BotonBloqueEspecial bloqueEspecialDoble = new BotonBloqueEspecial(bloqueId, this.algoritmo, this.fabricaDeBloques);
                bloqueEspecialDoble.getStyleClass().add("bloqueRepeticion");
                this.algoritmoVista.getChildren().add(bloqueEspecialDoble);
                break;
            case "bloqueRepeticionTriple":
                this.algoritmo.agregar(new BloqueRepetirTresVeces());
                BotonBloqueEspecial bloqueEspecialTriple = new BotonBloqueEspecial(bloqueId, this.algoritmo, this.fabricaDeBloques);
                bloqueEspecialTriple.getStyleClass().add("bloqueRepeticion");
                this.algoritmoVista.getChildren().add(bloqueEspecialTriple);
                break;
        }
    }
}
