//The original MathUtilsTest is tested on the MathUtils Function
//The code here contains all the test cases I wrote in Q1 (MathUtils Function) but
//tested on MathUtilsFixed for the sake of Q4

/*
   Line coverage before improvement: 96%
   Mutation score before improvement: 94%
 */


/*
   Line coverage after improvement: 96%
   Mutation score after improvement: 100%
 */


package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MathUtilsFixedTest {

  /**
   * Test the slope function with normal positive values
   */
  @Test
  void testSlope() {
    assertEquals(1.0, MathUtilsFixed.slope(1, 2, 1, 2));
    assertEquals(2.0, MathUtilsFixed.slope(1, 2, 1, 3));
    assertEquals(0.5, MathUtilsFixed.slope(1, 2, 1, 1.5));
  }

  /**
   * Test the slope function with normal negative values
   */
  @Test
  void testSlopeNeg() {
    assertEquals(1.0, MathUtilsFixed.slope(2, 1, 2, 1));
    assertEquals(2.0, MathUtilsFixed.slope(2, 1, 3, 1));
    assertEquals(0.5, MathUtilsFixed.slope(2, 1, 1.5, 1));
  }

  /**
   * Test the slope function with a horizontal line
   */
  @Test
  void testSlopeHorizontal() {
    assertEquals(0.0, MathUtilsFixed.slope(1, 2, 1, 1));
    assertEquals(-0.0, MathUtilsFixed.slope(2, 1, 1, 1));
  }

  /**
   * Test the slope function with a vertical line
   */
  @Test
  void testSlopeVertical() {
    assertEquals(Double.POSITIVE_INFINITY, MathUtilsFixed.slope(1, 1, 1, 2));
    assertEquals(Double.POSITIVE_INFINITY, MathUtilsFixed.slope(2, 2, 3, 9));
  }

  /**
   * Test the slope function with a negative infinity slope
   */
  @Test
  void testSlopeNegInfinity() {
    assertEquals(Double.NEGATIVE_INFINITY, MathUtilsFixed.slope(1, 1, 2, 1));
    assertEquals(Double.NEGATIVE_INFINITY, MathUtilsFixed.slope(2, 2, 5, 1));
  }

  /**
   * Test the slope function with identical points
   */
  @Test
  public void testSlopeIdenticalPoints() {
    double result = MathUtilsFixed.slope(1, 1, 2, 2);
    assertTrue(Double.isNaN(result), "Slope for identical points should be NaN");
  }

  /**
   * Test the rootMeansSquaredError function with normal values
   */
  @Test
  public void testRootMeansSquaredError() {
    double[] real = {1, 2, 3, 4, 5};
    double[] predicted = {2, 3, 4, 5, 7};
    assertEquals(1.26491106407, MathUtilsFixed.rootMeansSquaredError(real, predicted), 0.0001);

    double[] real2 = {2, 3, 4};
    double[] predicted2 = {5, 8, 1};
    assertEquals(3.7859, MathUtilsFixed.rootMeansSquaredError(real2, predicted2), 0.0001);
  }

  /**
   * Test the rootMeansSquaredError function with negative values
   */
  @Test
  public void testRootMeansSquaredErrorNeg() {
    double[] real = {-1, -2, -3, -4, -5};
    double[] predicted = {-2, -3, -4, -5, -7};
    assertEquals(1.26491106407, MathUtilsFixed.rootMeansSquaredError(real, predicted), 0.0001);

    double[] real2 = {-2, -3, -4};
    double[] predicted2 = {-5, -8, -1};
    assertEquals(3.7859, MathUtilsFixed.rootMeansSquaredError(real2, predicted2), 0.0001);
  }

  /**
   * Test the rootMeansSquaredError function with mixed values
   */
  @Test
  public void testRootMeansSquaredErrorMixedValues() {
    double[] realMixed = {-3, -1, 2, 4};
    double[] predictedMixed = {0, -2, 3, 5};
    assertEquals(Math.sqrt(3), MathUtilsFixed.rootMeansSquaredError(realMixed, predictedMixed), 0.0001);
  }

  /**
   * Test the rootMeansSquaredError empty array
   */
  @Test
  public void testRootMeansSquaredErrorEmptyArrays() {
    double[] real = {};
    double[] predicted = {};
    double result = MathUtilsFixed.rootMeansSquaredError(real, predicted);
    assertTrue(Double.isNaN(result), "RMSE for empty arrays should be NaN due to 0/0");
  }

  /**
   * Test the rootMeansSquaredError function with decimal values
   */
  @Test
  public void testRootMeansSquareErrorDecimalValues() {
    double[] real = {1.5, 2.5, 3.5, 4.5, 5.5};
    double[] predicted = {2.5, 3.5, 4.5, 5.5, 7.5};
    assertEquals(1.26491106407, MathUtilsFixed.rootMeansSquaredError(real, predicted), 0.0001);
  }

  /**
   * Test the sumOfSquares function with normal values
   */
  @Test
  public void testSumOfSquares() {
    double[] vector = {1, 2, 3, 4, 5};
    assertEquals(55, MathUtilsFixed.sumOfSquares(vector), 0.0001);

    double[] vector2 = {2, 3, 4};
    assertEquals(29, MathUtilsFixed.sumOfSquares(vector2), 0.0001);
  }

  /**
   * Test the sumOfSquares function with negative values
   */
  @Test
  public void testSumOfSquaresNeg() {
    double[] vector = {-1, -2, -3, -4, -5};
    assertEquals(55, MathUtilsFixed.sumOfSquares(vector), 0.0001);

    double[] vector2 = {-2, -3, -4};
    assertEquals(29, MathUtilsFixed.sumOfSquares(vector2), 0.0001);
  }

  /**
   * Test the sumOfSquares function with zero values
   */
  @Test
  public void testSumOfSquaresZero() {
    double[] vector = {0};
    assertEquals(0, MathUtilsFixed.sumOfSquares(vector), 0.0001);
  }

  /**
   * Test the sumOfSquares function with empty array
   */
  @Test
  public void testSumOfSquaresEmptyArray() {
    double[] vector = {};
    assertEquals(0, MathUtilsFixed.sumOfSquares(vector), 0.0001);
  }

  /**
   * Test the sumOfSquares function with Integer overflowing values
   */
  @Test
  public void testSumOfSquaresIntegerOverflow() {
    double[] vector = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    double expected = 9.22337202826484E18;
    assertEquals(expected, MathUtilsFixed.sumOfSquares(vector), 1.0E15);
  }







  /**
   * Test the getColumn function with normal values
   */
  @Test
  public void testGetColumnNormal() {
    double[] arr1 = {1, 2, 3};
    double[] arr2 = {4, 5, 6};
    double[] arr3 = {7, 8, 9};
    double[] result = MathUtilsFixed.getColumn(1, arr1, arr2, arr3);
    assertArrayEquals(new double[]{2, 5, 8}, result);
  }

  /**
   * Test the getColumn function with an empty array
   */
  @Test
  public void testGetColumnEmptyArray() {
    double[] arr1 = {};
    assertThrows(IllegalArgumentException.class, () -> MathUtilsFixed.getColumn(0, arr1));
  }

  /**
   * Test the getColumn function with a negative values
   */
  @Test
  public void testGetColumnNegativeValues() {
    double[] arr1 = {-1, -2, -3};
    double[] arr2 = {-4, -5, -6};
    double[] arr3 = {-7, -8, -9};
    double[] result = MathUtilsFixed.getColumn(1, arr1, arr2, arr3);
    assertArrayEquals(new double[]{-2, -5, -8}, result);
  }

  /**
   * Test the getColumn function with mixed values
   */
  @Test
  public void testGetColumnMixedValues() {
    double[] arr1 = {-1, 0, -3};
    double[] arr2 = {4, -5, 6};
    double[] arr3 = {-7, 8, -9};
    double[] result = MathUtilsFixed.getColumn(1, arr1, arr2, arr3);
    assertArrayEquals(new double[]{0, -5, 8}, result);
  }

  /**
   * Test the getColumn function with an invalid index
   */
  @Test
  public void testGetColumnInvalidIndex() {
    double[] arr1 = {1, 2, 3};
    double[] arr2 = {4, 5, 6};
    double[] arr3 = {7, 8, 9};
    assertThrows(IllegalArgumentException.class, () -> MathUtilsFixed.getColumn(5, arr1, arr2, arr3));
    assertThrows(IllegalArgumentException.class, () -> MathUtilsFixed.getColumn(-1, arr1, arr2, arr3));
  }

  // Added after Mutation analysis
  // New test: Exact boundary (last valid index)
  @Test
  void testGetColumnBoundary() {
    double[] arr1 = {1, 2, 3};
    double[] arr2 = {4, 5, 6};
    double[] arr3 = {7, 8, 9};
    assertArrayEquals(new double[]{3, 6, 9}, MathUtilsFixed.getColumn(2, arr1, arr2, arr3));
  }


  //Added after mutation analysis
  @Test
  void testGetColumnZeroIndex() {
    double[] arr1 = {1, 2, 3};
    double[] arr2 = {4, 5, 6};
    double[] arr3 = {7, 8, 9};
    assertArrayEquals(new double[]{1, 4, 7}, MathUtilsFixed.getColumn(0, arr1, arr2, arr3)); // First valid index
    // Ensures column < 0 mutant is killed
  }


  //Added after mutation analysis
  @Test
  void testGetColumnExactBoundaryException() {
    double[] arr1 = {1, 2, 3};
    double[] arr2 = {4, 5, 6};
    double[] arr3 = {7, 8, 9};
    assertThrows(IllegalArgumentException.class, () -> MathUtilsFixed.getColumn(3, arr1, arr2, arr3)); // Exactly length
    // Kills mutant: column >= curr.length -> column > curr.length
  }





  /**
   * Test the normalize function with positive values
   */
  @Test
  public void testNormalize() {
    double[] arr = {1, 2, 3, 4, 5};
    MathUtilsFixed.normalize(arr, 15);
    assertArrayEquals(new double[]{1/15.0, 2/15.0, 3/15.0, 4/15.0, 5/15.0}, arr, 0.0001);
  }

  /**
   * Test the normalize function with negative values
   */
  @Test
  public void testNormalizeNeg() {
    double[] arr = {-1, -2, -3, -4, -5};
    MathUtilsFixed.normalize(arr, 15);
    assertArrayEquals(new double[]{-1/15.0, -2/15.0, -3/15.0, -4/15.0, -5/15.0}, arr, 0.0001);
  }

  /**
   * Test the normalize function with mixed values
   */
  @Test
  public void testNormalizeZero() {
    double[] arr = {0, -1, 0, 1, 0};
    MathUtilsFixed.normalize(arr, 2);
    assertArrayEquals(new double[]{0.0, -0.5, 0.0, 0.5, 0.0}, arr, 0.0001);
  }

  /**
   * Test the normalize function with empty array
   */
  @Test
  public void testNormalizeEmptyArray() {
    double[] arr = {};
    MathUtilsFixed.normalize(arr, 4);
    assertArrayEquals(new double[]{}, arr);
  }

  /**
   * Test the normalize function with sum to be zero
   */
  @Test
  public void testNormalizeSumZero() {
    double[] arr = {1, 2, 3, 4, 5};
    assertThrows(IllegalArgumentException.class, () -> MathUtilsFixed.normalize(arr, 0));
  }

  /**
   * Test the normalize function with sum to be NaN
   */
  @Test
  public void testNormalizeSumNaN() {
    double[] arr = {1, 2, 3, 4, 5};
    assertThrows(IllegalArgumentException.class, () -> MathUtilsFixed.normalize(arr, Double.NaN));
  }





  /**
   * Test the calEntropy function with normal values
   */
  @Test
  public void testCalEntropy() {
    double[] probabilities = {0.1, 0.2, 0.3, 0.4};
    assertEquals(1.27985422583, MathUtilsFixed.calEntropy(probabilities), 0.0001);

    double[] probabilities2 = {0.5, 0.5};
    assertEquals(0.69314718056, MathUtilsFixed.calEntropy(probabilities2), 0.0001);
  }

  /**
   * Test the calEntropy function with zero values
   */
  @Test
  public void testCalEntropyZero() {
    double[] probabilities = {0, 0, 0, 0};
    assertThrows(IllegalArgumentException.class, () -> MathUtilsFixed.calEntropy(probabilities));
  }

  /**
   * Test the calEntropy function with empty array
   */
  @Test
  public void testCalEntropyEmptyArray() {
    double[] probabilities = {};
    assertEquals(0, MathUtilsFixed.calEntropy(probabilities), 0.000001);
  }

  /**
   * Test the calEntropy function with probabilities not in (0, 1)
   */
  @Test
  public void testCalEntropyInvalidProbabilities() {
    double[] probabilities = {1.1, 0.2, 0.3, 0.4};
    assertThrows(IllegalArgumentException.class, () -> MathUtilsFixed.calEntropy(probabilities));

    double[] probabilities2 = {-0.5, 1.5};
    assertThrows(IllegalArgumentException.class, () -> MathUtilsFixed.calEntropy(probabilities2));
  }


  //Added after mutation analysis
  // New test: Exact boundary values (0.0 and 1.0)
  @Test
  void testCalEntropyExactBoundaries() {
    double[] probabilities1 = {1.0}; // Exactly 1.0
    assertThrows(IllegalArgumentException.class,
            () -> MathUtilsFixed.calEntropy(probabilities1),
            "Should throw for probability == 1.0");
    // Kills mutant: d >= 1.0 -> d > 1.0

    double[] probabilities2 = {0.0}; // Exactly 0.0
    assertThrows(IllegalArgumentException.class,
            () -> MathUtilsFixed.calEntropy(probabilities2),
            "Should throw for probability == 0.0");
    // Kills mutant: d <= 0.0 -> d < 0.0
  }

  //Added after mutation analysis
  // Ensure single-element valid case (reinforces coverage)
  @Test
  void testCalEntropySingleValid() {
    double[] probabilities = {0.5};
    assertEquals(0.34657359027997264, MathUtilsFixed.calEntropy(probabilities), 0.0001);
  }

  //Added after mutation analysis
  @Test
  void testCalEntropyBoundaryValues() {
    double[] probabilities = {0.0000001, 0.9999999};
    double result = MathUtilsFixed.calEntropy(probabilities);
    assertTrue(result > 0 && result < 0.1);
  }



}
