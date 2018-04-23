package cn.sicau.count.utils;

/**
 * @author yelei
 * @date 18-4-21
 */
public class ScoreUtil {
    public static double yaAndCheng[]=new double[]{9.0,7.0,6.0,5.0,4.0,3.0,2.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
    public static double getAvgYaAndCheng(int start,int end){
        return getAvg(start,end,0);
    }


    public static double duJiangyan[]=new double[]{7.0,5.0,4.0,3.0,2.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
    public static double getAvgDuJiangYan(int start,int end){
        return getAvg(start,end,1);
    }

    public static double sumFinle[]=new double[]{27.0,21.0,18.0,15.0,12.0,9.0,6.0,3.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
    public static double getAvgFinle(int start,int end){
        return getAvg(start,end,10);
    }

    private static double getAvg(int start,int end,int xiaoqu){
        double result=0.0;
        double source[];

        if (xiaoqu==0){
            source=yaAndCheng;
        }else if(xiaoqu==10){
            source=sumFinle;
        }else {
            source=duJiangyan;
        }
        for (int i = start; i < end; i++) {
            result+=source[i];
        }

        return result/(end-start);
    }
}
