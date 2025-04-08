/*
 * @Author: chenzj1993 chenzj1993@gmail.com
 * @Date: 2025-04-05 09:28:52
 * @LastEditors: chenzj1993 chenzj1993@gmail.com
 * @LastEditTime: 2025-04-05 23:04:18
 * @FilePath: \algorithm\reverseList.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFilecurer查看配置 进行设置: https://github.com/OBKoro1/koro1Filecurer/wiki/%E9%85%8D%E7%BD%AE
 */

import java.util.Random;

public class SelectSort {
    private Random random = new Random();

    public static void printList(int[] list, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    private void process(int[] list, int length) {
        int max;
        int tmp;
        for (int i = 0; i < length - 1; i++) {
            max = 0;
            for (int j = 1; j < length - i; j++) {
                if (list[max] < list[j]) {
                    max = j;
                }

                tmp = list[length-i-1];
                list[length-i-1] = list[max];
                list[max] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int num = 10;
        int[] list = new int[num];
        SelectSort sort = new SelectSort();
        for (var i = 0; i < num; i++) {
            list[i] = sort.random.nextInt(100);
        }
        printList(list, num);
        sort.process(list, num);
        printList(list, num);

    }
}
