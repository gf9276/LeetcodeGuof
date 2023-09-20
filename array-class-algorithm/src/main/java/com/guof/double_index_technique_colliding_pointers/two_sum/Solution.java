package com.guof.double_index_technique_colliding_pointers.two_sum;

/**
 * ClassName: Solution
 * Package: com.feng.double_index_technique_colliding_pointers.two_sum
 * Description:
 *
 * @Author guof
 * @Create 2023/5/15 23:03
 * @Version 1.0
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left_idx = 0;
        int right_idx = numbers.length - 1;

        while (left_idx < right_idx) {
            if (numbers[left_idx] + numbers[right_idx] == target) {
                return new int[]{left_idx + 1, right_idx + 1};
            } else if (numbers[left_idx] + numbers[right_idx] > target) {
                // 如果值太大了，则需要减小
                right_idx--;
            } else if (numbers[left_idx] + numbers[right_idx] < target) {
                // 如果值太小了，则需要增大
                left_idx++;
            }
        }
        return null;
    }
}