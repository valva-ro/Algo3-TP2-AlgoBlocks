package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.*;
import fiuba.algo3.modelo.direcciones.Este;
import fiuba.algo3.modelo.direcciones.Norte;
import fiuba.algo3.modelo.direcciones.Oeste;
import fiuba.algo3.modelo.direcciones.Sur;

import java.util.ArrayList;
import java.util.HashMap;

public class SectorBloques implements Observable {

    private HashMap<String, Bloque> bloquesDisponibles;
    private ArrayList<Observador> observadores;

    public SectorBloques(){
        this.bloquesDisponibles = new HashMap<>();
        this.observadores = new ArrayList<>();
        this.bloquesDisponibles.put("arriba", new BloqueMovimiento(new Norte(), new Dibuja()));
        this.bloquesDisponibles.put("abajo", new BloqueMovimiento(new Sur(), new Dibuja()));
        this.bloquesDisponibles.put("izquierda", new BloqueMovimiento(new Oeste(), new Dibuja()));
        this.bloquesDisponibles.put("derecha", new BloqueMovimiento(new Este(), new Dibuja()));
        this.bloquesDisponibles.put("repetidordoble", new BloqueRepetirDosVeces());
        this.bloquesDisponibles.put("repetidortriple", new BloqueRepetirTresVeces());
        this.bloquesDisponibles.put("inversor", new BloqueInvertir());
    }

    public Bloque seleccionarBloque(String nombreBloque){
        return bloquesDisponibles.get(nombreBloque);
    }

    public void guardarBloqueAlgoritmoPersonalizado(String nombreBloque, Bloque[] bloques){
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        for (int i = 0; i < bloques.length; i++) {
            bloquePersonalizado.agregar(bloques[i]);
        }
        this.bloquesDisponibles.put(nombreBloque, bloquePersonalizado);
    }

    @Override
    public void addObserver(Observador obs) {
        observadores.add(obs);
    }

    @Override
    public void removeObserver(Observador obs) {
        observadores.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (Observador obs : observadores) obs.update();
    }
}
