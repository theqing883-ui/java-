package com.hspedu.enum_;

/*枚举是一种特殊的类，里面只包含*/

public class Enumeration01 {
    public static void main(String[] args) {
        Season season = new Season("春天", "生机勃勃");
        System.out.println(season);
        Season season1 = new Season("夏天", "阳光明媚");
        System.out.println(season1);
        Season season3 = new Season("秋天", "硕果累累");
        System.out.println(season3);
        Season season2 = new Season("冬天", "白雪皑皑");
        System.out.println(season2);
        //因为对于季节而言，它的对象就只有四个，不会再增加或减少
        //现在这样的设计，不能体现季节是固定的四个对象
        //因此引出枚举【将具体的有限个数对象，一个一个列举出来】
        Season season4 = new Season("今天", "出太阳");


    }
}

class Season {
    private String name;
    private String desc;

    public Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
