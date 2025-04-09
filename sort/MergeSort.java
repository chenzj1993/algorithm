
import java.util.Random;

import util.GetRandomArray;
import util.Print;

public class MergeSort {
    private Random random = new Random();

    private void process(Integer[] list, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        process(list, left, mid);
        process(list, mid + 1, right);

        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (list[i] <= list[j]) {
                tmp[k++] = list[i++];
            } else {
                tmp[k++] = list[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = list[i++];
        }
        while (j <= right) {
            tmp[k++] = list[j++];
        }
        for (int l = 0; l < k; l++) {
            list[left + l] = tmp[l];
        }
    }

    public static void main(String[] args) {
        int length = 10;
        MergeSort sort = new MergeSort();
        System.out.println("test started");
        for (int i = 0; i < 1000; i++) {
            Integer[] array = GetRandomArray.getRandomArray(length, 100, 0);
            sort.process(array, 0, length - 1);
            for (int j = 0; j < length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    Print.printArray(array, length);
                }
            }
        }
        System.out.println("test finished");

    }
}
