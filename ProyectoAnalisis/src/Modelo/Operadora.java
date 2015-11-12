/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Point;
import java.util.LinkedList;
import javafx.scene.shape.Line;

/**
 *
 * @author Ambrosio
 */
public class Operadora {
    private LinkedList<Point> puntos;
    private LinkedList<Line> lineas;
    private int altoPanel;
    private int anchoPanel;

    public Operadora(int altoP, int anchoP) {
        this.altoPanel = altoP;
        this.anchoPanel = anchoP;
        this.puntos = new LinkedList<>();
        this.lineas = new LinkedList<>();
    }
    
    public Line[] lineasInciales(){
        Line[] lineas = new Line[2];
        lineas[0] = new Line(this.puntos.getFirst().getX(), 0, this.puntos.getFirst().getX(), this.altoPanel);
        lineas[1] = new Line(0, this.puntos.getFirst().getY(), this.anchoPanel, this.puntos.getFirst().getY());
        return lineas;
    }  
    
    public void adicionarPunto(Point p){
        getPuntos().add(p);
    }

    /**
     * @return the puntos
     */
    public LinkedList<Point> getPuntos() {
        return puntos;
    }

    /**
     * @return the lineas
     */
    public LinkedList<Line> getLineas() {
        return lineas;
    }
}
