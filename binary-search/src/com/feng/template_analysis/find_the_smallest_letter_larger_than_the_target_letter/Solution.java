package com.feng.template_analysis.find_the_smallest_letter_larger_than_the_target_letter;


class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int left = 0;
        int right = letters.length;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return letters[left > letters.length - 1 ? 0 : left];

    }
}