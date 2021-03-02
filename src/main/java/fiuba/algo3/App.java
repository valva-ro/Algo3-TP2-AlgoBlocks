package fiuba.algo3;

import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import fiuba.algo3.modelo.fabricas.FabricaConcretaBloqueQueNoDibuja;
import fiuba.algo3.vista.ventanas.VistaInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final int ANCHO = 800;
    private static final int ALTO = 600;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage escenario) {

        Algoritmo algoritmo = new Algoritmo();
        FabricaAbstractaDeBloques fabricaDeBloques = new FabricaConcretaBloqueQueNoDibuja();

        VistaInicio vistaInicio = new VistaInicio(this, escenario, algoritmo, fabricaDeBloques);
        Scene escenaInicial = new Scene(vistaInicio, ANCHO, ALTO);

        escenaInicial.getStylesheets().clear();
        escenaInicial.getStylesheets().add("style.css");

        escenario.setScene(escenaInicial);
        escenario.setTitle("AlgoBlocks");
        escenario.getIcons().add(new Image("logo.png"));
        escenario.show();
    }
}