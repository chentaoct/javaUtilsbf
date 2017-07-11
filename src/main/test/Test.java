import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈涛 on 2017/6/2.
 */
public class Test {
    public static void main(String[] args) {
       test11();


    }

    private static void test11() {
        List<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i <1000 ; i++) {

            integers.add(i);
            if(i%100==0){
                System.out.println("i:"+i+"=============="+integers.size());
                integers=new ArrayList<Integer>();
            }
        }
    }
}
