
import java.util.Random;

import util.GetRandomArray;
import util.Print;

public class InsertSort {
    private Random random = new Random();

    private void process(Integer[] array, int length) {
        int tmp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }

            }
        }
    }

    public static void main(String[] args) {
        int length = 10;
        InsertSort sort = new InsertSort();
        System.out.println("test started");
        for (int i = 0; i < 1000; i++) {
            Integer[] array = GetRandomArray.getRandomArray(length, 100, 0);
            sort.process(array, length);
            for (int j = 0; j < length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    Print.printArray(array, length);
                }
            }
        }
        System.out.println("test finished");

    }
}
