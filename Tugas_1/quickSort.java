/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas_1;

import java.util.Vector;

/**
 *
 * @author Asus Gc
 */
public class quickSort {
    static Vector <Integer> insialisasiVector(){
        Vector<Integer> vector = new Vector<>();
        vector.add(37);
        vector.add(3);
        vector.add(-7);
        vector.add(57);
        vector.add(-68);
        vector.add(0);
        vector.add(99);
        return vector;
    }
    static void cetak(Vector<Integer> vector) {
        System.out.print("[");
        for(int v:vector) {
            System.out.print(" "+v);
        }
        System.out.println("]");
    }
    static Vector<Integer>kloning(Vector<Integer> vector) {
        Vector<Integer>vectorBaru = null;
        if(vector!=null) {
        vectorBaru = new Vector<>();
        for (int v:vector) {
            vectorBaru.add(v);
        }
    }
        return vectorBaru;
    }
    static void tukarNilai(Vector<Integer> vector, int indexA,int indexB){
        if(indexA>=0&&indexA<vector.size()&&indexB>=0&&indexB<vector.size()&&indexA!=indexB){
            int A, B, C;
            A = vector.get(indexA);
            B = vector.get(indexB);
            C =A;
            A = B;
            B = C;
            vector.set(indexA, A);
            vector.set(indexB, B);
        };
    }
    
    static int partisi(Vector<Integer> vector, int low, int high) {
        int pivot = vector.get(high);
        int i = low -1;
        for (int j = low; j<high;j++){
            if (vector.get(j) > pivot) {
                i++;
                tukarNilai(vector, i, j);
            }
        }
        tukarNilai(vector, i+1, high);
        int index = i+1;
        return index;
        
    }
    static void quickSort(Vector<Integer> vector, int low, int high) {
        if (low<high) {
            int indexPartisi = partisi(vector, low, high);
            quickSort(vector, low, indexPartisi-1);
            quickSort(vector, indexPartisi+1, high);
        }
    }
    static void quickSort(Vector<Integer>vector) {
        quickSort(vector, 0, vector.size()-1);
    }
    static public void main(String[] fosalgo) {
        Vector<Integer>data = insialisasiVector();
        System.out.print("Data asli :");
        cetak(data);
        
        Vector<Integer> data1 = kloning(data);
        System.out.print("Quick Sort : ");
        quickSort(data1);
        cetak(data1);
        
    }
}