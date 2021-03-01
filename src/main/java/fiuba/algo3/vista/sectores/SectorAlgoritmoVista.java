package fiuba.algo3.vista.sectores;

import fiuba.algo3.App;
import fiuba.algo3.controlador.clicks.BotonAtrasHandler;
import fiuba.algo3.controlador.clicks.BotonEjecutarAlgoritmoHandler;
import fiuba.algo3.controlador.clicks.LimpiadorDeAlgoritmoHandler;
import fiuba.algo3.controlador.drags.SeccionAlgoritmoDragDroppedEventHandler;
import fiuba.algo3.controlador.drags.SeccionAlgoritmoDragOverHandler;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.SectorDibujo;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import fiuba.algo3.vista.botones.Boton;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SectorAlgoritmoVista extends VBox {

    private final Algoritmo algoritmo;
    private final SectorDibujo sectorDibujo;
    private FabricaAbstractaDeBloques fabricaDeBloques;
    private VBox bloquesDelAlgoritmo;
    private HBox botonera;

    public SectorAlgoritmoVista(Algoritmo algoritmo, SectorDibujo sectorDibujo, App aplicacion, Stage escenario, FabricaAbstractaDeBloques fabricaDeBloques) {
        super();
        this.algoritmo = algoritmo;
        this.sectorDibujo = sectorDibujo;
        this.fabricaDeBloques = fabricaDeBloques;
        this.bloquesDelAlgoritmo = new VBox();
        this.bloquesDelAlgoritmo.setAlignment(Pos.CENTER);

        this.getStylesheets().add("style.css");
        this.setAlignment(Pos.TOP_CENTER);

        this.botonera = this.botoneraAccionesDisponibles(aplicacion, escenario);
        this.configurarVentana();
    }

    private void configurarVentana() {
        Label etiqueta = new Label("Algoritmo");
        etiqueta.getStyleClass().add("subtitulo");

        this.bloquesDelAlgoritmo.setMinWidth(250);
        this.bloquesDelAlgoritmo.setMaxWidth(350);
        this.setMinWidth(400);
        this.setOnDragOver(new SeccionAlgoritmoDragOverHandler(this.bloquesDelAlgoritmo));
        this.setOnDragDropped(new SeccionAlgoritmoDragDroppedEventHandler(this.algoritmo, this.bloquesDelAlgoritmo, this.fabricaDeBloques));

        ScrollPane scrolleable = new ScrollPane(this.bloquesDelAlgoritmo);
        scrolleable.setFitToWidth(true);
        scrolleable.setFitToHeight(true);
        scrolleable.setMinHeight(500);
        scrolleable.setMaxHeight(500);
        scrolleable.setMaxWidth(350);
        this.getChildren().addAll(etiqueta, this.botonera, scrolleable);
    }

    private HBox botoneraAccionesDisponibles(App aplicacion, Stage escenario) {

        Boton botonLimpiarDibujo = new Boton("botonLimpiarDibujo", "");
        Boton botonEjectuar = new Boton("botonEjecutar", "");
        Boton botonAtras = new Boton("botonAtras", "");
        Boton botonSalir = new Boton("botonSalir", "Salir");

        botonLimpiarDibujo.setOnAction(new LimpiadorDeAlgoritmoHandler(this.algoritmo, this.bloquesDelAlgoritmo));
        botonEjectuar.setOnAction(new BotonEjecutarAlgoritmoHandler(this.sectorDibujo, this.algoritmo));
        botonAtras.setOnAction(new BotonAtrasHandler(aplicacion, escenario));
        botonSalir.setOnAction(actionEvent -> Platform.exit());

        HBox botonera = new HBox();
        botonera.setAlignment(Pos.CENTER);
        botonera.getChildren().addAll(botonEjectuar, botonLimpiarDibujo, botonAtras, botonSalir);

        return botonera;
    }
}
