/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Sebas
 */
public class Cuadrado {
    private Point puntoInicial;
    private int ancho;
    private int alto;
    Color color;

    public Cuadrado(Point puntoInicial, int ancho, int alto, int r, int g, int b) {
        this.puntoInicial = puntoInicial;
        this.ancho = ancho;
        this.alto = alto;
        this.color = new Color(r,g,b);
    }
    
    public void dibujarCuadrado(Graphics g){
        g.setColor(color);
        g.fillRect((int)this.puntoInicial.getX(), (int)this.puntoInicial.getY(), ancho, alto);
    }
    /**
     * @return the puntoInicial
     */
    public Point getPuntoInicial() {
        return puntoInicial;
    }

    /**
     * @param puntoInicial the puntoInicial to set
     */
    public void setPuntoInicial(Point puntoInicial) {
        this.puntoInicial = puntoInicial;
    }

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }
}
