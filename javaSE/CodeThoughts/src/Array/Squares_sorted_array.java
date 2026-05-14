package Array;

public class Squares_sorted_array {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 1, 2, 3, 10, 20};
        Solution4 solution4 = new Solution4();
        int[] nums2 = solution4.sortArr(nums);
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + " ");
        }
    }
}

class Solution4 {
    public int[] sortArr(int[] arr) {
        int fastIndex = 0;
        int fastIndex2 = arr.length - 1;
        int slowIndex = arr.length - 1;
        int[] newArr = new int[arr.length];
        while (fastIndex <= fastIndex2) {
            int temp = arr[fastIndex] * arr[fastIndex];
            int temp2 = arr[fastIndex2] * arr[fastIndex2];
//            System.out.print("**");
            if (temp < temp2) {
                newArr[slowIndex] = temp2;
//                System.out.print("**");
                fastIndex2--;
            } else {
                newArr[slowIndex] = temp;
//                System.out.print("**");
                fastIndex++;
            }
            slowIndex--;
        }
//        newArr[0] = arr[fastIndex2] * arr[fastIndex2];
        return newArr;
    }


}



