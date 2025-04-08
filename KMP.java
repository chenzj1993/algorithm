
/*
 * @Author: chenzj1993 chenzj1993@gmail.com
 * @Date: 2025-04-05 23:46:35
 * @LastEditors: chenzj1993 chenzj1993@gmail.com
 * @LastEditTime: 2025-04-06 00:31:45
 * @FilePath: \algorithm\KMP.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
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
        String str = "aabbaaabb";
        String cmp = "aabb";
        KMP kmp = new KMP();
        int index = kmp.kmp(str, cmp);
        System.out.println(index);

    }
}
