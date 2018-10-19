package com.softandino.android.sobreruedas.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.softandino.android.sobreruedas.db.entity.Rodada;

import java.util.List;

@Dao
public interface RodadaDao {

    @Query("SELECT * FROM MT_RODADA")
    List<Rodada> cargarRodada();

    @Query("SELECT * FROM MT_RODADA WHERE id = :idRodada")
    LiveData<Rodada> cargarRodadaPorId(long idRodada);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Rodada entity);
}