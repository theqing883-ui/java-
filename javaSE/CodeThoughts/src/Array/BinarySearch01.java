package Array;

public class BinarySearch01 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        int target = 2;
        Tool tool = new Tool();
        int index = tool.findTarget(nums, target);
        System.out.println("输入：nums = {1,2,3,4,5,6,7,8}  target = " + target );
        System.out.println("输出：" + index );
        if(index == -1){
            System.out.println(target + " 在nums中不存在 ");
        }else{
            System.out.println(target + " 在nums的下标为 " + index );
        }

    }
}

class Tool {
    public int findTarget(int[] nums, int target) {
        // 冒泡排序
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length - i - 1; j++) {
//                if (nums[j] > nums[j + 1]) {
//                    int temp = nums[j];
//                    nums[j] = nums[j + 1];
//                    nums[j + 1] = temp;
//                }
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i] + " ");
//        }
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else if (nums[mid] > target) {
                right = mid - 1;
                mid = (left + right) / 2;
            }

        }
        return index;
    }
}