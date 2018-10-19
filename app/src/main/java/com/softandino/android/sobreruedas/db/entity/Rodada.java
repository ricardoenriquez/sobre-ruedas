package com.softandino.android.sobreruedas.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "MT_RODADA")
public class Rodada {

    @PrimaryKey
    private Integer id;
    private String rodada;
    private String descripcion;
    private String encargado;
    private String costo;
    private String dias;
    private String club;

    public Rodada(Integer id, String rodada, String descripcion, String encargado, String costo, String dias, String club) {
        this.id = id;
        this.rodada = rodada;
        this.descripcion = descripcion;
        this.encargado = encargado;
        this.costo = costo;
        this.dias = dias;
        this.club = club;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRodada() {
        return rodada;
    }

    public void setRodada(String rodada) {
        this.rodada = rodada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
