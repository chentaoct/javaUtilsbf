package fanxin;

/**
 * Created by 陈涛 on 2017/7/14.
 */
public class Card<T> {
    private T dataBody;

    public T getDataBody() {
        return dataBody;
    }

    public void setDataBody(T dataBody) {
        this.dataBody = dataBody;
    }
}
