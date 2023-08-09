package feng.search_insertion_location;

/**
 * ClassName: Solution
 * Package: com.feng.applying_basic_algorithmic_ideas.merge
 * Description:
 *
 * @Author guof
 * @Create 2023/5/15 21:32
 * @Version 1.0
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        // 边缘
        if (target > nums[nums.length - 1]) return nums.length;
        if (target < nums[0]) return 0;

        // 二分查找
        int right_idx = nums.length - 1;
        int left_idx = 0;

        while (left_idx < right_idx) {
            int midIdx = (left_idx + right_idx) / 2;
            int midValue = nums[midIdx];

            if (midValue == target) {
                return midIdx;
            } else if (midValue < target) {
                left_idx = midIdx + 1;
            } else {
                right_idx = midIdx - 1;
            }
        }
        if (target > nums[left_idx]) return left_idx + 1;
        return left_idx;
    }
}

