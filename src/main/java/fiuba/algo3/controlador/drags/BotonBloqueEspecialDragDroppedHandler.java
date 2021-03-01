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

    private final VBox contenedorDeBloquesVertical;
    private final BloquePersonalizado bloqueEspecial;
    private FabricaAbstractaDeBloques fabricaDeBloques;
    private final SeccionAlgoritmoDragDroppedEventHandler seccionAlgoritmoDragDropped;

    public BotonBloqueEspecialDragDroppedHandler(VBox contenedorDeBloquesVertical, BloquePersonalizado bloqueEspecial, Algoritmo algoritmo, FabricaAbstractaDeBloques fabricaDeBloques) {
        this.contenedorDeBloquesVertical = contenedorDeBloquesVertical;
        this.bloqueEspecial = bloqueEspecial;
        this.fabricaDeBloques = fabricaDeBloques;
        this.seccionAlgoritmoDragDropped = new SeccionAlgoritmoDragDroppedEventHandler(algoritmo, contenedorDeBloquesVertical, this.fabricaDeBloques);
    }

    @Override
    public void handle(DragEvent dragEvent) {

        Dragboard db = dragEvent.getDragboard();
        boolean success = false;

        if (db.hasString() && !db.getString().equals("bloqueInvertir") && !db.getString().equals("bloqueRepeticionDoble") && !db.getString().equals("bloqueRepeticionTriple")) {

            ImageView imageView = new ImageView(db.getImage());
            this.contenedorDeBloquesVertical.getChildren().add(imageView);

            this.agregarUnBloqueAlBloqueContenedor(db.getString());

            success = true;
        }
        dragEvent.setDropCompleted(success);
    }

    public void agregarUnBloqueAlBloqueContenedor(String bloqueId) {

        switch (bloqueId) {
            case "bloqueMovimientoArriba":
                this.bloqueEspecial.agregar(fabricaDeBloques.crearBloqueMovimientoArriba());
                break;
            case "bloqueMovimientoAbajo":
                this.bloqueEspecial.agregar(fabricaDeBloques.crearBloqueMovimientoAbajo());
                break;
            case "bloqueMovimientoIzquierda":
                this.bloqueEspecial.agregar(fabricaDeBloques.crearBloqueMovimientoIzquierda());
                break;
            case "bloqueMovimientoDerecha":
                this.bloqueEspecial.agregar(fabricaDeBloques.crearBloqueMovimientoDerecha());
                break;
            case "bloqueLapizNoDibuja":
                this.fabricaDeBloques = new FabricaConcretaBloqueQueNoDibuja();
                break;
            case "bloqueLapizDibuja":
                this.fabricaDeBloques = new FabricaConcretaBloqueQueDibuja();
                break;
            case "bloqueInvertir":
                this.bloqueEspecial.agregar(new BloqueInvertir());
                break;
            case "bloqueRepeticionDoble":
                this.bloqueEspecial.agregar(new BloqueRepetirDosVeces());
                break;
            case "bloqueRepeticionTriple":
                this.bloqueEspecial.agregar(new BloqueRepetirTresVeces());
                break;
        }
        this.seccionAlgoritmoDragDropped.agregarUnBloqueAlAlgoritmo(bloqueId);
    }
}
