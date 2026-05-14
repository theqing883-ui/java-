package com.hsp.string_;

public class StringMethod {
    public static void main(String[] args) {
        //equals()
        String s1 = "hello";
        String s2 = "Hello";
        System.out.println(s1.equals(s2));

        //equalsIgnoreCase
        System.out.println(s1.equalsIgnoreCase(s2));
        //length
        System.out.println(s1.length());
        //indexOf 获取字符在字符串中对象中第一次出现的位置，索引从0开始，找不到则返回-1
        String s3 = "hello1212";
        System.out.println(s3.indexOf('3'));
        System.out.println(s3.indexOf("he"));
        //lastIndexOf 获取字符在字符串中对象中最后一次出现的位置，索引从0开始，找不到则返回-1
        System.out.println("LastIndexOf" + s3.lastIndexOf('1'));
        System.out.println(s3.lastIndexOf("12"));
        //substring 截取指定范围的子串
        String s4 = "hello,张三";
        System.out.println(s4.substring(6));//截取索引6及其以后得
        System.out.println(s4.substring(0, 5));//截取索引[0,5)的字符


        //toUppercase 和toLowerCase
        System.out.println("====================");
        String s5 = "hello";
        String s6 = "RWDSDS";
        System.out.println(s5.toUpperCase());
        System.out.println(s5);//未改变原对象
        System.out.println(s6.toLowerCase());
        System.out.println(s6);
        //contact
        String s7 = "x";
        s1 = s7.concat("l").concat("f").concat("h").concat("together");
        System.out.println(s1);
        //replace
        s1 = "hello, world,world,world";
        System.out.println(s1);
        s1 = s1.replace("world", "people");//把world换成people
        System.out.println(s1);
        //split 分割字符串，对于某些字符，需要转义字符\
        String s8 = "锄禾日当午，汗滴禾下土，谁知盘中餐，粒粒皆辛苦";
        String[] s9 = s8.split("，");
        for (String s : s9) {
            System.out.println(s);
        }
        String s10 = "C:\\Users\\the_qing\\Desktop\\会议记录\\支部党员大会（6月以后）";
        String[] s11 = s10.split("\\|");//由于原字符串中没有 | 字符，所以不会发生分割
        String[] s12 = s10.split("\\\\");
        for (String s : s11) {
            System.out.println(s);
        }
        for (int i = 0; i < s12.length; i++) {
            System.out.println(s12[i]);
        }
        System.out.println(s12);
        //toCharArray 转化为字符数组
        String s13 = "happy";
        char[] c = s13.toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
        //compareTo 前者大返回正数，后者大返回负数[看源码]
        String s14 = "aa";
        String s15 = "aA";
        System.out.println(s14.compareTo(s15));//返回'a'-A的值
        //format 格式字符串
        String name = "join";
        int age = 18;
        double score = 18.5;
        char gender = '男';
        String info = "姓名：" + name + " 年龄 " + age + " 分数 " + score + " 性别 " + gender;
        System.out.println(info);
        //%s,%c,%d,%.2f[保留小数点后两位，四舍五入]
        String formatStr = "姓名：%s 年龄 %d  分数  %.2f 性别 %c";
        String info2 = String.format(formatStr, name, age, score, gender);
        System.out.println(info2);


    }
}
