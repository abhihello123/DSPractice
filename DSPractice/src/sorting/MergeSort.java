package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] {2,4,9,1,6,8,5,3,7};
        MergeSort obj = new MergeSort();
        obj.mergesort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void mergesort(int[] arr) {
        int n = arr.length;
        if (n < 2)
            return;
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];

        for (int i=0; i< mid; i++)
            left[i] = arr[i];

        for (int i=0;i<n-mid; i++)
            right[i] = arr[i+mid];

        mergesort(left);
        mergesort(right);

        merge(arr, left, right);
    }

    private void merge(int[] arr, int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i=0, j=0, k=0;
        while(i<len1 && j<len2) {
            if (arr1 [i] < arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }
        while (i<len1)
            arr[k++] = arr1[i++];

        while (j<len2)
            arr[k++] = arr2[j++];
    }

}