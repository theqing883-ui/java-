package com.hsp.wrapper;

/*
包装类
● 包装类的分类 WrapperType.java
1. 针对八种基本数据类型相应的引用类型——包装类
2. 有了类的特点，就可以调用类中的方法。

| 基本数据类型 | 包装类     |
|--------------|------------|
| boolean      | Boolean    |
| char         | Character  |
| byte         | Byte       |
| short        | Short      |
| int          | Integer    |
| long         | Long       |
| float        | Float      |
| double       | Double     |
* */
/*
Object
  ├── Boolean
  ├── Character
  └── Number
         ├── Byte
         ├── Short
         ├── Integer
         ├── Long
         ├── Float
         └── Double
* */
/*
              Object
               /  |  \
              /   |   \
             /    |    \
      Boolean Character Number
                        /  \
                       /    \
                      /      \
            数值类型包装类   数值类型包装类
            ┌──┬──┬──┬──┬──┬──┐
            │  │  │  │  │  │  │
          Byte Short Int Long Float Double
* */
public class WrapperType {
    public static void main(String[] args) {

    }
}
