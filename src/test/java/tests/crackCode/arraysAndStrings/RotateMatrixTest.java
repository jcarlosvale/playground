package tests.crackCode.arraysAndStrings;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RotateMatrixTest {

    @Test
    public void rotateMatrix90DegreeCase3x3Test(){
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int [][] actual = RotateMatrix.rotate90Degree(matrix);
        int [][] expected = {{7,4,1},{8,5,2},{9,6,3}};
        for (int i = 0; i < matrix.length ; i++) {
            assertTrue(Arrays.compare(expected[i], actual[i]) == 0);
        }
    }

    @Test
    public void rotateMatrix90DegreeCase4x4Test(){
        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int [][] actual = RotateMatrix.rotate90Degree(matrix);
        int [][] expected = {{13,9,5,1},{14,10,6,2},{15,11,7,3},{16,12,8,4}};
        for (int i = 0; i < matrix.length ; i++) {
            assertTrue(Arrays.compare(expected[i], actual[i]) == 0);
        }
    }

}
