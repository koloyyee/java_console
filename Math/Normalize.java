///usr/bin/env jbang "$0" "$@" ; exit $?


import java.util.Arrays;

public class Normalize {

  public static void main(String... args) {
    double[] nums = { 1000, 2000, 1223.22, 1234.22, 3392.22, 95.33, 933.33, 9999.22 };

    double high = 1.1;
    double low = -1.1;
      var sortedNums = Arrays.stream(nums).sorted().toArray();
      var min = Arrays.stream(sortedNums).min().orElse(0);
      var max = Arrays.stream(sortedNums).max().orElse(0);
    var norm = Arrays.stream(sortedNums).map(n -> {
      return ((n - min) / (max - min)) * ((high - low) +low);
    }).toArray();
    for (double d : norm) {
      System.out.println(d);
    }
  }
}
