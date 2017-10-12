package fanxin;

import domain.Book1;

import java.util.ArrayList;

/**
 * Created by 陈涛 on 2017/7/14.
 */
public class Test4 {
    public static void main(String[] args) {
        Card card = new Card();
        ArrayList<Book1> book1s = new ArrayList<Book1>();
        Book1 book1 = new Book1();
        book1.setBook1Name("99999999999999999");
        book1s.add(book1);
        card.setDataBody(book1s);
        ArrayList<Book1> dataBody = (ArrayList<Book1>) card.getDataBody();
        for (Book1 book11 : dataBody) {
            System.out.println(book11.getBook1Name());
        }
    }
}

