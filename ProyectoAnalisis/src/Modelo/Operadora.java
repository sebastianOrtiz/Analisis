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

    Arbol<DatoNodo> arbol;

    public Operadora() {
        this.puntos = new LinkedList<>();

        this.arbol = new Arbol<>();
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

    public void particionarConArbol(LinkedList<Point> puntos, int width, int height) {
        particionarRecArbol(arbol.getRaiz(), puntos, 0, 0, width, height, true);
    }

    private void particionarRecArbol(Nodo<DatoNodo> raiz, LinkedList<Point> pts, int iniWidth, int iniHeight, int finWidth, int finHeight, boolean orientacion) {
        Linea l = null;
        if (pts.size() > 1) {
            LinkedList<Point> puntosOdenados = organizarPuntos(pts, orientacion);
            int mitad = puntosOdenados.size() / 2;
            if (orientacion) {
                l = new Linea(new Point((int) puntosOdenados.get(mitad).getX(), iniHeight), new Point((int) puntosOdenados.get(mitad).getX(), finHeight));
                DatoNodo nuevoDatosNodo = new DatoNodo(puntosOdenados.get(mitad), l);
                raiz.setDato(nuevoDatosNodo);
                if (mitad >= 1) {
                    raiz.setHijoIzquierdo(new Nodo<>());
                    particionarRecArbol(raiz.getHijoIzquierdo(), sacarPorcion(pts, 0, mitad), iniWidth, iniHeight, (int) puntosOdenados.get(mitad).getX(), finHeight, !orientacion);
                }
                if (puntosOdenados.size() - mitad + 1 >= 1) {
                    raiz.setHijoDerecho(new Nodo<>());
                    particionarRecArbol(raiz.getHijoDerecho(), sacarPorcion(pts, mitad + 1, puntosOdenados.size()), (int) puntosOdenados.get(mitad).getX(), iniHeight, finWidth, finHeight, !orientacion);
                }
            } else {
                l = new Linea(new Point(iniWidth, (int) puntosOdenados.get(mitad).getY()), new Point(finWidth, (int) puntosOdenados.get(mitad).getY()));
                DatoNodo nuevoDatosNodo = new DatoNodo(puntosOdenados.get(mitad), l);
                raiz.setDato(nuevoDatosNodo);
                if (mitad >= 1) {
                    raiz.setHijoIzquierdo(new Nodo<>());
                    particionarRecArbol(raiz.getHijoIzquierdo(), sacarPorcion(pts, 0, mitad), iniWidth, iniHeight, finWidth, (int) puntosOdenados.get(mitad).getY(), !orientacion);
                }
                if (puntosOdenados.size() - mitad + 1 >= 1) {
                    raiz.setHijoDerecho(new Nodo<>());
                    particionarRecArbol(raiz.getHijoDerecho(), sacarPorcion(pts, mitad + 1, puntosOdenados.size()), iniWidth, (int) puntosOdenados.get(mitad).getY(), finWidth, finHeight, !orientacion);
                }
            }
        } else if (pts.size() == 1) {
            if (orientacion) {
                l = new Linea(new Point((int) pts.getFirst().getX(), iniHeight), new Point((int) pts.getFirst().getX(), finHeight));
                DatoNodo nuevoDatosNodo = new DatoNodo(pts.getFirst(), l);
                raiz.setDato(nuevoDatosNodo);
            } else {
                l = new Linea(new Point(iniWidth, (int) pts.getFirst().getY()), new Point(finWidth, (int) pts.getFirst().getY()));
                DatoNodo nuevoDatosNodo = new DatoNodo(pts.getFirst(), l);
                raiz.setDato(nuevoDatosNodo);
            }
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
        if (raiz.getHijoIzquierdo() != null && raiz.getHijoIzquierdo().getDato() != null) {
            obtenerLineas(lineas, raiz.getHijoIzquierdo());
        }
        if (raiz.getHijoDerecho() != null && raiz.getHijoDerecho().getDato() != null) {
            obtenerLineas(lineas, raiz.getHijoDerecho());
        }
    }
    /**
     * @return the lineas
     */
//    public LinkedList<Linea> getLineas() {
//        return lineas;
//    }
}
