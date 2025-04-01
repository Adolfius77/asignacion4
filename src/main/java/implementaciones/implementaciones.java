package Implementaciones;

import Nodo.Nodo; // Asegurate que la clase Nodo este accesible
import java.util.NoSuchElementException;

/**
 * Implementacion basica de una lista doblemente enlazada (aparentemente circular por la logica).
 * NOTA: El nombre de la clase 'implementaciones' no sigue las convenciones de Java (deberia empezar con mayuscula).
 *
 * @param <E> Tipo de elementos que almacena la lista.
 */
public class implementaciones<E> {

    /**
     * Referencia publica al primer nodo (cabeza) de la lista.
     * ADVERTENCIA: Modificar directamente este campo puede corromper la estructura de la lista.
     */
    public Nodo<E> inicial;

    private int contador; // Numero de elementos

    /**
     * Constructor: crea una lista vacia.
     */
    public implementaciones() {
        this.inicial = null;
        this.contador = 0;
    }

    /**
     * Verifica si la lista esta vacia.
     * @return true si no hay elementos, false en caso contrario.
     */
    public boolean isEmpty() {
        return contador == 0;
    }

    /**
     * Devuelve el numero de elementos en la lista.
     * @return Tamano de la lista.
     */
    public int size() {
        return contador;
    }

    /**
     * Anade un elemento al principio.
     * @param dato Elemento a anadir.
     */
    public void addFirst(E dato) {
        Nodo<E> nuevoNodo = new Nodo<>(dato);
        if (isEmpty()) {
            inicial = nuevoNodo;
            inicial.setSiguiente(inicial);
            inicial.setAnterior(inicial);
        } else {
            Nodo<E> ultimo = inicial.getAnterior();
            nuevoNodo.setSiguiente(inicial);
            inicial.setAnterior(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevoNodo);
            inicial = nuevoNodo;
        }
        contador++;
    }

    /**
     * Anade un elemento al final.
     * @param dato Elemento a anadir.
     */
    public void addLast(E dato) {
        Nodo<E> nuevoNodo = new Nodo<>(dato);
        if (isEmpty()) {
            inicial = nuevoNodo;
            inicial.setSiguiente(inicial);
            inicial.setAnterior(inicial);
        } else {
            Nodo<E> ultimo = inicial.getAnterior();
            nuevoNodo.setSiguiente(inicial);
            inicial.setAnterior(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevoNodo);
        }
        contador++;
    }

    /**
     * Elimina y devuelve el primer elemento.
     * @return El primer elemento.
     * @throws NoSuchElementException Si la lista esta vacia.
     */
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("La lista esta vacia.");
        }
        E datoEliminado = inicial.getDato();
        if (contador == 1) {
            inicial = null;
        } else {
            Nodo<E> ultimo = inicial.getAnterior();
            Nodo<E> nuevaCabeza = inicial.getSiguiente();
            ultimo.setSiguiente(nuevaCabeza);
            nuevaCabeza.setAnterior(ultimo);
            inicial = nuevaCabeza;
        }
        contador--;
        return datoEliminado;
    }

    /**
     * Elimina y devuelve el ultimo elemento.
     * @return El ultimo elemento.
     * @throws NoSuchElementException Si la lista esta vacia.
     */
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("La lista esta vacia.");
        }
        Nodo<E> ultimo = inicial.getAnterior();
        E datoEliminado = ultimo.getDato();

        if (contador == 1) {
            inicial = null;
        } else {
            Nodo<E> penultimo = ultimo.getAnterior();
            penultimo.setSiguiente(inicial);
            inicial.setAnterior(penultimo);
        }
        contador--;
        return datoEliminado;
    }

    /**
     * Busca si un elemento existe en la lista.
     * @param dato Elemento a buscar.
     * @return true si se encuentra, false si no.
     */
    public boolean contains(E dato) {
        if (isEmpty()) {
            return false;
        }
        Nodo<E> actual = inicial;
        for (int i = 0; i < contador; i++) {
            if (dato == null) {
                if (actual.getDato() == null) {
                    return true;
                }
            } else {
                if (dato.equals(actual.getDato())) {
                    return true;
                }
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    /**
     * Obtiene el elemento en un indice especifico.
     * @param index Indice del elemento (base 0).
     * @return El elemento en esa posicion.
     * @throws IndexOutOfBoundsException Si el indice es invalido.
     */
    public E getElement(int index) {
        if (index < 0 || index >= contador) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + index + ", Tamano: " + contador);
        }
        if (isEmpty()) { // Redundante por la primera verificacion, pero defensivo
            throw new IndexOutOfBoundsException("Indice " + index + " invalido para lista vacia.");
        }

        Nodo<E> nodoBuscado;
        if (index < contador / 2) { // Busca desde el inicio
            nodoBuscado = inicial;
            for (int i = 0; i < index; i++) {
                nodoBuscado = nodoBuscado.getSiguiente();
            }
        } else { // Busca desde el final (hacia atras desde inicio)
            nodoBuscado = inicial;
            for (int i = 0; i < contador - index; i++) {
                nodoBuscado = nodoBuscado.getAnterior();
            }
        }
        return nodoBuscado.getDato();
    }

    /**
     * Vacia la lista, eliminando todos los elementos.
     */
    public void clear() {
        // Opcionalmente romper el ciclo para ayudar al GC
        if (!isEmpty()) {
            Nodo<E> ultimo = inicial.getAnterior();
            inicial.setAnterior(null);
            ultimo.setSiguiente(null);
        }
        inicial = null; // Obligatorio para vaciar
        contador = 0;
    }

    /**
     * Devuelve una representacion String de la lista.
     * @return Cadena con formato [elem1, elem2, ...].
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Nodo<E> actual = inicial;
        for (int i = 0; i < contador; i++) {
            sb.append(actual.getDato() == null ? "null" : actual.getDato().toString());
            if (i < contador - 1) {
                sb.append(", ");
            }
            actual = actual.getSiguiente();
        }
        sb.append("]");
        return sb.toString();
    }

}