/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author aaron

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public final class Posicion {
    public int x;
    public int y;
    public Posicion() {
    }
    public Posicion(int x, int y) {
        Set(x, y);
    }
    public Posicion(Posicion p) {
        Set(p);
    }
    public void Set(int _x, int _y) {
        x = _x;y = _y;
    }
    public void Set(Posicion p) {
        if (p != null) {
            x = p.x; y = p.y;
        } else {
            x = 0; y = 0;
        }
    }
    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " (" + x + "," + y + ")";
    }
}