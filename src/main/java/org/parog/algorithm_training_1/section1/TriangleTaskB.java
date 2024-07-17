package org.parog.algorithm_training_1.section1;

import java.util.Scanner;

/**
 * B. Треугольник
 */
public class TriangleTaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sideA = scanner.nextInt();
        int sideB = scanner.nextInt();
        int sideC = scanner.nextInt();

        int max = Math.max(Math.max(sideA, sideB), sideC);
        if ((max == sideA && max < sideB + sideC) || (max == sideB && max < sideA + sideC)
                || (max == sideC && max < sideA + sideB)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
