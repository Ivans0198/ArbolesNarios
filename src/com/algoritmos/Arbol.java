package com.algoritmos;

public class Arbol {

    private Nodo cabeza;
    private int nivel;
    private int nivelMayor;


    public Nodo obtenerNodo(Nodo p, String dato) {
        Nodo q = p;
        Nodo aux;
        while (q != null) {
            if (q.getSw() == 0) {
                if (q.getDato().equals(dato)) {
                    return q;
                }
            } else {
                aux = obtenerNodo(q.getLigaLista(), dato);
                if (aux != null) {
                    return aux;
                }
            }
            q = q.getLiga();
        }
        return q;
    }

    public void mostrarHermanoDeUnDato(String dato) {
        Nodo nodo = obtenerNodo(cabeza, dato);
        if (nodo == cabeza) {
            System.out.println("La cabeza no tiene hermanos");
        } else {
            mostrarHermanoDeUnDato(cabeza, nodo.getPadre().getDato(), dato);
        }
    }

    private void mostrarHermanoDeUnDato(Nodo p, String padre, String dato) {
        Nodo q = p;
        while (q != null) {
            if (q.getSw() == 1) {
                mostrarHermanoDeUnDato(q.getLigaLista(), padre, dato);
            } else {
                //Padre siempre es diferente de null excepto en la cabeza.
                //Podria validarse q.getPadre != null o q != cabeza
                if (q != cabeza && q.getPadre().getDato().equals(padre) && !q.getDato().equals(dato)) {
                    System.out.println(q.getDato());
                }
            }
            q = q.getLiga();
        }
    }

    public void mostrarNodosDeUnNivel(int nivelBuscar) {
        mostrarNodosDeUnNivel(cabeza, null, nivelBuscar);
    }

    private void mostrarNodosDeUnNivel(Nodo p, Nodo ant, int nivelBuscar) {
        Nodo q = p;
        Nodo raiz = p;
        while (q != null) {
            if (ant != null && ant == raiz) {
                nivel++;
            }
            if (q.getSw() == 0) {
                if (nivel == nivelBuscar) {
                    System.out.println("Dato -->" + q.getDato());
                }
            } else {
                mostrarNodosDeUnNivel(q.getLigaLista(), q, nivelBuscar);
                nivel = nivel - 1;
            }
            ant = q;
            q = q.getLiga();
        }
    }

    public void mostrarDatos() {
        mostrarDatos(cabeza);
    }

    private void mostrarDatos(Nodo p) {
        Nodo q = p;
        while (q != null) {
            if (q.getSw() == 1) {
                mostrarDatos(q.getLigaLista());
            } else {
                System.out.println(q.getDato());
            }
            q = q.getLiga();
        }
    }

    public void insertarHijo(String dato, String referencia) {
        insertarHijo(cabeza, null, dato, referencia);
    }

    private void insertarHijo(Nodo p, Nodo anterior, String dato, String referencia) {
        if (p == null) {
            cabeza = new Nodo(dato);
            return;
        }
        while (p != null) {
            if (p.getSw() == 1) {
                insertarHijo(p.getLigaLista(), p, dato, referencia);
            } else {
                if (p.getDato().equals(referencia)) {

                    if (anterior == null || p == anterior.getLigaLista()) {
                        // ES UNA RAIZ
                        anterior = p;
                        while (anterior.getLiga() != null) {
                            anterior = anterior.getLiga();
                        }
                        Nodo nuevoNodo = new Nodo(dato, p);
                        anterior.setLiga(nuevoNodo);
                    } else {
                        // ES UNA HOJA
                        Nodo nuevaRaiz = new Nodo(p, p.getLiga());
                        Nodo nuevoNodo = new Nodo(dato, p);
                        anterior.setLiga(nuevaRaiz);
                        p.setLiga(nuevoNodo);
                    }
                }
            }
            anterior = p;
            p = p.getLiga();
        }
    }

    public void mostrarRaices() {
        mostrarRaices(cabeza);
    }

    private void mostrarRaices(Nodo p) {
        Nodo q = p;
        if (q != null) {
            System.out.println(q.getDato());
        }
        while (q != null) {
            if (q.getSw() == 1) {
                mostrarRaices(q.getLigaLista());
            }
            q = q.getLiga();
        }
    }

    public void mostrarHojas() {
        mostrarHojas(cabeza);
    }

    private void mostrarHojas(Nodo p) {
        Nodo q = p;
        if (q != null) {
            q = q.getLiga();
        }
        while (q != null) {
            if (q.getSw() == 0) {
                System.out.println(q.getDato());
            } else {
                mostrarHojas(q.getLigaLista());
            }
            q = q.getLiga();
        }
    }

    public void mostrarPadreDeUnDato(String dato) {
        mostrarPadreDeUnDato(cabeza, null, cabeza, dato);
    }

    private void mostrarPadreDeUnDato(Nodo p, Nodo ant, Nodo padreAnt, String dato) {
        Nodo padre = p;
        if (cabeza.getDato().equals(dato)) {
            System.out.println("No tiene padre");
            return;
        }
        while (p != null) {
            if (p.getSw() == 1) {
                mostrarPadreDeUnDato(p.getLigaLista(), p, padre, dato);
            } else {
                if (p.getDato().equals(dato)) {
                    if (ant == null || ant.getLigaLista() == p) {
                        System.out.println("El padre de " + dato + " es: " + padreAnt.getDato());
                    } else {
                        System.out.println("El padre de " + dato + " es " + padre.getDato());
                    }
                }
            }
            ant = p;
            p = p.getLiga();
        }
    }

    public void mostrarNivelDeUnDato(String dato) {
        mostrarNivelDeUnDato(cabeza, null, dato);
    }

    private void mostrarNivelDeUnDato(Nodo p, Nodo ant, String dato) {
        Nodo q = p;
        Nodo raiz = q;
        while (q != null) {
            if (ant != null && ant == raiz) {
                nivel++;
            }
            if (q.getSw() == 0) {
                if (q.getDato().equals(dato)) {
                    System.out.println("El nivel es: " + nivel);
                }
            } else {
                mostrarNivelDeUnDato(q.getLigaLista(), q, dato);
                nivel--;
            }
            ant = q;
            q = q.getLiga();
        }
    }

    public void mostrarAlturaDelArbol() {
        nivel = 1;
        nivelMayor = 0;
        mostrarAlturaDelArbol(cabeza, null);
        System.out.println("La altura del árbol es: " + nivelMayor);
    }

    private void mostrarAlturaDelArbol(Nodo p, Nodo ant) {
        Nodo q = p;
        Nodo raiz = q;
        while (q != null) {
            if (ant != null && ant == raiz) {
                nivel++;
                if (nivel > nivelMayor) {
                    nivelMayor = nivel;
                }
            }
            if (q.getSw() == 1) {
                mostrarAlturaDelArbol(q.getLigaLista(), q);
                nivel--;
            }
            ant = q;
            q = q.getLiga();
        }
    }

    public void mostrarHijosDeUnDato(String dato) {
        mostrarHijosDeUnDato(cabeza, dato);
    }

    //TODO retornar boolean si encontró o no, para imprimir en caso de no haber encontrado hijos
    private void mostrarHijosDeUnDato(Nodo p, String dato) {
        Nodo q = p;
        while (q != null) {
            if (q.getSw() == 1) {
                mostrarHijosDeUnDato(q.getLigaLista(), dato);
            } else {
                //Se valida q != cabeza porque la cabeza nunca va a tener padre
                if (q != cabeza && q.getPadre().getDato().equals(dato)) {
                    System.out.println(q.getDato());
                }
            }
            q = q.getLiga();
        }
    }

    public void mostrarGradoDelArbol() {
        mostrarGradoDelArbol(cabeza);
    }

    private void mostrarGradoDelArbol(Nodo p) {
        int gradoDelArbol = contarGradoDelArbol(p);
        System.out.println("El grado del arbol es: " + gradoDelArbol);
    }

    public int contarGradoDelArbol(Nodo p) {
        int contLocal = 0;
        int contGlobal = 0;
        Nodo q = p;
        if (q != null) {
            q = q.getLiga();
        }
        while (q != null) {
            contLocal++;
            if (q.getSw() == 1) {
                int cont = contarGradoDelArbol(q.getLigaLista());
                if (cont >= contGlobal) {
                    contGlobal = cont;
                }
            }
            q = q.getLiga();
        }
        if (contLocal >= contGlobal) {
            return contLocal;
        } else {
            return contGlobal;
        }
    }

    public void mostrarGradoDeUnNodo(String dato) {
        mostrarGradoDeUnNodo(cabeza, dato);
    }

    private void mostrarGradoDeUnNodo(Nodo p, String dato) {
        int gradoNodo = contarGradoDeUnNodo(p, dato);
        System.out.println("El grado del nodo es: " + gradoNodo);
    }

    private int contarGradoDeUnNodo(Nodo p, String dato) {
        Nodo q = p;
        int cont = 0;
        while (q != null) {
            if (q.getSw() == 1) {
                cont += contarGradoDeUnNodo(q.getLigaLista(), dato);
            } else {
                if (q != cabeza && q.getPadre().getDato().equals(dato)) {
                    cont++;
                }
            }
            q = q.getLiga();
        }
        return cont;
    }

    public void mostrarTotalRaices() {
        int totalRaices = contarRaices(cabeza);
        System.out.println("Total raices: " + totalRaices);
    }

    public int contarRaices() {
        return contarRaices(cabeza);
    }

    public int contarRaices(Nodo p) {
        Nodo q = p;
        int cantidadRaices = 0;
        if (q != null) {
            cantidadRaices++;
        }
        while (q != null) {
            if (q.getSw() == 1) {
                cantidadRaices += contarRaices(q.getLigaLista());
            }
            q = q.getLiga();
        }
        return cantidadRaices;
    }

    public void mostrarTotalHojas() {
        int totalHojas = contarHojas(cabeza);
        System.out.println("Total hojas: " + totalHojas);
    }

    public int contarHojas() {
        return contarHojas(cabeza);
    }

    public int contarHojas(Nodo p) {
        int cantidadHojas = 0;
        Nodo q = p;
        if (p != null) {
            q = q.getLiga();
        }
        while (q != null) {
            if (q.getSw() == 0) {
                cantidadHojas++;
            } else {
                cantidadHojas += contarHojas(q.getLigaLista());
            }
            q = q.getLiga();
        }
        return cantidadHojas;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }
}
