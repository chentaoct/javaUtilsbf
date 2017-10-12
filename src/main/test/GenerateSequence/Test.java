package GenerateSequence;

import java.util.Random;

/**
 * Created by 陈涛 on 2017/7/18.
 */
public class Test {
    public static void main(String[] args) {
        //String s = GenerateSequenceUtil.generateSequenceNo();
       // System.out.println(s);
      /*  int i=0;
        while (i < 20) {
            System.out.println(getFixLenthString(11));
            i++;
        }*/
        getRadom(11);
    }

    private static void getRadom(int length) {
        //获取一个随机数
        double rand = Math.random();
        //将随机数转换为字符串
        String str = String.valueOf(rand).replace("0.", "");
        //截取字符串
        String newStr = str.substring(0, length);
        System.out.println(newStr);
    }

    /*
 * 返回长度为【strLength】的随机数，在前面补0
 */
    private static String getFixLenthString(int strLength) {

        Random rm = new Random(1000000000);

        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);

        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);

        // 返回固定的长度的随机数
        return fixLenthString.substring(1, strLength + 1);
    }
}
