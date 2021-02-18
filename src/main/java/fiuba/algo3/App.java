package fiuba.algo3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final String TITULO_VENTANA = "AlgoBlocks";
    private static final String RUTA_ICONO = "file:././././resources/img/logo.png";
    private static final int ANCHO = 800;
    private static final int ALTO = 600;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage escenario) {

        BorderPane raiz = new BorderPane();

        Button botonJugar = new Button("¡Jugar!");
        botonJugar.setId("botonJugar");

        Button botonAcercaDe = new Button("Acerca de...");
        botonAcercaDe.setId("botonAcercaDe");

        Button botonSalir = new Button("Salir");
        botonSalir.setId("botonSalir");
        botonSalir.setOnAction(actionEvent -> Platform.exit());

        VBox botonera = new VBox(botonJugar, botonAcercaDe, botonSalir);
        botonera.setAlignment(Pos.CENTER);
        botonera.setSpacing(16);

        raiz.setCenter(botonera);

        Scene escenaInicial = new Scene(raiz, ANCHO, ALTO);
        escenario.setScene(escenaInicial);
        escenario.setTitle(TITULO_VENTANA);
        escenario.getIcons().add(new Image(RUTA_ICONO));
        escenario.show();
    }

}