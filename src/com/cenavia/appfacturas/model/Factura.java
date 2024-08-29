package com.cenavia.appfacturas.model;


import java.util.Date;

public class Factura {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceItems;
    public static final int MAX_ITEMS = 10;
    private static int ultimoFolio = 0;

    public Factura(String descripcion, Cliente cliente) {
        this.folio = ++ultimoFolio;
        this.descripcion = descripcion;
        this.fecha = new Date();
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.indiceItems = 0;
    }

    public void addItemFactura(ItemFactura item) {
        if (indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        } else {
            System.out.println("No se pueden agregar más ítems a la factura.");
        }
    }

    public float calcularTotal() {
        float total = 0;
        for (int i = 0; i < indiceItems; i++) {
            total += items[i].calcularImporte();
        }
        return total;
    }

    public int getFolio(){
        return folio;
    }

    public void setFolio(int folio){
        this.folio = folio;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public Date getFecha(){
        return fecha;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public ItemFactura[] getItems(){
        return items;
    }

    public void setItems(ItemFactura[] items){
        this.items = items;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder("Factura Nº: " + folio + "\nCliente: " + cliente.getNombre() +
                "\nNIF: " + cliente.getNif() + "\nDescripción: " + descripcion +
                "\nFecha: " + fecha + "\nItems:\n");

        for (int i = 0; i < indiceItems; i++) {
            sb.append("Producto: ").append(items[i].getProducto().getNombre())
                    .append("\tPrecio: ").append(items[i].getProducto().getPrecio())
                    .append("\tCantidad: ").append(items[i].getCantidad())
                    .append("\tImporte: ").append(items[i].calcularImporte())
                    .append("\n");
        }

        sb.append("Total: ").append(calcularTotal());
        return sb.toString();
    }

}

