package com.algoritmos;

public class Nodo {

    private int sw;
    private Nodo ligaLista;
    private String dato;
    private Nodo liga;
    private Nodo padre;

    //Constructor para crear Nodo cuando el arbol esta vacíoD
    public Nodo(String dato) {
        this.sw = 0;
        this.dato = dato;
    }


    //Constructor para crear Nodo para hoja
    public Nodo(String dato, Nodo padre) {
        this.sw = 0;
        this.dato = dato;
        this.padre = padre;
    }

    //Constructor para crear Nodo para raiz
    public Nodo(Nodo ligaLista, Nodo liga) {
        this.sw = 1;
        this.ligaLista = ligaLista;
        this.liga = liga;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }

    public Nodo getLigaLista() {
        return ligaLista;
    }

    public void setLigaLista(Nodo ligaLista) {
        this.ligaLista = ligaLista;
    }

    public int getSw() {
        return sw;
    }

    public void setSw(int sw) {
        this.sw = sw;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
}
