package com.company;

/**
 * Created by zxiaocun on 2017/4/5.
 */
public class MyMergeSort {
    public static void main(String[] args) {
        int[] inputArr = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        mergeSort(inputArr);
        for (int i : inputArr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        doMergeSort(array, 0, array.length - 1, temp);
    }

    private static void doMergeSort(int[] array, int start, int end, int[] temp) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            doMergeSort(array, start, mid, temp);
            doMergeSort(array, mid + 1, end, temp);

            merge(array, start, mid, end, temp);
        }
    }

    private static void merge(int[] array, int start, int mid, int end, int[] temp) {

        for (int i = start; i <= end; i++) {
            temp[i] = array[i];
        }
        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            if (temp[i] <= temp[j]) {
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            array[k++] = temp[i++];
        }
    }
}
