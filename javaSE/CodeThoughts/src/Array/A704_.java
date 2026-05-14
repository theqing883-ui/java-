package Array;

public class A704_ {
    public static void main(String[] args) {
        System.out.println(Solution08.search(new int[]{2, 5},5));
    }
}
class Solution08 {
    public static int search(int[] nums, int target) {
        int len = nums.length;//2
        if(len == 1 && nums[0] == target){
            return 0;
        }
        int index = (len-1) / 2;//想到用一个变量来储存每次二分后元素的索引是关键 0
        for(int i = 0; i < (len / 2) + 1 ; i++){//1
            if(nums[index] == target){
                return index;
            }else if(nums[index] > target){
                index = index / 2;
            }else{
                index = (index + len) / 2;
            }
        }
        return -1;
    }
}