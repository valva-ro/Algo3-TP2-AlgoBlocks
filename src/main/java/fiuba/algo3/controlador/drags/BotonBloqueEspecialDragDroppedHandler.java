package fiuba.algo3.controlador.drags;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.bloques.*;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueDibuja;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueNoDibuja;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;

public class BotonBloqueEspecialDragDroppedHandler extends BotonDragHandler {

    private VBox contenedorDeBloquesVertical;
    private BloquePersonalizado bloqueEspecial;
    private FabricaAbstractaDeBloques fabricaDeBloques;
    private SeccionAlgoritmoDragDroppedEventHandler seccionAlgoritmoDragDropped;

    public BotonBloqueEspecialDragDroppedHandler(VBox contenedorDeBloquesVertical, BloquePersonalizado bloqueEspecial, Algoritmo algoritmo){
        this.contenedorDeBloquesVertical = contenedorDeBloquesVertical;
        this.bloqueEspecial = bloqueEspecial;
        this.fabricaDeBloques = new FabricaConcretaBloqueQueNoDibuja();
        this.seccionAlgoritmoDragDropped = new SeccionAlgoritmoDragDroppedEventHandler(algoritmo, contenedorDeBloquesVertical);
    }

    @Override
    public void handle(DragEvent dragEvent) {

        Dragboard db = dragEvent.getDragboard();
        boolean success = false;

        if (db.hasString() && db.getString() != "bloqueInvertir" && db.getString() != "bloqueRepeticionDoble" && db.getString() != "bloqueRepeticionTriple") {

            ImageView imageView = new ImageView(db.getImage());
            this.contenedorDeBloquesVertical.getChildren().add(imageView);

            this.agregarUnBloqueAlBloqueContenedor(db.getString());

            success = true;
        }
        dragEvent.setDropCompleted(success);
    }

    public void agregarUnBloqueAlBloqueContenedor(String bloqueId){

        if (bloqueId == "bloqueMovimientoArriba"){
            this.bloqueEspecial.agregar(fabricaDeBloques.crearBloqueMovimientoArriba());
        } else if (bloqueId == "bloqueMovimientoAbajo"){
            this.bloqueEspecial.agregar(fabricaDeBloques.crearBloqueMovimientoAbajo());
        } else if (bloqueId == "bloqueMovimientoIzquierda"){
            this.bloqueEspecial.agregar(fabricaDeBloques.crearBloqueMovimientoIzquierda());
        } else if (bloqueId == "bloqueMovimientoDerecha"){
            this.bloqueEspecial.agregar(fabricaDeBloques.crearBloqueMovimientoDerecha());
        } else if (bloqueId == "bloqueLapizNoDibuja"){
            this.fabricaDeBloques = new FabricaConcretaBloqueQueNoDibuja();
        } else if (bloqueId == "bloqueLapizDibuja"){
            this.fabricaDeBloques = new FabricaConcretaBloqueQueDibuja();
        } else if (bloqueId == "bloqueInvertir"){
            this.bloqueEspecial.agregar(new BloqueInvertir());
        } else if (bloqueId == "bloqueRepeticionDoble"){
            this.bloqueEspecial.agregar(new BloqueRepetirDosVeces());
        } else if (bloqueId == "bloqueRepeticionTriple"){
            this.bloqueEspecial.agregar(new BloqueRepetirTresVeces());
        }
        this.seccionAlgoritmoDragDropped.agregarUnBloqueAlAlgoritmo(bloqueId);
    }
}
