package util;

import java.util.Random;

public class GetRandomStr {
    public static String getRandomStr(int length) {
        Random random = new Random();
        char[] str = new char[length];
        for (int i = 0; i < length; i++) {
            str[i] = (char) (97 + random.nextInt(26));
        }
        return String.valueOf(str);
    }

}
