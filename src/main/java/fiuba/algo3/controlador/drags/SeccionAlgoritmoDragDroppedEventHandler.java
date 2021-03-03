package fiuba.algo3.controlador.drags;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.vista.botones.BotonBloqueEspecial;
import fiuba.algo3.vista.botones.BotonBloquePersonalizado;
import fiuba.algo3.vista.botones.BotonBloqueSimple;
import fiuba.algo3.vista.sectores.SectorBloquesDisponiblesVista;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;

public class SeccionAlgoritmoDragDroppedEventHandler extends BotonDragDroppedHandler {

    public SeccionAlgoritmoDragDroppedEventHandler(VBox vistaBloques, Algoritmo algoritmo, Interpretador interpretador, SectorBloquesDisponiblesVista sectorBloquesDisponiblesVista) {
        super(algoritmo, interpretador, vistaBloques, sectorBloquesDisponiblesVista);
    }

    @Override
    void agregarUnBloque(String bloqueID) {
        if (this.interpretador.esBloqueEspecial(bloqueID)) {
            BotonBloqueEspecial bloqueEspecial = this.interpretador.obtenerBotonEspecialPorId(bloqueID, this.algoritmo, this.sectorBloquesDisponiblesVista);
            bloqueEspecial.setOnDragDetected((MouseEvent mouseEvent) -> {
                bloqueEspecial.startDragAndDrop(TransferMode.NONE);
                mouseEvent.consume();
            });
            this.algoritmo.agregar(bloqueEspecial.obtenerBloque());
            this.vistaBloques.getChildren().add(bloqueEspecial);
        } else if (this.sectorBloquesDisponiblesVista.existeGuardadoConId(bloqueID)) {
            BotonBloquePersonalizado botonBloquePersonalizado = this.sectorBloquesDisponiblesVista.obtenerCopiaPorId(bloqueID);
            botonBloquePersonalizado.setDisable(true);
            this.algoritmo.agregar(botonBloquePersonalizado.obtenerPersonalizado());
            this.vistaBloques.getChildren().add(botonBloquePersonalizado);
        } else {
            BotonBloqueSimple bloqueSimple = this.interpretador.agregarBloqueSimpleAlAlgoritmo(bloqueID, this.algoritmo);
            this.vistaBloques.getChildren().add(bloqueSimple);
        }
    }
}
