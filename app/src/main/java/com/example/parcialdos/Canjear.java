package com.example.parcialdos;

public class Canjear {
    private String descripcion;
    private String titulo;
    private int icono;
    private int valor;

    public Canjear() {
    }

    public Canjear(String descripcion, String titulo, int icono, int valor) {
        this.descripcion = "Canje de $" + descripcion + " en combustible de tu elección.";
        this.titulo = "Bono de USD $ " + titulo;
        this.icono = icono;
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
