/*
 * @Author: chenzj1993 chenzj1993@gmail.com
 * @Date: 2025-04-05 09:28:52
 * @LastEditors: chenzj1993 chenzj1993@gmail.com
 * @LastEditTime: 2025-04-05 23:03:36
 * @FilePath: \algorithm\reverseList.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFilecurer查看配置 进行设置: https://github.com/OBKoro1/koro1Filecurer/wiki/%E9%85%8D%E7%BD%AE
 */

import java.util.Random;

public class BubbleSort {
    private Random random = new Random();

    public static void printList(int[] list, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    private void process(int[] list, int length) {
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
        int num = 10;
        int[] list = new int[num];
        BubbleSort sort = new BubbleSort();
        for (var i = 0; i < num; i++) {
            list[i] = sort.random.nextInt(100);
        }
        printList(list, num);
        sort.process(list, num);
        printList(list, num);

    }
}
