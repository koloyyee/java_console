package Math;
///usr/bin/env jbang "$0" "$@" ; exit $?

public class Fibonacci{

  public static void main(String[] args) {
    System.out.println(fib(10));
  }

  public static int fib(int n) {
    if (n <= 1)
      return n;
    return fib(n - 1) + fib(n - 2);
  }
}
