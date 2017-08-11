package com.algorithm;

/**
 * 数值的整数次方
 * Created by zhangfeifei2 on 2017/7/12.
 */
public class Pow {
    public static double power(double base, int exponent) throws Exception {
        double result = 0.0;
        if (equal(base, 0.0) && exponent < 0)
            throw new Exception("0的负数次幂无意义");
        if (exponent == 0)
            return 1.0;
        if (exponent < 0)
            result = powerWithExponent2(1.0 / base, -exponent);
        else
            result = powerWithExponent2(base, exponent);
        return result;
    }
    private static double powerWithExponent( double base, int exponent) {
        double result = 1.0;
        for(int i = 1; i <= exponent; i++)
            result *= base;
        return result;
    }
    private static double powerWithExponent2(double base, int exponent) {
        if(exponent == 0)
            return 1.0;
        if(exponent == 1)
            return base;
        double result = powerWithExponent2(base, exponent>>1);
        result *= result;
        if((exponent&0x1) == 1){
            result *= base;//奇数次幂
        }
        return result;
    }
    //判断两个double类型数据是否相等
    private static boolean equal(double num1, double num2) {
        double diff = num1 - num2;
        if(Math.abs(diff) < 0.0000001) {
            return true;
        } return false;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(power(9.0, 3));
    }

}
