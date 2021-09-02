/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author nick paredes
 */
public class Sort {
       private static void swap(Comparable a, Comparable b){
        Comparable temp = a;
        a = b;
        b = temp;
    }

    private static void heapify(Comparable arr[], int n, int i){
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        //left child is greater than root
        if(l < n && arr[l].compareTo(arr[largest]) == 1 ? true : false){
            largest = l;
        }

        //right child is greater than root
        if (r < n && arr[r].compareTo(arr[largest]) == 1 ? true : false){
            largest = r;
        }

        if(largest != i){
            //swap(arr[i], arr[largest]);
            Comparable temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
//printArray(arr, n);
            heapify(arr, n, largest);
        }
    }
    
    public static void heapSort(Comparable[] arr){
        heapsort(arr, arr.length);
    }
    private static void heapsort(Comparable arr[], int n){
        int i;

        for (i = n / 2 - 1; i >= 0; i--){
            heapify(arr, n, i);
        }

        for (i = n - 1; i >= 0; i--){
            Comparable temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    
    public static void main(String[] args){
        Paciente[] pacientes = {new Paciente("A", 15), new Paciente("B", 7), new Paciente("C", 32), new Paciente("D", 10), new Paciente("F", 1)};
        Sort.heapSort(pacientes);
        for(Paciente p: pacientes){
            System.out.println(p);
        }
    }
    
}


