package fiuba.algo3;

import fiuba.algo3.vista.VistaInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final String TITULO_VENTANA = "AlgoBlocks";
    private static final String RUTA_ICONO = "logo.png";
    private static final int ANCHO = 800;
    private static final int ALTO = 600;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage escenario) {

        VistaInicio vistaInicio = new VistaInicio(escenario);
        Scene escenaInicial = new Scene(vistaInicio, ANCHO, ALTO);

        escenario.setScene(escenaInicial);
        escenario.setTitle(TITULO_VENTANA);
        escenario.getIcons().add(new Image(RUTA_ICONO));
        escenario.show();
    }

}