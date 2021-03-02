package fiuba.algo3.vista.sectores;

import fiuba.algo3.controlador.clicks.BotonGuardarAlgoritmoHandler;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.FabricaDeBloques;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.modelo.Observador;
import fiuba.algo3.vista.botones.Boton;
import fiuba.algo3.vista.botones.BotonBloqueEspecial;
import fiuba.algo3.vista.botones.BotonBloqueSimple;
import fiuba.algo3.vista.botones.BotonBloquePersonalizados;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class SectorBloquesDisponiblesVista extends BorderPane implements Observador {

    private final VBox contenedorVerticalBotones;
    private final Algoritmo algoritmo;
    private final Boton botonGuardarBloquePersonalizado;
    private final ArrayList<BotonBloquePersonalizados> botonesGuardados;
    private Interpretador interpretador;

    public SectorBloquesDisponiblesVista(Algoritmo algoritmo, Interpretador interpretador) {
        super();
        this.botonesGuardados = new ArrayList<>();

        this.algoritmo = algoritmo;
        this.algoritmo.agregarObservador(this);

        this.interpretador = interpretador;

        this.contenedorVerticalBotones = new VBox(10);

        this.botonGuardarBloquePersonalizado = new Boton("botonGuardarAlgoritmoEnPersonalizado", "");
        this.botonGuardarBloquePersonalizado.setDisable(true);
        this.botonGuardarBloquePersonalizado.setOnAction(new BotonGuardarAlgoritmoHandler(this, this.algoritmo));

        ScrollPane contenedorScrolleable = new ScrollPane(this.bloquesDisponibles());
        contenedorScrolleable.setFitToWidth(true);
        this.setCenter(contenedorScrolleable);
    }

    private VBox bloquesDisponibles() {

        Label etiqueta = new Label("Bloques disponibles");
        etiqueta.getStyleClass().add("subtitulo");
        this.getStylesheets().add("style.css");
        this.setTop(etiqueta);

        BotonBloqueSimple bloqueArriba = new BotonBloqueSimple("bloqueMovimientoArriba", "");
        BotonBloqueSimple bloqueAbajo = new BotonBloqueSimple("bloqueMovimientoAbajo", "");
        BotonBloqueSimple bloqueIzquierda = new BotonBloqueSimple("bloqueMovimientoIzquierda", "");
        BotonBloqueSimple bloqueDerecha = new BotonBloqueSimple("bloqueMovimientoDerecha", "");
        BotonBloqueEspecial bloqueRepeticionDoble = new BotonBloqueEspecial("bloqueRepeticionDoble", algoritmo, interpretador, this);
        BotonBloqueEspecial bloqueRepeticionTriple = new BotonBloqueEspecial("bloqueRepeticionTriple", algoritmo, interpretador, this);
        BotonBloqueEspecial bloqueInvertir = new BotonBloqueEspecial("bloqueInvertir", algoritmo, interpretador, this);
        BotonBloqueSimple bloqueLapizDibuja = new BotonBloqueSimple("bloqueLapizDibuja", "");
        BotonBloqueSimple bloqueLapizNoDibuja = new BotonBloqueSimple("bloqueLapizNoDibuja", "");

        bloqueArriba.getStyleClass().add("bloqueMovimiento");
        bloqueAbajo.getStyleClass().add("bloqueMovimiento");
        bloqueIzquierda.getStyleClass().add("bloqueMovimiento");
        bloqueDerecha.getStyleClass().add("bloqueMovimiento");
        bloqueRepeticionDoble.getStyleClass().add("bloqueRepeticion");
        bloqueRepeticionTriple.getStyleClass().add("bloqueRepeticion");

        this.contenedorVerticalBotones.getStylesheets().add("style.css");
        this.contenedorVerticalBotones.setPrefWidth(60);
        this.contenedorVerticalBotones.setAlignment(Pos.CENTER);
        this.contenedorVerticalBotones.getChildren().addAll(bloqueArriba,
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

    public void agregarBotonPersonalizado(BotonBloquePersonalizados botonPersonalizado) {
        this.botonesGuardados.add(botonPersonalizado);

        if (!this.botonesGuardados.isEmpty()) {
            this.contenedorVerticalBotones.getChildren().add(this.botonesGuardados.get(this.botonesGuardados.size() - 1));
        }
    }

    @Override
    public void actualizar() {
        this.botonGuardarBloquePersonalizado.setDisable(this.algoritmo.estaVacio());
    }

    public BotonBloquePersonalizados obtenerGuardadorPorId(String bloqueId) {
        BotonBloquePersonalizados botonEcontrado = null;

        for (BotonBloquePersonalizados boton : botonesGuardados) {
            if (boton.getId().equals(bloqueId)) {
                botonEcontrado = boton;
            }
        }
        return botonEcontrado;
    }
}
