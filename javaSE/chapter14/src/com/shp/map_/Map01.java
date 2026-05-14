package com.shp.map_;

import java.util.HashMap;
import java.util.Map;

/*
# **Map接口和常用方法

## **Map接口实现类的特点（JDK8）**

### **核心特点：**
1. Map与Collection并列存在：用于保存具有映射关系的数据，Key-Value键值对（双列）

2. 数据封装：Map中的key和value可以是任何引用类型的数据，会封装到HashMap$Node对象中

3. key不允许重复**：原因和HashSet一样（基于hashCode()和equals()）

4. **value可以重复**：不同的key可以对应相同的value

5. **null值处理**：
   - Map的key可以为null，但只能有一个（因为key不允许重复）
   - value也可以为null，可以有多个

6. **常用key类型**：常用String类作为Map的key

7. **映射关系**：key和value之间存在单向一对一关系，即通过指定的key总能找到对应的value

### **关键点总结：**
- **key唯一，value可重复**
- **允许key和value为null**
- **String是最常用的key类型**
- **键值对封装为HashMap$Node对象**
* */
public class Map01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Map map = new HashMap();

        /*
        一、Map实现类的有序性
            无序Map（不保证顺序）
            HashMap：无序，基于哈希表实现

            Hashtable：无序，线程安全的HashMap

            ConcurrentHashMap：无序，并发安全的HashMap

            有序Map
            LinkedHashMap：有序，按插入顺序或访问顺序（LRU）

            TreeMap：有序，按键的自然顺序或Comparator排序

            二、List实现类的有序性
            所有List实现类都是有序的，保证插入顺序：

            ArrayList：有序，基于动态数组

            LinkedList：有序，基于双向链表

            Vector：有序，线程安全的动态数组

            CopyOnWriteArrayList：有序，并发安全的动态数组

            三、Set实现类的有序性
            无序Set
            HashSet：无序，基于HashMap实现

            有序Set
            LinkedHashSet：有序，按插入顺序（基于LinkedHashMap）

            TreeSet：有序，按自然顺序或Comparator排序

            EnumSet：有序，按枚举定义顺序

            CopyOnWriteArraySet：有序，按插入顺序

            ConcurrentSkipListSet：有序，按自然顺序或Comparator（并发安全）
        * */

        /*

        HashMap：无序，不保证插入顺序或键的顺序
        Hashtable：无序（线程安全版 HashMap）

        1.Map与Collection并列存在：
            用于保存具有映射关系的数据，Key-Value键值对（双列）
        2.数据封装：Map中的key和value可以是任何引用类型的数据，
             会封装到HashMap$Node对象中
         3.key不允许重复：(替换)
         原因和HashSet一样（基于hashCode()和equals()）
         4.value可以重复：不同的key可以对应相同的value
         5.Map的key可以为null，但只能有一个（因为key不允许重复）
             value也可以为null，可以有多个
         * */
        /*
        HashMap$Node存放的key和value，为了方便管理，就建立了一个类EntrySet(实现了接口Set)，EntrySet里面的存的是Map.Entry，Map.Entry里面存的是指向key和value的引用(keyset和values)，
        keyset实现了Set接口，values实现了Collection接口
        * */

        //Key-Value Node(hash key value next)
        map.put("no1", "xxq");
        map.put("no2", "xxx");
        map.put("no1","张师傅");//当由相同的key时，相当于Node替换
        map.put("no4","xxx");
        map.put(null,null);
        map.put(null,"abc");//替换
        map.put(1,null);
        System.out.println(map);
        System.out.println(map.get("no1"));
    }
}
