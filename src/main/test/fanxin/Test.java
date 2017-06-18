package fanxin;

import domain.Book1;
import domain.Book2;
import domain.Student;

import java.util.ArrayList;

/**
 * Created by 陈涛 on 2017/6/18.
 */
public class Test {
    public static void main(String[] args) {
        Student<Book1,Book2> tStudent = new Student<Book1, Book2>();
        ArrayList<Book1> book1s = new ArrayList<Book1>();
        Book1 book1 = new Book1();
        book1s.add(book1);
        tStudent.setBook1List(book1s);
        //
        ArrayList<Book2> book2s = new ArrayList<Book2>();
        Book2 book2 = new Book2();
        book2s.add(book2);
        tStudent.setBook2List(book2s);

    }
}
