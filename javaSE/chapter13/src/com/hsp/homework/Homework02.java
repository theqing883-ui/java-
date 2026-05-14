package com.hsp.homework;

public class Homework02 {
    public static void main(String[] args) {
        String name = "xxx";
        String key = "123456";
        String mail = "123@qq.com";

        //用try处理
        try {
            userRegister(name, key, mail);
            System.out.println("注册成功！");
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }


    }

    public static void userRegister(String name, String key, String mail) {
        //用户名校验
        if (!(name.length() >= 2 && name.length() <= 4)) {
            throw new RuntimeException("用户名长度不正确！");
        }
        //密码校验
       /* if (key.length() != 6) {
            throw new RuntimeException("密码长度不对！");
        } else {
            try {
                Integer.parseInt(key);
            } catch (Exception e) {
                throw new RuntimeException("密码必须全部是数字");
            }
        }*/
//        System.out.println(isDigital(key));
        if (!(key.length() == 6 && isDigital(key))) {

            throw new RuntimeException("密码不对！");
        }

       //邮箱校验
//        StringBuffer sb = new StringBuffer(mail);
        int index = -1;
        index = mail.indexOf("@");
        int index2 = -1;
        index2 =mail.indexOf(".");
        if (index == -1 || index2 == -1 || index > index2) {
            throw new RuntimeException("邮箱必须包含@和. 并且@在.前面！");
        }
    }
    public static boolean isDigital(String key){
//        System.out.println(key.toString());
        char[] chars = key.toCharArray();

        boolean isDigital = true;
        for (int i = 0; i < chars.length; i++) {
            if (!(chars[i] >= '0' && chars[i] <= '9')) {
                isDigital = false;
//                System.out.println(isDigital);
            }
        }
        return isDigital;
    }
}
