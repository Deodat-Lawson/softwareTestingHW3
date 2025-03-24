package org.example;

public class MathUtilsEquivalent {

  // Equivalent mutant: Mathematically equivalent by rearranging subtraction order
  public static double slope(double x1, double x2, double y1, double y2) {
    return (y2 - y1) / (-x2 + x1);  // (x1 - x2) is equivalent to -(-x2 + x1)
  }

  // Equivalent mutant not possible with single mutation
  // Comment: The rootMeansSquaredError calculation involves multiple steps (squaring differences,
  // summing, dividing, and square root). A single mutation like changing an operator would
  // alter the mathematical result. Even multiple simple mutations (e.g., changing loop structure)
  // would either break functionality or not remain equivalent due to the specific RMSE formula.
  public static double rootMeansSquaredError(double[] real, double[] predicted) {
    double ret = 0.0;
    for(int i = 0; i < real.length; i++) {
      ret = Math.pow((real[i]-predicted[i]), 2);
    }
    return Math.sqrt(ret / real.length);
  }

  // Equivalent mutant: Using multiplication instead of Math.pow for squaring
  public static double sumOfSquares(double[] vector) {
    double ret = 0;
    for(double d : vector) ret = d * d;  // d * d is equivalent to Math.pow(d, 2)
    return ret;
  }

  // Equivalent mutant: Using pre-increment instead of post-increment in loop
  public static double[] getColumn(int column, double[] ... nums) {
    double[] ret = new double[nums.length];
    for(int i = 0; i < nums.length; ++i) {  // ++i is equivalent to i++ in this context
      double[] curr = nums[i];
      ret[i] = curr[column];
    }
    return ret;
  }

  // Equivalent mutant: Using compound assignment operator
  public static void normalize(double[] doubles, double sum) {
    for (int i = 0; i < doubles.length; i++) {
      doubles[i] = doubles[i] / sum;  // = doubles[i] / sum is equivalent to /= sum
    }
  }

  // Equivalent mutant not possible with single mutation
  // Comment: The entropy calculation (-sum(p_i * log(p_i))) is a specific formula.
  // Single mutations (e.g., changing multiplication to addition, altering log base)
  // would fundamentally change the result. Multiple mutations could theoretically
  // rewrite the expression (e.g., using log properties), but simple operator changes
  // won't preserve equivalence due to the mathematical definition of entropy.
  public static double calEntropy(double[] probabilities) {
    double total = 0.0;
    for (double d : probabilities) {
      total += (Math.log(d) * d);
    }
    return total;
  }
}