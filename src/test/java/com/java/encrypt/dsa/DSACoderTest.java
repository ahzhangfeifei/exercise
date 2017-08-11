package com.java.encrypt.dsa;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by zhangfeifei2 on 2017/8/4.
 */
public class DSACoderTest {
    @Test
    public void test() throws Exception {
        String inputStr = "abc";
        byte[] data = inputStr.getBytes();

        // 构建密钥
        Map<String, Object> keyMap = DSACoder.initKey();

        // 获得密钥
        String publicKey = DSACoder.getPublicKey(keyMap);
        String privateKey = DSACoder.getPrivateKey(keyMap);

        System.out.println("公钥:\r" + publicKey);
        System.out.println("私钥:\r" + privateKey);

        // 产生签名
        String sign = DSACoder.sign(data, privateKey);
        System.out.println("签名:\r" + sign);

        // 验证签名
        boolean status = DSACoder.verify(data, publicKey, sign);
        System.out.println("状态:\r" + status);
        Assert.assertTrue(status);
    }

}
