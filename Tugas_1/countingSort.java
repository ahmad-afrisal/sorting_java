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
public class countingSort {
    static void countSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max-min + 1;
        int count[] = new  int[range];
        int output[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]-min]++;
        }
        for (int i = count.length - 2; i >= 0; i--) {
            count[i] += count[i +1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]-min]-1] = arr[i];
            count[arr[i] - min]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
    static void printArray(int[] arr) {
         System.out.print("Counting Sort : "+ "[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
           System.out.println("]");
    }
    public static void main(String[] args) {
        int [] arr = {-5, -10, 0, 6, 9, 7 , 3};
        countSort(arr);
        printArray(arr);
    }
}
