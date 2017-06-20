package fanxin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao on 2017/6/18.
 */
public class Test3 {
    public static void main(String[] args) {
      say();
    }

    private static void say() {
        List<String> l1 = new ArrayList<String>();
        l1.add("String");
        List<?> l2 = l1;
        System.out.println(l2.get(0));
    }
}
