///usr/bin/env jbang "$0" "$@" ; exit $?

import java.util.Arrays;

public class entropy {

  public static void main(String... args) {
    double[] p = { 0.2, 0.5, 0.3, 0.1, 0.1 };

    double ans = 0;
    for (int i = 0; i < p.length; i++) {
      ans += -(p[i] * (Math.log(p[i]) / Math.log(2)));
    }
    System.out.println("PP: " +  ans);

    entropy(args);
  }

  public static double entropy(String... args) {
    if (args.length <= 1)
      return 0;
    double sum = Arrays.stream(args).mapToDouble(Double::parseDouble)
        .map(el -> -(el * (Math.log(el) / Math.log(2))))
        .sum();
        System.out.println("FP: " + sum);
    return sum;

  }
}
