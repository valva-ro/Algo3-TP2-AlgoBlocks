package fiuba.algo3.vista;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaInicio extends VBox {
    private static final String RUTA_ICONO = "file:././././resources/img/logo.png";
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
        botonJugar.setOnAction(actionEvent -> {
            VistaTablero vistaTablero = new VistaTablero(escenario);
            Scene nuevaScena = new Scene(vistaTablero, 800, 600);
            escenario.setScene(nuevaScena);
            escenario.setMaxHeight(600);
            escenario.setMaxWidth(800);

        });

        Button botonAcercaDe = new Button("Nosotros");
        botonAcercaDe.setId("botonAcercaDe");
        botonAcercaDe.setStyle("-fx-padding: 10px");

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

        this.setStyle("-fx-background-color: #FFFFFF");
        Label etiqueta = new Label("Bienvenidos a AlgoBlocks!");
        etiqueta.setFont(Font.font(30));
        etiqueta.setStyle("-fx-padding: 30px");

        this.getChildren().addAll(etiqueta, vistaDeImagen, botonera);

    }

}
