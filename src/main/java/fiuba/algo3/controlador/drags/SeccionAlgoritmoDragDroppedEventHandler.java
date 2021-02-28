package fiuba.algo3.controlador.drags;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.bloques.*;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueDibuja;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueNoDibuja;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;

public class SeccionAlgoritmoDragDroppedEventHandler extends BotonDragHandler {

    private Algoritmo algoritmo;
    private FabricaAbstractaDeBloques fabricaDeBloques;

    public SeccionAlgoritmoDragDroppedEventHandler(Algoritmo algoritmo){
        this.algoritmo = algoritmo;
        this.fabricaDeBloques = new FabricaConcretaBloqueQueNoDibuja();
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
    }

    public void agregarUnBloqueAlAlgoritmo(String bloqueId){
        System.out.println(bloqueId);
        if (bloqueId == "bloqueMovimientoArriba"){
            this.algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoArriba());
        } else if (bloqueId == "bloqueMovimientoAbajo"){
            this.algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoAbajo());
        } else if (bloqueId == "bloqueMovimientoIzquierda"){
            this.algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoIzquierda());
        } else if (bloqueId == "bloqueMovimientoDerecha"){
            this.algoritmo.agregar(fabricaDeBloques.crearBloqueMovimientoDerecha());
        } else if (bloqueId == "bloqueLapizNoDibuja"){
            this.fabricaDeBloques = new FabricaConcretaBloqueQueNoDibuja();
        } else if (bloqueId == "bloqueLapizDibuja"){
            this.fabricaDeBloques = new FabricaConcretaBloqueQueDibuja();
        } else if (bloqueId == "bloqueInvertir"){
            this.algoritmo.agregar(new BloqueInvertir());
        } else if (bloqueId == "bloqueRepeticionDoble"){
            this.algoritmo.agregar(new BloqueRepetirDosVeces());
        } else if (bloqueId == "bloqueRepeticionTriple"){
            this.algoritmo.agregar(new BloqueRepetirTresVeces());
        }
    }
}
