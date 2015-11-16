/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Sebas
 */
public class Nodo<E extends Comparable> {
    private E dato;
    private Nodo<E> hijoIzquierdo;
    private Nodo<E> hijoDerecho;

    public Nodo(E dato, Nodo<E> hijoIzquierdo, Nodo<E> hijoDerecho) {
        this.dato = dato;
    }

    public Nodo() {
        
    }
    
    
    /**
     * @return the dato
     */
    public E getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(E dato) {
        this.dato = dato;
    }

    /**
     * @return the hijoIzquierdo
     */
    public Nodo<E> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    /**
     * @param hijoIzquierdo the hijoIzquierdo to set
     */
    public void setHijoIzquierdo(Nodo<E> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    /**
     * @return the hijoDerecho
     */
    public Nodo<E> getHijoDerecho() {
        return hijoDerecho;
    }

    /**
     * @param hijoDerecho the hijoDerecho to set
     */
    public void setHijoDerecho(Nodo<E> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
   
    
    
}
