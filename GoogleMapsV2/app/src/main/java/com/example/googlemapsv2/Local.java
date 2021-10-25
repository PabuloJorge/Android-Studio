package com.example.googlemapsv2;

public class Local {
    private String titulo;
    private Double lat;
    private Double lon;

    public Local(String titulo, Double lat, Double lon) {
        this.titulo = titulo;
        this.lat = lat;
        this.lon = lon;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
