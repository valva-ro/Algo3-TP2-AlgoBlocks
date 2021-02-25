package fiuba.algo3.vista;

import fiuba.algo3.controlador.BotonJugarHandler;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaInicio extends VBox {
    private static final String RUTA_ICONO = "logo.png";
    private static final int ANCHO = 250;
    private static final int ALTO = 250;
    Stage escenario;

    public VistaInicio(Stage escenario) {
        super();

        this.escenario = escenario;
        this.setAlignment(Pos.CENTER);

        Button botonJugar = new Button("¡Jugar!");
        botonJugar.setId("botonJugar");
        botonJugar.setStyle("-fx-padding: 10px");
        BotonJugarHandler botonJugarHander = new BotonJugarHandler(escenario);
        botonJugar.setOnAction(botonJugarHander);

        Button botonAcercaDe = new Button("Acerca de");
        botonAcercaDe.setId("botonAcercaDe");
        botonAcercaDe.setStyle("-fx-padding: 10px");
        //BotonAcercaDeHandler botonAcercaDeHandler = new BotonAcercaDeHandler(escenario);
        //botonAcercaDe.setOnAction(botonAcercaDeHandler);

        Button botonSalir = new Button("Salir");
        botonSalir.setStyle("-fx-background-color: #FF6347; -fx-padding: 10px");
        botonSalir.setId("botonSalir");
        botonSalir.setOnAction(actionEvent -> Platform.exit());

        HBox botonera = new HBox(botonJugar, botonAcercaDe, botonSalir);
        botonera.setAlignment(Pos.CENTER);
        botonera.setSpacing(30);
        botonera.setStyle("-fx-padding: 20px");

        Image imagen = new Image(RUTA_ICONO);
        ImageView vistaDeImagen = new ImageView(imagen);
        vistaDeImagen.setFitWidth(ANCHO);
        vistaDeImagen.setFitHeight(ALTO);

        this.setStyle("-fx-background-color: #abe389");
        Label etiqueta = new Label("Bienvenidos a AlgoBlocks!");
        etiqueta.setFont(Font.font(30));
        etiqueta.setStyle("-fx-padding: 30px");

        this.getChildren().addAll(etiqueta, vistaDeImagen, botonera);

    }

}
