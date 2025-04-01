package Implementaciones;

import Nodo.Nodo;
import java.util.NoSuchElementException;

public class implementaciones<E> {

    public Nodo<E> inicial;
    private int contador;

    public implementaciones() {
        this.inicial = null;
        this.contador = 0;
    }

    public boolean isEmpty() {
        return contador == 0;
    }

    public int size() {
        return contador;
    }

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

    public E getElement(int index) {
        if (index < 0 || index >= contador) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + index + ", Tamano: " + contador);
        }
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Indice " + index + " invalido para lista vacia.");
        }

        Nodo<E> nodoBuscado;
        if (index < contador / 2) {
            nodoBuscado = inicial;
            for (int i = 0; i < index; i++) {
                nodoBuscado = nodoBuscado.getSiguiente();
            }
        } else {
            nodoBuscado = inicial;
            for (int i = 0; i < contador - index; i++) {
                nodoBuscado = nodoBuscado.getAnterior();
            }
        }
        return nodoBuscado.getDato();
    }

    public void clear() {
        if (!isEmpty()) {
            Nodo<E> ultimo = inicial.getAnterior();
            inicial.setAnterior(null);
            ultimo.setSiguiente(null);
        }
        inicial = null;
        contador = 0;
    }

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
