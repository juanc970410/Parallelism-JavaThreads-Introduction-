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
public class CountThreadsMain {

    public static void main(String[] args) {
        Thread A = new CountThread(0,9999);
        Thread B = new CountThread(10000,19999);
        Thread C = new CountThread(20000,29999);
        A.start();
        B.start();
        C.start();
        
    }
}
