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
public class Arbol<E extends Comparable>{
    private Nodo<E> raiz;

    public Arbol() {
        raiz = new Nodo<>();
    }

    public Arbol(Nodo<E> raiz) {
        this.raiz = raiz;
    }
    /**
     * @return the raiz
     */
    public Nodo<E> getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(Nodo<E> raiz) {
        this.raiz = raiz;
    }
}
