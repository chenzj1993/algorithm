
import java.util.Random;

import util.GetRandomArray;
import util.Print;

public class QuickSort {
    private Random random = new Random();

    private void process(Integer[] list, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = random.nextInt(right - left + 1);
        int tmp;
        int cmp = list[left + pivot];
        tmp = list[left];
        list[left] = list[left + pivot];
        list[left + pivot] = tmp;

        int equalleft = left;
        int equalright = left;
        int bigger = right;
        int i = left + 1;
        while (i <= bigger) {
            if (list[i] < cmp) {
                tmp = list[i];
                list[i++] = list[equalleft];
                list[equalleft++] = tmp;
                equalright++;
            } else if (list[i] == cmp) {
                i++;
                equalright++;
            } else {
                tmp = list[i];
                list[i] = list[bigger];
                list[bigger--] = tmp;
            }
        }
        process(list, left, equalleft - 1);
        process(list, equalright + 1, right);
    }

    public static void main(String[] args) {
        int length = 10;
        QuickSort sort = new QuickSort();
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
