
/*
 * @Author: chenzj1993 chenzj1993@gmail.com
 * @Date: 2025-04-05 23:46:35
 * @LastEditors: chenzj1993 chenzj1993@gmail.com
 * @LastEditTime: 2025-04-07 01:14:33
 * @FilePath: \algorithm\KMP.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */

import java.util.ArrayList;
import java.util.Random;

import util.GetRandomArray;
import util.Print;

public class FindLastTargetNumInOrderArray {

    private Random random = new Random();

    private void printArray(ArrayList array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }

    private int process(ArrayList<Integer> array, int target) {
        int result = -1;
        int left = 0;
        int right = array.size() - 1;
        int mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (array.get(mid) > target) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }
        return array.get(result) == target ? result : -1;
    }

    public static void main(String[] args) {
        int length = 20;
        int times = 1000;
        int target = 5;
        FindLastTargetNumInOrderArray findNum = new FindLastTargetNumInOrderArray();
        System.out.println("test started");
        for (int i = 0; i < times; i++) {
            ArrayList<Integer> array = GetRandomArray.getRandomArrayList(length, 10, 0);
            array.sort(null);
            int answer = array.lastIndexOf(target);

            int result = findNum.process(array, target);
            if (answer != result) {
                Print.printArray(array);
                System.out.println("answer: " + answer);
                System.out.println("result: " + result);
            }
        }
        System.out.println("test finished");
    }
}
