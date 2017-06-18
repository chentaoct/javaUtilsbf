package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈涛 on 2017/6/18.
 */
public class Student<A,B> {
    private String studentName;
    private List<A>  Book1List;
    private List<B>  Book2List;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<A> getBook1List() {
        return Book1List;
    }

    public void setBook1List(List<A> book1List) {
        Book1List = book1List;
    }

    public List<B> getBook2List() {
        return Book2List;
    }

    public void setBook2List(List<B> book2List) {
        Book2List = book2List;
    }
}
