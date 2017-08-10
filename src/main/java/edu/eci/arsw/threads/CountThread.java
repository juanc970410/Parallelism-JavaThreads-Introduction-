/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThread extends Thread {

    private int beg;
    private int fin;

    CountThread(int beg, int fin) {
        this.beg = beg;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (int i = beg; i < fin; i++) {
            System.out.println(i);
        }
    }
}
