package tests.leetcode.challenge30days;

import java.util.Arrays;

/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0
 * to 65535).
 *
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value
 * newColor, "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting
 * pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also
 * with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with
 * the newColor.
 *
 * At the end, return the modified image.
 *
 * Example 1:
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 * Note:
 *
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */
public class FloodFillPixel {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //first pixel
        int originalColor = image[sr][sc];
        image[sr][sc] = newColor;
        colorNeighbors(image, sr, sc, originalColor, newColor);
        return image;
    }

    private static void colorNeighbors(int[][] image, int i, int j, int originalColor, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length) return;
        //up
        if (i-1 >= 0) {
            if (image[i-1][j] == originalColor && image[i-1][j] != newColor){
                image[i-1][j] = newColor;
                colorNeighbors(image, i-1, j, originalColor, newColor);
            }
        }
        //down
        if (i+1 < image.length) {
            if (image[i+1][j] == originalColor && image[i+1][j] != newColor) {
                image[i+1][j] = newColor;
                colorNeighbors(image, i+1, j, originalColor, newColor);
            }
        }
        //left
        if (j-1 >= 0) {
            if (image[i][j-1] == originalColor && image[i][j-1] != newColor) {
                image[i][j-1] = newColor;
                colorNeighbors(image, i, j-1, originalColor, newColor);
            }
        }
        //right
        if (j+1 < image[0].length) {
            if (image[i][j+1] == originalColor && image[i][j+1] != newColor) {
                image[i][j+1] = newColor;
                colorNeighbors(image, i, j+1, originalColor, newColor);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 0, 0, 2);
        for (int [] line: image) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println("*****************************");
        image = floodFill(new int[][]{{0, 0, 0}, {0, 1, 0}}, 1, 1, 2);
        for (int [] line: image) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println("*****************************");
        image = floodFill(new int[][]{{0, 0, 0}, {0, 1, 1}}, 1, 1, 1);
        for (int [] line: image) {
            System.out.println(Arrays.toString(line));
        }

    }
}
