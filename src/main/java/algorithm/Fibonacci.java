package algorithm;

/**
 * @desc 斐波那契数列
 * @company tuniu.com
 * Created by zhangfeifei2 on 2017/7/11.
 */
public class Fibonacci {
    public static long find(long n) {
        int result = 0;
        int pOne = 1;
        int pTwo = 0;
        if(n == 0)
            return pTwo;
        if(n == 1)
            return pOne;
        for(int i = 2;i <= n; i++) {
            result = pOne + pTwo;
            pTwo = pOne;
            pOne = result;
        } return result;
    }
}
