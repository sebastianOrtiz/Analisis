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
public class DatoNodo implements Comparable<Object> {

    private Point punto;
    private Linea linea;

    public DatoNodo() {
    }

    public DatoNodo(Point punto, Linea linea) {
        this.punto = punto;
        this.linea = linea;
    }

    /**
     * @return the punto
     */
    public Point getPunto() {
        return punto;
    }

    /**
     * @param punto the punto to set
     */
    public void setPunto(Point punto) {
        this.punto = punto;
    }

    /**
     * @return the linea
     */
    public Linea getLinea() {
        return linea;
    }

    /**
     * @param linea the linea to set
     */
    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    @Override
    public int compareTo(Object o) {
        DatoNodo entra = (DatoNodo) o;
        int igual = 1;
        if (entra.getPunto().getX() == this.punto.getX() && entra.getPunto().getY() == this.punto.getY() && entra.getLinea().getIni().getX() == this.linea.getIni().getX() && entra.getLinea().getIni().getY() == this.linea.getIni().getY() && entra.getLinea().getFin().getX() == this.linea.getFin().getX() && entra.getLinea().getFin().getY() == this.linea.getFin().getY()) {
            igual = 0;
        }
        return igual;
    }

}
