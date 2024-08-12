
///usr/bin/env jbang "$0" "$@" ; exit $?

public class EuclideanDistance {

  public static void main(String... args) {
    var inputs = args;
    assert (inputs.length > 4);
    if (inputs.length < 4) {
      System.err.println("Must be 4 or more ");
      return;
    }
    assert (inputs.length % 2 == 0);
    if (inputs.length % 2 != 0) {
      System.err.println("Must be a pair");
      return;
    }
    euclidean(args);
  }

  public static double euclidean(String... args) {
    // d(p,q) = Math.sqrt(sum( (pi - qi) ^ 2 ));
    double sum = 0;
    for (int i = 0; i < args.length; i++) { // error here
      double px = Double.parseDouble(args[0]);
      double py = Double.parseDouble(args[1]);

      double qx = Double.parseDouble(args[2]);
      double qy = Double.parseDouble(args[3]);

      sum = Math.pow(px - qx, 2) + Math.pow(py - qy, 2);
    }
    var result = Math.sqrt(sum);
    System.out.println(result);
    return result;
  }

}
