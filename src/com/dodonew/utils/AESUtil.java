package com.dodonew.utils;

import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

/**
 * Created by yukx on 17/4/22.
 */
public class AESUtil {
    Logger logger = Logger.getLogger(AESUtil.class);

    public static boolean initialized = false;

    /**
     * AES解密
     *
     * @return
     * @throws InvalidAlgorithmParameterException
     * @throws NoSuchProviderException
     */
    public static JSONObject decrypt(String key, String data, String iv) throws InvalidAlgorithmParameterException {
        byte[] keyByte = Base64.decodeBase64(key);
        byte[] ivByte = Base64.decodeBase64(iv);
        byte[] content = Base64.decodeBase64(data);
        initialize();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Key sKeySpec = new SecretKeySpec(keyByte, "AES");

            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(ivByte));// 初始化
            byte[] resultByte = cipher.doFinal(content);
            if (null != resultByte && resultByte.length > 0) {
                String userInfo = new String(resultByte, "UTF-8");
                System.out.println(userInfo);
                JSONObject json = JSONObject.fromObject(userInfo);
                return json;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void initialize() {
        if (initialized) return;
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }

    //生成iv
    public static AlgorithmParameters generateIV(byte[] iv) throws Exception {
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(iv));
        return params;
    }

    public static void main(String[] args) {
        String encryptedData = "0sJG+51mBtTLcmYMKYK4oXdDerCwA/wmmRUeZV4zoZjGa7olJXjXYC/O/Rl3NXJ9zwZGf5iAoF3eFy//J9uOmFrrj943ejHBvPRu+HbgFD/UQJC7rStl+ulTxRyT/uY/v2iBHfZEeBhgBcQWe7INyK1Vx48uqVYidHTiBlrkPjKGF/TIWInj2mzkvhNxTjiWadMo6J/hih8cJSVmTFubGD9i/iZIYqO0TF8moKgSqPdhH3NsA3R3zREkNWI1AQKgZCRd9xM/ijYwKysf+5L0r8sWl0c2rDbEPtFMGRLfVBY0xqFHZNAPC96+4qkM2gncgaccqf8YTTP3mFoiRCgvMD+HcjgCw36M7TTswTSahCiKyUvBYTJ80Mlm0V4CbFNHWin8+eZZAHbJQ5nvIIzUfvbtbouTldbva6QrBxm7e9XjMUxQ74g3HTYepnMIYLFJP0e/xmP5npiq3HBza3I8YQ==";
        String iv = "cUrh0VhWnNDUYF6xNtYqkQ==";
        String session_key = "r844PiPEIFfZYzNKiXHs7g==";
        try {
            JSONObject object = AESUtil.decrypt(session_key, encryptedData, iv);
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        {
          "openId": "o-Ofs0Ny7jC6FzM9XBojD23IhOnM",
          "nickName": "yukx",
          "gender": 1,
          "language": "zh_CN",
          "city": "Yueyang",
          "province": "Hunan",
          "country": "CN",
          "avatarUrl": "http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJj3N9WvKoQia9prJtFO32jqUV307JZ0qrFx4NSJ0Gibu5jMSiauDHK7uT4FdQ3u2OyVeCu7hakLTUkQ/0",
          "unionId": "oYaDHs-ldJZZekLnIKlIfZOnXnzw",
          "watermark": {
            "timestamp": 1492840053,
            "appid": "wx2972fce28f00a5ce"
          }
        }
        */
    }
}
