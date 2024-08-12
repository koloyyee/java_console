package Math;

///usr/bin/env jbang "$0" "$@" ; exit $?

import java.util.Arrays;
import java.util.stream.IntStream;

public class LinearRegression {

    public static void main(String... args) {
        // y = mx + b

        double[] x = { 63, 64, 66, 69, 69, 71, 71, 72, 73, 75 };
        double[] y = { 127, 121, 142, 157, 162, 156, 169, 165, 181, 208 };

        var eq = new LinearRegression();
        double m = eq.slope(x, y);
        double b = eq.yIntercept(x, y, m);
        double[] pred = eq.predictions(x, b, m);
        double[] predErr = eq.predictionErrors(y, pred);
        double[] sqPredErr = eq.sqPredictionErrors(y, pred);

        for (int i = 0; i < x.length; i++) {
            System.out.println(
                    "x: " + x[i] +
                            " y: " + y[i] +
                            " actual (y): " +
                            y[i] +
                            " prediction: " +
                            pred[i] +
                            " error indifference: " +
                            predErr[i] +
                            " square of error: " +
                            sqPredErr[i]);
        }
        System.out.println("Root Mean Squared Error: " + eq.rmse(sqPredErr));

    }

    public double slope(double[] x, double[] y) {
        // m = (n sum( x * y ) - sum(x) * sum(y)) / ( n * sum( x^2) - sum(x) ^ 2 )

        double xSum = Arrays.stream(x).sum();
        double ySum = Arrays.stream(y).sum();
        double xySum = 0;
        double xSqSum = Arrays.stream(x).map(i -> Math.pow(i, 2)).sum();
        double sqXSum = Math.pow(xSum, 2);

        for (int i = 0; i < x.length; i++) {
            xySum += x[i] * y[i];
        }
        return (x.length * xySum - (xSum * ySum)) / (x.length * xSqSum - sqXSum);
    }

    public double yIntercept(double[] x, double[] y, double slope) {
        // b = y mean - m * x mean
        double xMean = Arrays.stream(x).average().getAsDouble();
        double yMean = Arrays.stream(y).average().getAsDouble();
        return yMean - slope * xMean;
    }

    public double[] predictions(double[] x, double b, double m) {
        // y = mx + b
        return Arrays.stream(x).map(el -> m * el + b).toArray();
    }

    public double[] predictionErrors(double[] actual, double[] predictions) {
        return IntStream.range(0, actual.length)
                .mapToDouble(i -> actual[i] - predictions[i])
                .toArray();
    }

    public double[] sqPredictionErrors(double[] y, double[] predictions) {
        return IntStream.range(0, y.length)
                .mapToDouble(i -> Math.pow(y[i] - predictions[i], 2))
                .toArray();
    }

    public double rmse(double[] sqPredErr) {
        double sum = 0.0;
        for (int i = 0; i < sqPredErr.length; i++) {
            sum += sqPredErr[i];
        }
        return Math.sqrt(sum / sqPredErr.length);
    }
}
