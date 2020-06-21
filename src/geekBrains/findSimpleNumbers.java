package geekBrains;

import java.util.Arrays;


public class findSimpleNumbers {
    public static void main(String[] args) {


        int[] arr1 = new int[99];
        int a = 2;

/*        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = a;
            a += 1;
//            System.out.println(arr1[i]);
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] % 2 == 0) {
                System.out.println(arr1[i]);
            }

        }*/


        int[] test_array = {0, 1, 2, 2, 3, 0, 4, 2};
//        removeElement(test_array, 2);
        System.out.println(Arrays.toString(removeElement(test_array, 2)));

    }
    public static int[] removeElement(int[] nums, int value){
        int offset = 0;


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == value) {
                offset++;
            } else {
                nums[i - offset] = nums[i];
            }



        }
        return Arrays.copyOf(nums, nums.length - offset);

    }



}




