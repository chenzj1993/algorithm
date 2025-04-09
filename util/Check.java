package util;

import java.util.ArrayList;

public class Check<T> {

    // check if two arrays' values are equal
    public static boolean isEqual(ArrayList<Integer> answer, ArrayList<Integer> test) {
        if (answer.size() != test.size()) {
            return false;
        }
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) != test.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEqual(Integer[] answer, Integer[] test, int length) {
        for (int i = 0; i < length; i++) {
            if (answer[i] != test[i]) {
                return false;
            }
        }
        return true;
    }
}
