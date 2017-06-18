package fanxin;

import domain.SimpleGen;
import domain.SimpleGen2;

/**
 * Created by tao on 2017/6/18.
 */
public class Test2 {
    public static void main(String[] args) {
        SimpleGen simpleGen = new SimpleGen(new Integer(99));
        Integer ob = (Integer) simpleGen.getOb();
        System.out.println(ob);
        SimpleGen2<Integer> simpleGen2 = new SimpleGen2(new Integer(99));
        Integer ob1 = simpleGen2.getOb();
        System.out.println(ob1);
    }
}
