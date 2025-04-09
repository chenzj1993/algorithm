import util.GetRandomStr;

public class KMP {

    private int[] helpArray(String str) {
        int length = str.length();
        int[] help = new int[length];
        int tmp;
        char[] charArray = str.toCharArray();
        help[0] = -1;
        for (int i = 1; i < length; i++) {
            tmp = i - 1;
            while (help[tmp] != -1) {
                if (charArray[i] == charArray[help[tmp]]) {
                    help[i] = help[tmp] + 1;
                    break;
                }
                tmp = help[tmp];
            }
            if (help[tmp] == -1) {
                help[i] = 0;
            }
        }
        return help;

    }

    private int kmp(String str, String cmp) {
        char[] strArray = str.toCharArray();
        char[] cmpArray = cmp.toCharArray();
        if (cmp.length() <= 0 || cmp.length() > str.length()) {
            return -1;
        }
        int result = -1;
        int i = 0;
        int j = 0;
        int[] help = helpArray(cmp);
        while (i < str.length() && j < cmp.length()) {
            if (strArray[i] == cmpArray[j]) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = help[j];
                }
            }
        }
        result = j != cmp.length() ? -1 : i - cmp.length();
        return result;

    }

    public static void main(String[] args) {
        System.out.println("test started");
        for (int i = 0; i < 1000; i++) {
            String str = GetRandomStr.getRandomStr(100);
            String cmp = GetRandomStr.getRandomStr(3);
            KMP kmp = new KMP();
            int result = kmp.kmp(str, cmp);
            int answer = str.indexOf(cmp);
            if (result != answer) {
                System.out.println(str);
                System.out.println("answer: " + answer);
                System.out.println("result: " + result);
            }

        }
        System.out.println("test finished");
    }
}