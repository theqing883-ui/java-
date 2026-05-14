package com.itheima.pojo;

public class Account {
    private Integer id;
    private String name;
    private Integer money;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
