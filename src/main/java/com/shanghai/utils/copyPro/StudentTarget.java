package com.shanghai.utils.copyPro;

import java.util.Date;

/**
 * Created by 陈涛 on 2017/6/14.
 */
public class StudentTarget {
    private String name;
    private String marr;
   private Date StudentDate;
    private Date StudentDate2;

    public Date getStudentDate2() {
        return StudentDate2;
    }

    public void setStudentDate2(Date studentDate2) {
        StudentDate2 = studentDate2;
    }
    public Date getStudentDate() {
        return StudentDate;
    }

    public void setStudentDate(Date studentDate) {
        StudentDate = studentDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarr() {
        return marr;
    }

    public void setMarr(String marr) {
        this.marr = marr;
    }

    @Override
    public String toString() {
        return "StudentTarget{" +
                "name='" + name + '\'' +
                ", marr='" + marr + '\'' +
                ", StudentDate=" + StudentDate +
                '}';
    }
}
