package com.hspedu.annotation;

import java.util.ArrayList;
import java.util.List;

/*all，抑制所有警告
boxing，抑制与封装/拆装作业相关的警告
cast，抑制与强制转型作业相关的警告
dep-ann，抑制与淘汰注释相关的警告
deprecation，抑制与淘汰的相关警告
fallthrough，抑制与switch陈述式中遗漏break相关的警告
            finally，抑制与未传回finally区块相关的警告
hiding，抑制与隐藏变数的区域变数相关的警告
incomplete-switch，抑制与switch陈述式(enum case)中遗漏项目相关的警告
javadoc，抑制与javadoc相关的警告
nls，抑制与非nls字串文字相关的警告
            null，抑制与空值分析相关的警告
rawtypes，抑制与使用raw类型相关的警告
resource，抑制与使用Closeable类型的资源相关的警告
restriction，抑制与使用不建议或禁止参照相关的警告
serial，抑制与可序列化的类别遗漏serialVersionUID栏位相关的警告
static-access，抑制与静态存取不正确相关的警告
static-method，抑制与可能宣告为static的方法相关的警告
            super，抑制与置换方法相关但不含super呼叫的警告
synthetic-access，抑制与内部类别的存取未最佳化相关的警告
sync-override，抑制因为置换同步方法而遗漏同步化的警告
unchecked，抑制与未检查的作业相关的警告
unqualified-field-access，抑制与栏位存取不合格相关的警告
unused，抑制与未用的程式码及停用的程式码相关的警告

import java.util.ArrayList;
import java.util.List;*/

public class SuppressWarning_ {
    /*
    * 1.当我们不想要看见这些警告时，我们可以使用@SuppressWarning({""})
    * 2.在{""}中写你想要抑制的信息,在上面选
    * 3.关于@SuppressWarning作用范围，与你放置的位置相关
    *  【如写在main方法前，作用范围就在main】通常可以放在方法、类、某条语句前
    * 5.源码
    *  1）放置位置 TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE
    *  2）该注解类有一个String[] value();可以传入一个数组
    *
    *  @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface SuppressWarnings {

        String[] value();
        }
    * */
//    @SuppressWarnings("all")
    @SuppressWarnings("rawtypes,unchecked,unused")
    public static void main(String[] args) {
    List list = new ArrayList();//集合
    list.add("a");
    list.add("b");
    list.add("c");
    int i;
        System.out.println(list.get(1));
    }
}


