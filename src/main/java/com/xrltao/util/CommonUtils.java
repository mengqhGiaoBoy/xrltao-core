package com.xrltao.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/** 常用工具类
 * @author mengqh
 * @version 1.0
 * @date 2020/1/12 17:02
 * @Description
 */
public class CommonUtils {

    /* 获取32位UUID
     * @author mengqh
     * @date 2020/1/12 17:16
     * @param []
     * @return java.lang.String
     * @description
     */
    public static String weChatGenerateUUID(){
        String uuid = UUID.randomUUID().toString()
                .replaceAll("-","")
                .substring(0, 32);

        return uuid;
    }

    public static String weChatMD5(String data) {
        try {
            // 加密算法为MD5
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digests = md5.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            // 遍历节点
            for (byte digest : digests) {
                sb.append(Integer.toHexString((digest & 0XFF) | 0x100).substring(1,3));
            }
            return sb.toString().toUpperCase();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;
    }

}
