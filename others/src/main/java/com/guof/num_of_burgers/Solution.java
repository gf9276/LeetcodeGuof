package com.guof.num_of_burgers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        // 鸡兔同笼。。。
        // 2*x + 2*y = 2*cheeseSlices
        // 4x+2y = tomatoSlices
        if (tomatoSlices >= 2 * cheeseSlices && (tomatoSlices - 2 * cheeseSlices) % 2 == 0) {
            int x = (tomatoSlices - 2 * cheeseSlices) / 2;
            int y = cheeseSlices - (tomatoSlices - 2 * cheeseSlices) / 2;
            if (x >= 0 && y >= 0) {
                return new ArrayList<>(Arrays.asList(x, y));
            } else {
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
    }
}