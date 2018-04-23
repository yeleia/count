package cn.sicau.count.utils;

import freemarker.template.utility.StringUtil;
import org.apache.commons.lang.StringUtils;

import java.util.Scanner;

/**
 * @author yelei
 * @date 18-4-19
 */
public class TimeUtil {
    public static int timeCompare(String a,String b){
        int amin=0,asec=0,amm=0,adda=0;
        int bmin=0,bsec=0,bmm=0,addb=0;
        if(a.length()>8)adda=a.charAt(8)-'0';
        if(b.length()>8)addb=b.charAt(8)-'0';
        amm=Integer.parseInt(a.substring(a.indexOf(".")+1,8));
        bmm=Integer.parseInt(b.substring(b.indexOf(".")+1,8));
        if (a.contains(":")){
            asec=Integer.parseInt(a.substring(a.indexOf(":")+1,a.indexOf(".")));
            amin=Integer.parseInt(a.substring(0,a.indexOf(":")));
        }else {
            asec=Integer.parseInt(a.substring(0,a.indexOf(".")));
        }
        if (b.contains(":")){
            bsec=Integer.parseInt(b.substring(b.indexOf(":")+1,b.indexOf(".")));
            bmin=Integer.parseInt(b.substring(0,b.indexOf(":")));
        }else {
            bsec=Integer.parseInt(b.substring(0,b.indexOf(".")));
        }
      /*  System.out.println(amin+" "+asec+" "+amm);
        System.out.println(bmin+" "+bsec+" "+bmm);*/
        if (amin!=bmin){
            return amin-bmin;
        }
        if (asec!=bsec){
            return asec-bsec;
        }
        if (amm!=bmm){
            return amm-bmm;
        }
        if(adda!=addb)
            return adda-addb;
        return 0;
    }

    public static String get8bitTime(String score){
        return get8bitTime(score,9);
    }

    public static String get8bitTime(String score,int n){
        StringBuffer buffer=new StringBuffer();
        if (score.length()<8){
            int pointIndex=score.indexOf(".");
            if(!score.contains(":")){
                buffer.append("00:");
                if (pointIndex<2){
                    buffer.append("0").append(score.substring(0,2));
                }else {
                    buffer.append(score.substring(0,3));
                }
            }else{
                int fenIndex=score.indexOf(":");
                if (fenIndex<2){
                    buffer.append("0").append(score.substring(0,2));
                }else {
                    buffer.append(score.substring(0,3));
                }
                if (pointIndex<fenIndex+3){
                    buffer.append("0").append(score.substring(fenIndex+1,fenIndex+3));
                }else {
                    buffer.append(score.substring(fenIndex+1,fenIndex+4));
                }
            }
            //处理mm
            buffer.append(score.substring(pointIndex+1));
            if (pointIndex>score.length()-3) {
                buffer.append("0");
            }
        }else if(score.length()>8){
            if (n==8){
                buffer.append(score.substring(0,n));
            }
            buffer.append(score.substring(0));
        }else {
            return score;
        }
        return buffer.toString();
    }
    public static String conver(String ss,String pro){
        String s=ss;
        if (ss.length()>8){
            s=s.substring(0,8);
        }
        int a= Integer.parseInt(StringUtils.substringBefore(s,":"));
        if (pro.equals("001006")||pro.equals("001007")||pro.equals("001008")||pro.equals("001009")
                ||pro.equals("002006")||pro.equals("002007")||pro.equals("002008")||pro.equals("002009")) {
            if (a == 0) {
               // System.out.println(StringUtils.substringAfter(s, ":"));
                if(s.charAt(3)=='0'){
                    return s.substring(4)+"米";
                }else {
                    return s.substring(3)+"米";
                }
            }else {
                return s;
            }
        }else {
            return s;
        }

    }

    public static void main(String[] args) {
        System.out.println(timeCompare("00:12.09","00:12.04"));

    }


}
