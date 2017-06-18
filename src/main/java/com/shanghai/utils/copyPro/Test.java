package com.shanghai.utils.copyPro;

import org.apache.commons.beanutils.*;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 陈涛 on 2017/6/14.
 */
public class Test {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        StudentSource studentSource = new StudentSource();
        studentSource.setName("小明");
        studentSource.setStudentDate("2016-11-20");
        StudentTarget studentTarget = new StudentTarget();


       BeanUtils.copyProperties(studentSource,studentTarget);
        System.out.println(studentTarget.toString());
    }
}
