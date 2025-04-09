package util;

import java.util.ArrayList;
import java.util.Random;

public class GetRandomArray {
    public static ArrayList<Integer> getRandomArrayList(int length, int ceiling, int ground) {
        Random random = new Random();
        int range = ceiling - ground + 1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            result.add(ground + random.nextInt(range));
        }
        return result;
    }

    public static Integer[] getRandomArray(int length, int ceiling, int ground) {
        Random random = new Random();
        int range = ceiling - ground + 1;
        Integer[] result = new Integer[length];
        for (int i = 0; i < length; i++) {
            result[i] = ground + random.nextInt(range);
        }
        return result;
    }
}
