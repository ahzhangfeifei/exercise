package com.algorithm;

/**
 * 跳台阶(Fibonacci变形)
 * Created by zhangfeifei2 on 2017/7/11.
 */
public class StageFibonacci {
    public static long find(long n) {
        long a = 0;
        if(n < 0) {
            a = 0;
        } else if(n == 0) {
            a = 1;
        } else {
            a = (long)Math.pow(2, n-1);
        } return a;
    }
}
