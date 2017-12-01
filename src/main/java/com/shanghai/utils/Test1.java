package com.shanghai.utils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 陈涛 on 2017/11/23.
 */
public class Test1 {
    public static void main(String[] args){
        String[] atp = {"qq","bb","cc"};
        List<String> strings = Arrays.asList(atp);
        for(String aa : strings){
            System.out.println(aa);
        }
       for(int i=0;i<strings.size();i++){
           System.out.println(strings.get(i));
       }

        for(int i=1;i<=9;i++){

            for (int j=1;j<=i;j++){
                System.out.print(""+j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }

        System.out.println("=======================");
        for(int i=1;i<=9;i++){

            for (int j=i;j<=9;j++){
                System.out.print(""+i+"*"+j+"="+i*j+"\t");
            }
            System.out.println();
        }

        System.out.println("=======================");

        for(int i=1;i<=9;i++){

            for (int j=1;j<=9;j++){
                System.out.print(""+i+"*"+j+"="+i*j+"\t");
            }
            System.out.println();
        }
    }


}
