package com.hspedu.InnerClass;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        /*new CellPhone().alamClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });*/
        CellPhone cellPhone = new CellPhone();
        cellPhone.alamClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        cellPhone.alamClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课啦");
            }
        });
    }

}

interface Bell {
    void ring();
}

class CellPhone {
    public void alamClock(Bell bell) {
        bell.ring();//动态绑定机制
    }
}