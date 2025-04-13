
import java.util.Random;

import util.GetRandomArray;
import util.Print;

public class SelectSort {
    private Random random = new Random();

    private void process(Integer[] array, int length) {
        int max;
        int tmp;
        for (int i = 0; i < length - 1; i++) {
            max = 0;
            for (int j = 1; j < length - i; j++) {
                if (array[max] < array[j]) {
                    max = j;
                }

                tmp = array[length-i-1];
                array[length-i-1] = array[max];
                array[max] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int length = 10;
        SelectSort sort = new SelectSort();
        System.out.println("test started");
        for (int i = 0; i < 1000; i++) {
            Integer[] array = GetRandomArray.getRandomArray(length, 100, 0);
            sort.process(array, length);
            for (int j = 0; j < length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    Print.printArray(array);
                }
            }
        }
        System.out.println("test finished");

    }
}
