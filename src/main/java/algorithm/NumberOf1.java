package algorithm;

/**
 * @desc 二进制中1的个数
 * @company tuniu.com
 * Created by zhangfeifei2 on 2017/7/11.
 */
public class NumberOf1 {

    public static int numberOf1_mth1(int num) {
        int count = 0;
        int f = 1;
        while (f != 0) {
            if ((f & num) != 0) {
                count++;
            }
            f <<= 1;
        }
        return count;
    }

    public static int numberOf1_mth2(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

    //extension
    public static boolean isPowOf2(int num) {
        return (num & (num - 1)) == 0;
    }

    //extension
    public static int needChangeBits(int m, int n) {
        int num = m ^ n;
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        //System.out.println(numberOf1_mth2(9));
        //System.out.println(isPowOf2(64));
        System.out.println(needChangeBits(10, 13));
    }

}
