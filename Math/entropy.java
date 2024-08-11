///usr/bin/env jbang "$0" "$@" ; exit $?

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Entropy {

  public static void main(String... args) {
    // test with 0.2 0.5 0.3 0.1 0.1

    List<Double> input = Arrays.stream(args).mapToDouble(Double::parseDouble).boxed().toList();
    Entropy e = new Entropy();
   System.out.println(e.pp(input))    ;
   System.out.println(e.fp(input))    ;
  }

  public double fp(List<Double> input) {
    return input.stream()
        .collect(
            Collectors.summingDouble(el -> -(el * (Math.log(el) / Math.log(2))))); // log base 2

  }

  public double pp(List<Double> input) {
    double ans = 0;
    for (int i = 0; i < input.size(); i++) {
      ans += -(input.get(i) * (Math.log(input.get(i)) / Math.log(2)));
    }
    return ans;
  }
}
