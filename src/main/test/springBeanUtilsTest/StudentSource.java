package springBeanUtilsTest;

import java.util.Date;

/**
 * Created by 陈涛 on 2017/6/14.
 */
public class StudentSource {
    private String name;
    private  String age;
    private String StudentDate;
    private Date StudentDate2;

    public Date getStudentDate2() {
        return StudentDate2;
    }

    public void setStudentDate2(Date studentDate2) {
        StudentDate2 = studentDate2;
    }

    public String getStudentDate() {
        return StudentDate;
    }

    public void setStudentDate(String studentDate) {
        StudentDate = studentDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentSource{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", StudentDate=" + StudentDate +
                '}';
    }
}
