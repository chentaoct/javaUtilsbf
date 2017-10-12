package fanxin;

/**
 * Created by 陈涛 on 2017/7/24.
 */
public class Test5 {
    public static void main(String[] args) {
//使用Point<?>
        Point<?> point1 = new Point(new Integer(23),new Integer(23));
//直接使用Point
        Point point3 = new Point(new Integer(23),new Integer(23));
        point3.setX(23);
    }
}
