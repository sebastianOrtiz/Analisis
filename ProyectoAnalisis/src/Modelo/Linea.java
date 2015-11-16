/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Point;

/**
 *
 * @author Sebas
 */
public class Linea {
    private Point ini;
    private Point fin;

    public Linea() {
    }

    public Linea(Point ini, Point fin) {
        this.ini = ini;
        this.fin = fin;
    }

    /**
     * @return the ini
     */
    public Point getIni() {
        return ini;
    }

    /**
     * @param ini the ini to set
     */
    public void setIni(Point ini) {
        this.ini = ini;
    }

    /**
     * @return the fin
     */
    public Point getFin() {
        return fin;
    }

    /**
     * @param fin the fin to set
     */
    public void setFin(Point fin) {
        this.fin = fin;
    }

}
