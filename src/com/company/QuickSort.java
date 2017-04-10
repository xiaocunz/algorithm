package com.company;

/**
 * Created by zxiaocun on 2017/4/6.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] inputArr = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};

        quickSort(inputArr);

        for (int i : inputArr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static void quickSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        doSort(arr, 0, arr.length - 1);

    }

    private static void doSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = arr[high];
        int i = low, j = high;
        while (i < j) {
            while(i < j && arr[i] <= pivot) i++;
            arr[j] = arr[i];
            while (i < j && arr[j] >= pivot) j--;
            arr[i] = arr[j];
        }
        arr[i] = pivot;

        doSort(arr, low, i -1);
        doSort(arr, i+1, high);
    }
}
