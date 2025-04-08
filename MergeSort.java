/*
 * @Author: chenzj1993 chenzj1993@gmail.com
 * @Date: 2025-04-05 09:28:52
 * @LastEditors: chenzj1993 chenzj1993@gmail.com
 * @LastEditTime: 2025-04-05 23:01:14
 * @FilePath: \algorithm\reverseList.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFilecurer查看配置 进行设置: https://github.com/OBKoro1/koro1Filecurer/wiki/%E9%85%8D%E7%BD%AE
 */

import java.util.Random;

public class MergeSort {
    private Random random = new Random();

    public static void printList(int[] list, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    private void process(int[] list, int left, int right) {
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
        int[] list = new int[length];
        MergeSort sort = new MergeSort();
        for (var i = 0; i < length; i++) {
            list[i] = sort.random.nextInt(100);
        }
        printList(list, length);
        sort.process(list, 0, length - 1);
        printList(list, length);

    }
}
