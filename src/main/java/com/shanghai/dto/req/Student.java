package com.shanghai.dto.req;

import com.shanghai.dto.PageInfo;

import java.util.List;

/**
 * Created by 陈涛 on 2017/6/18.
 */
public class Student extends PageInfo {
    private String studentName;
    private Book1 book1;
    private Book2 book2;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Book1 getBook1() {
        return book1;
    }

    public void setBook1(Book1 book1) {
        this.book1 = book1;
    }

    public Book2 getBook2() {
        return book2;
    }

    public void setBook2(Book2 book2) {
        this.book2 = book2;
    }
}
