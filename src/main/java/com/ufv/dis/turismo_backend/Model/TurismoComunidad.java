package com.ufv.dis.turismo_backend.Model;

public class TurismoComunidad {
    private int id;
    private Origen origen;
    private Destino destino;
    private Periodo periodo;
    private int total;

    public TurismoComunidad(int id, Origen origen, Destino destino, Periodo periodo, int total) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.periodo = periodo;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Origen getOrigen() {
        return origen;
    }

    public void setOrigen(Origen origen) {
        this.origen = origen;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "TursimoComunidad{" +
                "id=" + id +
                ", origen=" + origen +
                ", destino=" + destino +
                ", periodo=" + periodo +
                ", total=" + total +
                '}';
    }
}