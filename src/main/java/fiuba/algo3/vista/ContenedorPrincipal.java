package fiuba.algo3.vista;

import fiuba.algo3.App;
import fiuba.algo3.controlador.BotonAtrasHandler;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    Tablero vistaTablero;
    VBox contenedorCentral;

    public ContenedorPrincipal(App aplicacion, Stage escenario) {
        this.setBloquesDisponibles();
        this.setSectorDibujo(aplicacion, escenario);
    }

    private void setBloquesDisponibles() {

        BotonBloqueSimple bloqueArriba = new BotonBloqueSimple("bloqueMovimientoArriba", "");
        BotonBloqueSimple bloqueAbajo = new BotonBloqueSimple("bloqueMovimientoAbajo", "");
        BotonBloqueSimple bloqueIzquierda = new BotonBloqueSimple("bloqueMovimientoIzquierda", "");
        BotonBloqueSimple bloqueDerecha = new BotonBloqueSimple("bloqueMovimientoDerecha", "");
        BotonBloqueEspecial bloqueRepeticionDoble = new BotonBloqueEspecial("bloqueRepeticionDoble", "");
        BotonBloqueEspecial bloqueRepeticionTriple = new BotonBloqueEspecial("bloqueRepeticionTriple", "");
        BotonBloqueEspecial bloqueInvertir = new BotonBloqueEspecial("bloqueInvertir", "");
        BotonBloqueSimple bloqueLapizDibuja = new BotonBloqueSimple("bloqueLapizDibuja", "");
        BotonBloqueSimple bloqueLapizNoDibuja = new BotonBloqueSimple("bloqueLapizNoDibuja", "");

        bloqueRepeticionDoble.getStyleClass().add("bloqueRepeticion");
        bloqueRepeticionTriple.getStyleClass().add("bloqueRepeticion");

        VBox contenedorVerticalBotones = new VBox();

        Label etiqueta = new Label("Bloques disponibles");
        etiqueta.getStyleClass().add("subtitulo");

        contenedorVerticalBotones.setAlignment(Pos.TOP_CENTER);
        contenedorVerticalBotones.getStylesheets().add("style.css");

        contenedorVerticalBotones.getChildren().addAll(etiqueta,
                bloqueArriba,
                bloqueAbajo,
                bloqueDerecha,
                bloqueIzquierda,
                bloqueRepeticionDoble,
                bloqueRepeticionTriple,
                bloqueInvertir,
                bloqueLapizDibuja,
                bloqueLapizNoDibuja);

        ScrollPane scroll = new ScrollPane(contenedorVerticalBotones);
        scroll.setMinWidth(150);

        this.setLeft(scroll);
    }

    private void setSectorDibujo(App aplicacion, Stage escenario) {

        this.vistaTablero = new Tablero(500, 500);
        this.vistaTablero.dibujar();


        VistaAlgoritmo contenedorVerticalAlgoritmo = new VistaAlgoritmo();
        HBox contenedorTableroAlgoritmo = new HBox();
        contenedorTableroAlgoritmo.getChildren().addAll(contenedorVerticalAlgoritmo, this.vistaTablero, this.setBotoneraAbajo(aplicacion, escenario));
        contenedorTableroAlgoritmo.setAlignment(Pos.TOP_CENTER);

        this.setCenter(contenedorVerticalAlgoritmo);

        this.contenedorCentral = new VBox();
        this.contenedorCentral.getStylesheets().add("style.css");
        this.contenedorCentral.setAlignment(Pos.CENTER);

        Label etiqueta = new Label("Dibujo");
        etiqueta.getStyleClass().add("subtitulo");

        this.contenedorCentral.getChildren().addAll(etiqueta, this.vistaTablero, contenedorTableroAlgoritmo);

        this.setRight(this.contenedorCentral);
    }

    private HBox setBotoneraAbajo(App aplicacion, Stage escenario) {

        Boton botonGuardar = new Boton("botonGuardarAlgoritmoEnPersonalizado", "");
        Boton botonEjectuar = new Boton("botonEjecutar", "");
        Boton botonAtras = new Boton("botonAtras", "");
        Boton botonSalir = new Boton("botonSalir", "Salir");

        botonAtras.setOnAction(new BotonAtrasHandler(aplicacion, escenario));
        botonSalir.setOnAction(actionEvent -> Platform.exit());

        HBox botonera = new HBox();
        botonera.setAlignment(Pos.CENTER);
        botonera.getChildren().addAll(botonEjectuar, botonGuardar, botonAtras, botonSalir);

        return botonera;
    }
}
