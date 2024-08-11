///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

public class entropy {

  public static void main(String... args) {
    double[] p = { 0.2, 0.5, 0.3, 0.1, 0.1 };

    double ans = 0;
    for (int i = 0; i < p.length; i++) {
      ans += -(p[i] * (Math.log(p[i]) / Math.log(2)));
    }
    System.out.println(ans);
  }
}
