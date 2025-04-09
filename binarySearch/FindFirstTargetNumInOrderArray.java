import java.util.ArrayList;
import java.util.Random;
import util.GetRandomArray;
import util.Print;

public class FindFirstTargetNumInOrderArray {

    private Random random = new Random();

    private int process(ArrayList<Integer> array, int target) {
        int result = -1;
        int left = 0;
        int right = array.size() - 1;
        int mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (array.get(mid) >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return array.get(result) == target ? result : -1;
    }

    public static void main(String[] args) {
        int length = 20;
        int times = 1000;
        int target = 5;
        FindFirstTargetNumInOrderArray findNum = new FindFirstTargetNumInOrderArray();
        System.out.println("test started");
        for (int i = 0; i < times; i++) {

            ArrayList<Integer> array = GetRandomArray.getRandomArrayList(length, 10, 0);
            array.sort(null);
            int answer = array.indexOf(target);
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
