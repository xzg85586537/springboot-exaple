package com.cn.common.utils;

/**
 * @ClassName RsaTool
 * @Description: TODO
 * @Author Jacob
 * @Date 2020/3/2
 * @Version V1.0
 **/

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
/**
 * 1、公钥加密，私钥解密用于信息加密
 * 2、私钥加密，公钥解密用于数字签名
 */
public class RsaTool
{
//    /**
//     * 测试方法
//     */
//    public static void main(String[] args)
//    {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map = RsaTool.init();
//        System.out.println("公钥："+RsaTool.getPublicKey(map));
//        System.out.println("私钥："+RsaTool.getPrivateKey(map));
//        //由前四行代码获得公、私密钥
//        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC38gbqskIC+0SRZM3CM2aOJbpnzEOnwzk0D9AA1p7oeK2aXL71A4ik9E5D62KPqPqfGCEUfdYC1sGeZzpyYAFydkHFkbZw5iVYIWuN2qB0HAnFEeE+ZymlpyTrWZT4rdgCRqWfgpFzr/9ZFLSuJecOykv2q9SOr1Uxg+IaKc5eUQIDAQAB";
//        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKs9aCEjqU3S2isiTT/vM3rNDUEa/WVKsH0vnRCfhIUQj6zW7Ebta61qgKUVSJWJd/mDsGpWLy7QX2sZOy+5NussrokNgNLOzfQl3UTqzDqUIGNxeHYzOj9BPpHM6fJ2xPGLnCWvYA0XioOaSQ8AcSmFKBbp664kzXDALyuKkmJDAgMBAAECgYB6Bhcmzk++GkvHQvlDXwQTNP2F8GKzhIbBnmVRTCrV25hWdQ0H+fWqLOOhP8pqbPxmfHYBQIr81BW6rs8jUduUjQvsqPP+jR61oApGW7iV9xuP7LH3LmTh2rFqDQVVBf9WrGuLzvX+t//fE9gc8ReJixEFglGqGFncslnVTTxKiQJBAOIBQZZnqkFZZWRxomzu9KAK8l2NHR635C2NT70CFivH/hI0pILgBJ1MZlIcjwSltD2SmwWsvQw++eIvwbWnMg8CQQDB93QSAcrvjz0GadcMz3pC5ubtVDJfOsqCyF7HPQpFflN3HJzTfVq1T1v9CnW56c0dYgH/wenPiQa3XvHPVzCNAkEArXzRYCeLpkZ9crFYQc7csc41ZmLgq6f13JHRWAG2Cz2mZ0tJzb0xTZ5MHVQW5TZeObXEkoKbTD87ismmJU+HOQJBAIeAbgaSWAmowBH16HSbkKaiFdrgAdyC/qwEfCmlm8JWcMp6I5ifLroQuYt5PirliRQovorEFamU6Ss62aRmHZUCQHjAcu3AtWlyX5kwUDwHhMg9rMMBFAi/q2y4rfTPhXfXIztZe2+Y2ecO2U/Gebj9HE/hSJpF/Aw1I3/U0Rlret8=";
//
//        String str = "{\"method\":\"UPDATE\",\"data\":{\"parkSpaceTotal\":0,\"parkName\":\"测试激活码\",\"city\":1,\"companyName\":\"\",\"groupId\":\"1\",\"parkProperty\":0,\"surplusSpace\":0,\"parkType\":0,\"feeDescribe\":\"\",\"province\":12,\"cityName\":\"安庆市\",\"tempSpace\":0,\"startTime\":\"\",\"stopTime\":\"\",\"id\":238,\"lat\":11.961627,\"createdUser\":\"\",\"parkNo\":\"001\",\"pkid\":\"ED39496252984EBB93BC83987A811108\",\"gateNumber\":0,\"address\":\"龙湖天街2\",\"lng\":116.334704,\"parkingWordFees\":[{\"wordFeeId\":\"07E35959964C436BB03C650B66B3F842\",\"pkid\":\"ED39496252984EBB93BC83987A811108\",\"timeName\":\"早间段27\",\"parkingCarModelFees\":[{\"wordFeeId\":\"07E35959964C436BB03C650B66B3F842\",\"carModelName\":\"小型车27\",\"fee\":\"5元/27分钟\",\"carModelFeeId\":\"E7E3B09F29814C149C50A16BBCD905E5\",\"id\":2206},{\"wordFeeId\":\"07E35959964C436BB03C650B66B3F842\",\"carModelName\":\"中型车27\",\"fee\":\"8元/27分钟\",\"carModelFeeId\":\"A56C9FF912E54B73B5B177C0641F752E\",\"id\":2207},{\"wordFeeId\":\"07E35959964C436BB03C650B66B3F842\",\"carModelName\":\"大型车27\",\"fee\":\"20元/27分钟\",\"carModelFeeId\":\"FEFFC586CA1F4C14AD55F2465F328B73\",\"id\":2208}],\"isDelete\":\"\",\"carModelFeeId\":\"\",\"id\":931},{\"wordFeeId\":\"29259E82D9264F72AFA9110682CBFDDF\",\"pkid\":\"ED39496252984EBB93BC83987A811108\",\"timeName\":\"晚间段27\",\"parkingCarModelFees\":[{\"wordFeeId\":\"29259E82D9264F72AFA9110682CBFDDF\",\"carModelName\":\"小型车27\",\"fee\":\"8元/27分钟\",\"carModelFeeId\":\"722179F4A2464FDA85059AC1E481153B\",\"id\":2209},{\"wordFeeId\":\"29259E82D9264F72AFA9110682CBFDDF\",\"carModelName\":\"中型车27\",\"fee\":\"15元/27分钟\",\"carModelFeeId\":\"B1C51FB04ED74024A8E23BA3072B9319\",\"id\":2210},{\"wordFeeId\":\"29259E82D9264F72AFA9110682CBFDDF\",\"carModelName\":\"大型车27\",\"fee\":\"27元/27分钟\",\"carModelFeeId\":\"CF48535CDE414D568D8D1365C846F67E\",\"id\":2211}],\"isDelete\":\"\",\"carModelFeeId\":\"\",\"id\":932}],\"collaborateType\":0,\"isDelete\":\"\",\"longTermSpace\":0,\"feeRule\":\"\",\"updateUser\":\"\",\"updateTime\":1583146590444,\"companyId\":\"1\",\"district\":1,\"activationCode\":\"\"},\"key\":\"parking_info\"}";
//        // 公钥加密，私钥解密
//        String enStr1 = "TOCFiQ1wGV59zwgjNKcbUqFS59KKeAmXq5bmo7DbSSUiU5oaXO3eGNvfvyIYjTm+3Q+dvFIPbE1HBz1wyGi/jgl7xIcZKgXzRzEH9eW1iy8iOZHHCzMbmtM7cgzHzkK0DgI8IwOW0sDv3ON7754aJEL4Pm7pAv+PllyXLtC72KF4dzznA6zFn97Ci+LNnEKmIjeVUrbtD4toOcpFDXiNeTUEr2J+GN5bIK/tK+h+sD9d013ehIvGwvbYi9ukhGMUUhn/EgL0ENcs3yQ4flm8krNo8mcrj6aysw8mhhlaIUMbUkUH1AQfnl14Bwaq/gW6LdgGFOFsVKB4LTqRx96RKkQGRjeC7IwAGR4RdZTOjzjZbAcDJ2KANcidXHP/UEemy/4fg7wBuk5g2f0CEQ5gctL645lC/8Ofy4KkFmeWUq1NxNMH//P+RZ32jPLf6SvnKGP37pmWxT1PEG2dQ9QIHJ24sP35FOGbHeG7t+12hiTaYWxCt3q0gcrUVeC97BdvBqUMCwUVs2EndBd0qQpyDgDzTbVPYC7vfISY0c/w9qyHJj2XEa7rkvUYUpLZ5vBRBtN2ZtrK0Av9X39XxyUe32N+by1aZEO0AGns8JbpI6c/nUVLaYLDjmgqz3qzEmyuMxQZ0BomrHFStKGmSpFw8b3ruv+AWgJnk3deauYqaGOg7JLksrJcWBw2mdna+3Qiw2+7/nDtzlbGGkF9mCrxbyZB/W7z69adBbRD4LZDWGLtMqwWoNPlJOHXvr0O/rMVXmKClIu/zPkO4fvYb+4+2E8vFJ5Of2qT/2C7xhEA9/Zv0dSHNvG4t41GQHVyqc9i2cm1RhM0i13YNRoX60c4NGOHkpQG0lpEorzVQ6Lod4XtGhJnAJT0ERuO4uHH3NsBzVE3N/Z1m3Csdosg9jNbEzSfuZrEDLHFOU5zFW1CqQ7PJdXdwnT2gOimrJP2BjS8HL29QZWaRnhyJzeefZZhGyvxRX765N2rFY5I+ufWuO7CzUGUwPbkvAwyia0NNUGMIWzMWrpgBGCaV4BkLkG/nPMxBHgnqv7egQsJYBl3MuiMmPhBWK/57bogTe16P1IagR4QJXl5VqfkuIzPjKoY2HHwJgqLLolWKTq0C8ARjSfBoiNCF1HGdLQ8TC0jXP7WAvWwtejxGdr4JV/8Ua/dYciF4+SPbELUa0dtSBlNxmo6iOxHK7GRZ3N3FBtsRD8q63ZpS8C9luwyk02mmypTulz39QPpECY+zCfnSNqZSi+Lb/xwMmNmiX0Uh34sOgwdazGTI4ke6jfik+3zTD3b5ieRuudQ14WMGtQaf4ON6kSVkvCsYfS4IESLrXBKumcFVB6au7FQ+Y5JsK7tbhauLA==";
//        System.out.println("公钥加密后：" + enStr1);
//        String deStr1 = RsaTool.decryptByPrivateKey(enStr1, privateKey);
//        System.out.println("私钥解密后：" + deStr1);
//        // 私钥加密，公钥解密
//        String enStr2 = RsaTool.encryptByPrivateKey(str, privateKey);
//        System.out.println("私钥加密后：" + enStr2);
//        String deStr2 = RsaTool.decryptByPublicKey(enStr2, publicKey);
//        System.out.println("公钥解密后：" + deStr2);
//        // 产生签名
//        String sign = sign(enStr2, privateKey);
//        System.out.println("签名:" + sign);
//        // 验证签名
//        boolean status = verify(enStr2, publicKey, sign);
//        System.out.println("状态:" + status);
//
//
//
//}

    //定义加密方式
    public static final String KEY_RSA = "RSA";
    //定义公钥关键词
    public static final String KEY_RSA_PUBLICKEY = "RSAPublicKey";
    //定义私钥关键词
    public static final String KEY_RSA_PRIVATEKEY = "RSAPrivateKey";
    //定义签名算法
    private final static String KEY_RSA_SIGNATURE = "MD5withRSA";
    /**
     * **
     * RSA最大加密大小
     */
    private final static int MAX_ENCRYPT_BLOCK = 117;

    /**
     * **
     * RSA最大解密大小
     */
    private final static int MAX_DECRYPT_BLOCK = 128;

    /**
     * 生成公私密钥对
     */
    public static Map<String, Object> init()
    {
        Map<String, Object> map = null;
        try
        {
            KeyPairGenerator generator = KeyPairGenerator.getInstance(KEY_RSA);
            //设置密钥对的bit数，越大越安全，但速度减慢，一般使用512或1024
            generator.initialize(1024);
            KeyPair keyPair = generator.generateKeyPair();
            // 获取公钥
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
            // 获取私钥
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            // 将密钥对封装为Map
            map = new HashMap<String, Object>();
            map.put(KEY_RSA_PUBLICKEY, publicKey);
            map.put(KEY_RSA_PRIVATEKEY, privateKey);
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        return map;
    }

    /**
     * 获取Base64编码的公钥字符串
     */
    public static String getPublicKey(Map<String, Object> map)
    {
        String str = "";
        Key key = (Key) map.get(KEY_RSA_PUBLICKEY);
        str = encryptBase64(key.getEncoded());
        return str;
    }

    /**
     * 获取Base64编码的私钥字符串
     */
    public static String getPrivateKey(Map<String, Object> map)
    {
        String str = "";
        Key key = (Key) map.get(KEY_RSA_PRIVATEKEY);
        str = encryptBase64(key.getEncoded());
        return str;
    }

    /**
     * BASE64 解码
     *
     * @param key 需要Base64解码的字符串
     * @return 字节数组
     */
    public static byte[] decryptBase64(String key)
    {
        return Base64.getDecoder().decode(key);
    }

    /**
     * BASE64 编码
     *
     * @param key 需要Base64编码的字节数组
     * @return 字符串
     */
    public static String encryptBase64(byte[] key)
    {
        return new String(Base64.getEncoder().encode(key));
    }

    /**
     * 公钥加密
     *
     * @param encryptingStr
     * @param publicKeyStr
     * @return
     */
    public static String encryptByPublicKey(String encryptingStr, String publicKeyStr)
    {
        try
        {
            // 将公钥由字符串转为UTF-8格式的字节数组
            byte[] publicKeyBytes = decryptBase64(publicKeyStr);
            // 获得公钥
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
            // 取得待加密数据
            byte[] data = encryptingStr.getBytes("UTF-8");
            KeyFactory factory;
            factory = KeyFactory.getInstance(KEY_RSA);
            PublicKey publicKey = factory.generatePublic(keySpec);
            // 对数据加密
            Cipher cipher = Cipher.getInstance(factory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            // 返回加密后由Base64编码的加密信息
            int inputLen = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0)
            {
                if (inputLen - offSet > MAX_ENCRYPT_BLOCK)
                {
                    cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
                } else
                {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            return encryptBase64(decryptedData);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 私钥解密
     *
     * @param encryptedStr
     * @param privateKeyStr
     * @return
     */
    public static String decryptByPrivateKey(String encryptedStr, String privateKeyStr)
    {
        try
        {
            // 对私钥解密
            byte[] privateKeyBytes = decryptBase64(privateKeyStr);
            // 获得私钥
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            // 获得待解密数据
            byte[] data = decryptBase64(encryptedStr);
            KeyFactory factory = KeyFactory.getInstance(KEY_RSA);
            PrivateKey privateKey = factory.generatePrivate(keySpec);
            // 对数据解密
            Cipher cipher = Cipher.getInstance(factory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            // 返回UTF-8编码的解密信息
            int inputLen = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0)
            {
                if (inputLen - offSet > MAX_DECRYPT_BLOCK)
                {
                    cache = cipher.doFinal(data, offSet, MAX_DECRYPT_BLOCK);
                } else
                {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            return new String(decryptedData, "UTF-8");
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 私钥加密
     *
     * @param encryptingStr
     * @param privateKeyStr
     * @return
     */
    public static String encryptByPrivateKey(String encryptingStr, String privateKeyStr)
    {
        try
        {
            byte[] privateKeyBytes = decryptBase64(privateKeyStr);
            // 获得私钥
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            // 取得待加密数据
            byte[] data = encryptingStr.getBytes("UTF-8");
            KeyFactory factory = KeyFactory.getInstance(KEY_RSA);
            PrivateKey privateKey = factory.generatePrivate(keySpec);
            // 对数据加密
            Cipher cipher = Cipher.getInstance(factory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            // 返回加密后由Base64编码的加密信息
            int inputLen = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0)
            {
                if (inputLen - offSet > MAX_ENCRYPT_BLOCK)
                {
                    cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
                } else
                {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            return encryptBase64(decryptedData);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 公钥解密
     *
     * @param encryptedStr
     * @param publicKeyStr
     * @return
     */
    public static String decryptByPublicKey(String encryptedStr, String publicKeyStr)
    {
        try
        {
            // 对公钥解密
            byte[] publicKeyBytes = decryptBase64(publicKeyStr);
            // 取得公钥
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
            // 取得待加密数据
            byte[] data = decryptBase64(encryptedStr);
            KeyFactory factory = KeyFactory.getInstance(KEY_RSA);
            PublicKey publicKey = factory.generatePublic(keySpec);
            // 对数据解密
            Cipher cipher = Cipher.getInstance(factory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            // 返回UTF-8编码的解密信息
            int inputLen = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0)
            {
                if (inputLen - offSet > MAX_DECRYPT_BLOCK)
                {
                    cache = cipher.doFinal(data, offSet, MAX_DECRYPT_BLOCK);
                } else
                {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            return new String(decryptedData, "UTF-8");
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 用私钥对加密数据进行签名
     *
     * @param encryptedStr
     * @param privateKey
     * @return
     */
    public static String sign(String encryptedStr, String privateKey)
    {
        String str = "";
        try
        {
            //将私钥加密数据字符串转换为字节数组
            byte[] data = encryptedStr.getBytes();
            // 解密由base64编码的私钥
            byte[] bytes = decryptBase64(privateKey);
            // 构造PKCS8EncodedKeySpec对象
            PKCS8EncodedKeySpec pkcs = new PKCS8EncodedKeySpec(bytes);
            // 指定的加密算法
            KeyFactory factory = KeyFactory.getInstance(KEY_RSA);
            // 取私钥对象
            PrivateKey key = factory.generatePrivate(pkcs);
            // 用私钥对信息生成数字签名
            Signature signature = Signature.getInstance(KEY_RSA_SIGNATURE);
            signature.initSign(key);
            signature.update(data);
            str = encryptBase64(signature.sign());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 校验数字签名
     *
     * @param encryptedStr
     * @param publicKey
     * @param sign
     * @return 校验成功返回true，失败返回false
     */
    public static boolean verify(String encryptedStr, String publicKey, String sign)
    {
        boolean flag = false;
        try
        {
            //将私钥加密数据字符串转换为字节数组
            byte[] data = encryptedStr.getBytes();
            // 解密由base64编码的公钥
            byte[] bytes = decryptBase64(publicKey);
            // 构造X509EncodedKeySpec对象
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytes);
            // 指定的加密算法
            KeyFactory factory = KeyFactory.getInstance(KEY_RSA);
            // 取公钥对象
            PublicKey key = factory.generatePublic(keySpec);
            // 用公钥验证数字签名
            Signature signature = Signature.getInstance(KEY_RSA_SIGNATURE);
            signature.initVerify(key);
            signature.update(data);
            flag = signature.verify(decryptBase64(sign));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }
}
