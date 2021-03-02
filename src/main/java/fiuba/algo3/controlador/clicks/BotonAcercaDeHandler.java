package fiuba.algo3.controlador.clicks;

import fiuba.algo3.App;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Interpretador;
import fiuba.algo3.vista.botones.BotonBloquePersonalizado;
import fiuba.algo3.vista.botones.BotonBloqueSimple;
import fiuba.algo3.vista.ventanas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonAcercaDeHandler extends BotonClickHandler {

    private final Stage escenario;
    private final Button botonAtras;
    private final VistaPrincipal vistaPrincipal;

    public BotonAcercaDeHandler(App aplicacion, Stage escenario, Algoritmo algoritmo, Interpretador interpretador) {
        super();
        this.escenario = escenario;
        this.vistaPrincipal = new VistaPrincipal(aplicacion, escenario, algoritmo, interpretador);

        this.botonAtras = new Button();
        this.botonAtras.getStyleClass().addAll("boton", "bloque");
        this.botonAtras.setId("botonAtras");
        this.botonAtras.setOnAction(new BotonAtrasHandler(aplicacion, this.escenario));
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        Scene nuevaEscena = new Scene(this.vistaPrincipal, 800, 600);
        nuevaEscena.getStylesheets().add("style.css");

        Label texto = new Label("Instrucciones");
        texto.setId("informacion");

        BotonBloqueSimple bloqueArriba = new BotonBloqueSimple("bloqueMovimientoArriba", "");
        BotonBloqueSimple bloqueAbajo = new BotonBloqueSimple("bloqueMovimientoAbajo", "");
        BotonBloqueSimple bloqueIzquierda = new BotonBloqueSimple("bloqueMovimientoIzquierda", "");
        BotonBloqueSimple bloqueDerecha = new BotonBloqueSimple("bloqueMovimientoDerecha", "");
        BotonBloqueSimple bloqueRepeticionDoble = new BotonBloqueSimple("bloqueRepeticionDoble","");
        BotonBloqueSimple bloqueRepeticionTriple = new BotonBloqueSimple("bloqueRepeticionTriple","");
        BotonBloqueSimple bloqueInvertir = new BotonBloqueSimple("bloqueInvertir", "");
        BotonBloqueSimple bloqueLapizDibuja = new BotonBloqueSimple("bloqueLapizDibuja", "");
        BotonBloqueSimple bloqueLapizNoDibuja = new BotonBloqueSimple("bloqueLapizNoDibuja", "");
        BotonBloquePersonalizado bloquePersonalizado = new BotonBloquePersonalizado("personalizado", "Personalizado",null);

        bloqueArriba.getStyleClass().add("bloqueMovimiento");
        bloqueArriba.setDisable(true);
        bloqueAbajo.getStyleClass().add("bloqueMovimiento");
        bloqueAbajo.setDisable(true);
        bloqueIzquierda.getStyleClass().add("bloqueMovimiento");
        bloqueIzquierda.setDisable(true);
        bloqueDerecha.getStyleClass().add("bloqueMovimiento");
        bloqueDerecha.setDisable(true);
        bloqueRepeticionDoble.getStyleClass().add("bloqueRepeticion");
        bloqueRepeticionDoble.setDisable(true);
        bloqueRepeticionTriple.getStyleClass().add("bloqueRepeticion");
        bloqueRepeticionTriple.setDisable(true);

        HBox contenedorMovimientos1 = new HBox();
        contenedorMovimientos1.getChildren().addAll(bloqueArriba,
                new Label("Movimiento arriba"),
                bloqueAbajo,
                new Label("Movimiento abajo "));
        contenedorMovimientos1.setAlignment(Pos.CENTER);
        contenedorMovimientos1.setSpacing(10);

        HBox contenedorMovimientos2 = new HBox();
        contenedorMovimientos2.getChildren().addAll(
                bloqueDerecha,
                new Label("Movimiento derecha "),
                bloqueIzquierda,
                new Label("Movimiento izquierda"));
        contenedorMovimientos2.setAlignment(Pos.CENTER);
        contenedorMovimientos2.setSpacing(10);

        HBox contenedorEspeciales1 = new HBox();
        contenedorEspeciales1.getChildren().addAll(bloqueRepeticionDoble,
                new Label("Repeticion doble "),
                bloqueRepeticionTriple,
                new Label("Repeticion triple"));
        contenedorEspeciales1.setAlignment(Pos.CENTER);
        contenedorEspeciales1.setSpacing(10);

        HBox contenedorEspeciales2 = new HBox();
        contenedorEspeciales2.getChildren().addAll(
                bloqueInvertir,
                new Label("Invertir      "),
                bloquePersonalizado,
                new Label("Personalizado"));
        contenedorEspeciales2.setAlignment(Pos.CENTER);
        contenedorEspeciales2.setSpacing(10);

        HBox contendorLapiz = new HBox();
        contendorLapiz.getChildren().addAll(bloqueLapizDibuja,
                new Label("Dibujar"),
                bloqueLapizNoDibuja,
                new Label("Levantar lapiz"));
        contendorLapiz.setAlignment(Pos.CENTER);
        contendorLapiz.setSpacing(10);


        VBox contenedor = new VBox();
        contenedor.getChildren().addAll(texto,
                contenedorMovimientos1,
                contenedorMovimientos2,
                contendorLapiz,
                contenedorEspeciales1,
                contenedorEspeciales2,
                this.botonAtras);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(10);
        nuevaEscena.setRoot(contenedor);

        this.escenario.setScene(nuevaEscena);
    }
}
