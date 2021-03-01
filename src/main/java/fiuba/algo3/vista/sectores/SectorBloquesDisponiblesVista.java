package fiuba.algo3.vista.sectores;

import fiuba.algo3.controlador.clicks.BotonGuardarAlgoritmoHandler;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Observador;
import fiuba.algo3.modelo.SectorBloques;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import fiuba.algo3.vista.botones.Boton;
import fiuba.algo3.vista.botones.BotonBloqueEspecial;
import fiuba.algo3.vista.botones.BotonBloqueSimple;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SectorBloquesDisponiblesVista extends BorderPane implements Observador {

    private VBox contenedorVerticalBotones;
    private Algoritmo algoritmo;
    private Boton botonGuardarBloquePersonalizado;
    private FabricaAbstractaDeBloques fabricaDeBloques;

    public SectorBloquesDisponiblesVista(SectorBloques sectorBloques, Algoritmo algoritmo, FabricaAbstractaDeBloques fabricaDeBloques) {
        super();

        this.algoritmo = algoritmo;
        this.algoritmo.addObserver(this);

        this.fabricaDeBloques = fabricaDeBloques;

        this.botonGuardarBloquePersonalizado = new Boton("botonGuardarAlgoritmoEnPersonalizado", "");
        this.botonGuardarBloquePersonalizado.setDisable(true);
        this.botonGuardarBloquePersonalizado.setOnAction(new BotonGuardarAlgoritmoHandler(contenedorVerticalBotones, sectorBloques, this.algoritmo));

        this.setLeft(new ScrollPane(this.bloquesDisponibles()));
    }

    private VBox bloquesDisponibles() {

        Label etiqueta = new Label("Bloques disponibles");
        etiqueta.getStyleClass().add("subtitulo");

        BotonBloqueSimple bloqueArriba = new BotonBloqueSimple("bloqueMovimientoArriba", "");
        BotonBloqueSimple bloqueAbajo = new BotonBloqueSimple("bloqueMovimientoAbajo", "");
        BotonBloqueSimple bloqueIzquierda = new BotonBloqueSimple("bloqueMovimientoIzquierda", "");
        BotonBloqueSimple bloqueDerecha = new BotonBloqueSimple("bloqueMovimientoDerecha", "");
        BotonBloqueEspecial bloqueRepeticionDoble = new BotonBloqueEspecial("bloqueRepeticionDoble", "", algoritmo, fabricaDeBloques);
        BotonBloqueEspecial bloqueRepeticionTriple = new BotonBloqueEspecial("bloqueRepeticionTriple", "", algoritmo, fabricaDeBloques);
        BotonBloqueEspecial bloqueInvertir = new BotonBloqueEspecial("bloqueInvertir", "", algoritmo, fabricaDeBloques);
        BotonBloqueSimple bloqueLapizDibuja = new BotonBloqueSimple("bloqueLapizDibuja", "");
        BotonBloqueSimple bloqueLapizNoDibuja = new BotonBloqueSimple("bloqueLapizNoDibuja", "");

        bloqueArriba.getStyleClass().add("bloqueMovimiento");
        bloqueAbajo.getStyleClass().add("bloqueMovimiento");
        bloqueIzquierda.getStyleClass().add("bloqueMovimiento");
        bloqueDerecha.getStyleClass().add("bloqueMovimiento");
        bloqueRepeticionDoble.getStyleClass().add("bloqueRepeticion");
        bloqueRepeticionTriple.getStyleClass().add("bloqueRepeticion");

        this.contenedorVerticalBotones = new VBox(10);
        this.contenedorVerticalBotones.minWidth(50);
        this.contenedorVerticalBotones.setAlignment(Pos.TOP_CENTER);
        this.contenedorVerticalBotones.getStylesheets().add("style.css");
        this.contenedorVerticalBotones.getChildren().addAll(etiqueta,
                bloqueArriba,
                bloqueAbajo,
                bloqueDerecha,
                bloqueIzquierda,
                bloqueRepeticionDoble,
                bloqueRepeticionTriple,
                bloqueInvertir,
                bloqueLapizDibuja,
                bloqueLapizNoDibuja,
                this.botonGuardarBloquePersonalizado);

        return contenedorVerticalBotones;
    }

    @Override
    public void update() {
        this.botonGuardarBloquePersonalizado.setDisable(this.algoritmo.estaVacio());
    }
}
