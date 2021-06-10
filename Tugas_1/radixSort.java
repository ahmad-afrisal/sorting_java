/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas_1;

import java.util.Arrays;

/**
 *
 * @author Asus Gc
 */
public class radixSort {
   public static int getMax(int[] data) {
        int max = 0;
        for (int angka : data) {
            if (angka > max)
                max = angka;
        }

        return max;
    }

    public static void cetak(int[] data) {
        System.out.println(Arrays.toString(data));
    }

    public static void countingSort(int[] data, int exp) {
        int len = data.length;
        int[] output = new int[len];
        int[] count = new int[10];

        for (int i = 0; i < len; i++) {
            count[(data[i] / exp) % 10]++;
        }

        for (int i = 8; i > 0; i--) {
            count[i] += count[i + 1];
        }

        for (int i = len - 1; i >= 0; i--) {
            output[count[(data[i] / exp) % 10] - 1] = data[i];
            count[(data[i] / exp) % 10]--;
        }

        for (int i = 0; i < len; i++) {
            data[i] = output[i];
        }
    }

    public static void radixSort(int[] data) {
        int max = getMax(data);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(data, exp);
        }
    }

    public static void main(String[] args) throws Exception {
        int[] data = new int[] {12, 43, 67, 74, 23, 54, 66 };
        System.out.print("Data Original :");
        cetak(data);
        radixSort(data);
        System.out.print("Data Sesudah Sort :");
        cetak(data);
    }
}


