/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;


import Implementaciones.implementaciones;
import java.util.NoSuchElementException;

/**
 *
 * @author USER
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Probando Lista Doblemente Enlazada Circular de Strings:");
        implementaciones<String> miListaDobleCircular = new implementaciones<>();

        System.out.println("Lista vacia? " + miListaDobleCircular.isEmpty()); 
        System.out.println("Tamano inicial: " + miListaDobleCircular.size());   

        miListaDobleCircular.addLast("Mundo");
        miListaDobleCircular.addFirst("Hola");
        miListaDobleCircular.addLast("!");
        miListaDobleCircular.addFirst("Inicio"); 

        System.out.println("Lista actual: " + miListaDobleCircular.toString()); 
        System.out.println("Lista vacia? " + miListaDobleCircular.isEmpty()); 
        System.out.println("Tamano: " + miListaDobleCircular.size());           
        if (!miListaDobleCircular.isEmpty()) {
           System.out.println("Inicial: " + miListaDobleCircular.inicial.getDato());
           System.out.println("ultimo (inicial.anterior): " + miListaDobleCircular.inicial.getAnterior().getDato());
           System.out.println("Siguiente de ultimo: " + miListaDobleCircular.inicial.getAnterior().getSiguiente().getDato()); 
           System.out.println("Anterior de Inicial: " + miListaDobleCircular.inicial.getAnterior().getDato()); 
        }

        System.out.println("Contiene 'Mundo'? " + miListaDobleCircular.contains("Mundo"));     
        System.out.println("Contiene 'Adios'? " + miListaDobleCircular.contains("Adios"));   

        System.out.println("Elemento en indice 0: " + miListaDobleCircular.getElement(0)); 
        System.out.println("Elemento en indice 3: " + miListaDobleCircular.getElement(3)); 
        System.out.println("Elemento en indice 1 (desde inicio): " + miListaDobleCircular.getElement(1)); 
        System.out.println("Elemento en indice 2 (desde fin): " + miListaDobleCircular.getElement(2));

        System.out.println("Eliminando primero: " + miListaDobleCircular.removeFirst()); 
        System.out.println("Lista ahora: " + miListaDobleCircular.toString());          
        System.out.println("Tamano: " + miListaDobleCircular.size());                   
        if (!miListaDobleCircular.isEmpty()) {
           System.out.println("Nuevo Inicial: " + miListaDobleCircular.inicial.getDato()); 
           System.out.println("ultimo: " + miListaDobleCircular.inicial.getAnterior().getDato()); 
        }


        System.out.println("Eliminando ultimo: " + miListaDobleCircular.removeLast()); 
        System.out.println("Lista ahora: " + miListaDobleCircular.toString());          
        System.out.println("Tamano: " + miListaDobleCircular.size());                   
        if (!miListaDobleCircular.isEmpty()) {
           System.out.println("Inicial: " + miListaDobleCircular.inicial.getDato()); 
           System.out.println("Nuevo ultimo: " + miListaDobleCircular.inicial.getAnterior().getDato()); 
        }

        miListaDobleCircular.addLast("Fin"); 
        System.out.println("Lista despues de addLast(Fin): " + miListaDobleCircular.toString());

        miListaDobleCircular.clear();
        System.out.println("Lista despues de clear: " + miListaDobleCircular.toString());
        System.out.println("Lista vacia? " + miListaDobleCircular.isEmpty());        
        System.out.println("Tamano final: " + miListaDobleCircular.size());             

        try {
           System.out.println("Intentando removeFirst en lista vacia (error esperado):");
           miListaDobleCircular.removeFirst();
        } catch (NoSuchElementException e) {
           System.out.println("Excepcion capturada: " + e.getMessage());
        }
    }
}
