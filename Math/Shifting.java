package Math;

///usr/bin/env jbang "$0" "$@" ; exit $?

import java.util.Scanner;

/**
 * Learn about shifting bits
 */
public class Shifting {
  public static void main(String[] args) {

    try (Scanner sc = new Scanner(System.in)) {
      boolean cont = true;
      while (cont) {

        System.out.print("Input a whole number: ");
        int dec = Integer.parseInt(sc.nextLine());
        System.out.print("Input shift bits: ");
        int bit = Integer.parseInt(sc.nextLine());
        System.out.print("Shift L or R: ");
        String dir = sc.nextLine();
        var result = dir.equalsIgnoreCase("l") ? dec << bit : dec >> bit;
        System.out.println(result);
        System.out.println("continue? y or n ");
        String ans = sc.nextLine();
        cont = ans.equalsIgnoreCase("y");
      }
    }
  }
}
