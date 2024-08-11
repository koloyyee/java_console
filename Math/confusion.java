///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

public class confusion {

  public static void main(String... args) {
    int[][] matrix = {
        { 130, 20 },
        { 10, 70 }
    };

    int tp = matrix[0][0];
    int tn = matrix[1][1];
    int fp = matrix[1][0];
    int fn = matrix[0][1];

    double acc = (double) (tp + tn) / (tp + tn + fn + fp);
    System.out.println("accuracy: " + acc);

    double precision = (double) tp / (tp + fp);
    System.out.println("precision: " + precision);
    double sensitivity = (double) tp / (tp + fn);
    System.out.println("sensivity: " + sensitivity);
    double specificity = (double) tn / (tn + fp);
    System.out.println("specificity: " + specificity);
    double f1 = (2 * precision * sensitivity) / (precision + sensitivity);
    System.out.println("f1 measure: " + f1);

  }
}
