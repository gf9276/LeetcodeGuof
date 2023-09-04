package com.feng.summary.image_rendering;


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int baseColor = image[sr][sc];
        dfs(image, sr, sc, color, baseColor);

        return image;

    }

    public void dfs(int[][] image, int sr, int sc, int color, int baseColor) {
        if (sr < 0) return;
        if (sc < 0) return;
        if (sr > image.length - 1) return;
        if (sc > image[0].length - 1) return;
        if (image[sr][sc] != baseColor) return;
        if (image[sr][sc] == color) return;

        image[sr][sc] = color;

        dfs(image, sr - 1, sc, color, baseColor);
        dfs(image, sr + 1, sc, color, baseColor);
        dfs(image, sr, sc - 1, color, baseColor);
        dfs(image, sr, sc + 1, color, baseColor);

    }
}