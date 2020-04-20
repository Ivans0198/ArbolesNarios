package com.algoritmos;

import javax.swing.*;

public class ArbolFachada extends Arbol {

    public ArbolFachada() {
        super();
    }

    public void mostrarHermanoDeUnDato(String dato) {
        Nodo nodo = obtenerNodo(cabeza, dato);
        if (nodo == cabeza) {
            JOptionPane.showMessageDialog(null,"La cabeza no tiene hermanos");
        } else {
            mostrarHermanoDeUnDato(cabeza, nodo.getPadre().getDato(), dato);
        }
    }

    public void mostrarNodosDeUnNivel(int nivelBuscar) {
        mostrarNodosDeUnNivel(cabeza, null, nivelBuscar);
    }

    public void mostrarDatos() {
        mostrarDatos(cabeza);
    }

    public void insertarHijo(String dato, String referencia) {
        insertarHijo(cabeza, null, dato, referencia);
    }

    public void insertarRaizPrincipal(String dato) {
        insertarHijo(cabeza, null, dato, "");
    }

    public void mostrarRaices() {
        mostrarRaices(cabeza);
    }

    public void mostrarHojas() {
        mostrarHojas(cabeza);
    }

    public void mostrarPadreDeUnDato(String dato) {
        mostrarPadreDeUnDato(cabeza, null, cabeza, dato);
    }

    public void mostrarNivelDeUnDato(String dato) {
        mostrarNivelDeUnDato(cabeza, null, dato);
    }

    public void mostrarAlturaDelArbol() {
        nivel = 1;
        nivelMayor = 0;
        mostrarAlturaDelArbol(cabeza, null);
        JOptionPane.showMessageDialog(null, "La altura del árbol es: " + nivelMayor);
    }

    public void mostrarHijosDeUnDato(String dato) {
        mostrarHijosDeUnDato(cabeza, dato);
    }

    public void mostrarGradoDelArbol() {
        mostrarGradoDelArbol(cabeza);
    }

    public void mostrarGradoDeUnNodo(String dato) {
        mostrarGradoDeUnNodo(cabeza, dato);
    }

    public void mostrarTotalRaices() {
        int totalRaices = contarRaices(cabeza);
        System.out.println("Total raices: " + totalRaices);
    }

    public int contarRaices() {
        return contarRaices(cabeza);
    }

    public void mostrarTotalHojas() {
        int totalHojas = contarHojas(cabeza);
        System.out.println("Total hojas: " + totalHojas);
    }

    public int contarHojas() {
        return contarHojas(cabeza);
    }
}
