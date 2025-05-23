
/*
 * @Author: chenzj1993 chenzj1993@gmail.com
 * @Date: 2025-04-05 23:46:35
 * @LastEditors: chenzj1993 chenzj1993@gmail.com
 * @LastEditTime: 2025-04-07 00:54:26
 * @FilePath: \algorithm\KMP.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */

import java.util.ArrayList;
import java.util.Random;

import util.GetRandomArray;
import util.Print;

public class FindNumInOrderArray {

    private Random random = new Random();

    private int process(ArrayList<Integer> array, int target) {
        int result = -1;
        int left = 0;
        int right = array.size() - 1;
        int mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (array.get(mid) > target) {
                right = mid - 1;
            } else if (array.get(mid) == target) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int length = 20;
        int times = 1000;
        int ceiling = 20;
        int ground = 0;
        int target = 8;
        FindNumInOrderArray findNum = new FindNumInOrderArray();
        System.out.println("test started");
        for (int i = 0; i < times; i++) {
            ArrayList array = GetRandomArray.getRandomArrayList(length, ceiling, ground);
            array.sort(null);
            int result = findNum.process(array, target);
            int answer = array.indexOf(target);
            if (answer != result && (int) array.get(result) != target) {
                Print.printArray(array);
                System.out.println("result: " + result);
            }
        }
        System.out.println("test finished");
    }
}
