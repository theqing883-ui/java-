package com.hspedu.houserent.view;

import com.hspedu.houserent.domain.House;
import com.hspedu.houserent.service.HouseService;
import com.hspedu.houserent.utils.Utility;

public class HouseView {
    //显示主菜单
    private boolean loop = true;
    private char key;
    private HouseService houseService = new HouseService(3);

    public void mainMenu() {
        do {
            System.out.println("\n------------房屋出租系统------------");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t4 修 改 房 屋 信 息 ");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退      出");


            System.out.println("请选择业务(1-6)：");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    editHouse();
                    break;
                case '5':
                    houseList();
                    break;
                case '6':
                    exit();
                    break;
                default: {
                    System.out.println("输入错误");
                }
            }
        } while (loop);
        System.out.println("你已经退出房屋出租系统");
    }

    public void houseList() {
        House[] houses = houseService.list();
        System.out.println("---------------房屋列表---------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        for (House house : houses) {
            if (house == null) {//如果house为空，则这个house不显示
                break;
            }
            System.out.println(house);
        }
        System.out.println("--------------房屋列表完成--------------");
    }

    public void addHouse() {
        //接收输入，创建house对象，调用add
        System.out.println("---------------添加房屋---------------");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态(未出租/已出租)");
        String state = Utility.readString(3);
        House house = new House(0, rent, phone, name, address, state);
        //id由系统分配
        boolean flag = houseService.add(house);
        if (flag) {
            System.out.println("---------------添加房屋成功---------------");
        } else {
            System.out.println("---------------添加房屋失败---------------");
        }
    }

    public void deleteHouse() {
        System.out.println("---------------删除房屋---------------");
        System.out.print("请选择待删除房屋编号(-1退出)：");
        int houseId = Utility.readInt();
        if (houseId == -1) {
            return;
        }
        //调用该方法再次确认，该方法循环询问直到收到y/n
        char temp = Utility.readConfirmSelection();
        boolean flag = false;
        if ('Y' == temp) {
            flag = houseService.delete(houseId);
        }
        if (flag) {
            System.out.println("---------------删除完成---------------");
        }
    }

    public void exit() {
        System.out.println("是否真的要退出（y/n）：");
        char temp = Utility.readChar();
        if ('y' == temp) {
            loop = false;
        } else if ('n' == temp) {
            loop = true;
        } else {
            System.out.println("输入有误！");
            loop = true;
        }
    }

    public void findHouse() {
        System.out.println("---------------查找房屋---------------");
        System.out.print("请输入你要查找的id:");
        int houseId = Utility.readInt();
        House house = houseService.findById(houseId);
        if (house == null) {
            System.out.println("---------------没有该房屋---------------");
        } else {
            System.out.println(house);
        }
    }

    public void editHouse() {
        System.out.println("---------------修改房屋信息---------------");
        System.out.println("请选择待修改的房屋编号(-1退出)：");
        int houseId = Utility.readInt();
        House house = houseService.findById(houseId);
        if (house == null) {
            System.out.println("---------------修改房屋信息失败---------------");
            return;
        }
        System.out.print("姓名(" + house.getName() + "):");
        String name = Utility.readString(8, house.getName());
        System.out.print("电话(" + house.getPhone() + "):");
        String phone = Utility.readString(12, house.getPhone());
        System.out.print("地址(" + house.getAddress() + "):");
        String address = Utility.readString(16, house.getAddress());
        System.out.print("租金(" + house.getRent() + "):");
        int rent = Utility.readInt(house.getRent());
        System.out.print("状态(" + house.getState() + "):");
        String state = Utility.readString(3,house.getState());

        houseService.edit(houseId, name, phone, address, rent, state);
        System.out.println("---------------修改房屋信息成功---------------");
    }
}
