package com.ufv.dis.turismo_backend.Model;

public class Destino {
    private String provincia;
    private String comunidad;

    public Destino(String provincia, String comunidad) {
        this.provincia = provincia;
        this.comunidad = comunidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    @Override
    public String toString() {
        return "Destino{" +
                "provincia='" + provincia + '\'' +
                ", comunidad='" + comunidad + '\'' +
                '}';
    }
}
