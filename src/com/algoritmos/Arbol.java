package com.algoritmos;

import javax.swing.*;

public abstract class Arbol {

    protected Nodo cabeza;
    protected int nivel;
    protected int nivelMayor;

    protected Nodo obtenerNodo(Nodo p, String dato) {
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

    protected void mostrarHermanoDeUnDato(Nodo p, String padre, String dato) {
        Nodo q = p;
        while (q != null) {
            if (q.getSw() == 1) {
                mostrarHermanoDeUnDato(q.getLigaLista(), padre, dato);
            } else {
                //Padre siempre es diferente de null excepto en la cabeza.
                //Podria validarse q.getPadre != null o q != cabeza
                if (q != cabeza && q.getPadre().getDato().equals(padre) && !q.getDato().equals(dato)) {
                    JOptionPane.showMessageDialog(null, q.getDato());
                }
            }
            q = q.getLiga();
        }
    }

    protected void mostrarNodosDeUnNivel(Nodo p, Nodo anterior, int nivelBuscar) {
        Nodo q = p;
        while (q != null) {
            if (anterior != null && anterior == p) {
                nivel++;
            }
            if (q.getSw() == 0) {
                if (nivel == nivelBuscar) {
                    JOptionPane.showMessageDialog(null, "Dato -->" + q.getDato());
                }
            } else {
                mostrarNodosDeUnNivel(q.getLigaLista(), q, nivelBuscar);
                nivel = nivel - 1;
            }
            anterior = q;
            q = q.getLiga();
        }
    }

    protected void mostrarDatos(Nodo p) {
        Nodo q = p;
        while (q != null) {
            if (q.getSw() == 1) {
                mostrarDatos(q.getLigaLista());
            } else {
                JOptionPane.showMessageDialog(null, q.getDato());
            }
            q = q.getLiga();
        }
    }

    protected void insertarHijo(Nodo p, Nodo anterior, String dato, String referencia) {
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

    protected void mostrarRaices(Nodo p) {
        Nodo q = p;
        if (q != null) {
            JOptionPane.showMessageDialog(null, q.getDato());
        }
        while (q != null) {
            if (q.getSw() == 1) {
                mostrarRaices(q.getLigaLista());
            }
            q = q.getLiga();
        }
    }

    protected void mostrarHojas(Nodo p) {
        Nodo q = p;
        if (q != null) {
            q = q.getLiga();
        }
        while (q != null) {
            if (q.getSw() == 0) {
                JOptionPane.showMessageDialog(null, q.getDato());
            } else {
                mostrarHojas(q.getLigaLista());
            }
            q = q.getLiga();
        }
    }

    protected void mostrarPadreDeUnDato(Nodo p, Nodo ant, Nodo padreAnt, String dato) {
        Nodo padre = p;
        if (cabeza.getDato().equals(dato)) {
            JOptionPane.showMessageDialog(null, "No tiene padre");
            return;
        }
        while (p != null) {
            if (p.getSw() == 1) {
                mostrarPadreDeUnDato(p.getLigaLista(), p, padre, dato);
            } else {
                if (p.getDato().equals(dato)) {
                    if (ant == null || ant.getLigaLista() == p) {
                        JOptionPane.showMessageDialog(null, "El padre de " + dato + " es: " + padreAnt.getDato());
                    } else {
                        JOptionPane.showMessageDialog(null, "El padre de " + dato + " es " + padre.getDato());
                    }
                }
            }
            ant = p;
            p = p.getLiga();
        }
    }

    protected void mostrarNivelDeUnDato(Nodo p, Nodo ant, String dato) {
        Nodo q = p;
        Nodo raiz = q;
        while (q != null) {
            if (ant != null && ant == raiz) {
                nivel++;
            }
            if (q.getSw() == 0) {
                if (q.getDato().equals(dato)) {
                    JOptionPane.showMessageDialog(null, "El nivel es: " + nivel);
                }
            } else {
                mostrarNivelDeUnDato(q.getLigaLista(), q, dato);
                nivel--;
            }
            ant = q;
            q = q.getLiga();
        }
    }

    protected void mostrarAlturaDelArbol(Nodo p, Nodo ant) {
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

    //TODO retornar boolean si encontró o no, para imprimir en caso de no haber encontrado hijos
    protected void mostrarHijosDeUnDato(Nodo p, String dato) {
        Nodo q = p;
        while (q != null) {
            if (q.getSw() == 1) {
                mostrarHijosDeUnDato(q.getLigaLista(), dato);
            } else {
                //Se valida q != cabeza porque la cabeza nunca va a tener padre
                if (q != cabeza && q.getPadre().getDato().equals(dato)) {
                    JOptionPane.showMessageDialog(null, q.getDato());
                }
            }
            q = q.getLiga();
        }
    }

    protected void mostrarGradoDelArbol(Nodo p) {
        int gradoDelArbol = contarGradoDelArbol(p);
        JOptionPane.showMessageDialog(null, "El grado del arbol es: " + gradoDelArbol);
    }

    protected int contarGradoDelArbol(Nodo p) {
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
        return Math.max(contLocal, contGlobal);
    }

    protected void mostrarGradoDeUnNodo(Nodo p, String dato) {
        int gradoNodo = contarGradoDeUnNodo(p, dato);
        JOptionPane.showMessageDialog(null, "El grado del nodo es: " + gradoNodo);
    }

    protected int contarGradoDeUnNodo(Nodo p, String dato) {
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

    protected int contarRaices(Nodo p) {
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

    protected int contarHojas(Nodo p) {
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
