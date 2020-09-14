package com.dzy.leet;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author douzy
 * @date 2020-01-13.
 */
public class Question0004 {


    /**
     * 合并两个有序数组,成为一个大的有序数组;
     * 求中值
     * 难度在于直接合并,时间复杂度会高于 O(log(m + n))。所以要使用归并排序.
     * (因为已经是两个有序数组了,只需要最后一次归并排序即可)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];

        for (int index = 0, i = 0, j = 0; index < nums.length; index++) {
            if (i >= nums1.length) {
                nums[index] = nums2[j++];
            } else if (j >= nums2.length) {
                nums[index] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                nums[index] = nums2[j++];
            } else {
                nums[index] = nums1[i++];
            }
        }
        return getMiddle(nums);
    }


    /**
     * 获取中值
     *
     * @param num
     * @return
     */
    public double getMiddle(int[] num) {
        if (num.length == 0) {
            return 0d;
        } else if (num.length % 2 == 1) {
            return num[num.length / 2] + 0d;
        } else {
            return (num[num.length / 2 - 1] + num[num.length / 2]) / 2.0d;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{-2, -1};
        double result = new Question0004().findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}
