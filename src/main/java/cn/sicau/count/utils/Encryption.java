package cn.sicau.count.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yelei on 17-7-22.
 */
public class Encryption {
    public static String md5(String passWord){
        String newPass="";
        try{
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            byte[] encodeMd5Digest=messageDigest.digest(passWord.getBytes());
            newPass=converByteToHexString(encodeMd5Digest);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return newPass;
    }
    public static String converByteToHexString(byte[] bytes) {
        String result = "";
        for (int i = 0; i < bytes.length; i++) {
            int temp = bytes[i] & 0Xff;
            String tempHex = Integer.toHexString(temp);
            if (tempHex.length() < 2) {
                result += "0" + tempHex;
            } else {
                result += tempHex;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(md5("sicau"));

    }
}
