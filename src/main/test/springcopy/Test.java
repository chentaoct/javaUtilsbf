package springcopy;

import domain.Book1;
import org.springframework.beans.BeanUtils;

/**
 * Created by 陈涛 on 2017/7/20.
 */
public class Test {
    public static void main(String[] args) {
      Ss2 ss2 = new Ss2();
        ss2.setName("111111111111111");
        ss2.setAge("2222222222222222");
        Book1 book1 = new Book1();
        book1.setBook1Name("3333333333333333");
        ss2.setBook1(book1);
        Tt1 tt1 = new Tt1();
        BeanUtils.copyProperties(ss2, tt1);
        System.out.println(tt1);

        System.out.println(tt1.getBook1().getBook1Name());


    }
}
