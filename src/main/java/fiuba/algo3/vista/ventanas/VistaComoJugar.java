package fiuba.algo3.vista.ventanas;

import fiuba.algo3.vista.botones.Boton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaComoJugar {

    public static void display(Stage escenario, VistaPrincipal vistaPrincipal, Button botonAtras) {

        Scene nuevaEscena = new Scene(vistaPrincipal, 800, 600);
        nuevaEscena.getStylesheets().add("style.css");

        Label titulo = new Label("Como Jugar");
        titulo.getStyleClass().add("titulo");

        VBox contenedorVertical = new VBox(titulo, acomodarBotones(), botonAtras);
        contenedorVertical.setStyle("-fx-background-color: #abe389");
        contenedorVertical.setAlignment(Pos.CENTER);

        nuevaEscena.setRoot(contenedorVertical);

        escenario.setScene(nuevaEscena);
    }

    private static GridPane acomodarBotones() {

        Boton bloqueArriba = new Boton("bloqueMovimientoArriba", "");
        Boton bloqueAbajo = new Boton("bloqueMovimientoAbajo", "");
        Boton bloqueIzquierda = new Boton("bloqueMovimientoIzquierda", "");
        Boton bloqueDerecha = new Boton("bloqueMovimientoDerecha", "");
        Boton bloqueRepeticionDoble = new Boton("bloqueRepeticionDoble", "");
        Boton bloqueRepeticionTriple = new Boton("bloqueRepeticionTriple", "");
        Boton bloqueInvertir = new Boton("bloqueInvertir", "");
        Boton bloqueLapizDibuja = new Boton("bloqueLapizDibuja", "");
        Boton bloqueLapizNoDibuja = new Boton("bloqueLapizNoDibuja", "");

        bloqueArriba.getStyleClass().add("bloqueMovimiento");
        bloqueAbajo.getStyleClass().add("bloqueMovimiento");
        bloqueIzquierda.getStyleClass().add("bloqueMovimiento");
        bloqueDerecha.getStyleClass().add("bloqueMovimiento");
        bloqueRepeticionDoble.getStyleClass().add("bloqueRepeticion");
        bloqueRepeticionTriple.getStyleClass().add("bloqueRepeticion");

        Label botonesMovimiento = new Label("Botones de movimiento");
        botonesMovimiento.getStyleClass().add("subtitulo");

        Label botonesLapiz = new Label("Activar/desactivar lapiz");
        botonesLapiz.getStyleClass().add("subtitulo");

        Label botonRepetirDoble = new Label("Repetir dos veces");
        botonRepetirDoble.getStyleClass().add("subtitulo");

        Label botonRepetirTriple = new Label("Repetir tres veces");
        botonRepetirTriple.getStyleClass().add("subtitulo");

        Label botonInvertir = new Label("Invertir");
        botonInvertir.getStyleClass().add("subtitulo");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.add(botonesMovimiento, 0, 0);
        grid.add(bloqueArriba, 1, 0);
        grid.add(bloqueAbajo, 2, 0);
        grid.add(bloqueDerecha, 3, 0);
        grid.add(bloqueIzquierda, 4, 0);

        grid.add(botonesLapiz, 0, 1);
        grid.add(bloqueLapizDibuja, 2, 1);
        grid.add(bloqueLapizNoDibuja, 3, 1);

        grid.add(botonRepetirDoble, 0, 2);
        grid.add(bloqueRepeticionDoble, 2, 2);

        grid.add(botonRepetirTriple, 0, 3);
        grid.add(bloqueRepeticionTriple, 2, 3);

        grid.add(botonInvertir, 0, 4);
        grid.add(bloqueInvertir, 2, 4);

        return grid;
    }
}
