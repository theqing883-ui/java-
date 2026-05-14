package com.hspedu.houserent.service;

import com.hspedu.houserent.domain.House;

public class HouseService {
    private House[] houses;
    private int houseNum = 2;
    private int idCounter = 2;

    public HouseService(int size) {
        houses = new House[size];

        //测试
        houses[0] = new House(1, 5000, "116", "none", "昌平区", "已出租");
        houses[1] = new House(2, 9000, "111", "mary", "海定区", "未出租");
    }

    public House[] list() {
        return houses;
    }

    public boolean add(House newhouse) {
        // 假设数组大小一定，不考虑进行扩容
        if (houseNum == houses.length) {//数组满了，无法添加
            System.out.println("数组满了，无法添加!");
            return false;
        }
        houses[houseNum] = newhouse;
        houses[houseNum++].setId(++idCounter);
        return true;
    }

    public boolean delete(int houseId) {
        if (houseId > idCounter) {
            System.out.println("此编号的房屋不存在！");
            return false;
        }
        houses[houseId - 1] = null;
        for (int i = houseId; i < idCounter; i++) {
            houses[i - 1] = houses[i];
            houses[i - 1].setId(houses[i].getId() - 1);
        }
        houses[--idCounter] = null;
        houseNum--;
        return true;
    }

    public House findById(int houseId) {
        if (houseId > idCounter) {
            System.out.println("房屋Id不存在");
            return null;
        }
        for (int i = 0; i < houseNum; i++) {
            if (houses[i].getId() == houseId) {
                return houses[i];
            }
        }
        return null;
    }
    public void edit(int houseId,String name,String phone,String address,int rent,String state) {
        if(name != null) {
            houses[houseId].setName(name);
        }
        if(phone != null) {
            houses[houseId].setPhone(phone);
        }
        if(address != null) {
            houses[houseId].setAddress(address);
        }
        if(rent != 0) {
            houses[houseId].setRent(rent);
        }
        if(state != null) {
            houses[houseId].setState(state);
        }
    }

}
