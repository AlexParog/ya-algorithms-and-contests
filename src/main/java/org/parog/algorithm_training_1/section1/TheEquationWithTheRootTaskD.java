package org.parog.algorithm_training_1.section1;

import java.util.Scanner;

/**
 * D. Уравнение с корнем
 */
public class TheEquationWithTheRootTaskD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (c < 0) {
            System.out.println("NO SOLUTION");
        } else if (a == 0) {
            if (b == c * c) {
                System.out.println("MANY SOLUTIONS");
            } else {
                System.out.println("NO SOLUTION");
            }
        } else {
            if ((c * c - b) % a == 0) {
                System.out.println((c * c - b) / a);
            } else {
                System.out.println("NO SOLUTION");
            }
        }
    }
}
