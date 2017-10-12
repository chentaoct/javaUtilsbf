package fanxin;

/**
 * Created by 陈涛 on 2017/7/24.
 */
public class Point<T> {

    private T x;       // 表示X坐标
    private T y;       // 表示Y坐标

    public Point(){

    }
    public Point(T x,T y){
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
}
