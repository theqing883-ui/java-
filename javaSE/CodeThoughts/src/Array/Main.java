package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String s = "a";
        String t = "ab";
//         = "anagram", t = "nagaram"


    }
}

class Solution {
    /*
    add(E e)：添加元素，如果集合中已存在该元素，则不会重复添加，并返回false；否则添加并返回true。

    remove(Object o)：删除指定元素，如果元素存在则删除并返回true，否则返回false。

    contains(Object o)：判断集合是否包含指定元素，包含则返回true，否则返回false。

    size()：返回集合中元素的数量。

    isEmpty()：判断集合是否为空。

    clear()：清空集合。
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }

        int[] nums3 = new int[set.size()];
        int count  = 0;
        for(Integer num : set){
            nums3[count] = num;
            count++;
        }

        set.clear();
        for(int i = 0; i < nums2.length; i++){
            set.add(nums2[i]);
        }
        int[] nums4 = new int[set.size()];
        count  = 0;
        for(Integer num : set){
            nums4[count] = num;
            count++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums3.length; i++){
            for(int j = 0; j < nums4.length; j++){
                if(nums3[i] == nums4[j]){
                    list.add(nums3[i]);
                }
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */