package com.cenavia.appfacturas.model;

public class Producto {
    private int codigo;
    private String nombre;
    private float precio;

    private static int ultimoCodigo = 0;

    public Producto(String nombre, float precio){
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = ++ultimoCodigo;
    }

    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public float getPrecio(){
        return precio;
    }

    public void setPrecio(float precio){
        this.precio = precio;
    }
}

