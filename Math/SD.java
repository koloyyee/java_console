///usr/bin/env jbang "$0" "$@" ; exit $?

import java.util.Arrays;

public class SD {

    public static void main(String... args) {
        /**
         * 
         * σ = √[ Σ(x - μ)² / N ]
         * Where:
         * σ (sigma) is the standard deviation
         * Σ means "sum of"
         * x represents each value in the data set
         * μ (mu) is the mean of all values
         * N is the number of values
         */

        double[] nums = { 1000, 2000, 1223.22, 1234.22, 3392.22, 95.33, 933.33, 9999.22 };
        double mean = Arrays.stream(nums).average().orElse(0);
        System.out.println("mean" + mean);
        double sum = 0 ;
        for(double d : nums ) {
            System.out.println("d: " + d );
            System.out.println("mean: " + mean );
            sum += Math.pow((d - mean),2 );
        }
        System.out.println("sum " + sum);
        double avg = sum/nums.length -1;
        System.out.println("avg " + avg);
        double sd = Math.sqrt(avg);
        System.out.println(sd);
    }

}
