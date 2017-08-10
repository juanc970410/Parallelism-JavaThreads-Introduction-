package edu.eci.arsw.math;

///  <summary>

import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.util.Length;

///  An implementation of the Bailey-Borwein-Plouffe formula for calculating hexadecimal
///  digits of pi.
///  https://en.wikipedia.org/wiki/Bailey%E2%80%93Borwein%E2%80%93Plouffe_formula
///  *** Translated from C# code: https://github.com/mmoroney/DigitsOfPi ***
///  </summary>
public class PiDigits {

    /*private static int DigitsPerSum = 8;
    private static double Epsilon = 1e-17;
*/
    
    /**
     * Returns a range of hexadecimal digits of pi.
     * @param start The starting location of the range.
     * @param count The number of digits to return
     * @return An array containing the hexadecimal digits.
     */
    public static byte[] getDigits(int start, int count, int N) {
        byte[] digits = new byte[count];
        int beg = start;
        int size = count/N;
        int last = count%N+size;
        MyThread[] hilos = new MyThread[N];
        
        for (int i = 0; i < hilos.length-1; i++) {
            hilos[i]=new MyThread(beg, size);
            hilos[i].start();
            beg+=size;
        }
        hilos[hilos.length-1]=new MyThread(beg, last);
        hilos[hilos.length-1].start();
        
        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(PiDigits.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("UNIR");
        int ind = 0;
        
        while (ind < digits.length){
             for (int i = 0; i < hilos.length; i++) {
                 for (int j = 0; j < hilos[i].digits.length; j++) {             
                     digits[ind]=hilos[i].digits[j];
                     ind++;
                 }
            }
        }
        
        return digits;
    }

    /// <summary>
    /// Returns the sum of 16^(n - k)/(8 * k + m) from 0 to k.
    /// </summary>
    /// <param name="m"></param>
    /// <param name="n"></param>
    /// <returns></returns>
    /*private static double sum(int m, int n) {
        double sum = 0;
        int d = m;
        int power = n;

        while (true) {
            double term;

            if (power > 0) {
                term = (double) hexExponentModulo(power, d) / d;
            } else {
                term = Math.pow(16, power) / d;
                if (term < Epsilon) {
                    break;
                }
            }

            sum += term;
            power--;
            d += 8;
        }

        return sum;
    }

    /// <summary>
    /// Return 16^p mod m.
    /// </summary>
    /// <param name="p"></param>
    /// <param name="m"></param>
    /// <returns></returns>
    private static int hexExponentModulo(int p, int m) {
        int power = 1;
        while (power * 2 <= p) {
            power *= 2;
        }

        int result = 1;

        while (power > 0) {
            if (p >= power) {
                result *= 16;
                result %= m;
                p -= power;
            }

            power /= 2;

            if (power > 0) {
                result *= result;
                result %= m;
            }
        }

        return result;
    }
    
*/
}
