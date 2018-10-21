package com.softandino.android.sobreruedas.util;

import com.softandino.android.sobreruedas.db.entity.Rodada;
import com.softandino.android.sobreruedas.dto.RodadaDTO;

import java.util.ArrayList;
import java.util.List;

public class Cast {

    public static RodadaDTO castRodadaEntityToDTO(Rodada rodada) {
        return new RodadaDTO(rodada.getId(), rodada.getRodada(), rodada.getDescripcion(),
                rodada.getEncargado(), rodada.getCosto(), rodada.getDias(), rodada.getClub());
    }

    public static ArrayList<RodadaDTO> castListRodadaEntityToDTO(List<Rodada> rodadas) {
        ArrayList<RodadaDTO> rodadaDTOs = new ArrayList();
        for (Rodada entity : rodadas) {
            rodadaDTOs.add(castRodadaEntityToDTO(entity));
        }
        return null;
    }
}
