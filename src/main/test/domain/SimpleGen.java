package domain;

/**
 * Created by 陈涛 on 2017/6/18.
 */
public class SimpleGen {
    private Object ob;

    public SimpleGen(Object ob) {
        this.ob = ob;
    }

    public Object getOb() {
        return ob;
    }

    public void setOb(Object ob) {
        this.ob = ob;
    }

    public void showType() {
        System.out.println(ob.getClass().getName());
    }

}
