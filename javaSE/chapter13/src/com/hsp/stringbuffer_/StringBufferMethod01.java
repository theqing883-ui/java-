package com.hsp.stringbuffer_;

public class StringBufferMethod01 {
    public static void main(String[] args) {
       /* ● StringBuffer类常见方法
        StringBufferMethod.java
        1) 增 append
        2) 删 delete(start,end)
        3) 改 replace(start,end,string)//将start----end 间的内容替换掉,不含end
        4) 查 indexOf//查找子串在字符串第次出现的索引,如果找不到返回-1
        5) 插 insert
        6) 获取长度 length*/

        //
        StringBuffer s = new StringBuffer("Hello");
        //1) 增 append
        s.append("赵敏");
        s.append("张无忌").append("100").append("true").append("10.5");
        System.out.println(s);//Hello赵敏张无忌100true10.5
        // 2) 删 delete(start,end),
        s.delete(0, 5);//删除索引[0,5),的字符
        System.out.println(s);//赵敏张无忌100true10.5
        // 3) 改 replace(start,end,string)//将start----end 间的内容替换掉,不含end
        s.replace(0, 2, "周芷若");//将索引[6,8)的字符替换为"周芷若"
        System.out.println(s);//周芷若张无忌100true10.5

        //4) 查 indexOf//查找子串在字符串第1次出现的索引,如果找不到返回-1
        int index = s.indexOf("张无忌");
        System.out.println(index);
       // 5) 插 insert
        s.insert(6, "赵敏");//在索引为6的位置插入赵敏，原来索引为6的字符自动后移
        System.out.println(s);//周芷若张无忌赵敏100true10.5
        //6) 获取长度 length
        System.out.println(s.length());
    }
}
