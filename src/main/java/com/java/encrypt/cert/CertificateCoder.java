package com.java.encrypt.cert;

import com.java.encrypt.Coder;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;

/**
 * 证书组件
 * Created by zhangfeifei2 on 2017/8/4.
 */
public abstract class CertificateCoder extends Coder {

    /**
     * 在构建Java代码实现前，我们需要完成证书的制作。
     * 1.生成keyStroe文件
     * 在命令行下执行以下命令：
     * Shell代码  收藏代码
     * keytool -genkey -validity 36000 -alias www.team.org -keyalg RSA -keystore d:\team.keystore
     * 其中
     * -genkey表示生成密钥
     * -validity指定证书有效期，这里是36000天
     * -alias指定别名，这里是www.team.org
     * -keyalg指定算法，这里是RSA
     * -keystore指定存储位置，这里是d:\team.keystore
     * <p>
     * Java密钥库(Java Key Store，JKS)
     * 2.生成自签名证书
     * 光有keyStore文件是不够的，还需要证书文件，证书才是直接提供给外界使用的公钥凭证。
     * 导出证书：
     * Shell代码  收藏代码
     * keytool -export -keystore d:\team.keystore -alias www.team.org -file d:\team.cer -rfc
     * 其中
     * -export指定为导出操作
     * -keystore指定keystore文件
     * -alias指定导出keystore文件中的别名
     * -file指向导出路径
     * -rfc以文本格式输出，也就是以BASE64编码输出
     *  Created by zhangfeifei on 2017/8/4.
     */
    public static final String KEY_STORE = "JKS";

    public static final String X509 = "X.509";

    /**
     * 由KeyStore获得私钥
     *
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    private static PrivateKey getPrivateKey(String keyStorePath, String alias,
                                            String password) throws Exception {
        KeyStore ks = getKeyStore(keyStorePath, password);
        PrivateKey key = (PrivateKey) ks.getKey(alias, password.toCharArray());
        return key;
    }

    /**
     * 由Certificate获得公钥
     *
     * @param certificatePath
     * @return
     * @throws Exception
     */
    private static PublicKey getPublicKey(String certificatePath)
            throws Exception {
        Certificate certificate = getCertificate(certificatePath);
        PublicKey key = certificate.getPublicKey();
        return key;
    }

    /**
     * 获得Certificate
     *
     * @param certificatePath
     * @return
     * @throws Exception
     */
    private static Certificate getCertificate(String certificatePath)
            throws Exception {
        CertificateFactory certificateFactory = CertificateFactory
                .getInstance(X509);
        FileInputStream in = new FileInputStream(certificatePath);

        Certificate certificate = certificateFactory.generateCertificate(in);
        in.close();

        return certificate;
    }

    /**
     * 获得Certificate
     *
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    private static Certificate getCertificate(String keyStorePath,
                                              String alias, String password) throws Exception {
        KeyStore ks = getKeyStore(keyStorePath, password);
        Certificate certificate = ks.getCertificate(alias);

        return certificate;
    }

    /**
     * 获得KeyStore
     *
     * @param keyStorePath
     * @param password
     * @return
     * @throws Exception
     */
    private static KeyStore getKeyStore(String keyStorePath, String password)
            throws Exception {
        FileInputStream is = new FileInputStream(keyStorePath);
        KeyStore ks = KeyStore.getInstance(KEY_STORE);
        ks.load(is, password.toCharArray());
        is.close();
        return ks;
    }

    /**
     * 私钥加密
     *
     * @param data
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String keyStorePath,
                                             String alias, String password) throws Exception {
        // 取得私钥
        PrivateKey privateKey = getPrivateKey(keyStorePath, alias, password);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(data);

    }

    /**
     * 私钥解密
     *
     * @param data
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, String keyStorePath,
                                             String alias, String password) throws Exception {
        // 取得私钥
        PrivateKey privateKey = getPrivateKey(keyStorePath, alias, password);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        return cipher.doFinal(data);

    }

    /**
     * 公钥加密
     *
     * @param data
     * @param certificatePath
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String certificatePath)
            throws Exception {

        // 取得公钥
        PublicKey publicKey = getPublicKey(certificatePath);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        return cipher.doFinal(data);

    }

    /**
     * 公钥解密
     *
     * @param data
     * @param certificatePath
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, String certificatePath)
            throws Exception {
        // 取得公钥
        PublicKey publicKey = getPublicKey(certificatePath);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        return cipher.doFinal(data);

    }

    /**
     * 验证Certificate
     *
     * @param certificatePath
     * @return
     */
    public static boolean verifyCertificate(String certificatePath) {
        return verifyCertificate(new Date(), certificatePath);
    }

    /**
     * 验证Certificate是否过期或无效
     *
     * @param date
     * @param certificatePath
     * @return
     */
    public static boolean verifyCertificate(Date date, String certificatePath) {
        boolean status = true;
        try {
            // 取得证书
            Certificate certificate = getCertificate(certificatePath);
            // 验证证书是否过期或无效
            status = verifyCertificate(date, certificate);
        } catch (Exception e) {
            status = false;
        }
        return status;
    }

    /**
     * 验证证书是否过期或无效
     *
     * @param date
     * @param certificate
     * @return
     */
    private static boolean verifyCertificate(Date date, Certificate certificate) {
        boolean status = true;
        try {
            X509Certificate x509Certificate = (X509Certificate) certificate;
            x509Certificate.checkValidity(date);
        } catch (Exception e) {
            status = false;
        }
        return status;
    }

    /**
     * 签名
     *
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    public static String sign(byte[] sign, String keyStorePath, String alias,
                              String password) throws Exception {
        // 获得证书
        X509Certificate x509Certificate = (X509Certificate) getCertificate(
                keyStorePath, alias, password);
        // 获取私钥
        KeyStore ks = getKeyStore(keyStorePath, password);
        // 取得私钥
        PrivateKey privateKey = (PrivateKey) ks.getKey(alias, password
                .toCharArray());

        // 构建签名
        Signature signature = Signature.getInstance(x509Certificate
                .getSigAlgName());
        signature.initSign(privateKey);
        signature.update(sign);
        return encryptBASE64(signature.sign());
    }

    /**
     * 验证签名
     *
     * @param data
     * @param sign
     * @param certificatePath
     * @return
     * @throws Exception
     */
    public static boolean verify(byte[] data, String sign,
                                 String certificatePath) throws Exception {
        // 获得证书
        X509Certificate x509Certificate = (X509Certificate) getCertificate(certificatePath);
        // 获得公钥
        PublicKey publicKey = x509Certificate.getPublicKey();
        // 构建签名
        Signature signature = Signature.getInstance(x509Certificate
                .getSigAlgName());
        signature.initVerify(publicKey);
        signature.update(data);

        return signature.verify(decryptBASE64(sign));

    }

    /**
     * 验证Certificate
     *
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     */
    public static boolean verifyCertificate(Date date, String keyStorePath,
                                            String alias, String password) {
        boolean status = true;
        try {
            Certificate certificate = getCertificate(keyStorePath, alias,
                    password);
            status = verifyCertificate(date, certificate);
        } catch (Exception e) {
            status = false;
        }
        return status;
    }

    /**
     * 验证Certificate
     *
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     */
    public static boolean verifyCertificate(String keyStorePath, String alias,
                                            String password) {
        return verifyCertificate(new Date(), keyStorePath, alias, password);
    }
}