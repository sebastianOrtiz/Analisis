/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Point;
import java.util.LinkedList;
import sun.reflect.generics.tree.Tree;

/**
 *
 * @author Ambrosio
 */
public class Operadora {

    private LinkedList<Point> puntos;
    private Arbol<DatoNodo> arbol;
    private LinkedList<Cuadrado> cuadrados;

    public Operadora() {
        this.puntos = new LinkedList<>();
        this.arbol = new Arbol<>();
        this.cuadrados = new LinkedList<>();
    }

    public void definirPuntos(LinkedList<Point> puntos) {
        this.puntos = puntos;
    }

    private LinkedList<Point> sacarPorcion(LinkedList<Point> pts, int indIni, int indFin) {
        LinkedList<Point> subPts = new LinkedList<Point>();
        for (int i = indIni; i < indFin; i++) {
            subPts.add(pts.get(i));
        }
        return subPts;
    }

    private LinkedList<Point> organizarPuntos(LinkedList<Point> pts, boolean orientacion) {
        if (!this.puntos.isEmpty()) {
            if (orientacion) {
                for (int i = 0; i < pts.size(); i++) {
                    for (int j = i + 1; j < pts.size(); j++) {
                        if (pts.get(i).getX() > pts.get(j).getX()) {
                            Point aux = pts.get(i);
                            pts.set(i, pts.get(j));
                            pts.set(j, aux);
                        }
                    }
                }
            } else {
                for (int i = 0; i < pts.size(); i++) {
                    for (int j = i + 1; j < pts.size(); j++) {
                        if (pts.get(i).getY() > pts.get(j).getY()) {
                            Point aux = pts.get(i);
                            pts.set(i, pts.get(j));
                            pts.set(j, aux);
                        }
                    }
                }
            }
            return pts;
        }
        return null;
    }

    public void particionarConArbol(LinkedList<Point> puntos, int ancho, int alto) {
        this.cuadrados.removeAll(cuadrados);
        particionarRecArbol(arbol.getRaiz(), puntos, 0, 0, ancho, alto, false);
        
    }

    private void particionarRecArbol(Nodo<DatoNodo> raiz, LinkedList<Point> pts, int anchoInicial, int altoInicial, int anchoFinal, int altoFinal, boolean orientacion) {
        Linea l = null;
        if (pts.size() > 1) {
            LinkedList<Point> puntosOdenados = organizarPuntos(pts, orientacion);
            int mitad = puntosOdenados.size() / 2;
            if (orientacion) {
                l = new Linea(new Point((int) puntosOdenados.get(mitad).getX(), altoInicial), new Point((int) puntosOdenados.get(mitad).getX(), altoFinal));
                DatoNodo nuevoDatosNodo = new DatoNodo(puntosOdenados.get(mitad), l);
                raiz.setDato(nuevoDatosNodo);
                if (mitad >= 1) {
                    raiz.setHijoIzquierdo(new Nodo<>());
                    particionarRecArbol(raiz.getHijoIzquierdo(), sacarPorcion(pts, 0, mitad), anchoInicial, altoInicial, (int) puntosOdenados.get(mitad).getX(), altoFinal, !orientacion);
                } else {
                    Point puntoInicialCuadrado1 = new Point(anchoInicial, altoInicial);
                    int ancho1 = (int) (puntosOdenados.get(mitad).getX() - anchoInicial);
                    int alto1 = altoFinal - altoInicial;
                    this.getCuadrados().add(new Cuadrado(puntoInicialCuadrado1, ancho1, alto1, 50, 50, 50));
                }
                if (puntosOdenados.size() - (mitad + 1) >= 1) {
                    raiz.setHijoDerecho(new Nodo<>());
                    particionarRecArbol(raiz.getHijoDerecho(), sacarPorcion(pts, mitad + 1, puntosOdenados.size()), (int) puntosOdenados.get(mitad).getX(), altoInicial, anchoFinal, altoFinal, !orientacion);
                } else {
                    Point puntoInicialCuadrado2 = new Point((int) puntosOdenados.get(mitad).getX(), altoInicial);
                    int ancho2 = (int) (anchoFinal - puntosOdenados.get(mitad).getX());
                    int alto2 = altoFinal - altoInicial;
                    this.getCuadrados().add(new Cuadrado(puntoInicialCuadrado2, ancho2, alto2, 200, 100, 200));
                }
            } else {
                l = new Linea(new Point(anchoInicial, (int) puntosOdenados.get(mitad).getY()), new Point(anchoFinal, (int) puntosOdenados.get(mitad).getY()));
                DatoNodo nuevoDatosNodo = new DatoNodo(puntosOdenados.get(mitad), l);
                raiz.setDato(nuevoDatosNodo);
                if (mitad >= 1) {
                    raiz.setHijoIzquierdo(new Nodo<>());
                    particionarRecArbol(raiz.getHijoIzquierdo(), sacarPorcion(pts, 0, mitad), anchoInicial, altoInicial, anchoFinal, (int) puntosOdenados.get(mitad).getY(), !orientacion);
                } else {
                    Point puntoInicialCuadrado1 = new Point(anchoInicial, altoInicial);
                    int ancho1 = anchoFinal - anchoInicial;
                    int alto1 = (int) (puntosOdenados.get(mitad).getY() - altoInicial);
                    this.getCuadrados().add(new Cuadrado(puntoInicialCuadrado1, ancho1, alto1, 50, 50, 50));
                }
                if (puntosOdenados.size() - (mitad + 1) >= 1) {
                    raiz.setHijoDerecho(new Nodo<>());
                    particionarRecArbol(raiz.getHijoDerecho(), sacarPorcion(pts, mitad + 1, puntosOdenados.size()), anchoInicial, (int) puntosOdenados.get(mitad).getY(), anchoFinal, altoFinal, !orientacion);
                } else {
                    Point puntoInicialCuadrado2 = new Point(anchoInicial, (int) puntosOdenados.get(mitad).getY());
                    int ancho2 = anchoFinal - anchoInicial;
                    int alto2 = (int) (altoFinal - puntosOdenados.get(mitad).getY());
                    this.getCuadrados().add(new Cuadrado(puntoInicialCuadrado2, ancho2, alto2, 200, 100, 200));
                }
            }
        } else if (pts.size() == 1) {
            Point puntoInicialCuadrado1 = null;
            int ancho1 = 0;
            int alto1 = 0;
            Point puntoInicialCuadrado2 = null;
            int ancho2 = 0;
            int alto2 = 0;
            if (orientacion) {
                l = new Linea(new Point((int) pts.getFirst().getX(), altoInicial), new Point((int) pts.getFirst().getX(), altoFinal));
                DatoNodo nuevoDatosNodo = new DatoNodo(pts.getFirst(), l);
                raiz.setDato(nuevoDatosNodo);
                puntoInicialCuadrado1 = new Point(anchoInicial, altoInicial);
                ancho1 = (int) (pts.getFirst().getX() - anchoInicial);
                alto1 = altoFinal - altoInicial;
                puntoInicialCuadrado2 = new Point((int) pts.getFirst().getX(), altoInicial);
                ancho2 = (int) (anchoFinal - pts.getFirst().getX());
                alto2 = altoFinal - altoInicial;
            } else {
                l = new Linea(new Point(anchoInicial, (int) pts.getFirst().getY()), new Point(anchoFinal, (int) pts.getFirst().getY()));
                DatoNodo nuevoDatosNodo = new DatoNodo(pts.getFirst(), l);
                raiz.setDato(nuevoDatosNodo);
                puntoInicialCuadrado1 = new Point(anchoInicial, altoInicial);
                ancho1 = anchoFinal - anchoInicial;
                alto1 = (int) (pts.getFirst().getY() - altoInicial);
                puntoInicialCuadrado2 = new Point(anchoInicial, (int) pts.getFirst().getY());
                ancho2 = anchoFinal - anchoInicial;
                alto2 = (int) (altoFinal - pts.getFirst().getY());
            }

            this.getCuadrados().add(new Cuadrado(puntoInicialCuadrado1, ancho1, alto1, 128, 100, 53));
            this.getCuadrados().add(new Cuadrado(puntoInicialCuadrado2, ancho2, alto2, 53, 100, 128));
        }
    }

//    public void particionar(LinkedList<Point> puntos, int width, int height) {
//        particionarRec(puntos, 0, 0, width, height, true);
//    }
//
//    private void particionarRec(LinkedList<Point> pts, int iniWidth, int iniHeight, int finWidth, int finHeight, boolean orientacion) {
//        Linea l = null;
//        if (pts.size() > 1) {
//            LinkedList<Point> puntosOdenados = organizarPuntos(pts, orientacion);
//            int mitad = puntosOdenados.size() / 2;
//            if (orientacion) {
//                l = new Linea(new Point((int) puntosOdenados.get(mitad).getX(), iniHeight), new Point((int) puntosOdenados.get(mitad).getX(), finHeight));
//                particionarRec(sacarPorcion(pts, 0, mitad), iniWidth, iniHeight, (int) puntosOdenados.get(mitad).getX(), finHeight, !orientacion);
//                particionarRec(sacarPorcion(pts, mitad + 1, puntosOdenados.size()), (int) puntosOdenados.get(mitad).getX(), iniHeight, finWidth, finHeight, !orientacion);
//            } else {
//                l = new Linea(new Point(iniWidth, (int) puntosOdenados.get(mitad).getY()), new Point(finWidth, (int) puntosOdenados.get(mitad).getY()));
//                particionarRec(sacarPorcion(pts, 0, mitad), iniWidth, iniHeight, finWidth, (int) puntosOdenados.get(mitad).getY(), !orientacion);
//                particionarRec(sacarPorcion(pts, mitad + 1, puntosOdenados.size()), iniWidth, (int) puntosOdenados.get(mitad).getY(), finWidth, finHeight, !orientacion);
//            }
//            this.getLineas().add(l);
//
//        } else if (pts.size() == 1) {
//            if (orientacion) {
//                l = new Linea(new Point((int) pts.getFirst().getX(), iniHeight), new Point((int) pts.getFirst().getX(), finHeight));
//            } else {
//                l = new Linea(new Point(iniWidth, (int) pts.getFirst().getY()), new Point(finWidth, (int) pts.getFirst().getY()));
//            }
//            this.getLineas().add(l);
//        }
//
//    }
    public LinkedList<Linea> obtenerLineasDelArbol() {
        LinkedList<Linea> lineas = new LinkedList<Linea>();
        obtenerLineas(lineas, arbol.getRaiz());
        return lineas;
    }

    private void obtenerLineas(LinkedList<Linea> lineas, Nodo<DatoNodo> raiz) {
        lineas.add(raiz.getDato().getLinea());
        if (raiz.getHijoIzquierdo() != null) {// && raiz.getHijoIzquierdo().getDato() != null) {
            obtenerLineas(lineas, raiz.getHijoIzquierdo());
        }
        if (raiz.getHijoDerecho() != null) {// && raiz.getHijoDerecho().getDato() != null) {
            obtenerLineas(lineas, raiz.getHijoDerecho());
        }
    }

    /**
     * @return the cuadrados
     */
    public LinkedList<Cuadrado> getCuadrados() {
        return cuadrados;
    }
    /**
     * @return the lineas
     */
//    public LinkedList<Linea> getLineas() {
//        return lineas;
//    }
}
