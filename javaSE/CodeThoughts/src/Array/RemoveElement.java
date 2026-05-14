package Array;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 2, 3, 5, 3, 3, 0, 4, 2, 3};
        int val = 3;
        Solution09 solution = new Solution09();
        int[] newArr = solution.delete(arr, val);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(newArr[i] + " ");
        }

        System.out.println();
        Solution2 solution2 = new Solution2();
        int[] newArr2 = solution2.delete2(arr, val);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(newArr2[i] + " ");
        }

        System.out.println();
        Solution3 solution3 = new Solution3();
        int[] newArr3 = solution3.delete(arr, val);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(newArr2[i] + " ");
        }


    }
}

class Solution09 {
    public int[] delete(int[] arr, int val) {
//        int count = 0;
//        for (int value : arr) {
//            if (value == val) {
//                count++;
//            }
//        }
        int count1 = 0;
//        for (int k = 0; k <= count; k++) {
            for (int i = 0; i < arr.length - count1; i++) {
                if (arr[i] == val) {
                    for (int j = i; j < arr.length - 1; j++) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                    i--;
                    count1++;
                }
            }
//        }
        return arr;
    }
}


class Solution2 {
    public int[] delete2(int[] nums, int val) {
        // 暴力法
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < n; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                n--;
            }
        }
        return nums;
    }
}

// 双指针
class Solution3 {
    int slowIndex = 0;
    public int[] delete(int[] nums, int val) {
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return nums;
    }
}
