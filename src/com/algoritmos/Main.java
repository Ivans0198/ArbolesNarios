package com.algoritmos;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        int opcionSeleccionada = -1;
        ArbolFachada arbol = new ArbolFachada();

        do {
            String lectura = JOptionPane.showInputDialog(null, "************************\nElige opción:" +
                    "\n1. Insertar raiz" +
                    "\n2. Insertar como hijo de" +
                    "\n3. Mostrar datos " +
                    "\n4. Mostrar hermano de un dato " +
                    "\n5. Mostrar nodos de un nivel " +
                    "\n6. Mostrar raíces " +
                    "\n7. Mostrar hojas " +
                    "\n8. Mostrar padre de un dato " +
                    "\n9. Mostrar nivel de un dato " +
                    "\n10. Mostrar altura del árbol " +
                    "\n11. Mostrar hijos de un dato " +
                    "\n12. Mostrar grado del árbol " +
                    "\n13. Mostrar grado de un nodo " +
                    "\n14. Contar raíces " +
                    "\n15. Contar hojas " +
                    "\n0. Salir\n************************");

            try {
                if (lectura == null) {
                    break;
                }
                opcionSeleccionada = Integer.parseInt(lectura);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una opción válida.");
                continue;
            }

            switch (opcionSeleccionada) {
                case 0:
                    break;
                case 1:
                    String raiz = JOptionPane.showInputDialog(null, "Digite el dato que desea como raiz: ");
                    arbol.insertarRaizPrincipal(raiz);
                    break;
                case 2:
                    String hijo = JOptionPane.showInputDialog(null, "Ingrese el dato hijo: ");
                    String padre = JOptionPane.showInputDialog(null, "Ingrese el dato padre: ");
                    arbol.insertarHijo(hijo, padre);
                    break;
                case 3:
                    arbol.mostrarDatos();
                    break;
                case 4:
                    String dato = JOptionPane.showInputDialog(null, "Ingrese el dato: ");
                    arbol.mostrarHermanoDeUnDato(dato);
                    break;
                case 5:
                    String nivel = JOptionPane.showInputDialog(null, "Ingrese el nivel: ");
                    Integer nivelBuscar = Integer.parseInt(nivel);
                    arbol.mostrarNodosDeUnNivel(nivelBuscar);
                    break;
                case 6:
                    arbol.mostrarRaices();
                    break;
                case 7:
                    arbol.mostrarHojas();
                    break;
                case 8:
                    String datoBuscar = JOptionPane.showInputDialog(null, "Ingrese el dato: ");
                    arbol.mostrarPadreDeUnDato(datoBuscar);
                    break;
                case 9:
                    String datoABuscar = JOptionPane.showInputDialog(null, "Ingrese el dato: ");
                    arbol.mostrarNivelDeUnDato(datoABuscar);
                    break;
                case 10:
                    arbol.mostrarAlturaDelArbol();
                    break;
                case 11:
                    String datoMostrarHijos = JOptionPane.showInputDialog(null, "Ingrese el dato: ");
                    arbol.mostrarHijosDeUnDato(datoMostrarHijos);
                    break;
                case 12:
                    arbol.mostrarGradoDelArbol();
                    break;
                case 13:
                    String datoMostrarGrado = JOptionPane.showInputDialog(null, "Ingrese el dato: ");
                    arbol.mostrarGradoDeUnNodo(datoMostrarGrado);
                    break;
                case 14:
                    JOptionPane.showMessageDialog(null, "Total raices: " + arbol.contarRaices());
                    break;
                case 16:
                    JOptionPane.showMessageDialog(null, "Total hojas: " + arbol.contarHojas());
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Debe ingresar una opción válida.");
            }
        }
        while (opcionSeleccionada != 0);


        // Datos de prueba
        /* ArbolFachada arbol = new ArbolFachada();
        arbol.insertarHijo("M", "M");
        arbol.insertarHijo("A", "M");
        arbol.insertarHijo("G", "A");
        arbol.insertarHijo("D", "A");
        arbol.insertarHijo("J", "D");
        arbol.insertarHijo("K", "D");
        arbol.insertarHijo("F", "M");
        arbol.insertarHijo("I", "F");
        arbol.insertarHijo("H", "F");
        arbol.insertarHijo("T", "H");
        arbol.insertarHijo("B", "H");
        arbol.insertarHijo("E", "F");
        arbol.insertarHijo("L", "F");
        arbol.insertarHijo("W", "L");
        arbol.insertarHijo("C", "M");
        arbol.insertarHijo("N", "C");
        arbol.insertarHijo("Z", "M");
        arbol.mostrarDatos();
        arbol.mostrarHermanoDeUnDato("M");
        arbol.mostrarNodosDeUnNivel(2);
        arbol.mostrarRaices();
        arbol.mostrarHojas();
        arbol.mostrarPadreDeUnDato("J");
        arbol.mostrarNivelDeUnDato("M");
        arbol.mostrarAlturaDelArbol();
        arbol.mostrarHijosDeUnDato("G");
        arbol.mostrarGradoDelArbol();
        arbol.mostrarGradoDeUnNodo("M");
        arbol.mostrarTotalRaices();
        arbol.contarRaices();
        arbol.mostrarTotalHojas();
        arbol.contarHojas(); */
    }
}
