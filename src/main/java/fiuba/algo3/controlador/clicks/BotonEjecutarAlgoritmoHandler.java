package fiuba.algo3.controlador.clicks;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.AlgoritmoNoTieneBloquesError;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.modelo.SectorDibujo;
import fiuba.algo3.modelo.bloques.BloquePersonalizadoNoPuedeEjecutarseSinBloquesError;
import fiuba.algo3.vista.sectores.SectorDibujoVista;
import fiuba.algo3.vista.ventanas.VentanaNoPuedeEjecutarseAlgoritmo;
import javafx.event.ActionEvent;

public class BotonEjecutarAlgoritmoHandler extends BotonClickHandler {

    private final Algoritmo algoritmo;
    private final SectorDibujoVista sectorDibujoVista;


    public BotonEjecutarAlgoritmoHandler(Algoritmo algoritmo, SectorDibujoVista sectorDibujoVista) {
        this.algoritmo = algoritmo;
        this.sectorDibujoVista = sectorDibujoVista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            SectorDibujo sectorDibujo = new SectorDibujo();
            sectorDibujo.agregarObservador(this.sectorDibujoVista);
            this.sectorDibujoVista.borrarDibujo();
            this.algoritmo.ejecutar(sectorDibujo);
        } catch (BloquePersonalizadoNoPuedeEjecutarseSinBloquesError error) {
            String mensaje = "El algoritmo no pudo ejecutarse porque el bloque especial esta vacio";
            VentanaNoPuedeEjecutarseAlgoritmo.display(mensaje);
        } catch (AlgoritmoNoTieneBloquesError error) {
            String mensaje = "El algoritmo no pudo ejecutarse porque esta vacio";
            VentanaNoPuedeEjecutarseAlgoritmo.display(mensaje);
        }
    }
}
