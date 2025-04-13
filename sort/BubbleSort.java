
import java.util.Random;

import util.GetRandomArray;
import util.Print;

public class BubbleSort {
    private Random random = new Random();

    private void process(Integer[] list, int length) {
        int tmp;
        for (int i = 0; i < length - 1; i++)
            for (int j = 0; j < length - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    tmp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tmp;
                }
            }
    }

    public static void main(String[] args) {
        int length = 10;
        BubbleSort sort = new BubbleSort();

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
