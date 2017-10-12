import io.swagger.models.auth.In;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 陈涛 on 2017/6/2.
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");
        Date repayDate = time.parse("2017-7-31");
        if(repayDate!=null){
            Calendar calendar =  new GregorianCalendar();
            calendar.setTime(repayDate);
            calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
            repayDate=calendar.getTime();
            System.out.println(repayDate);
        }
       /* String phone="1231234123411";
        String s = phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        System.out.println(s);
        String idCard="123456789012345678";
        String s1 = idCard.replaceAll("(\\d{4})\\d{10}(\\w{4})", "$1*****$2");
        System.out.println(s1);*/
        //test2();

    }

    private static void test2() {
    int a = 8888;
        int sum=0;
        for (int i = 8888; i <=9999 ; i++) {
            sum=sum+i;
        }
        System.out.println(sum);
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
