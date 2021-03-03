package fiuba.algo3.vista.ventanas;

import fiuba.algo3.App;
import fiuba.algo3.controlador.clicks.BotonAcercaDeHandler;
import fiuba.algo3.controlador.clicks.BotonComoJugarHandler;
import fiuba.algo3.controlador.clicks.BotonJugarHandler;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.FabricaDeBloques;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.vista.botones.Boton;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaInicio extends VBox {

    private static final String RUTA_ICONO = "logo.png";
    private static final int ANCHO = 250;
    private static final int ALTO = 250;
    Stage escenario;

    public VistaInicio(App aplicacion, Stage escenario, Algoritmo algoritmo, Interpretador interpretador) {
        super();

        this.escenario = escenario;
        this.setAlignment(Pos.CENTER);

        Boton botonJugar = new Boton("botonJugar", "Jugar");
        Boton botonComoJugar = new Boton("botonComoJugar", "Como jugar");
        Boton botonAcercaDe = new Boton("botonAcercaDe", "Acerca de");
        Boton botonSalir = new Boton("botonSalir", "Salir");

        BotonJugarHandler botonJugarHandler = new BotonJugarHandler(aplicacion, escenario, algoritmo, interpretador);
        botonJugar.setOnAction(botonJugarHandler);

        BotonAcercaDeHandler botonAcercaDeHandler = new BotonAcercaDeHandler(aplicacion, escenario, algoritmo, interpretador);
        botonAcercaDe.setOnAction(botonAcercaDeHandler);

        BotonComoJugarHandler botonComoJugarHandler = new BotonComoJugarHandler(aplicacion, escenario, algoritmo, interpretador);
        botonComoJugar.setOnAction(botonComoJugarHandler);

        botonSalir.setOnAction(actionEvent -> Platform.exit());

        HBox botonera = new HBox(botonJugar, botonComoJugar, botonAcercaDe, botonSalir);
        botonera.setAlignment(Pos.CENTER);

        botonera.getStylesheets().clear();
        botonera.getStylesheets().add("style.css");

        Image imagen = new Image(RUTA_ICONO);
        ImageView vistaDeImagen = new ImageView(imagen);
        vistaDeImagen.setFitWidth(ANCHO);
        vistaDeImagen.setFitHeight(ALTO);

        this.setStyle("-fx-background-color: #abe389");
        Label etiqueta = new Label("Bienvenide a AlgoBlocks!");
        etiqueta.getStyleClass().add("titulo");

        this.getChildren().addAll(etiqueta, vistaDeImagen, botonera);
    }
}
