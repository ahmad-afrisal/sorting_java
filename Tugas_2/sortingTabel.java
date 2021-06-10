/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas_2;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Asus Gc
 */
public class sortingTabel {
    public static void main(String[] args) {
        Mahasiswa[] data1= readArrayMahasiswaFromFile("data_mahasiswa.csv");
        System.out.println("Data Seblum di Sort");
        cetak(data1);
        quickSort(data1);
        System.out.println("Data Setelah Di sort");
        cetak(data1);
    }
    
    static Mahasiswa[] readArrayMahasiswaFromFile(String path) {
        try {
            String line ="";
            BufferedReader reader = new BufferedReader (new FileReader (path));
            int jumlahData = 0;
            while (reader.ready()) {
                line = reader.readLine();
                jumlahData++;
            }
            reader.close();
            reader = new BufferedReader (new FileReader(path));
            
            Mahasiswa[] arrayMahasiswa = new Mahasiswa[jumlahData];
            int i = 0;
            while (reader.ready()) {
                line = reader.readLine();
                String[] data = line.split("; ?");
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.namaMahasiswa = data[0];
                mahasiswa.nilai = Double.parseDouble(data[1]);
                arrayMahasiswa[i] = mahasiswa;
                i++;
            }
            reader.close();
            return arrayMahasiswa;
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return new Mahasiswa[1];
    }
    
    static void swapMahasiswa(Mahasiswa[] arr, int index1, int index2) {
        Mahasiswa data1 = arr[index1];
        Mahasiswa data2 = arr[index2];
        arr[index1] = data2;
        arr[index2] = data1;
    }
    
    static void cetak(Mahasiswa[] arrMahasiswa) {
        System.out.printf("%-15s\t|  %s\n", "Nama Mahasiswa", "Nilai" );
        for (Mahasiswa mahasiswa : arrMahasiswa) {
            System.out.printf("%-15s\t|  %d\n", mahasiswa.namaMahasiswa, (int) mahasiswa.nilai );
        }
    }
    
    static int partisi(Mahasiswa[] data, int low, int high) {
        double pivot = data[high].nilai;
        int i = low - 1;
        for (int j = low; j < high; j++ ) {
            if (data[j].nilai > pivot) {
                i++;
                swapMahasiswa(data, i, j);
                
            }
            
        }
        swapMahasiswa (data, i + 1, high);
        return i + 1;
    }
    static void quickSort(Mahasiswa[] data, int low, int high) {
        if (low < high) {
            int partitionIndex = partisi(data, low, high);
            quickSort(data, low, partitionIndex - 1);
            quickSort(data, partitionIndex + 1, high);
        }
    }
    
    public static void quickSort(Mahasiswa[] data) {
        quickSort(data, 0, data.length - 1);
    }
}
