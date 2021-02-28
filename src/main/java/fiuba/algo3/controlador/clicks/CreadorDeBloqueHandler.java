package fiuba.algo3.controlador.clicks;

import fiuba.algo3.modelo.AlgoBlocks;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.bloques.BloqueInvertir;
import fiuba.algo3.modelo.bloques.BloqueRepetirDosVeces;
import fiuba.algo3.modelo.bloques.BloqueRepetirTresVeces;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CreadorDeBloqueHandler extends BotonClickHandler {

    private AlgoBlocks algoBlocks;
    private Algoritmo algoritmo;

    public CreadorDeBloqueHandler(Algoritmo algoritmo) {
        this.algoBlocks = new AlgoBlocks();
        this.algoritmo = algoritmo;
    }

    public EventHandler<ActionEvent> agregar(String botonID) {
        if (botonID == "bloqueMovimientoArriba") {
            this.algoBlocks.agregarBloqueMovimientoArriba(algoritmo);
        } else if (botonID == "bloqueMovimientoAbajo") {
            this.algoBlocks.agregarBloqueMovimientoAbajo(algoritmo);
        } else if (botonID == "bloqueMovimientoIzquierda") {
            this.algoBlocks.agregarBloqueMovimientoIzquierda(algoritmo);
        } else if (botonID == "bloqueMovimientoDerecha") {
            this.algoBlocks.agregarBloqueMovimientoDerecha(algoritmo);
        } else if (botonID == "bloqueLapizDibuja") {
            this.algoBlocks.agregarBloqueBajarLapiz();
        } else if (botonID == "bloqueLapizNoDibuja") {
            this.algoBlocks.agregarBloqueLevantarLapiz();
        } else if (botonID == "bloqueRepeticionDoble") {
            this.algoritmo.agregar(new BloqueRepetirDosVeces());
        } else if (botonID == "bloqueRepeticionTriple") {
            this.algoritmo.agregar(new BloqueRepetirTresVeces());
        } else if (botonID == "bloqueInvertir") {
            this.algoritmo.agregar(new BloqueInvertir());
        }
        return this;
    }
}
