package feng.double_pointer_technique.max_num_of_consecutive1;

/**
 * ClassName: Solution
 * Package: com.feng.applying_basic_algorithmic_ideas.merge
 * Description: 中心回文，简单粗暴~
 *
 * @Author guof
 * @Create 2023/5/15 21:32
 * @Version 1.0
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int fast = 0;
        int slow = 0;
        int sum = 0;
        int output = nums.length + 1;

        for (; fast < nums.length; fast++) {
            sum += nums[fast];

            while (slow <= fast && sum >= target) {
                output = Math.min(output, fast - slow + 1);
                sum -= nums[slow];
                slow++;
            }

        }

        return output == nums.length + 1 ? 0 : output;

    }
}