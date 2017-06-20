package fanxin;

/**
 * Created by tao on 2017/6/18.
 */
public class GenericsDemo14 {
    public static void main(String args[]){
        Info<String> i = new Info<String>() ;       // 使用String为泛型类型
        i.setVar("it") ;                            // 设置内容
        fun(i) ;
    }
    public static void fun(Info<?> temp){     // 可以接收任意的泛型对象
        System.out.println("内容：" + temp) ;
    }
}
