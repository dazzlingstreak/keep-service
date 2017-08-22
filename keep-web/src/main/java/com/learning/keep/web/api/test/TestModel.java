package com.learning.keep.web.api.test;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by huangdawei on 2017/8/15.
 */
//@XmlRootElement(name = "testModel")
public class TestModel {

    private String name;

    private Integer age;

    private Date birthday;

    private Double salary;

    private Boolean married;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }
}
