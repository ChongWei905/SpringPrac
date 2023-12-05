package leetcode.arrays;

import java.util.Arrays;
import java.util.TreeSet;

public class Problem414 {
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i-1] < nums[i]) {
                count += 1;
                if (count == 3) {
                    return nums[i-1];
                }
            }
        }
        return nums[nums.length -1];
    }

    public static int thirdMaxSec(int[] nums) {
        TreeSet<Integer> numSet = new TreeSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
            if (numSet.size() > 3) {
                numSet.remove(numSet.first());
            }
        }
        if (numSet.size() == 3) {
            return numSet.first();
        } else {
            return numSet.last();
        }
    }

    public static int thirdMaxThd(int[] nums) {
        long leastFir = Long.MIN_VALUE;
        long leastSec = Long.MIN_VALUE;
        long leastTrd = Long.MIN_VALUE;

        for (int num : nums) {
            if (num == leastFir || num == leastSec || num == leastTrd) {
                continue;
            }
            if (num > leastFir) {
                leastFir = num;
            }
            if (num > leastSec) {
                long temp = leastFir;
                leastFir = leastSec;
                leastSec = temp;
            }
            if (num > leastTrd) {
                long temp = leastSec;
                leastSec = leastTrd;
                leastTrd = temp;
            }
        }
        if (leastFir == Long.MIN_VALUE) {
            return (int) leastTrd;
        } else {
            return (int) leastFir;
        }
    }

    public static void main(String[] args) {
        thirdMaxSec(new int[]{1,2,2,5,3,5});
    }
}
