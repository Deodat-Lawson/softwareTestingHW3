package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MathUtilsTest {


  //Testing the slope function

  //Tests for the slope function in MathUtils.java

  /**
   * Test the slope function with normal positive values
   */
  @Test
  void testSlope() {
    assertEquals(1.0, MathUtils.slope(1, 2, 1, 2));
    assertEquals(2.0, MathUtils.slope(1, 2, 1, 3));
    assertEquals(0.5, MathUtils.slope(1, 2, 1, 1.5));
  }

  /**
   * Test the slope function with normal negative values
   */
  @Test
  void testSlopeNeg() {
    assertEquals(1.0, MathUtils.slope(2, 1, 2, 1));
    assertEquals(2.0, MathUtils.slope(2, 1, 3, 1));
    assertEquals(0.5, MathUtils.slope(2, 1, 1.5, 1));
  }

  /**
   * Test the slope function with a horizontal line
   */
  @Test
  void testSlopeHorizontal() {
    assertEquals(0.0, MathUtils.slope(1, 2, 1, 1));
    assertEquals(-0.0, MathUtils.slope(2, 1, 1, 1));
  }

  /**
   * Test the slope function with a vertical line
   */
  @Test
  void testSlopeVertical() {
    assertEquals(Double.POSITIVE_INFINITY, MathUtils.slope(1, 1, 1, 2));
    assertEquals(Double.POSITIVE_INFINITY, MathUtils.slope(1, 1, 2, 1));
  }

  /**
   * Test the slope function with a negative infinity slope
   */
  @Test
  void testSlopeNegInfinity() {
    assertEquals(Double.NEGATIVE_INFINITY, MathUtils.slope(1, 1, 2, 1));
    assertEquals(Double.NEGATIVE_INFINITY, MathUtils.slope(1, 1, 1, 2));
  }


  /**
   * Test the slope function with identical points
   */
  @Test
  public void testSlopeIdenticalPoints() {
    // For identical points: (1,2) and (1,2), result is 0/0 which yields NaN.
    double result = MathUtils.slope(1, 1, 2, 2);
    assertTrue(Double.isNaN(result), "Slope for identical points should be NaN");
  }


  //Tests for the rootMeansSquaredError function in MathUtils.java

  /**
   * Test the rootMeansSquaredError function with normal values
   */
  @Test
  public void testRootMeansSquaredError() {
    double[] real = {1, 2, 3, 4, 5};
    double[] predicted = {2, 3, 4, 5, 7};
    assertEquals(1.26491106407, MathUtils.rootMeansSquaredError(real, predicted), 0.0001);

    double[] real2 = {2, 3, 4};
    double[] predicted2 = {5, 8, 1};
    assertEquals(3.785188, MathUtils.rootMeansSquaredError(real2, predicted2), 0.0001);
  }

  /**
   * Test the rootMeansSquaredError function with negative values
   */
  @Test
  public void testRootMeansSquaredErrorNeg() {
    double[] real = {-1, -2, -3, -4, -5};
    double[] predicted = {-2, -3, -4, -5, -7};
    assertEquals(1.26491106407, MathUtils.rootMeansSquaredError(real, predicted), 0.0001);

    double[] real2 = {-2, -3, -4};
    double[] predicted2 = {-5, -8, -1};
    assertEquals(3.785188, MathUtils.rootMeansSquaredError(real2, predicted2), 0.0001);
  }

  /**
   * Test the rootMeansSquaredError function with zero values
   */
  @Test
  public void testRootMeansSquaredErrorMixedValues() {
    double[] realMixed = {-3, -1, 2, 4};
    double[] predictedMixed = {0, -2, 3, 5};
    assertEquals(Math.sqrt(3), MathUtils.rootMeansSquaredError(realMixed, predictedMixed), 0.0001);
  }

  /**
   * Test the rootMeansSquaredError empty array
   */
  @Test
  public void testRootMeansSquaredErrorEmptyArrays() {
    double[] real = {};
    double[] predicted = {};
    double result = MathUtils.rootMeansSquaredError(real, predicted);
    assertTrue(Double.isNaN(result), "RMSE for empty arrays should be NaN due to division by zero");
  }

  /**
   * Test the rootMeansSquaredError function with decimal values
   */
  @Test
  public void testRootMeansSquareErrorDecimalValues() {
    double[] real = {1.5, 2.5, 3.5, 4.5, 5.5};
    double[] predicted = {2.5, 3.5, 4.5, 5.5, 7.5};
    assertEquals(1.26491106407, MathUtils.rootMeansSquaredError(real, predicted), 0.0001);
  }

  //Tests for the sumOfSquares function in MathUtils.java

  /**
   * Test the sumOfSquares function with normal values
   */
  @Test
  public void testSumOfSquares() {
    double[] vector = {1, 2, 3, 4, 5};
    assertEquals(55, MathUtils.sumOfSquares(vector), 0.0001);

    double[] vector2 = {2, 3, 4};
    assertEquals(29, MathUtils.sumOfSquares(vector2), 0.0001);
  }

  /**
   * Test the sumOfSquares function with negative values
   */
  @Test
  public void testSumOfSquaresNeg() {
    double[] vector = {-1, -2, -3, -4, -5};
    assertEquals(55, MathUtils.sumOfSquares(vector), 0.0001);

    double[] vector2 = {-2, -3, -4};
    assertEquals(29, MathUtils.sumOfSquares(vector2), 0.0001);
  }

  /**
   * Test the sumOfSquares function with zero values
   */
  @Test
  public void testSumOfSquaresZero() {
    double[] vector = {0};
    assertEquals(0, MathUtils.sumOfSquares(vector), 0.0001);
  }

  /**
   * Test the sumOfSquares function with empty array
   */
  @Test
  public void testSumOfSquaresEmptyArray() {
    double[] vector = {};
    assertEquals(0, MathUtils.sumOfSquares(vector), 0.0001);
  }

  /**
   * Test the sumOfSquares function with Integer overflowing values
   */
  @Test
  public void testSumOfSquaresIntegerOverflow() {
    double[] vector = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    assertEquals(8.98846567431158E18, MathUtils.sumOfSquares(vector), 0.0001);
  }


  //Tests for the getColumn function in MathUtils.java

  /**
   * Test the getColumn function with normal values
   */
  @Test
  public void testGetColumnNormal() {
    double[] arr1 = {1, 2, 3};
    double[] arr2 = {4, 5, 6};
    double[] arr3 = {7, 8, 9};
    double[] result = MathUtils.getColumn(1, arr1, arr2, arr3);
    assertArrayEquals(new double[]{2, 5, 8}, result);
  }

  /**
   * Test the getColumn function with an empty array
   */
  @Test
  public void testGetColumnEmptyArray() {
    double[] arr1 = {};

    double[] result = MathUtils.getColumn(0, arr1);
    assertArrayEquals(new double[]{}, result);
  }

  /**
   * Test the getColumn function with a negative values
   */
  @Test
  public void testGetColumnNegativeValues() {
    double[] arr1 = {-1, -2, -3};
    double[] arr2 = {-4, -5, -6};
    double[] arr3 = {-7, -8, -9};
    double[] result = MathUtils.getColumn(1, arr1, arr2, arr3);
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
    double[] result = MathUtils.getColumn(1, arr1, arr2, arr3);
    assertArrayEquals(new double[]{2, -5, 8}, result);
  }

  /**
   * Test the getColumn function with an invalid index
   */
  @Test
  public void testGetColumnInvalidIndex() {
    double[] arr1 = {1, 2, 3};
    double[] arr2 = {4, 5, 6};
    double[] arr3 = {7, 8, 9};
    assertThrows(IllegalArgumentException.class, () -> MathUtils.getColumn(5, arr1, arr2, arr3));
    assertThrows(IllegalArgumentException.class, () -> MathUtils.getColumn(-1, arr1, arr2, arr3));
  }


  //Tests for the normalize function in MathUtils.java

  /**
   * Test the normalize function with positive values
   */
  @Test
  public void testNormalize() {
    double[] arr = {1, 2, 3, 4, 5};
    MathUtils.normalize(arr, 15);
    assertArrayEquals(new double[]{1/15.0, 2/15.0, 3/15.0, 4/15.0, 5/15.0}, arr, 0.0001);
  }

  /**
   * Test the normalize function with negative values
   */
  @Test
  public void testNormalizeNeg() {
    double[] arr = {-1, -2, -3, -4, -5};
    MathUtils.normalize(arr, 15);
    assertArrayEquals(new double[]{-1/15.0, -2/15.0, -3/15.0, -4/15.0, -5/15.0}, arr, 0.0001);
  }

  /**
   * Test the normalize function with mixed values
   */
  @Test
  public void testNormalizeZero() {
    double[] arr = {0, -1, 0, 1, 0};
    MathUtils.normalize(arr, 2);
    assertArrayEquals(new double[]{0, -0.5, 0, 0.5, 0}, arr, 0.0001);
  }

  /**
   * Test the normalize function with empty array
   */
  @Test
  public void testNormalizeEmptyArray() {
    double[] arr = {};
    MathUtils.normalize(arr, 4);
    assertArrayEquals(new double[]{}, arr);
  }

  /**
   * Test the normalize function with sum to be zero
   */
  @Test
  public void testNormalizeSumZero() {
    double[] arr = {1, 2, 3, 4, 5};
    assertThrows(IllegalArgumentException.class, () -> MathUtils.normalize(arr, 0));
  }

  /**
   * Test the normalize function with sum to be NaN
   */
  @Test
  public void testNormalizeSumNaN() {
    double[] arr = {1, 2, 3, 4, 5};
    assertThrows(IllegalArgumentException.class, () -> MathUtils.normalize(arr, Double.NaN));
  }

  //Tests for the calEntropy function in MathUtils.java

  /**
   * Test the calEntropy function with normal values
   */
  @Test
  public void testCalEntropy() {
    double[] probabilities = {0.1, 0.2, 0.3, 0.4};
    assertEquals(1.84643934467, MathUtils.calEntropy(probabilities), 0.0001);

    double[] probabilities2 = {0.5, 0.5};
    assertEquals(0.69314718056, MathUtils.calEntropy(probabilities2), 0.0001);
  }

  /**
   * Test the calEntropy function with negative values
   */
  @Test
  public void testCalEntropyNeg() {
    double[] probabilities = {-0.1, -0.2, -0.3, -0.4};
    assertEquals(1.84643934467, MathUtils.calEntropy(probabilities), 0.0001);

    double[] probabilities2 = {-0.5, -0.5};
    assertEquals(0.69314718056, MathUtils.calEntropy(probabilities2), 0.0001);
  }

  /**
   * Test the calEntropy function with zero values
   */
  @Test
  public void testCalEntropyZero() {
    double[] probabilities = {0, 0, 0, 0};
    assertEquals(0, MathUtils.calEntropy(probabilities));
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
    assertThrows(IllegalArgumentException.class, () -> MathUtils.calEntropy(probabilities));

    double[] probabilities2 = {-0.5, 1.5};
    assertThrows(IllegalArgumentException.class, () -> MathUtils.calEntropy(probabilities2));
  }


















}
