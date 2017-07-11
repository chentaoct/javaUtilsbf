package choujiang.four;

import domain.PrizesWeightDomain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 陈涛 on 2017/7/10.
 */
public class Test3 {
    public static void main(String[] args) {
        Random random = new Random();
        Integer n = random.nextInt(1000);
        System.out.println(n);
        PrizesWeightDomain prizesWeightDomain = testWard();
        System.out.println(prizesWeightDomain);

    }

    private static PrizesWeightDomain testWard() {
        ArrayList<PrizesWeightDomain> categorys = new ArrayList<PrizesWeightDomain>();
        PrizesWeightDomain prizesWeightDomain = new PrizesWeightDomain();
        prizesWeightDomain.setPrizesName("杯子");
        prizesWeightDomain.setNum(10);
        prizesWeightDomain.setWeight(1);
        categorys.add(prizesWeightDomain);

        PrizesWeightDomain prizesWeightDomain2 = new PrizesWeightDomain();
        prizesWeightDomain2.setPrizesName("杯子2");
        prizesWeightDomain2.setNum(10);
        prizesWeightDomain2.setWeight(2);
        categorys.add(prizesWeightDomain2);


        PrizesWeightDomain prizesWeightDomain3 = new PrizesWeightDomain();
        prizesWeightDomain3.setPrizesName("谢谢参与");
        prizesWeightDomain3.setNum(10);
        prizesWeightDomain3.setWeight(7);
        categorys.add(prizesWeightDomain3);

        Random random = new Random();
        Integer weightSum = 0;
        for (PrizesWeightDomain wc : categorys) {
            weightSum +=wc.getWeight();
        }
        if (weightSum <= 0) {
        }
        Integer n = random.nextInt(weightSum); // n in [0, weightSum)
        Integer m = 0;
        for (PrizesWeightDomain wc : categorys) {
            System.out.println("wc.getWeight():"+wc.getWeight());
           int n2 = m + wc.getWeight();
            System.out.println("************************开始："+m+"结束:"+n2);
            if (m <= n && n < n2) {
                System.out.println("=====n:"+n+"n2:"+n2);
                //return wc;a
            }
            m += wc.getWeight();
        }
        return null;
    }

}
