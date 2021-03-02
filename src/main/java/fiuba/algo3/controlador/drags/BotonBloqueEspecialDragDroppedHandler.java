package fiuba.algo3.controlador.drags;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.modelo.bloques.Bloques;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;

public class BotonBloqueEspecialDragDroppedHandler implements EventHandler<DragEvent> {

    private final VBox bloqueEspecialVista;
    private final Bloques bloqueEspecial;
    private final Algoritmo algoritmo;
    private FabricaAbstractaDeBloques fabricaDeBloques;
    private Interpretador interpretador;

    public BotonBloqueEspecialDragDroppedHandler(VBox bloqueEspecialVista, Bloques bloqueEspecial, Algoritmo algoritmo, FabricaAbstractaDeBloques fabricaDeBloques) {
        this.bloqueEspecialVista = bloqueEspecialVista;
        this.bloqueEspecial = bloqueEspecial;
        this.fabricaDeBloques = fabricaDeBloques;
        this.algoritmo = algoritmo;
        this.interpretador = new Interpretador();
    }

    @Override
    public void handle(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            this.agregarUnBloqueAlBloqueContenedor(db.getString());
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();
    }

    /*private void agregarUnBloqueAlBloqueContenedor(String bloqueId){
        if (this.interpretador.esBloqueEspecial(bloqueId)){
            // TODO: reordenar el metodo de abajo con el interpretador
        }

    }*/

    private void agregarUnBloqueAlBloqueContenedor(String bloqueId) {

        Button bloque = new BotonBloqueSimple(bloqueId, "");
        bloque.setDisable(true);
        bloque.getStyleClass().add("contenidoDeBloquePersonalizado");

        switch (bloqueId) {
            case "bloqueMovimientoArriba":
                this.bloqueEspecial.agregar(fabricaDeBloques.crearBloqueMovimientoArriba());
                this.bloqueEspecialVista.getChildren().add(bloque);
                break;
            case "bloqueMovimientoAbajo":
                this.bloqueEspecial.agregar(fabricaDeBloques.crearBloqueMovimientoAbajo());
                this.bloqueEspecialVista.getChildren().add(bloque);
                break;
            case "bloqueMovimientoIzquierda":
                this.bloqueEspecial.agregar(fabricaDeBloques.crearBloqueMovimientoIzquierda());
                this.bloqueEspecialVista.getChildren().add(bloque);
                break;
            case "bloqueMovimientoDerecha":
                this.bloqueEspecial.agregar(fabricaDeBloques.crearBloqueMovimientoDerecha());
                this.bloqueEspecialVista.getChildren().add(bloque);
                break;
            case "bloqueLapizNoDibuja":
                this.fabricaDeBloques = new FabricaConcretaBloqueQueNoDibuja();
                this.bloqueEspecialVista.getChildren().add(bloque);
                break;
            case "bloqueLapizDibuja":
                this.fabricaDeBloques = new FabricaConcretaBloqueQueDibuja();
                this.bloqueEspecialVista.getChildren().add(bloque);
                break;
            case "bloqueInvertir":
                this.bloqueEspecial.agregar(new BloqueInvertir());
                BotonBloqueEspecial bloqueEspecial1 = new BotonBloqueEspecial(bloqueId, this.algoritmo, this.fabricaDeBloques);
                //bloqueEspecial1.getStyleClass().add("bloqueContenido");
                this.bloqueEspecialVista.getChildren().add(bloqueEspecial1);
                break;
            case "bloqueRepeticionDoble":
                this.bloqueEspecial.agregar(new BloqueRepetirDosVeces());
                BotonBloqueEspecial bloqueEspecial2 = new BotonBloqueEspecial(bloqueId, this.algoritmo, this.fabricaDeBloques);
                //bloqueEspecial2.getStyleClass().add("bloqueContenido");
                this.bloqueEspecialVista.getChildren().add(bloqueEspecial2);
                break;
            case "bloqueRepeticionTriple":
                this.bloqueEspecial.agregar(new BloqueRepetirTresVeces());
                BotonBloqueEspecial bloqueEspecial3 = new BotonBloqueEspecial(bloqueId, this.algoritmo, this.fabricaDeBloques);
                //bloqueEspecial3.getStyleClass().add("bloqueContenido");
                this.bloqueEspecialVista.getChildren().add(bloqueEspecial3);
                break;
        }
    }
}
