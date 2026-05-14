package com.hspedu.enum_;

public class EnumExercise01 {
    public static void main(String[] args) {
        Week[] weeks = Week.values();
        for (Week week : weeks) {
//            System.out.println(week);
            week.exchange();
        }
    }
}

enum Week{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    public void exchange(){
        switch(this){
             case MONDAY:{
                 System.out.println("星期一");
                 break;
             }
             case TUESDAY:{
                 System.out.println("星期二");
                 break;
             }
             case WEDNESDAY:{
                 System.out.println("星期三");
                 break;
             }
             case THURSDAY:{
                 System.out.println("星期四");
                 break;
             }
             case FRIDAY:{
                 System.out.println("星期五");
                 break;
             }
             case SATURDAY:{
                 System.out.println("星期六");
                 break;
             }
             case SUNDAY:{
                 System.out.println("星期日");
                 break;
             }
        }

    }
}
