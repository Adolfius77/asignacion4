package Nodo; // O el paquete donde tengas tu clase Nodo

/**
 * Representa un nodo para una lista doblemente enlazada (circular o no).
 * Contiene el dato y referencias al nodo anterior y siguiente.
 *
 * @param <E> El tipo del dato almacenado en el nodo.
 */
public class Nodo<E> {

    private E dato;             // El dato almacenado.
    private Nodo<E> anterior;   // Referencia al nodo previo.
    private Nodo<E> siguiente;  // Referencia al nodo siguiente.

    /**
     * Constructor para crear un nodo con un dato específico.
     * Los enlaces anterior y siguiente se inicializan a null.
     *
     * @param dato El dato a almacenar en el nodo.
     * @pre El dato proporcionado es del tipo E.
     * @post Se crea una instancia de Nodo con el dato y enlaces en null.
     */
    public Nodo(E dato) {
        this.dato = dato;
        this.anterior = null; // Se establecerá la circularidad en la clase LDEC
        this.siguiente = null; // Se establecerá la circularidad en la clase LDEC
    }

    /**
     * Obtiene el dato almacenado en el nodo.
     * @return El dato del nodo.
     * @pre El nodo ha sido inicializado.
     * @post Devuelve el valor del atributo 'dato'.
     */
    public E getDato() {
        return dato;
    }

    /**
     * Establece o actualiza el dato del nodo.
     * @param dato El nuevo dato para el nodo.
     * @pre El nodo ha sido inicializado.
     * @post El atributo 'dato' se actualiza.
     */
    public void setDato(E dato) {
        this.dato = dato;
    }

    /**
     * Obtiene la referencia al nodo anterior.
     * @return El nodo anterior. En una LDEC nunca será null si la lista no está vacía.
     * @pre El nodo ha sido inicializado y pertenece a una lista.
     * @post Devuelve la referencia al nodo anterior.
     */
    public Nodo<E> getAnterior() {
        return anterior;
    }

    /**
     * Establece la referencia al nodo anterior.
     * @param anterior El nodo que será el anterior.
     * @pre El nodo ha sido inicializado.
     * @post El puntero 'anterior' se actualiza.
     */
    public void setAnterior(Nodo<E> anterior) {
        this.anterior = anterior;
    }

    /**
     * Obtiene la referencia al nodo siguiente.
     * @return El nodo siguiente. En una LDEC nunca será null si la lista no está vacía.
     * @pre El nodo ha sido inicializado y pertenece a una lista.
     * @post Devuelve la referencia al nodo siguiente.
     */
    public Nodo<E> getSiguiente() {
        return siguiente;
    }

    /**
     * Establece la referencia al nodo siguiente.
     * @param siguiente El nodo que será el siguiente.
     * @pre El nodo ha sido inicializado.
     * @post El puntero 'siguiente' se actualiza.
     */
    public void setSiguiente(Nodo<E> siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Devuelve la representación en String del dato del nodo.
     * @return String que representa el dato, o "null" si el dato es null.
     * @pre El nodo ha sido inicializado.
     * @post Devuelve la representación textual del dato.
     */
    @Override
    public String toString() {
        return dato != null ? dato.toString() : "null";
    }
}