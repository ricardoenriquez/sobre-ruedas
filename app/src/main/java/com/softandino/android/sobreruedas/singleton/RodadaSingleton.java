package com.softandino.android.sobreruedas.singleton;

import com.softandino.android.sobreruedas.dto.RodadaDTO;

import java.util.ArrayList;

public class RodadaSingleton {

    private ArrayList<RodadaDTO> rodadas;
    private static RodadaSingleton rodada;

    private RodadaSingleton(){
        rodadas = new ArrayList<>();
    }

    public static RodadaSingleton getInstance() {
        if (rodada == null) {
            return new RodadaSingleton();
        }
        return rodada;
    }

    public void limpiarLista(){
        RodadaSingleton.getInstance().getRodadas().clear();
    }

    public boolean agregarRodada(RodadaDTO rodadaDTO){
        return RodadaSingleton.getInstance().getRodadas().add(rodadaDTO);
    }

    public ArrayList<RodadaDTO> getRodadas() {
        return RodadaSingleton.getInstance().getRodadas();
    }
    public int size(){
        return getRodadas().size();
    }
}
