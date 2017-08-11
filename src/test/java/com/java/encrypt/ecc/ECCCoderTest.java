package com.java.encrypt.ecc;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Chipher不支持EC算法 ，以上代码仅供参考。
 * Chipher、Signature、KeyPairGenerator、KeyAgreement、SecretKey均不支持EC算法。
 * 为了确保程序能够正常执行，我们使用了NullCipher类，验证程序。
 * Created by zhangfeifei2 on 2017/8/4.
 */
public class ECCCoderTest {
    @Test
    public void test() throws Exception {
        String inputStr = "abc123";
        byte[] data = inputStr.getBytes();

        Map<String, Object> keyMap = ECCCoder.initKey();

        String publicKey = ECCCoder.getPublicKey(keyMap);
        String privateKey = ECCCoder.getPrivateKey(keyMap);
        System.out.println("公钥: \n" + publicKey);
        System.out.println("私钥： \n" + privateKey);

        byte[] encodedData = ECCCoder.encrypt(data, publicKey);

        byte[] decodedData = ECCCoder.decrypt(encodedData, privateKey);

        String outputStr = new String(decodedData);
        System.out.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
        Assert.assertEquals(inputStr, outputStr);
    }
}
