package fiuba.algo3.vista.sectores;

import fiuba.algo3.controlador.clicks.BotonGuardarAlgoritmoHandler;
import fiuba.algo3.controlador.clicks.CreadorDeBloqueHandler;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Observador;
import fiuba.algo3.modelo.SectorBloques;
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

    public SectorBloquesDisponiblesVista(SectorBloques sectorBloques, Algoritmo algoritmo) {
        super();
        this.algoritmo = algoritmo;
        this.algoritmo.addObserver(this);
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
        BotonBloqueEspecial bloqueRepeticionDoble = new BotonBloqueEspecial("bloqueRepeticionDoble", "", algoritmo);
        BotonBloqueEspecial bloqueRepeticionTriple = new BotonBloqueEspecial("bloqueRepeticionTriple", "", algoritmo);
        BotonBloqueEspecial bloqueInvertir = new BotonBloqueEspecial("bloqueInvertir", "", algoritmo);
        BotonBloqueSimple bloqueLapizDibuja = new BotonBloqueSimple("bloqueLapizDibuja", "");
        BotonBloqueSimple bloqueLapizNoDibuja = new BotonBloqueSimple("bloqueLapizNoDibuja", "");

        bloqueRepeticionDoble.getStyleClass().add("bloqueRepeticion");
        bloqueRepeticionTriple.getStyleClass().add("bloqueRepeticion");

        CreadorDeBloqueHandler creadorDeBloqueHandler = new CreadorDeBloqueHandler(algoritmo);

        bloqueArriba.setOnAction(creadorDeBloqueHandler.agregar(bloqueArriba.obtenerID()));
        bloqueAbajo.setOnAction(creadorDeBloqueHandler.agregar(bloqueAbajo.obtenerID()));
        bloqueIzquierda.setOnAction(creadorDeBloqueHandler.agregar(bloqueIzquierda.obtenerID()));
        bloqueDerecha.setOnAction(creadorDeBloqueHandler.agregar(bloqueDerecha.obtenerID()));
        bloqueRepeticionDoble.setOnAction(creadorDeBloqueHandler.agregar(bloqueRepeticionDoble.obtenerID()));
        bloqueRepeticionTriple.setOnAction(creadorDeBloqueHandler.agregar(bloqueRepeticionTriple.obtenerID()));
        bloqueInvertir.setOnAction(creadorDeBloqueHandler.agregar(bloqueInvertir.obtenerID()));
        bloqueLapizDibuja.setOnAction(creadorDeBloqueHandler.agregar(bloqueLapizDibuja.obtenerID()));
        bloqueLapizNoDibuja.setOnAction(creadorDeBloqueHandler.agregar(bloqueLapizNoDibuja.obtenerID()));

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