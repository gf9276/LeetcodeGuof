package com.guof.nth_digit;


class Solution {
    public int findNthDigit(int n) {
        // 烦，直接存好了
        // arr[i]表示到位数为(i+1)的数字，累计的长度，例如arr[0]表示到9为止有9个数字，arr[1]表示10到99为止180个数字
        long[] arr = new long[9];
        long digNbr = 9;
        arr[0] = digNbr;

        for (int i = 1; i < arr.length; i++) {
            digNbr *= 10;
            arr[i] = digNbr * (i + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (n - arr[i] > 0) {
                n -= (int) arr[i];
            } else {
                // 说明在当前区间里
                int whichNbr = (n - 1) / (i + 1);
                int whichBit = (n - 1) % (i + 1);
                int tmp = 1;
                for (int j = 0; j < i; j++) {
                    tmp *= 10;
                }
                String strTmp = String.valueOf(tmp + whichNbr);
                return Integer.parseInt(String.valueOf(strTmp.charAt(whichBit)));
            }
        }
        return -1;
    }
}