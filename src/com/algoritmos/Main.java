package com.algoritmos;

public class Main {

    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        arbol.insertarHijo( "M", "M");
        arbol.insertarHijo( "A", "M");
        arbol.insertarHijo( "G", "A");
        arbol.insertarHijo( "D", "A");
        arbol.insertarHijo( "J", "D");
        arbol.insertarHijo( "K", "D");
        arbol.insertarHijo( "F", "M");
        arbol.insertarHijo( "I", "F");
        arbol.insertarHijo( "H", "F");
        arbol.insertarHijo( "T", "H");
        arbol.insertarHijo( "B", "H");
        arbol.insertarHijo( "E", "F");
        arbol.insertarHijo( "L", "F");
        arbol.insertarHijo( "W", "L");
        arbol.insertarHijo( "C", "M");
        arbol.insertarHijo( "N", "C");
        arbol.insertarHijo( "Z", "M");
        //arbol.mostrarDatos();
        //arbol.mostrarHermanoDeUnDato("M");
        //arbol.mostrarNodosDeUnNivel(2);
        //arbol.mostrarRaices();
        //arbol.mostrarHojas();
        //arbol.mostrarPadreDeUnDato("J");
        //arbol.mostrarNivelDeUnDato("M");
        //arbol.mostrarAlturaDelArbol();
        //arbol.mostrarHijosDeUnDato("G");
        //arbol.mostrarGradoDelArbol();
        //arbol.mostrarGradoDeUnNodo("M");
        //arbol.mostrarTotalRaices();
        //arbol.contarRaices();
        //arbol.mostrarTotalHojas();
        //arbol.contarHojas();
    }
}
