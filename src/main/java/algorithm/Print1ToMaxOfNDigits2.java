package algorithm;

/**
 * 思路：用数字排列的方法表示：如果我们在数字前面补0的话，就会发现n位所有十进制数其实就是n
 * 个从0到9的全排列。
 * 也就是说，我们把数字的每一位都从0到9排列一遍，就得到了所有的十进制数。当然打印的时候，我
 * 们应该将前面的0补位去掉.
 */

public class Print1ToMaxOfNDigits2 {

    public static void print1ToMaxOfDigits(int n) {
        if (n < 0)
            return;
        StringBuffer s = new StringBuffer(n);
        for (int i = 0; i < n; i++)
            s.append('0');
        for (int i = 0; i < 10; i++) {
            s.setCharAt(0, (char) (i + '0'));
            print1ToMaxOfDigitsRecursively(s, n, 0);
        }
    }

    private static void print1ToMaxOfDigitsRecursively(StringBuffer s, int n,
                                                       int index) {
        if (index == n - 1) {
            printNumber(s);
            return;
        }
        for (int i  =  0; i  < 10; i++) {
            s.setCharAt(index + 1, (char) (i + '0'));
            print1ToMaxOfDigitsRecursively(s, n, index + 1);
        }
    }

    private static void printNumber(StringBuffer s) {
        boolean isBeginning0 = true;
        for (int i = 0; i < s.length(); i++) {
            if (!isBeginning0 && s.charAt(i) != '0')
                isBeginning0 = false;
            if (!isBeginning0) {
                System.out.print(s.charAt(i));
            }
        }
        System.out.println();
    }

}
