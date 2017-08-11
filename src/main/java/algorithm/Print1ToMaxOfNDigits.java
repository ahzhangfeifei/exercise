package algorithm;

/**
 * @desc 打印1-最大数 用字符串来存储数字
 * @company tuniu.com
 * Created by zhangfeifei2 on 2017/7/12.
 */
public class Print1ToMaxOfNDigits {

    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        StringBuffer number = new StringBuffer();
        for (int i = 0; i < n; i++) {
            number.append('0');
        }
        while (!increment(number)) {
            printNumber(number);
        }
    }

    private static boolean increment(StringBuffer s) {
        boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = s.length();
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = s.charAt(i) - '0' + nTakeOver;
            if (i == nLength - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    s.setCharAt(i, (char) ('0' + nSum));
                }
            } else {
                s.setCharAt(i, (char) ('0' + nSum));
                break;
            }
        }
        return isOverflow;
    }

    private static void printNumber(StringBuffer s) {
        boolean isBeginning0 = true;
        for (int i = 0; i < s.length(); i++) {
            if (isBeginning0 && s.charAt(i) != '0') {
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                System.out.print(s.charAt(i));
            }
        }
        System.out.println();
    }

    public static void main(String args[]){
        print1ToMaxOfNDigits(50);
    }

}
