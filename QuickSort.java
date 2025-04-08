/*
 * @Author: chenzj1993 chenzj1993@gmail.com
 * @Date: 2025-04-05 09:28:52
 * @LastEditors: chenzj1993 chenzj1993@gmail.com
 * @LastEditTime: 2025-04-05 23:44:01
 * @FilePath: \algorithm\reverseList.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFilecurer查看配置 进行设置: https://github.com/OBKoro1/koro1Filecurer/wiki/%E9%85%8D%E7%BD%AE
 */

import java.util.Random;

public class QuickSort {
    private Random random = new Random();

    public static void printList(int[] list, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    private void process(int[] list, int left, int right) {
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
        int[] list = new int[length];
        QuickSort sort = new QuickSort();
        for (var i = 0; i < length; i++) {
            list[i] = sort.random.nextInt(100);
        }
        printList(list, length);
        sort.process(list, 0, length - 1);
        printList(list, length);

    }
}
