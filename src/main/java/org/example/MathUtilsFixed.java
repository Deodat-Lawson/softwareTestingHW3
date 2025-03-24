package org.example;
public class MathUtilsFixed {

  /**
   * Returns the slope of the line between two points (x1, y1) and (x2, y2).
   *
   * Modification:
   * - Fixed the denominator: changed from (x1 - x2) to (x2 - x1) to correctly compute the slope.
   *
   * @param x1 the first x-coordinate
   * @param x2 the second x-coordinate
   * @param y1 the first y-coordinate
   * @param y2 the second y-coordinate
   * @return the slope of the line between the given points
   */
  public static double slope(double x1, double x2, double y1, double y2) {
    return (y2 - y1) / (x2 - x1);
  }

  /**
   * Returns the root mean squared error (RMSE) between two data sets.
   *
   * Modification:
   * - Changed assignment in the loop to accumulate the sum of squared differences.
   *
   * @param real the array of real values
   * @param predicted the array of predicted values
   * @return the RMSE for the two data sets
   */
  public static double rootMeansSquaredError(double[] real, double[] predicted) {
    double sum = 0.0;
    for (int i = 0; i < real.length; i++) {
      sum += Math.pow(real[i] - predicted[i], 2);
    }
    return Math.sqrt(sum / real.length);
  }

  /**
   * Returns the sum of squares for a given vector.
   *
   * Modification:
   * - Changed assignment in the loop to accumulate the squares instead of overwriting.
   *
   * @param vector the vector to obtain the sum of squares for
   * @return the sum of squares for the vector
   */
  public static double sumOfSquares(double[] vector) {
    double sum = 0;
    for (double d : vector) {
      sum += Math.pow(d, 2);
    }
    return sum;
  }

  /**
   * Returns the given column over n arrays.
   *
   * Modifications:
   * - Added validation to ensure the provided column index is valid for each array.
   *   If the index is negative or not less than the length of an array, an IllegalArgumentException is thrown.
   *
   * @param column the column index to extract from each array
   * @param nums the arrays from which to extract values
   * @return a double array containing the numbers in the given column for all arrays
   * @throws IllegalArgumentException if the column index is invalid for any array
   */
  public static double[] getColumn(int column, double[]... nums) {
    double[] ret = new double[nums.length];
    for (int i = 0; i < nums.length; i++) {
      double[] curr = nums[i];
      if (column < 0 || column >= curr.length) {
        throw new IllegalArgumentException("Invalid column index: " + column);
      }
      ret[i] = curr[column];
    }
    return ret;
  }

  /**
   * Normalizes the doubles in the array using a given value.
   *
   * Modifications:
   * - Added validation to check if sum is zero or NaN.
   *   If so, an IllegalArgumentException is thrown.
   *
   * @param doubles the array of doubles to be normalized
   * @param sum the value by which the doubles are to be normalized
   * @throws IllegalArgumentException if sum is zero or NaN
   */
  public static void normalize(double[] doubles, double sum) {
    if (sum == 0.0 || Double.isNaN(sum)) {
      throw new IllegalArgumentException("Normalization sum cannot be zero or NaN.");
    }
    for (int i = 0; i < doubles.length; i++) {
      doubles[i] /= sum;
    }
  }

  /**
   * Returns the entropy for a given vector of probabilities.
   * Entropy is defined as: -sum(p_i * log(p_i))
   *
   *
   * @param probabilities a vector of probabilities, each must be in the range (0, 1)
   * @return the entropy of the given probabilities
   * @throws IllegalArgumentException if any probability is not in (0, 1)
   */
  public static double calEntropy(double[] probabilities) {
    double total = 0.0;
    for (double d : probabilities) {
      if (d <= 0.0 || d >= 1.0) {
        throw new IllegalArgumentException("Probability out of range (0,1): " + d);
      }
      total += d * Math.log(d);
    }
    return -total;
  }
}
