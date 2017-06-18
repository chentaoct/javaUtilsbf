package com.shanghai.utils.copyPro;

import org.springframework.beans.BeanUtils;

/**
 * Created by 陈涛 on 2017/6/14.
 */
public class Test {
    public static void main(String[] args) {
        StudentSource studentSource = new StudentSource();
        studentSource.setName("小明");

        StudentTarget studentTarget = new StudentTarget();

        BeanUtils.copyProperties(studentSource,studentTarget);
        System.out.println(studentTarget.toString());
    }
}
