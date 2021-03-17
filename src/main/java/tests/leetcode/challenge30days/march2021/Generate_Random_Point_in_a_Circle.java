package tests.leetcode.challenge30days.march2021;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3675/

Given the radius and x-y positions of the center of a circle, write a function randPoint which generates a uniform
random point in the circle.

Note:

input and output values are in floating-point.
radius and x-y position of the center of the circle is passed into the class constructor.
a point on the circumference of the circle is considered to be in the circle.
randPoint returns a size 2 array containing x-position and y-position of the random point, in that order.
Example 1:

Input:
["Solution","randPoint","randPoint","randPoint"]
[[1,0,0],[],[],[]]
Output: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
Example 2:

Input:
["Solution","randPoint","randPoint","randPoint"]
[[10,5,-7.5],[],[],[]]
Output: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has three arguments,
the radius, x-position of the center, and y-position of the center of the circle. randPoint has no arguments.
Arguments are always wrapped with a list, even if there aren't any.
 */
public class Generate_Random_Point_in_a_Circle {

    private final double radius;
    private final double x_center;
    private final double y_center;

    public Generate_Random_Point_in_a_Circle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    //https://stackoverflow.com/questions/5837572/generate-a-random-point-within-a-circle-uniformly
    public double[] randPoint() {
        double r = this.radius * Math.sqrt(Math.random());
        double theta = Math.random() * 2 * Math.PI;

        double randomX = this.x_center + Math.cos(theta) * r;
        double randomY = this.y_center + Math.sin(theta) * r;
        return new double[] {randomX, randomY};
    }
}
