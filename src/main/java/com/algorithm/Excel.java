package com.algorithm;

/**
 * @desc 把用A~Z表示的二十六进制转化为十进制数字
 * @company tuniu.com
 * Created by zhangfeifei2 on 2017/7/12.
 */
public class Excel {

    public static int numberTransform(String str) {
        if(str == null) {
            System.out.println("null字符串");
            return -1;
        }
        char[] strArray = str.toCharArray();
        if(strArray.length <= 0) {
            System.out.println("没有输入字符");
            return -1;
        }
        int sum = 0;
        for(int i = 0; i < strArray.length; i++) {
            int num = strArray[i]-'A';
            if(num >= 26 || num < 0) {
                System.out.println("字符不符合规范");
                return -1;
            } sum =
                    sum*26+num+1;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(numberTransform("ABC"));
    }


}
