public class ArrayOne {
    //firstLast6 solution
    public static boolean firstLast6(int[] nums) {
        int length = nums.length;
        return nums[0] == 6 || nums[length-1] == 6;
    }

    //sameFirstLast solution 
    public static boolean sameFirstLast(int[] nums) {
        int length = nums.length;
        return length >= 1 && nums[0] == nums[length-1];
    }

    //makePi Solution
    public static int[] makePi() {
        return new int[]{3, 1, 4};
    }

    //commonEnd solution
    public static boolean commonEnd(int[] a, int[] b) {
        return a[0] == b[0] || a[a.length - 1] == b[b.length - 1];
    }

    //sum3 solution
    public static int sum3(int[] nums) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        else {
            return 0; // Return 0 if the array length is not 3
        }
    }

    //rotateLeft3 solution
    public static int[] rotateLeft3(int[] nums) {
        int[] result = new int[3];
        result[0] = nums[1];
        result[1] = nums[2];
        result[2] = nums[0];
        return result;
    }

    public static void main(String[] args) {
        int [] nums = {1, 2, 6};
        System.out.println(firstLast6(nums)); 

        System.out.println(sameFirstLast(nums));

        System.out.println(makePi());

        System.out.println(commonEnd(new int[]{1, 2, 3}, new int[]{7, 3}));

        System.out.println(sum3(new int[]{1, 2, 3}));

        System.out.println(rotateLeft3(new int[]{1, 2, 3}));
        

    }

    
}
